package com.zhiye.services;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyPremission;
import com.zhiye.common.bean.ZyPremissionParams;
import com.zhiye.dao.ZyPremissionDAO;

public class PremissionService extends CommonService {
	private ZyPremissionDAO premissionDao;

	public ZyPremissionDAO getPremissionDao(){
		return premissionDao;
	}
	public void setPremissionDao(ZyPremissionDAO premissionDao){
		this.premissionDao=premissionDao;
	}
	/**
	 * 添加权限
	 * 
	 */
	public void addPremission(ZyPremission premission) throws ServiceException {
		String method = "addPremission";
		if (premission != null) {
			try {
				premissionDao.insert(premission);
			} catch (Exception e) {
				error(method, "add premission dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add premission successed! with premission id=" + premission.getPremissionId());
	}

	/**
	 * 更新权限
	 * 
	 * @param premission
	 * @return
	 */
	public int updatePremission(ZyPremission premission) throws ServiceException {
		String method = "updatePremission";
		int result = 0;
		if (null != premission) {
			try {
				result = premissionDao.updateByPrimaryKey(premission);
			} catch (Exception e) {
				error(method, "update premission DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update premission success with premissionid=" + premission.getPremissionId());
		return result;
	}

	/**
	 * 根据主键ID 查询 PREMISSION
	 * 
	 * @param premissionId
	 * @return
	 */
	public ZyPremission findPremissionById(int premissionId) throws ServiceException {
		String method = "findPremissionById";
		ZyPremission resultPremission = null;
		if (premissionId > 0) {
			try {
				resultPremission = premissionDao.selectByPrimaryKey(premissionId);
			} catch (Exception e) {
				error(method, "find premission by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find premission success by id =" + premissionId);
		return resultPremission;
	}

	/**
	 * 根据主键ID删除权限
	 * 
	 * @param premissionId
	 * @return
	 */
	public int removePremissionById(int premissionId) throws ServiceException {
		String method = "removePremissionById";
		int result = 0;
		if (premissionId > 0) {
			try {
				result = premissionDao.deleteByPrimaryKey(premissionId);
			} catch (Exception e) {
				error(method, "delete premission by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed premission by id=" + premissionId);
		return result;
	}
	
	/**
	 * 根据SECTION ID 来删除权限
	 * @param sectionId
	 * @return
	 * @throws ServiceException
	 */
	public int removePremissionBySectionId(int sectionId) throws ServiceException{
		String method = "removePremissionBySectionId";
		int result = 0;
		if (sectionId > 0) {
			try {
				ZyPremissionParams param=new ZyPremissionParams();
				param.createCriteria().andSectionIdEqualTo(sectionId);
				result = premissionDao.deleteByParams(param);
			} catch (Exception e) {
				error(method, "delete premission by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed premission by sectionId=" + sectionId);
		return result;
	}

	/**
	 * 批量查询 获得PREMISSION
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyPremission> findPremissionList(ZyPremissionParams params)
			throws ServiceException {
		String method = "findPremissionList";
		List<ZyPremission> premissions = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			premissions = premissionDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find premission by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query premissions success by params=" + params.toString());

		return premissions;
	}

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */
	public int countPremissionList(ZyPremissionParams params) throws ServiceException {
		String method = "countPremissionList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = premissionDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count premissions by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count premissions success by params=" + params.toString());

		return result;
	}
	
	public List<ZyPremission> findSectionIdByRoleId(Map<String,Object> params) throws ServiceException{
		String method="findSectionIdByRoleId";
		List<ZyPremission> result=null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = premissionDao.findSectionIdByRoleId(params);
		} catch (Exception e) {
			error(method, "find premissions by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "find premissions success by params=" + params.toString());

		return result;
	}
}
