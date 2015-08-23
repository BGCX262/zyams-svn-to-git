package com.zhiye.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyIndex;
import com.zhiye.common.bean.ZyIndexParams;
import com.zhiye.dao.ZyIndexDAO;

public class IndexService extends CommonService {
	private ZyIndexDAO indexDao;


	public ZyIndexDAO getIndexDAO() {
		return indexDao;
	}

	public void setIndexDAO(ZyIndexDAO indexDao) {
		this.indexDao = indexDao;
	}

	/**
	 * 添加申报
	 * 
	 */
	public void addIndex(ZyIndex index) throws ServiceException {
		String method = "addIndex";
		if (index != null) {
			try {
				indexDao.insert(index);
			} catch (Exception e) {
				error(method, "add index dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add index successed! with index id="
				+ index.getId());
	}

	/**
	 * 更新申报
	 * 
	 * @param index
	 * @return
	 */
	public int updateIndex(ZyIndex index)
			throws ServiceException {
		String method = "updateIndex";
		int result = 0;
		if (null != index) {
			try {
				result = indexDao.updateByPrimaryKey(index);
			} catch (Exception e) {
				error(method, "update index DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update index success with indexid="
				+ index.getId());
		return result;
	}

	/**
	 * 根据主键ID 查询 ARTICLE
	 * 
	 * @param indexId
	 * @return
	 */
	public ZyIndex findIndexById(int indexId) throws ServiceException {
		String method = "findIndexById";
		ZyIndex resultIndex = null;
		if (indexId > 0) {
			try {
				resultIndex = indexDao.selectByPrimaryKey(indexId);
			} catch (Exception e) {
				error(method, "find index by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find index success by id =" + indexId);

		return resultIndex;
	}

	/**
	 * 根据主键ID删除申报
	 * 
	 * @param indexId
	 * @return
	 */
	public int removeIndexById(int indexId) throws ServiceException {
		String method = "removeIndexById";
		int result = 0;
		if (indexId > 0) {
			try {
				result = indexDao.deleteByPrimaryKey(indexId);
			} catch (Exception e) {
				error(method, "delete index by id exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed index by id=" + indexId);
		return result;
	}

	/**
	 * 批量查询 获得ARTICLE,支持大文本
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndex> findIndexListWithBLOB(
			ZyIndexParams params) throws ServiceException {
		String method = "findIndexList";
		List<ZyIndex> indexs = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			indexs = indexDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find index by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query indexs success by params=" + params.toString());

		return indexs;
	}

	/**
	 * 批量查询 获得ARTICLE,不支持大文本
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndex> findIndexListWithOutBLOB(ZyIndexParams params)
			throws ServiceException {
		String method = "findIndexList";
		List<ZyIndex> indexs = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			indexs = indexDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find index by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query indexs success by params=" + params.toString());

		return indexs;
	}

	/**
	 * 根据PAGE SIZE ,PAGENUM获得所需的新闻
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndex> findIndexByPageNum(int start, int pageSize)
			throws ServiceException {
		String m = "findIndexByPageNum";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", pageSize);
		List<ZyIndex> indexs = indexDao.selectPaginationByPageNum(params);
		if (indexs == null) {
			warn(m, "can't found any indexs");
			return null;
		} else {
			info(m, "find " + indexs.size() + " indexs");
			return indexs;
		}

	}

	/**
	 * 根据PAGE SIZE ,PAGENUM,parent Id获得所需的新闻分类
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndex> findIndexsByPageNumAndTypeId(int start,
			int pageSize, int typeId) throws ServiceException {
		String m = "findIndexsByPageNumAndTypeId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", pageSize);
		params.put("typeId", typeId);
		List<ZyIndex> indexs = indexDao.selectPaginationByPageNum(params);
		if (indexs == null) {
			warn(m, "can't found any indexs");
			return null;
		} else {
			info(m, "find " + indexs.size() + " indexs");
			return indexs;
		}

	}

	/**
	 * 根据跟定参数进行批量查询数量
	 * 
	 * @param params
	 * @return
	 */
	public int countIndexList(ZyIndexParams params) throws ServiceException {
		String method = "countIndexList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = indexDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count indexs by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count indexs success by params=" + params.toString());

		return result;
	}

	/**
	 * 获得所有的新闻的总数
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countAllIndexs() throws ServiceException {
		String m = "countAllIndexs";
		ZyIndexParams params = new ZyIndexParams();
		int count = countIndexList(params);
		if (count == 0) {
			warn(m, "can't found any indexs,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}



	/**
	 * 获得所有的新闻的总数,新闻列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String, Object> map)
			throws ServiceException {
		String m = "countSearchPager";
		int count = indexDao.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any indexs,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}


	/**
	 * ARTICLE 分页查询和搜索 获得所需的新闻
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndex> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyIndex> indexs = indexDao.selectPaginationByPageNum(params);
		if (indexs == null) {
			warn(m, "can't found any indexs");
			return null;
		} else {
			info(m, "find " + indexs.size() + " indexs");
			return indexs;
		}
	}

	
}
