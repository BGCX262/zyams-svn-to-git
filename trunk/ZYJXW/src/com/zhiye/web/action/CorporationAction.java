package com.zhiye.web.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.xwork.tree.IntInsnNode;

import com.sun.org.apache.bcel.internal.classfile.Code;
import com.zhiye.*;
import com.zhiye.common.bean.ZyArticleType;
import com.zhiye.common.bean.ZyCorporation;
import com.zhiye.common.bean.ZyCorporationProduct;
import com.zhiye.common.bean.ZyDictionary;
import com.zhiye.common.bean.ZyProduct;
import com.zhiye.common.bean.ZyProductParams;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Pager;
import com.zhiye.services.CorporationProductService;
import com.zhiye.services.CorporationService;
import com.zhiye.services.DictionaryService;
import com.zhiye.services.ProductService;
import com.zhiye.services.ServiceException;

/**
 * @FileName:CorporationAction.java
 * @ClassPath:com.zhiye.web.action
 * @Author:Arthur
 * @Create Time:2012-4-24下午09:42:33
 * @Email:arthurkingtoo@foxmail.com
 * @Company:www.maszy.cn
 */
public class CorporationAction extends GenericActionSupport<ZyCorporation>{

	private static final long serialVersionUID = 1L;
	
	ZyCorporation corporation;
	
	CorporationService corporationService;
	
	DictionaryService dictionaryService;
	ZyDictionary dictionary;
	
	ZyProduct product;
	
	ProductService productService;
	
	ZyCorporationProduct corporationProduct;
	
	CorporationProductService corporationProductService;
	
	ZyProductParams param;

	public ZyCorporationProduct getCorporationProduct() {
		return corporationProduct;
	}

	public void setCorporationProduct(ZyCorporationProduct corporationProduct) {
		this.corporationProduct = corporationProduct;
	}

	public CorporationProductService getCorporationProductService() {
		return corporationProductService;
	}

	public void setCorporationProductService(
			CorporationProductService corporationProductService) {
		this.corporationProductService = corporationProductService;
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

	public ZyDictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(ZyDictionary dictionary) {
		this.dictionary = dictionary;
	}

	public int rowid;
	
	public String id;
	
	public String password;
	
	public String name;
	
	public String areaid;
	
	public String tradeid;
	
	public String activation;
	
	public String is50;
	
	public String is100;
	
	public String orderno;
	
	public String isnew;
	
	public String area;
	
	public String address;
	
	public String taxnumber;
	
	public String workername;
	
	public String tel;
	
	public String mobile;
	
	public String email;
	
	public String postcode;
	
	public String faxes;
	
	public String infor;
	
	public String remark;
	
	public String weburl;
	
	public int byorder;
	
	public String bak1;
	
	public String bak2;
	
	public String bak3;
	
	public int bak4;
	
	public int bak5;
	
	public int bak6;

	
	
	/**
	 * 列出所有企业
	 * 
	 * */
	public String listCorporation(){
		String m = "listCorporation";
		List<ZyCorporation> corporations = null;
		try{
			
			//TEST
			Map<String,Object> params1=new HashMap<String,Object>();
			params1.put("month", 3);
			params1.put("year", 2012);
			params1.put("areaId", 23);
			params1.put("tradeId", 28);	
			params1.put("corporationId", 1);	
			
			
			corporationService.searchListByArea(params1);
			
			corporationService.searchListByTrade(params1);
			
			corporationService.searchListByCorp(params1);
			params1.put("isSpec", '是');		
			corporationService.searchListByCorp(params1);
			
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
			//搜索
			if(null!=name && name.trim().length()>0 && !name.equals("all")){
				params.put("name",name);
			}
			if(null!=id && id.trim().length()>0 && !id.equals("all")){
				params.put("id",id);
			}
			corporations =corporationService.searchForPager(params);
			//搜索结束
			params.remove("start");
			
			params.remove("size");
			
			int count = corporationService.countSearchPager(params);
			
			pager = new Pager<ZyCorporation>(pageNum, numPerPage);
			
			pager.setPageRecords(corporations);
			
			pager.setTotalRecords(count);
			
			info(m, "find the " + count + " corporations");
			
		}catch(ServiceException e){
			error(m, "find all corporations exeption", e);
		}catch(Exception e){
			error(m, "find all corporations exeption", e);
		}
			
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		return "success";
	}
	
	/**
	 * @Author:Arthur
	 * @Time:2012-4-24
	 * @Parameter:@return
	 * @Return:String
	 * @Throws 
	 * 点击添加跳转到新增页面
	 */
	public String addCorporation() {
		String m = "addCorporation";
		List<ZyDictionary> dictionarys=null;
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("dictid", 102);
			//查询所属区域
			dictionarys=dictionaryService.finDictionaryDictid(params);
			if(null != dictionarys){
				request.setAttribute("dictionarys", dictionarys);
				params.remove("dictid");
			}
			//查询行业
			List<ZyDictionary> trades=null;
			params.put("dictid", 108);
			trades=dictionaryService.finDictionaryDictid(params);
			if(null != trades){
				request.setAttribute("trades", trades);
				params.remove("dictid");
			}
			//查询地区
			List<ZyDictionary> areas=null;
			params.put("dictid", 107);
			areas=dictionaryService.finDictionaryDictid(params);
			if(null != areas){
				request.setAttribute("areas", areas);
				params.remove("dictid");
			}
			//查询产品信息
			List<ZyProduct> products=null;
			products=productService.finDictionaryid();
			if(null != products){
				request.setAttribute("product", products);
			}
		}catch(ServiceException e){
			error(m, "find all dictionarys exeption", e);
		}catch(Exception e){
			error(m, "find all dictionarys exeption", e);
		}
		return "add";
	}
	
