package com.zhiye.services;

import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyDictionary;
import com.zhiye.common.bean.ZyPartment;
import com.zhiye.common.bean.ZyPartmentParams;
import com.zhiye.common.bean.ZyProduct;
import com.zhiye.common.bean.ZyProductParams;
import com.zhiye.common.bean.ZyRole;
import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.bean.ZyUserParams;
import com.zhiye.dao.ZyProductDAO;

public class ProductService extends CommonService {

	private ZyProductDAO productDAO;

	public ZyProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ZyProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@SuppressWarnings("unchecked")
	public List<ZyProduct> findAllProducts() {
		ZyProductParams params = new ZyProductParams();
		return (List<ZyProduct>) productDAO.selectByExample(params);
	}

	/**
	 * 根据用户名称查找用户
	 * 
	 * @param userName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ZyProduct findListProduct(String orderno) throws ServiceException {
		String method = "findListProduct";
		List<ZyProduct> resultProduct = null;
		ZyProductParams params = new ZyProductParams();
		params.createCriteria().andOrdernoEqualTo(orderno);
		try {
			resultProduct = productDAO.selectByExample(params);
		} catch (Exception e) {
			error(method, "find product exception:" + e.getMessage());
			throw new ServiceException(e, ServiceException.PARAMS_NULL_ERROR);
		}

		if (resultProduct != null && resultProduct.size() > 0) {
			info(method, "find product success by name =" + orderno);
			return resultProduct.get(0);

		} else {
			warn(method, "can 't find any product by name =" + orderno);
			return null;
		}

	}

	/**
	 * 查出所有产品信息
	 * 
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@param params
	 * @Parameter:@return
	 * @Parameter:@throws ServiceException
	 * @Return:List<ZyDictionary>
	 * @Throws
	 */
	public List<ZyProduct> finDictionaryid() throws ServiceException {
		String method = "finDictionaryid";
		List<ZyProduct> results = null;
		try {
			results = productDAO.selectByExample();
		} catch (Exception e) {
			error(method, "find Product by id exception:" + e.getMessage());
			throw new ServiceException(e, ServiceException.PARAMS_NULL_ERROR);
		}
		info(method, "find Product by id");
		return results;
	}

	/**
	 * 根据产品名称，查询
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ZyProduct findProductByName(String name) throws ServiceException {
		String method = "findProductByName";
		List<ZyProduct> products = null;
		if (null == name) {
			System.out.println("Name is empaty");
			throw new ServiceException(ServiceException.PARAMS_NULL_ERROR);
		}
		ZyProductParams params = new ZyProductParams();
		params.createCriteria().andProductNameEqualTo(name);
		try {
			products = productDAO.selectByExample(params);
		} catch (Exception e) {
			error(method, "find product by params=" + params.toString(), e);
			throw new ServiceException(ServiceException.QUERY_DAO_ERROR);
		}
		info(method, "query products success by name=" + params.toString());
		if (products != null && products.size() > 0) {
			return products.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 添加产品
	 * 
	 */
	public void addProduct(ZyProduct product) throws ServiceException {
		String method = "addProduct";
		if (product != null) {
			try {
				productDAO.insert(product);
			} catch (Exception e) {
				error(method, "add product dao exception!");
				throw new ServiceException(e, ServiceException.INSERT_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "add product successed! with product id="
				+ product.getProductid());
	}

	/**
	 * 根据主键ID 查询 product
	 * 
	 * @param roleId
	 * @return
	 */
	public ZyProduct findProductById(long id) throws ServiceException {
		String method = "findProductById";
		ZyProduct resultProduct = null;
		if (id > 0) {
			try {
				resultProduct = productDAO.selectByPrimaryKey(id);
			} catch (Exception e) {
				error(method, "find product by id exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.QUERY_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "find productID success by id =" + id);
		return resultProduct;
	}

	/**
	 * 根据主键ID删除产品
	 * 
	 * @param partmentId
	 * @return
	 */
	public long removeProductById(long Id) throws ServiceException {
		String method = "removeProductById";
		int result = 0;
		if (Id > 0) {
			try {
				result = productDAO.deleteByPrimaryKey(Id);
			} catch (Exception e) {
				error(method, "delete product by id exception:"
						+ e.getMessage());
				throw new ServiceException(e, ServiceException.DELETE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ID_NULL_ERROR);
		}
		info(method, "removed product by id=" + Id);
		return result;
	}

	/**
	 * 更新产品
	 * 
	 * @param partment
	 * @return
	 */
	public int updateProduct(ZyProduct product) throws ServiceException {
		String method = "updateProduct";
		int result = 0;
		if (null != product) {
			try {
				result = productDAO.updateByPrimaryKey(product);
			} catch (Exception e) {
				error(method, "update product DAO exception:" + e.getMessage());
				throw new ServiceException(e, ServiceException.UPDATE_DAO_ERROR);
			}
		} else {
			throw new ServiceException(ServiceException.ENTITY_NULL_ERROR);
		}
		info(method, "update product success with productid=" + product.getId());
		return result;
	}

	/**
	 * product 分页查询和搜索 获得所需的产品
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<ZyProduct> searchForPager(Map<String, Object> params)
			throws ServiceException {
		String m = "searchForPager";
		List<ZyProduct> Products = productDAO.selectPaginationByPageNum(params);
		if (Products == null) {
			warn(m, "can't found any products");
			return null;
		} else {
			info(m, "find " + Products.size() + " products");
			return Products;
		}

	}

	/**
	 * 获得所有的产品的总数,产品列表页面，分页
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public int countSearchPager(Map<String, Object> map)
			throws ServiceException {
		String m = "countSearchPager";
		int count = productDAO.countPaginationByPageNum(map);
		if (count == 0) {
			warn(m, "can't found any products ,total count is zero!");
			return 0;
		} else {
			info(m, "the total count is " + count);
			return count;
		}

	}
}
