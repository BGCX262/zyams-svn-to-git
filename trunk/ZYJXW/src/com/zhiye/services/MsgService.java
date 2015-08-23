package com.zhiye.services;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyMsg;
import com.zhiye.common.bean.ZyMsgParams;
import com.zhiye.dao.ZyMsgDAO;

public class MsgService extends CommonService {
	private ZyMsgDAO msgDao;

	public ZyMsgDAO getMsgDao() {
		return msgDao;
	}

	public void setMsgDao(ZyMsgDAO msgDao) {
		this.msgDao = msgDao;
	}

	/**
	 * 添加留言
	 * 
	 */
	public void addMsg(ZyMsg msg) throws ServiceException {
		String method = "addMsg";
		if (msg != null) {
			try {
				msgDao.insert(msg);
			} catch (Exception e) {
				error(method, "add msg dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add msg successed! with msg id=" + msg.getMsgId());
	}

	/**
	 * 更新留言
	 * 
	 * @param msg
	 * @return
	 */
	public int updateMsg(ZyMsg msg) throws ServiceException {
		String method = "updateMsg";
		int result = 0;
		if (null != msg) {
			try {
				result = msgDao.updateByPrimaryKeyWithBLOBs(msg);
			} catch (Exception e) {
				error(method, "update msg DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update msg success with msgId=" + msg.getMsgId());
		return result;
	}

	/**
	 * 根据主键ID 查询 USER
	 * 
	 * @param msgId
	 * @return
	 */
	public ZyMsg findMsgById(long msgId) throws ServiceException {
		String method = "findMsgById";
		ZyMsg resultMsg = null;
		if (msgId > 0) {
			try {
				resultMsg = msgDao.selectByPrimaryKey(msgId);
			} catch (Exception e) {
				error(method, "find msg by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find msg success by id =" + msgId);
		return resultMsg;
	}

	/**
	 * 根据留言名称查找留言
	 * 
	 * @param msgName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ZyMsg findMsgByName(String msgName) throws ServiceException {
		String method = "findMsgByName";
		List<ZyMsg> resultMsgs = null;
		ZyMsgParams params = new ZyMsgParams();
		params.createCriteria().andUsernameEqualTo(msgName);

		if (msgName != null) {
			try {
				resultMsgs = msgDao.selectByParamsWithBLOBs(params);
			} catch (Exception e) {
				error(method, "find msg by msgname exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.USER_NAME_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		
		if (resultMsgs != null&&resultMsgs.size()>0) {
			info(method, "find msg success by name =" + msgName);
			return resultMsgs.get(0);
		} else {
			warn(method, "can 't find any msg by name =" + msgName);
			return null;
		}

	}

	/**
	 * 根据主键ID删除留言
	 * 
	 * @param msgId
	 * @return
	 */
	public int removeMsgById(long msgId) throws ServiceException {
		String method = "removeMsgById";
		int result = 0;
		if (msgId > 0) {
			try {
				result = msgDao.deleteByPrimaryKey(msgId);
			} catch (Exception e) {
				error(method, "delete msg by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed msg by id=" + msgId);
		return result;
	}

	/**
	 * 批量查询 获得USER
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyMsg> findMsgList(ZyMsgParams params)
			throws ServiceException {
		String method = "findMsgList";
		List<ZyMsg> msgs = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			msgs = msgDao.selectByParamsWithBLOBs(params);
		} catch (Exception e) {
			error(method, "find msg by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query msgs success by params=" + params.toString());

		return msgs;
	}

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */
	public int countMsgList(ZyMsgParams params) throws ServiceException {
		String method = "countMsgList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = msgDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count msgs by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count msgs success by params=" + params.toString());

		return result;
	}
	
	/**
	 * 获得所有的留言的总数,留言列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String, Object> map)
			throws ServiceException {
		String m = "countSearchPager";
		int count = msgDao.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any msgs ,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * USER 分页查询和搜索 获得所需的留言
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyMsg> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyMsg> msgs = msgDao.selectPaginationByPageNum(params);
		if (msgs == null) {
			warn(m, "can't found any msgs");
			return null;
		} else {
			info(m, "find " + msgs.size() + " msgs");
			return msgs;
		}

	}
}
