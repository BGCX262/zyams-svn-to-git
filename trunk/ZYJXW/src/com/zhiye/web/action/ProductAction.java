package com.zhiye.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.jexl2.internal.AbstractExecutor.Set;

import com.zhiye.common.bean.ZyPartment;
import com.zhiye.common.bean.ZyProduct;
import com.zhiye.common.bean.ZyRole;
import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Pager;
import com.zhiye.services.ProductService;
import com.zhiye.services.ServiceException;

public class ProductAction extends GenericActionSupport<ZyProduct>{

	private static final long serialVersionUID = 1L;
	
	ZyProduct product;
	
	ProductService productService;
	public Long id;
	public Long productid;
	
	public String productName;
	
	public String unit;
	
	public String orderno;
	
	List<ZyProduct> products;
	
	public List<ZyProduct> getProducts() {
		return products;
	}

	public void setProducts(List<ZyProduct> products) {
		this.products = products;
	}
	
	/*
	 * 列出所有产品
	 * 
	 * */
	public String listProducts() {
		String m = "listProducts";
		List<ZyProduct> products=null;
		try {
			if(numPerPage==0){
				numPerPage = Config.getInt("pager.page_size");
			}
			int start = 0;
			if (pageNum > 1) {
				start = (pageNum - 1) * numPerPage;
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("start", start);
			params.put("size", numPerPage);
//			//搜索功能
			if(null!=productName&&productName.trim().length()>0&&!productName.equals("all")){
				params.put("productName",productName);
			}
			if(null!=productid && productid.toString().trim().length()>0 && !productid.equals("all")){
				params.put("productid",productid);
			}
			products = productService.searchForPager(params);
			params.remove("start");
			params.remove("size");
			int count = productService.countSearchPager(params);
			
			pager = new Pager<ZyProduct>(pageNum, numPerPage);
			
			pager.setPageRecords(products);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " products");

		} catch (ServiceException e) {
			error(m, "find all partments exeption", e);
		} catch (Exception e) {
			error(m, "find all partments exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		return "success";
	}
	
	/**
	 * 点击添加按钮，跳转到添加页面
	 * 
	 * @return
	 */
	public String addProduct() {
		String m = "addProduct";
		return "add";
	}
	
	/**
	 * 添加一个产品
	 * 
	 * @return
	 */
	public String doAddProduct() {
		String m = "doAddProduct";
		info(m, "add the product  =" + product);
		try {
			ZyProduct temp = productService.findProductByName(product.getProductName());
			if (temp != null) {
				this.message = "添加失败,产品已存在！";
				this.statusCode = "300";
				this.navTabId = "addProduct";
				info(m,
						"add the product failed product name existsed ,with title="
								+ product.getProductName());
				return "ajaxDone";
			}
			productService.addProduct(product);

			info(m, "add product view  premisison,productid=" + productid);

		} catch (ServiceException e) {
			error(m, "add the product  exception", e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addProduct";
			info(m, "add the product failed with title="
					+ product.getProductName());
			return "ajaxDone";
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		this.navTabId = "listProducts";

		info(m, "add the partment success with partment title="
				+ product.getProductName());
		return "ajaxDone";
	}
	
	
	// 删除product
	public String removeProduct() {
		String m = "removeProduct";
		info(m, "product Id is" +id);
		long result = 0;
		try {
			result = productService.removeProductById(id);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the Product with id=" + id, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listProducts";
			this.forwardUrl = "listProducts.action";

			info(m, "remove the Product successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the Product failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}
	
	
	// 批量删除product
	public String removeProducts() {
		String m = "removeProducts";
		info(m, "products ids is" + entityIds);
		long result = 0;
		try {
			for (String id : entityIds.split(",")) {
				result = productService.removeProductById(Integer.parseInt(id.trim()));
			}
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the product with id=" + entityIds, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listProducts";
//			this.forwardUrl = "listProducts.action";
			info(m, "remove the product successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the product failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "ajaxDone";
	}
	
	/**
	 * 编辑一个产品，跳转到编辑页面
	 * 
	 * @return
	 */
	public String editProduct() {
		String m = "editProduct";
		info(m, "edit the Product  with Product id=" + id);
		try {
			product = productService.findProductById(id);
		} catch (ServiceException e) {
			error(m, "find the Product exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (null != product) {
			request.setAttribute("product", product);
			info(m, "find the partment  success with product Id=" + id);
			return "success";
		} else {
			this.callbackType = "forward";
			this.callbackType = "listProducts.action";

			this.message = "操作失败";
			this.statusCode = "300";
			this.navTabId = "listProducts";
			info(m, "find the product failed with product Id=" + id);
			return "ajaxDone";
		}
	}
	
	/**
	 * 编辑一个产品
	 * 
	 * @return
	 */
	public String doEditProduct() {
		String m = "doEditProduct";
		info(m, "edit the product  with product id="+product.getId());
		int result = 0;
		try {
			ZyProduct productTemp = productService.findProductById(product.getId());
			ZyProduct temp = productService.findProductByName(product.getProductName());
			result = productService.updateProduct(product);
			 if ((temp != null) && (productTemp.getId() == temp.getId())) {
				 this.message = "编辑失败,产品已存在！";
				 this.statusCode = "300";
				 this.navTabId = "addProduct";
				 info(m, "update the Product failed Product name existsed with name="
				 + product.getProductName());
				 return "ajaxDone";
				 }
		} catch (ServiceException e) {
			error(m, "find the Product  exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "closeCurrent";
			this.message = "编辑成功";
			this.statusCode = "200";
			this.navTabId = "listProducts";
			info(m, "update the Product  success with Product id="
					+ product.getId());
		} else {
			this.message = "编辑失败";
			this.statusCode = "300";
			this.navTabId = "editProduct";

			info(m, "find the Product type failed with Product id="
					+ product.getId());
		}
		return "ajaxDone";
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZyProduct getProduct() {
		return product;
	}

	public void setProduct(ZyProduct product) {
		this.product = product;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}


}
