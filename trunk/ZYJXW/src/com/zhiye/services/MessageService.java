/**
 * 
 */
package com.zhiye.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


import com.zhiye.common.bean.ZyMessage;
import com.zhiye.common.bean.ZyMessageParams;
import com.zhiye.common.util.Config;
import com.zhiye.dao.ZyMessageDAO;


/** 
 * @作者 Allen Shu 
 * @创建日期 2012-4-26 
 * @版本 V 1.0 
 */

public class MessageService extends CommonService{
	private ZyMessageDAO messageDao;

	public ZyMessageDAO getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(ZyMessageDAO messageDao) {
		this.messageDao = messageDao;
	}


	/**
	 * 根据主键ID 查询 message
	 * 
	 * @param linkId
	 * @return
	 */
	public ZyMessage findMessageById(Long msg_id) throws ServiceException {
		String method = "findMessageById";
		ZyMessage obj = null;
		if (msg_id > 0) {
			try {
				obj = messageDao.selectByPrimaryKey(msg_id);
			} catch (Exception e) {
				error(method, "find link by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find link success by id =" + msg_id);
		return obj;
	}

	/**
	 * 批量查询 获得LINK,支持大文本
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyMessage> findMessageListWithBLOB(ZyMessageParams params)
			throws ServiceException {
		String method = "findLinkList";
		List<ZyMessage> ZyMessages = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			ZyMessages = messageDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find link by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query links success by params=" + params.toString());

		return ZyMessages;
	}

	
	/**
	 * 根据PAGE SIZE ,PAGENUM获得所需的链接
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyMessage> findLinkByPageNum(int start, int pageSize)
			throws ServiceException {
		String m = "findLinkByPageNum";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", pageSize);
		List<ZyMessage> messages = messageDao.selectPaginationByPageNum(params);
		if (messages == null) {
			warn(m, "can't found any messages");
			return null;
		} else {
			info(m, "find " + messages.size() + " links");
			return messages;
		}

	}

	/**
	 * 根据PAGE SIZE ,PAGENUM,parent Id获得所需的链接分类
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyMessage> findLinksByPageNumAndTypeId(int start, int pageSize,
			int typeId) throws ServiceException {
		String m = "findLinksByPageNumAndTypeId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", pageSize);
		params.put("typeId", typeId);
		List<ZyMessage> links = messageDao.selectPaginationByPageNum(params);
		if (links == null) {
			warn(m, "can't found any links");
			return null;
		} else {
			info(m, "find " + links.size() + " links");
			return links;
		}

	}

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */

	public int countMessageList(ZyMessageParams params) throws ServiceException {
		String method = "countLinkList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = messageDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count links by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count links success by params=" + params.toString());

		return result;
	}



	/**
	 * 获得所有的短信的总数,链接列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String, Object> map)
			throws ServiceException {
		String m = "countSearchPager";
		int count = messageDao.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any messages,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * LINK 分页查询和搜索 获得所需的链接
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyMessage> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyMessage> messages = messageDao.selectPaginationByPageNum(params);
		if (messages == null) {
			warn(m, "can't found any links");
			return null;
		} else {
			info(m, "find " + messages.size() + " messages");
			return messages;
		}

	}

	/**
	 * @param zy_message
	 * @throws ServiceException 
	 */
	public void addMessage(ZyMessage obj) throws ServiceException {
		// TODO Auto-generated method stub
		String method = "addMessage";
		if (obj != null) {
			try {
				messageDao.insert(obj);
			} catch (Exception e) {
				error(method, "add message dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add messge successed! with link id=" + obj.getMsgId());
	}
	public String sendMessage(ZyMessage obj,String phone,String login,String password) throws ClientProtocolException, IOException{
		HttpClient client = new DefaultHttpClient();
//		 String balance_url="http://18dx.cn/API/Services.aspx?action=getbalance&user=shulei@maszy.cn&hashcode=13855585327";
		 String msg_url="http://18dx.cn/API/Services.aspx?action=msgsend&user="+login+"&mobile="+phone+"&content="+obj.getMsgContent()+"&time=&msgid="+obj.getMsgId()+"&hashcode="+password+"&encode=UTF-8";
		 HttpPost post=new HttpPost(msg_url);
			// 在头文件中设置转码
		  post.addHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
		 ResponseHandler<String> responseHandler = new BasicResponseHandler();
		 String responseBody =client.execute(post, responseHandler);		
        return responseBody;
	}
	public int getBalance(String login,String password) throws ClientProtocolException, IOException{
		System.out.println("==========================================================");
		int i=0;
		HttpClient client = new DefaultHttpClient();
		 String balance_url="http://18dx.cn/API/Services.aspx?action=getbalance&user="+login+"&hashcode="+password;
		
		 HttpPost post=new HttpPost(balance_url);
			// 在头文件中设置转码
		  post.addHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
		 ResponseHandler<String> responseHandler = new BasicResponseHandler();
		 String responseBody =client.execute(post, responseHandler);	
		 i=Integer.parseInt(responseBody.trim());
		
		return i;
	}
	public static void main(String[] args){
		MessageService ms=new MessageService();
		try {
			ms.getBalance("shulei@maszy.cn", "13855585327");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