	/**
	 *编辑,跳转到编辑页面
	 * */
	public String editCorporation(){
		String m="editCorporation";
		info(m, "edit the editenterprise");
		List<ZyDictionary> dictionarys=null;
		try{
			corporation = corporationService.findcorporationById(rowid);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("dictid", 102);
			//查询所属区域
			dictionarys=dictionaryService.finDictionaryDictid(params);
			if(null != dictionarys){
				request.setAttribute("dictionarys", dictionarys);
				params.remove("dictid");
			}
			//查询行业
			List<ZyDictionary> trades=null;
			params.put("dictid", 108);
			trades=dictionaryService.finDictionaryDictid(params);
			if(null != trades){
				request.setAttribute("trades", trades);
				params.remove("dictid");
			}
			//查询地区
			List<ZyDictionary> areas=null;
			params.put("dictid", 107);
			areas=dictionaryService.finDictionaryDictid(params);
			if(null != areas){
				request.setAttribute("areas", areas);
				params.remove("dictid");
			}
			request.setAttribute("corporation", corporation);
			
			//查询产品信息
			List<ZyProduct> products=null;
			products=productService.finDictionaryid();
			if(null != products){
				request.setAttribute("product", products);
			}
			//查询corporacton product信息
			List<ZyCorporationProduct> corporactonproducts=null;
			corporactonproducts=corporationProductService.finDictionaryid(corporation.getId());
			if(null != corporactonproducts){
				request.setAttribute("corporactonproduct", corporactonproducts);
			}
		}catch(ServiceException e){
			error(m, "find all dictionarys exeption", e);
		}catch(Exception e){
			error(m, "find all dictionarys exeption", e);
		}
		return "success";
	}
	
