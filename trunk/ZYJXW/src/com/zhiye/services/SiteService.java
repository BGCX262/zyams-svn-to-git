package com.zhiye.services;

import java.util.List;

import com.zhiye.common.bean.ZySite;
import com.zhiye.dao.ZySiteDAO;

public class SiteService extends CommonService {
	private ZySiteDAO siteDao;

	public ZySiteDAO getSiteDao() {
		return siteDao;
	}

	public void setSiteDao(ZySiteDAO siteDao) {
		this.siteDao = siteDao;
	}

	/**
	 * 添加记录
	 * 
	 */
	public void addSite(ZySite site) throws ServiceException {
		String method = "addSite";
		if (site != null) {
			try {
				siteDao.insert(site);
			} catch (Exception e) {
				error(method, "add site dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add site successed! with site id="
				+ site.getId());
	}

	/**
	 * 更新记录
	 * 
	 * @param site
	 * @return
	 */
	public int updateSite(ZySite site)
			throws ServiceException {
		String method = "updateSite";
		int result = 0;
		if (null != site) {
			try {
				result = siteDao.updateByPrimaryKey(site);
			} catch (Exception e) {
				error(method, "update site DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update site success with siteid="
				+ site.getId());
		return result;
	}

	/**
	 * 根据主键ID 查询 ARTICLE
	 * 
	 * @param siteId
	 * @return
	 */
	public ZySite findSiteById(long siteId) throws ServiceException {
		String method = "findSiteById";
		ZySite resultSite = null;
		if (siteId > 0) {
			try {
				resultSite = siteDao.selectByPrimaryKey(siteId);
			} catch (Exception e) {
				error(method, "find site by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find site success by id =" + siteId);

		return resultSite;
	}
	/**
	 * 根据主键IP 查询 ARTICLE
	 * 
	 * @param siteId
	 * @return
	 */
	public List<ZySite> findSiteByIP(String ip) throws ServiceException {
		String method = "findSiteByIP";
		List<ZySite> resultSites = null;
		if (ip!=null) {
			try {
				resultSites = siteDao.selectByIP(ip);
			} catch (Exception e) {
				error(method, "find site by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find site success by id =" + resultSites);

		return resultSites;
	}

	/**
	 * 根据主键ID删除记录
	 * 
	 * @param siteId
	 * @return
	 */
	public int removeSiteById(long siteId) throws ServiceException {
		String method = "removeSiteById";
		int result = 0;
		if (siteId > 0) {
			try {
				result = siteDao.deleteByParams(siteId);
			} catch (Exception e) {
				error(method, "delete site by id exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed site by id=" + siteId);
		return result;
	}



	/**
	 * 获得所有的记录的总数
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public long countAllSites() throws ServiceException {
		String m = "countAllSites";
		long count =siteDao.countAllRecords();
		if (count == 0) {
			warn(m, "can't found any sites,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	
}
