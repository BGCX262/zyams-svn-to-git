package com.zhiye.services;

import java.util.List;

import com.zhiye.common.bean.ZyRolePremission;
import com.zhiye.common.bean.ZyRolePremissionParams;
import com.zhiye.dao.ZyRolePremissionDAO;

public class RolePremissionService extends CommonService {
	private ZyRolePremissionDAO rolePremissionDao;
	public ZyRolePremissionDAO getRolePremissionDao(){
		return rolePremissionDao;
	}
	public void setRolePremissionDao(ZyRolePremissionDAO rolePremissionDao){
		this.rolePremissionDao=rolePremissionDao;
	}
	/**
	 * 添加角色 权限
	 * 
	 */
	public void addRolePremission(ZyRolePremission rolePremission) throws ServiceException {
		String method = "addRolePremission";
		if (rolePremission != null) {
			try {
				rolePremissionDao.insert(rolePremission);
			} catch (Exception e) {
				error(method, "add rolePremission dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add rolePremission successed! with roleid=" + rolePremission.getRoleId());
	}


	/**
	 * 根据条件参数删除ROLE PREMISSION
	 * 
	 * @param params
	 * @return
	 */
	public int removeRolePremissionById(ZyRolePremissionParams params) throws ServiceException {
		String method = "removeRolePremissionById";
		int result = 0;
		if (params !=null) {
			try {
				result = rolePremissionDao.deleteByParams(params) ;
			} catch (Exception e) {
				error(method, "delete rolePremission by param exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		info(method, "removed rolePremission by params=" + params);
		return result;
	}

	/**
	 * 批量查询 获得ROLEPREMISSION
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyRolePremission> findRolePremissionList(ZyRolePremissionParams params)
			throws ServiceException {
		String method = "findRolePremissionList";
		List<ZyRolePremission> rolePremissions = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			rolePremissions = rolePremissionDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find rolePremission by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query rolePremissions success by params=" + params.toString());

		return rolePremissions;
	}

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */
	public int countRolePremissionList(ZyRolePremissionParams params) throws ServiceException {
		String method = "countRolePremissionList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = rolePremissionDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count rolePremissions by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count rolePremissions success by params=" + params.toString());

		return result;
	}
}
