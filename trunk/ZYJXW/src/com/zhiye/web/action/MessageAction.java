package com.zhiye.web.action;
/** 
 * @作者 Allen Shu 
 * @创建日期 2012-4-26 
 * @版本 V 1.0 
 */

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;

import com.zhiye.common.bean.ZyContactType;
import com.zhiye.common.bean.ZyCorporation;
import com.zhiye.common.bean.ZyMessage;
import com.zhiye.common.bean.ZyPartment;
import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.bean.ZyUserParams;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Pager;
import com.zhiye.services.ContactAndTypeService;
import com.zhiye.services.ContactService;
import com.zhiye.services.ContactTypeService;
import com.zhiye.services.CorporationService;
import com.zhiye.services.MessageService;
import com.zhiye.services.PartmentService;
import com.zhiye.services.ServiceException;
import com.zhiye.services.UserService;

public class MessageAction extends GenericActionSupport<ZyMessage> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ZyMessage zy_message;
	String phones;
	ContactService contactService;

	ContactTypeService contactTypeService;
	
	ContactAndTypeService contactAndTypeService;

	public ContactAndTypeService getContactAndTypeService() {
		return contactAndTypeService;
	}

	public void setContactAndTypeService(ContactAndTypeService contactAndTypeService) {
		this.contactAndTypeService = contactAndTypeService;
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public ContactTypeService getContactTypeService() {
		return contactTypeService;
	}

	public void setContactTypeService(ContactTypeService contactTypeService) {
		this.contactTypeService = contactTypeService;
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}
	Long msgId;

	MessageService messageService;
	PartmentService partmentService;
	UserService userService;
	List<ZyMessage> messages;
	CorporationService corporationService;



	public CorporationService getCorporationService() {
		return corporationService;
	}

	public void setCorporationService(CorporationService corporationService) {
		this.corporationService = corporationService;
	}

	public ZyMessage getZy_message() {
		return zy_message;
	}

	public void setZy_message(ZyMessage zy_message) {
		this.zy_message = zy_message;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public List<ZyMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<ZyMessage> messages) {
		this.messages = messages;
	}

	/**
	 * 列出所有的短信
	 * 
	 * @return
	 */
	public String listMessages() {
		String m = "listMsgs";
		try {
			// 获得配置的每页数量
			if (numPerPage == 0) {
				numPerPage = Config.getInt("pager.page_size");
			}
			int start = 0;
			if (pageNum > 1) {
				start = (pageNum - 1) * numPerPage;
			}
			Map<String, Object> params = new HashMap<String, Object>();
			List<ZyMessage> messages = null;
		
			params.put("start", start);
			params.put("size", numPerPage);
			messages = messageService.searchForPager(params);

			params.remove("start");
			params.remove("size");
			int count = messageService.countSearchPager(params);
		
			pager = new Pager<ZyMessage>(pageNum, numPerPage);
			for(ZyMessage message:messages){
				try{
					if(!"".equals(message.getSuccessList())&&message.getSuccessList()!=null){
					message.setSuccessSize(message.getSuccessList().split(",").length);
					}else{
						message.setSuccessSize(0);
					}
					if(!"".equals(message.getFailList())&&message.getFailList()!=null){
						message.setFailSize(message.getFailList().split(",").length);
					}else{
						message.setFailSize(0);
					}
					
					info(m, "find the " + message.getSuccessSize() + " success messages and "+message.getFailSize()+" messages");
				}catch(Exception e){
					error(m, "find get send list size exeption", e);
				}
				
			}
			pager.setPageRecords(messages);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " messages");

		} catch (ServiceException e) {
			error(m, "find all msgs exeption", e);
		} catch (Exception e) {
			error(m, "find all msgs exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		return "success";

	}



	/**
	 * 添加一个留言，跳转到添加页面
	 * 
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public String addMessage() throws ClientProtocolException, IOException {
		String m = "addMessage";
		int bulance=0;
		bulance = messageService.getBalance(Config.getString("sms.loginUser"),Config.getString("sms.loginPassword"));
		// get联系人分组列表
		List<ZyContactType> types = null;
		// GET 联系人列表
		try {
			types = contactTypeService.findAllContactTypes();
	
		Map<Integer,List> usersMap=new HashMap<Integer,List>();
		int count=0;
		if(types!=null&&types.size()>0){
			//根据部门查询出每个分组的用户
			for(ZyContactType t:types){
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("typeid", t.getTypeId());
				List cs=contactService.selectContactByTypeId(map);
				if(cs!=null){
					usersMap.put(count, cs);
				}else{
					usersMap.put(count, new ArrayList<ZyUser>());
				}
					
				count++;
			}
		}
		
		request.setAttribute("usersMap", usersMap);
		request.setAttribute("types", types);
		} catch (Exception e) {
			error(m, "find all  user and companys exception", e);
		}
		
		request.setAttribute("bulance", bulance);
		return "add";
	}

	/**
	 * 添加一个留言
	 * 
	 * @return
	 */
	public String doAddMessage() {
		String m = "doAddMessage";
		info(m, "add the zy_message  =" + zy_message);
		try {
			Date newDate = new Date();
			zy_message.setSendTime(newDate);
			
			Random random=new Random();
			String sRand="";
			  for (int i=0;i<4;i++){
				   String rand=String.valueOf(random.nextInt(10));
				   sRand+=rand;
				}
			String id=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())+sRand; 
			zy_message.setMsgId(Long.parseLong(id));
			String[] phoneArray=phones.split(",");
			//判断余额.
			int bulance=messageService.getBalance(Config.getString("sms.loginUser"),Config.getString("sms.loginPassword"));
			
			if(bulance<phoneArray.length){
				this.message = "账户余额不足,请充值.";
				this.statusCode = "300";
				this.navTabId = "addMessage";
				return "ajaxDone";
			}
			int countSuccess=0;
			int countFail=0;
			for(int i=0;i<phoneArray.length;i++){				
				String str=messageService.sendMessage(zy_message, phoneArray[i],Config.getString("sms.loginUser"),Config.getString("sms.loginPassword"));
				String[] strArray=str.split("&");
				if("1".equals(strArray[0])){
					if(countSuccess>0){
						zy_message.setSuccessList(zy_message.getSuccessList()+","+phoneArray[i]);
					}
					else{
						zy_message.setSuccessList(phoneArray[i]);
					}
					countSuccess++;
				}else{
					if(countFail>0){
						zy_message.setFailList(zy_message.getFailList()+","+phoneArray[i]);
					}
					else{
						zy_message.setFailList(phoneArray[i]);
					}
					countFail++;
				}
			}
			messageService.addMessage(zy_message);
		} 
		catch (ServiceException e) {
			error(m, "add the message  exception", e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addMsg";
			info(m, "add the message failed with title=" + zy_message.getMsgContent());
			return "ajaxDone";
		}catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		this.callbackType = "forward";
		this.forwardUrl = "listMessages.action";
		this.message = "短信发送成功";
		this.statusCode = "200";
		this.navTabId = "listMessags";
		info(m, "add the msg success with message title=" + zy_message.getMsgContent());
		return "ajaxDone";
	}
	/**
	 * 
	 * 
	 * @return
	 */
	public String viewMessage() {
		String m = "viewMessage";
		info(m, "view the zy_message  =" + zy_message);
		if (msgId != null) {
			try {
				zy_message = messageService.findMessageById(msgId);				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		try{
			zy_message.setSuccessSize(zy_message.getSuccessList().split(",").length);
			zy_message.setFailSize(zy_message.getFailList().split(",").length);
			info(m, "find the " + zy_message.getSuccessSize() + " success messages and "+zy_message.getFailSize()+" messages");
		}catch(Exception e){
			error(m, "find get send list size exeption", e);
		}
		info(m, "view the message success with message msgId=" + zy_message.getMsgId());
		return "success";
	}
	/*
	 * 发短信时获取全部联系企业,并且可以选择.
	 */
	public String lookupCompany(){
//		initArticleTypeData(corporationService,true,true);
		List<ZyCorporation> list = new ArrayList();
		try {
			list = corporationService.finDictionaryid();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public PartmentService getPartmentService() {
		return partmentService;
	}

	public void setPartmentService(PartmentService partmentService) {
		this.partmentService = partmentService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