	/**
	 * 编辑企业管理
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@return
	 * @Return:String
	 * @Throws
	 */
	public String doEditCorporation(){
		String m="doEditCorporation";
		info(m, "edit the editEnterprise,by Corporation rowid"+rowid);
		int result=0;
		int resultProduct=0;
		try{
			//更新corporationService
			result = corporationService.updateCorporation(corporation);
			//更新corporationProductService,先删除企业旗下 所有产品,然后再增加,实现更新方式
			corporationProductService.removeCorporationProduct(corporationProduct.getCorportationid());
			//增加
			String[] ssString=corporationProduct.getProductid().split(",");
			for(String s:ssString){
				corporationProduct.setProductid(s.trim());
				corporationProductService.addCorporationProduct(corporationProduct);
			}
		}catch(ServiceException e){
			error(m,"unknown");
		}catch (Exception e) {
			// TODO: handle exception
			error(m, "unknown exeption", e);
		}
		if(result > 0 ){
			this.callbackType = "closeCurrent";
			this.message = "修改成功";
			this.statusCode = "200";
			this.navTabId = "listCorporation";
			return "ajaxDone";
		}else{
			return null;
		}
	}
	/**
	 * 增加
	 * */
	public String doAddCorporation(){
		String m="doAddCorporation";
		info(m,"add the corporation"+ corporation);
		try{
			corporationService.addCorporation(corporation);
			info(m, "add corporation view  premisison,corporation=" + corporation);
			//增加corporationProduct内容
			String[] ssString=corporationProduct.getProductid().split(",");
			for(String s:ssString){
				corporationProduct.setProductid(s.trim());
				corporationProductService.addCorporationProduct(corporationProduct);
			}
				
			info(m, "add corporationProduct view  premisison,corporationProduct=" + corporationProduct);
		}catch(ServiceException e){
			error(m, "add the corporation",e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addCorporation";
			info(m, "add the corporation failed with title="
					+ corporation.getName());
			return "ajaxDone";
		}catch(Exception e){
			error(m, "unknown corporation", e);
		}
		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		this.navTabId = "listCorporation";
		return "ajaxDone";
	}

	
	/**
	 * 删除一个企业
	 * @Author:Arthur
	 * @Time:2012-4-25
	 * @Parameter:@return
	 * @Return:String
	 * @Throws
	 */
	public String removeCorporation(){
		String m="removeCorporation";
		info(m,"delete the corporation"+ corporation + rowid);
		int result = 0;
		int results=0;
		try{
			//删除企业
			result=corporationService.deleteCorporation(rowid);
			//删除企业下所有相关产品
			results=corporationProductService.removeCorporationProduct(request.getParameter("corportationid"));
			info(m, "delete corporation view  premisison,corporation=" + corporation);
		}catch(NumberFormatException e){
			error(m, "add the corporation",e);
		}catch(Exception e){
			error(m, "unknown corporation", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listCorporation";
			this.forwardUrl = "listCorporation.action";
			info(m, "remove the corporation successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the corporation failed!");
		}
		return "ajaxDone";
	}
	
	
	
	// 批量删除corporation
	public String removeCorporations() {
		String m = "removeCorporations";
		info(m, "corporation ids is" + entityIds);
		long result = 0;
		try {
			for (String id : entityIds.split(",")) {
				result = corporationService.deleteCorporation(Integer.parseInt(id.trim()));
			}
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the corporation with id=" + entityIds, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listCorporation";
//			this.forwardUrl = "listProducts.action";
			info(m, "remove the corporation successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the corporation failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "ajaxDone";
	}
	
	
	
	
	
	
	
	
	public ZyCorporation getCorporation() {
		return corporation;
	}

	public void setCorporation(ZyCorporation corporation) {
		this.corporation = corporation;
	}

	public CorporationService getCorporationService() {
		return corporationService;
	}

	public void setCorporationService(CorporationService corporationService) {
		this.corporationService = corporationService;
	}



	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public int getRowid() {
		return rowid;
	}

	public void setRowid(int rowid) {
		this.rowid = rowid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getTradeid() {
		return tradeid;
	}

	public void setTradeid(String tradeid) {
		this.tradeid = tradeid;
	}

	public String getActivation() {
		return activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}

	public String getIs50() {
		return is50;
	}

	public void setIs50(String is50) {
		this.is50 = is50;
	}

	public String getIs100() {
		return is100;
	}

	public void setIs100(String is100) {
		this.is100 = is100;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getIsnew() {
		return isnew;
	}

	public void setIsnew(String isnew) {
		this.isnew = isnew;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTaxnumber() {
		return taxnumber;
	}

	public void setTaxnumber(String taxnumber) {
		this.taxnumber = taxnumber;
	}

	public String getWorkername() {
		return workername;
	}

	public void setWorkername(String workername) {
		this.workername = workername;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getFaxes() {
		return faxes;
	}

	public void setFaxes(String faxes) {
		this.faxes = faxes;
	}

	public String getInfor() {
		return infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public int getByorder() {
		return byorder;
	}

	public void setByorder(int byorder) {
		this.byorder = byorder;
	}

	public String getBak1() {
		return bak1;
	}

	public void setBak1(String bak1) {
		this.bak1 = bak1;
	}

	public String getBak2() {
		return bak2;
	}

	public void setBak2(String bak2) {
		this.bak2 = bak2;
	}

	public String getBak3() {
		return bak3;
	}

	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}

	public int getBak4() {
		return bak4;
	}

	public void setBak4(int bak4) {
		this.bak4 = bak4;
	}

	public int getBak5() {
		return bak5;
	}

	public void setBak5(int bak5) {
		this.bak5 = bak5;
	}

	public int getBak6() {
		return bak6;
	}

	public void setBak6(int bak6) {
		this.bak6 = bak6;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
