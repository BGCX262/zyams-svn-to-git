package com.zhiye.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyLink;
import com.zhiye.common.bean.ZyLinkParams;
import com.zhiye.dao.ZyLinkDAO;

public class LinkService extends CommonService {
	private ZyLinkDAO linkDao;

	public ZyLinkDAO getLinkDao() {
		return linkDao;
	}

	public void setLinkDao(ZyLinkDAO linkDao) {
		this.linkDao = linkDao;
	}

	/**
	 * 添加链接
	 * 
	 */
	public void addLink(ZyLink link) throws ServiceException {
		String method = "addLink";
		if (link != null) {
			try {
				linkDao.insert(link);
			} catch (Exception e) {
				error(method, "add link dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add link successed! with link id=" + link.getLinkId());
	}

	/**
	 * 更新链接
	 * 
	 * @param link
	 * @return
	 */
	public int updateLink(ZyLink link) throws ServiceException {
		String method = "updateLink";
		int result = 0;
		if (null != link) {
			try {
				result = linkDao.updateByPrimaryKeyWithBLOBs(link);
			} catch (Exception e) {
				error(method, "update link DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update link success with linkId=" + link.getLinkId());
		return result;
	}

	/**
	 * 根据主键ID 查询 LINK
	 * 
	 * @param linkId
	 * @return
	 */
	public ZyLink findLinkById(int linkId) throws ServiceException {
		String method = "findLinkById";
		ZyLink resultLink = null;
		if (linkId > 0) {
			try {
				resultLink = linkDao.selectByPrimaryKey(linkId);
			} catch (Exception e) {
				error(method, "find link by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find link success by id =" + linkId);
		return resultLink;
	}

	/**
	 * 根据主键ID删除链接
	 * 
	 * @param linkId
	 * @return
	 */
	public int removeLinkById(int linkId) throws ServiceException {
		String method = "removeLinkById";
		int result = 0;
		if (linkId > 0) {
			try {
				result = linkDao.deleteByPrimaryKey(linkId);
			} catch (Exception e) {
				error(method, "delete link by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed link by id=" + linkId);
		return result;
	}

	/**
	 * 批量查询 获得LINK,支持大文本
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyLink> findLinkListWithBLOB(ZyLinkParams params)
			throws ServiceException {
		String method = "findLinkList";
		List<ZyLink> links = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			links = linkDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find link by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query links success by params=" + params.toString());

		return links;
	}

	
	/**
	 * 根据PAGE SIZE ,PAGENUM获得所需的链接
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyLink> findLinkByPageNum(int start, int pageSize)
			throws ServiceException {
		String m = "findLinkByPageNum";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", pageSize);
		List<ZyLink> links = linkDao.selectPaginationByPageNum(params);
		if (links == null) {
			warn(m, "can't found any links");
			return null;
		} else {
			info(m, "find " + links.size() + " links");
			return links;
		}

	}

	/**
	 * 根据PAGE SIZE ,PAGENUM,parent Id获得所需的链接分类
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyLink> findLinksByPageNumAndTypeId(int start, int pageSize,
			int typeId) throws ServiceException {
		String m = "findLinksByPageNumAndTypeId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", pageSize);
		params.put("typeId", typeId);
		List<ZyLink> links = linkDao.selectPaginationByPageNum(params);
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
	public int countLinkList(ZyLinkParams params) throws ServiceException {
		String method = "countLinkList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = linkDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count links by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count links success by params=" + params.toString());

		return result;
	}

	/**
	 * 获得所有的链接的总数
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countAllLinks() throws ServiceException {
		String m = "countAllLinks";
		ZyLinkParams params = new ZyLinkParams();
		int count = countLinkList(params);
		if (count == 0) {
			warn(m, "can't found any links,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * 获得所有的链接的总数,链接列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String, Object> map)
			throws ServiceException {
		String m = "countSearchPager";
		int count = linkDao.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any links,total count is zero!");
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
	public List<ZyLink> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyLink> links = linkDao.selectPaginationByPageNum(params);
		if (links == null) {
			warn(m, "can't found any links");
			return null;
		} else {
			info(m, "find " + links.size() + " links");
			return links;
		}

	}

}
