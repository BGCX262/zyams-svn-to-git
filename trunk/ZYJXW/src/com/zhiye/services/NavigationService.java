package com.zhiye.services;

import java.util.List;

import com.zhiye.common.bean.ZyNavigation;
import com.zhiye.common.bean.ZyNavigationParams;
import com.zhiye.dao.ZyNavigationDAO;

public class NavigationService extends CommonService {
	private ZyNavigationDAO naviDao;
	
	public ZyNavigationDAO getNaviDao(){
		return naviDao;
	}
	public void setNaviDao(ZyNavigationDAO naviDao){
		this.naviDao=naviDao;
	}
	/**
	 * 添加导航
	 * 
	 */
	public void addNavigation(ZyNavigation navi) throws ServiceException {
		String method = "addNavigation";
		if (navi != null) {
			try {
				naviDao.insert(navi);
			} catch (Exception e) {
				error(method, "add navi dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add navi successed! with navi id=" + navi.getNaviId());
	}

	/**
	 * 更新导航
	 * 
	 * @param navi
	 * @return
	 */
	public int updateNavigation(ZyNavigation navi) throws ServiceException {
		String method = "updateNavigation";
		int result = 0;
		if (null != navi) {
			try {
				result = naviDao.updateByPrimaryKey(navi);
			} catch (Exception e) {
				error(method, "update navi DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update navi success with naviid=" + navi.getNaviId());
		return result;
	}

	/**
	 * 根据主键ID 查询 NAVI
	 * 
	 * @param naviId
	 * @return
	 */
	public ZyNavigation findNavigationById(int naviId) throws ServiceException {
		String method = "findNavigationById";
		ZyNavigation resultNavigation = null;
		if (naviId > 0) {
			try {
				resultNavigation = naviDao.selectByPrimaryKey(naviId);
			} catch (Exception e) {
				error(method, "find navi by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find navi success by id =" + naviId);
		return resultNavigation;
	}

	/**
	 * 根据主键ID删除导航
	 * 
	 * @param naviId
	 * @return
	 */
	public int removeNavigationById(int naviId) throws ServiceException {
		String method = "removeNavigationById";
		int result = 0;
		if (naviId > 0) {
			try {
				result = naviDao.deleteByPrimaryKey(naviId);
			} catch (Exception e) {
				error(method, "delete navi by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed navi by id=" + naviId);
		return result;
	}

	/**
	 * 批量查询 获得NAVI
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyNavigation> findNavigationList(ZyNavigationParams params)
			throws ServiceException {
		String method = "findNavigationList";
		List<ZyNavigation> navis = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			navis = naviDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find navi by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query navis success by params=" + params.toString());

		return navis;
	}

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */
	public int countNavigationList(ZyNavigationParams params) throws ServiceException {
		String method = "countNavigationList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = naviDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count navis by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count navis success by params=" + params.toString());

		return result;
	}
}
