package com.zhiye.services;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyArticle;
import com.zhiye.common.bean.ZyRole;
import com.zhiye.common.bean.ZyRoleParams;
import com.zhiye.dao.ZyRoleDAO;

public class RoleService extends CommonService {
	private ZyRoleDAO roleDao;

	public ZyRoleDAO getRoleDao(){
		return roleDao;
	}
	public void setRoleDao(ZyRoleDAO roleDao){
		this.roleDao=roleDao;
	}
	/**
	 * 添加角色
	 * 
	 */
	public int addRole(ZyRole role) throws ServiceException {
		String method = "addRole";
		if (role != null) {
			try {
				info(method, "add role successed! with role id=" + role.getRoleId());
				return roleDao.insert(role);
			} catch (Exception e) {
				error(method, "add role dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}

	}

	/**
	 * 更新角色
	 * 
	 * @param role
	 * @return
	 */
	public int updateRole(ZyRole role) throws ServiceException {
		String method = "updateRole";
		int result = 0;
		if (null != role) {
			try {
				result = roleDao.updateByPrimaryKey(role);
			} catch (Exception e) {
				error(method, "update role DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update role success with roleid=" + role.getRoleId());
		return result;
	}

	/**
	 * 根据主键ID 查询 ROLE
	 * 
	 * @param roleId
	 * @return
	 */
	public ZyRole findRoleById(int roleId) throws ServiceException {
		String method = "findRoleById";
		ZyRole resultRole = null;
		if (roleId > 0) {
			try {
				resultRole = roleDao.selectByPrimaryKey(roleId);
			} catch (Exception e) {
				error(method, "find role by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find role success by id =" + roleId);
		return resultRole;
	}

	/**
	 * 根据主键ID删除角色
	 * 
	 * @param roleId
	 * @return
	 */
	public int removeRoleById(int roleId) throws ServiceException {
		String method = "removeRoleById";
		int result = 0;
		if (roleId > 0) {
			try {
				result = roleDao.deleteByPrimaryKey(roleId);
			} catch (Exception e) {
				error(method, "delete role by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed role by id=" + roleId);
		return result;
	}
	/**
	 * 批量查询 获得ROLE,获得所有
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyRole> findAllRoleList()
			throws ServiceException {
		String m = "findAllRoleList";
		ZyRoleParams param=new ZyRoleParams();
		List<ZyRole> result=findRoleList(param);
		if(null!=result){
			info(m,"find all users success, total count is "+result.size());
			return result;
		}else{
			return null;
		}
		
	}
	
	/**
	 * 批量查询 获得ROLE
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyRole> findRoleList(ZyRoleParams params)
			throws ServiceException {
		String method = "findRoleList";
		List<ZyRole> roles = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			roles = roleDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find role by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query roles success by params=" + params.toString());
		return roles;
	}
	/**
	 * 根据角色名查询，角色
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ZyRole findRoleByName(String name)
			throws ServiceException {
		String method = "findRoleByName";
		List<ZyRole> roles = null;
		if (null == name) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		ZyRoleParams params=new ZyRoleParams();
		params.createCriteria().andRoleNameEqualTo(name);
		try {
			roles = roleDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find role by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query roles success by name=" + params.toString());
		if(roles!=null&&roles.size()>0){
			return roles.get(0);
		}else{
			return null;
		}
			
	}
	

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */
	public int countRoleList(ZyRoleParams params) throws ServiceException {
		String method = "countRoleList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = roleDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count roles by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count roles success by params=" + params.toString());

		return result;
	}
	/**
	 * 获得所有的角色的总数,角色列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String, Object> map)
			throws ServiceException {
		String m = "countSearchPager";
		int count = roleDao.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any roles ,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * ROLE 分页查询和搜索 获得所需的角色
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyRole> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyRole> roles = roleDao.selectPaginationByPageNum(params);
		if (roles == null) {
			warn(m, "can't found any roles");
			return null;
		} else {
			info(m, "find " + roles.size() + " roles");
			return roles;
		}

	}
}
