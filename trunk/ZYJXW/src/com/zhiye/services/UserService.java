package com.zhiye.services;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.bean.ZyUserParams;
import com.zhiye.dao.ZyUserDAO;

public class UserService extends CommonService {
	private ZyUserDAO userDao;

	public ZyUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(ZyUserDAO userDao) {
		this.userDao = userDao;
	}

	/**
	 * 添加用户
	 * 
	 */
	public void addUser(ZyUser user) throws ServiceException {
		String method = "addUser";
		if (user != null) {
			try {
				userDao.insert(user);
			} catch (Exception e) {
				error(method, "add user dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add user successed! with user id=" + user.getUserId());
	}

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(ZyUser user) throws ServiceException {
		String method = "updateUser";
		int result = 0;
		if (null != user) {
			try {
				result = userDao.updateByPrimaryKey(user);
			} catch (Exception e) {
				error(method, "update user DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update user success with userid=" + user.getUserId());
		return result;
	}

	/**
	 * 根据主键ID 查询 USER
	 * 
	 * @param userId
	 * @return
	 */
	public ZyUser findUserById(int userId) throws ServiceException {
		String method = "findUserById";
		ZyUser resultUser = null;
		if (userId > 0) {
			try {
				resultUser = userDao.selectByPrimaryKey(userId);
			} catch (Exception e) {
				error(method, "find user by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find user success by id =" + userId);
		return resultUser;
	}

	/**
	 * 根据用户名称查找用户
	 * 
	 * @param userName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ZyUser findUserByName(String userName) throws ServiceException {
		String method = "findUserByName";
		List<ZyUser> resultUsers = null;
		ZyUserParams params = new ZyUserParams();
		params.createCriteria().andLoginameEqualTo(userName);

		if (userName != null) {
			try {
				resultUsers = userDao.selectByParams(params);
			} catch (Exception e) {
				error(method, "find user by username exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.USER_NAME_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		
		if (resultUsers != null&&resultUsers.size()>0) {
			info(method, "find user success by name =" + userName);
			return resultUsers.get(0);
		} else {
			warn(method, "can 't find any user by name =" + userName);
			return null;
		}

	}

	/**
	 * 根据主键ID删除用户
	 * 
	 * @param userId
	 * @return
	 */
	public int removeUserById(int userId) throws ServiceException {
		String method = "removeUserById";
		int result = 0;
		if (userId > 0) {
			try {
				result = userDao.deleteByPrimaryKey(userId);
			} catch (Exception e) {
				error(method, "delete user by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed user by id=" + userId);
		return result;
	}

	/**
	 * 批量查询 获得USER
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyUser> findUserList(ZyUserParams params)
			throws ServiceException {
		String method = "findUserList";
		List<ZyUser> users = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			users = userDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find user by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query users success by params=" + params.toString());

		return users;
	}

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */
	public int countUserList(ZyUserParams params) throws ServiceException {
		String method = "countUserList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = userDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count users by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count users success by params=" + params.toString());

		return result;
	}
	
	/**
	 * 获得所有的用户的总数,用户列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String, Object> map)
			throws ServiceException {
		String m = "countSearchPager";
		int count = userDao.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any users ,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * USER 分页查询和搜索 获得所需的用户
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyUser> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyUser> users = userDao.selectPaginationByPageNum(params);
		if (users == null) {
			warn(m, "can't found any users");
			return null;
		} else {
			info(m, "find " + users.size() + " users");
			return users;
		}

	}
}
