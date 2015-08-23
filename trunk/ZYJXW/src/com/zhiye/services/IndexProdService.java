package com.zhiye.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyCorporationProduct;
import com.zhiye.common.bean.ZyCorporationProductParams;
import com.zhiye.common.bean.ZyIndex;
import com.zhiye.common.bean.ZyIndexProd;
import com.zhiye.common.bean.ZyIndexProdParams;
import com.zhiye.dao.ZyIndexProdDAO;

public class IndexProdService extends CommonService {
	private ZyIndexProdDAO indexProdDao;

	public ZyIndexProdDAO getIndexProdDAO() {
		return indexProdDao;
	}

	public void setIndexProdDAO(ZyIndexProdDAO indexProdDao) {
		this.indexProdDao = indexProdDao;
	}

	/**
	 * 
	 */
	public void addIndexProd(ZyIndexProd indexProd) throws ServiceException {
		String method = "addIndexProd";
		if (indexProd != null) {
			try {
				indexProdDao.insert(indexProd);
			} catch (Exception e) {
				error(method, "add indexProd dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add indexProd successed! with indexProd id="
				+ indexProd.getId());
	}

	/**
	 * 
	 * @param indexProd
	 * @return
	 */
	public int updateIndexProd(ZyIndexProd indexProd) throws ServiceException {
		String method = "updateIndexProd";
		int result = 0;
		if (null != indexProd) {
			try {
				result = indexProdDao.updateByPrimaryKey(indexProd);
			} catch (Exception e) {
				error(method, "update indexProd DAO exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update indexProd success with indexProdid="
				+ indexProd.getId());
		return result;
	}

	/**
	 * 
	 * @param indexProdId
	 * @return
	 */
	public ZyIndexProd findIndexProdById(int indexProdId)
			throws ServiceException {
		String method = "findIndexProdById";
		ZyIndexProd resultIndexProd = null;
		if (indexProdId > 0) {
			try {
				resultIndexProd = indexProdDao.selectByPrimaryKey(indexProdId);
			} catch (Exception e) {
				error(method, "find indexProd by id exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find indexProd success by id =" + indexProdId);

		return resultIndexProd;
	}

	/**
	 * 
	 * @param indexProdId
	 * @return
	 */
	public int removeIndexProdById(int indexProdId) throws ServiceException {
		String method = "removeIndexProdById";
		int result = 0;
		if (indexProdId > 0) {
			try {
				result = indexProdDao.deleteByPrimaryKey(indexProdId);
			} catch (Exception e) {
				error(method, "delete indexProd by id exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed indexProd by id=" + indexProdId);
		return result;
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndexProd> findIndexProdList(ZyIndexProdParams params)
			throws ServiceException {
		String method = "findIndexProdList";
		List<ZyIndexProd> indexProds = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			indexProds = indexProdDao.selectByParams(params);
		} catch (Exception e) {
			error(method, "find indexProd by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query indexProds success by params=" + params.toString());

		return indexProds;
	}


	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndexProd> findIndexProdByPageNum(int start, int pageSize)
			throws ServiceException {
		String m = "findIndexProdByPageNum";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", pageSize);
		List<ZyIndexProd> indexProds = indexProdDao
				.selectPaginationByPageNum(params);
		if (indexProds == null) {
			warn(m, "can't found any indexProds");
			return null;
		} else {
			info(m, "find " + indexProds.size() + " indexProds");
			return indexProds;
		}

	}

	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndexProd> findIndexProdsByPageNumAndTypeId(int start,
			int pageSize, int typeId) throws ServiceException {
		String m = "findIndexProdsByPageNumAndTypeId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", pageSize);
		params.put("typeId", typeId);
		List<ZyIndexProd> indexProds = indexProdDao
				.selectPaginationByPageNum(params);
		if (indexProds == null) {
			warn(m, "can't found any indexProds");
			return null;
		} else {
			info(m, "find " + indexProds.size() + " indexProds");
			return indexProds;
		}

	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public int countIndexProdList(ZyIndexProdParams params)
			throws ServiceException {
		String method = "countIndexProdList";
		int result = 0;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			result = indexProdDao.countByParams(params);
		} catch (Exception e) {
			error(method, "count indexProds by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "count indexProds success by params=" + params.toString());

		return result;
	}

	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countAllIndexProds() throws ServiceException {
		String m = "countAllIndexProds";
		ZyIndexProdParams params = new ZyIndexProdParams();
		int count = countIndexProdList(params);
		if (count == 0) {
			warn(m, "can't found any indexProds,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String, Object> map)
			throws ServiceException {
		String m = "countSearchPager";
		int count = indexProdDao.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any indexProds,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}

	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndexProd> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyIndexProd> indexProds = indexProdDao
				.selectPaginationByPageNum(params);
		if (indexProds == null) {
			warn(m, "can't found any indexProds");
			return null;
		} else {
			info(m, "find " + indexProds.size() + " indexProds");
			return indexProds;
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndexProd> searchListByCorp(Map<String, Object> params)
			throws ServiceException {
		String m = "searchListByCorp";
		List<ZyIndexProd> indexs = indexProdDao.selectIndexProdWithCorp(params);
		if (indexs == null) {
			warn(m, "can't found any indexs");
			return null;
		} else {
			info(m, "find " + indexs.size() + " indexs");
			return indexs;
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyIndexProd> searchListByProd(Map<String, Object> params)
			throws ServiceException {
		String m = "searchListByProd";
		List<ZyIndexProd> indexs = indexProdDao.selectIndexProdWithProduct(params);
		if (indexs == null) {
			warn(m, "can't found any indexs");
			return null;
		} else {
			info(m, "find " + indexs.size() + " indexs");
			return indexs;
		}
	}

}
