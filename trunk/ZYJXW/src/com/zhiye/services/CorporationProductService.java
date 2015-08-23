package com.zhiye.services;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyCorporationProduct;
import com.zhiye.common.bean.ZyProduct;
import com.zhiye.dao.ZyCorporationProductDAO;

public class CorporationProductService extends CommonService {

	private ZyCorporationProductDAO corporationProductDAO;

	public ZyCorporationProductDAO getCorporationProductDAO() {
		return corporationProductDAO;
	}

	public void setCorporationProductDAO(
			ZyCorporationProductDAO corporationProductDAO) {
		this.corporationProductDAO = corporationProductDAO;
	}

	/**
	 * 
	 * 增加corporationProduct表中一条记录
	 */
	public void addCorporationProduct(ZyCorporationProduct corporationProduct)
			throws ServiceException {
		String method = "addCorporationProduct";
		if (corporationProduct != null) {
			try {
				corporationProductDAO.insert(corporationProduct);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method,
				"add corporationProduct successed! with corporationProduct id="
						+ corporationProduct.getRowid());
	}

	public int removeCorporationProduct(String corportationid)
			throws ServiceException {
		String method = "removeCorporationProduct";
		info(method, "delete corporationProduct by id=" + corportationid);
		int results = 0;
		if (null != corportationid) {
			try {
				corporationProductDAO.deleteByPrimaryKey(corportationid);
			} catch (Exception e) {
				// TODO: handle exception
				error(method, "Delete failed");
				throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
			}
			info(method,
					"delete corporationProduct successed! with corporationProduct id="
							+ corportationid);
		}
		return results;
	}

	/**
	 * 
	 * 增加corporationProduct表中一条记录
	 */
	public void addCorporationProductID(String productid)
			throws ServiceException {
		String method = "addCorporationProductID";
		if (productid != null) {
			try {
				corporationProductDAO.insert(productid);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method,
				"add corporationProduct successed! with corporationProduct id="
						+ productid);
	}

	/**
	 * 编辑,企业管理
	 * 
	 * @throws ServiceException
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@return
	 * @Return:int
	 * @Throws
	 */
	public int updateCorporation(ZyCorporationProduct corporationProduct)
			throws ServiceException {
		String method = "updateCorporation";
		int result = 0;
		if (null != corporationProduct) {
			try {
				result = corporationProductDAO
						.updateByPrimaryKey(corporationProduct);
			} catch (Exception e) {
				error(method, "update corporation DAO exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update corporation success with corporation id="
				+ corporationProduct.getRowid());
		return result;
	}

	/**
	 * 查出所有信息
	 * 
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@param params
	 * @Parameter:@return
	 * @Parameter:@throws ServiceException
	 * @Return:List<ZyDictionary>
	 * @Throws
	 */
	public List<ZyCorporationProduct> finDictionaryid(String id)
			throws ServiceException {
		String method = "finDictionaryid";
		List<ZyCorporationProduct> results = null;
		try {
			results = corporationProductDAO
					.selectByParamssCorporationProduct(id);
		} catch (Exception e) {
			error(method, "find CorporationProduct by id exception:"
					+ e.getMessage());
			throw new ServiceException(e, ServiceException.PARAMS_NULL_ERROR);
		}
		info(method, "find CorporationProduct by id");
		return results;
	}

	public List<ZyProduct> findCorporationProductList(
			Map<String,Object> params) throws ServiceException {
		String method = "findCorporationProductList";
		List<ZyProduct> products = null;
		if (null == params) {
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		try {
			products = corporationProductDAO.selectByParams(params);
		} catch (Exception e) {
			error(method, "find products by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query products success by params=" + params.toString());

		return products;
	}
}
