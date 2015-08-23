package com.zhiye.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyDictclass;
import com.zhiye.common.bean.ZyDictionary;
import com.zhiye.common.bean.ZyProduct;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Pager;
import com.zhiye.services.DictclassService;
import com.zhiye.services.DictionaryService;
import com.zhiye.services.ServiceException;

public class DictionaryAction extends GenericActionSupport<ZyDictionary>{
		
	private static final long serialVersionUID = 1L;
	
	ZyDictclass dictclass;
	
	ZyDictionary dictionary;
	
	public String dictid;
	
	public String dictname;
	
	public String visible;
	
	public Integer code;
	
	public String name;
	
	public Integer flag;
	
	public String remarks;
	DictionaryService dictionaryService;
	DictclassService dictclassService;

	public DictclassService getDictclassService() {
		return dictclassService;
	}

	public void setDictclassService(DictclassService dictclassService) {
		this.dictclassService = dictclassService;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	List<ZyDictionary> dictionarys;

	public List<ZyDictionary> getDictionarys() {
		return dictionarys;
	}

	public void setDictionarys(List<ZyDictionary> dictionarys) {
		this.dictionarys = dictionarys;
	}

	
	
	/*
	 * 列出,行业,地区,所在区域
	 * 
	 * @modle
	 * 
	 * */
	public String listDictionary(){
		String m = "listDictionary";
		List<ZyDictionary> dictionarys = null;
		try{
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
			//搜索结束
			if("108".equals(dictid)){
				params.put("dictid",dictid);
			}else if("107".equals(dictid)){
				params.put("dictid",dictid);
			}else if("102".equals(dictid)){
				params.put("dictid",dictid);
			}
			dictionarys = dictionaryService.searchForPager(params);
			params.remove("start");
			
			params.remove("size");
			
			int count = dictionaryService.countSearchPager(params);
			
			pager = new Pager<ZyDictionary>(pageNum, numPerPage);
			
			pager.setPageRecords(dictionarys);
			
			pager.setTotalRecords(count);
			
			info(m, "find the " + count + " dictionarys");
			
		}catch(ServiceException e){
			error(m, "find all dictionarys exeption", e);
		}catch(Exception e){
			error(m, "find all dictionarys exeption", e);
		}
			
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		return "success";
	}
	
	
	
	/*
	 * 添加页面跳转，行业，地区
	 * */
	
	public String addDictionary(){
		String m = "addDictionary";
		return "add";
	}
	
	
	
	/*
	 * 添加一个行业，地区
	 * */
	public String doAddDictionary(){
		String m="doAddDictionary";
		info(m, "add the dictionary  =" + dictionary);
		try{
			/*
			 *   由于行业和地区在一个表中,使用字典的形式,根据dictid 来添加,不会产生表内容混乱,所以去掉这段查询重复的代码!
			 * */
			ZyDictionary temp = dictionaryService.findDictionaryByName(dictionary.getName(),dictionary.getDictid());
			if (temp != null) {
				if(dictionary.getDictid().equals("108")){
					this.message = "添加失败,行业已存在！";
					this.statusCode = "300";
					this.navTabId = "addTrade";
					}else{
						this.message = "添加失败,地区已存在！";
						this.statusCode = "300";
					this.navTabId = "addArea";
					}
				info(m,
						"add the dictionary failed dictionary name existsed ,with title="
								+ dictionary.getName());
				return "ajaxDone";
			}
			dictionaryService.addDictionary(dictionary);

			info(m, "add dictionary view  premisison,dictionaryid=" + code);
		}catch(ServiceException e){
			if(dictionary.getDictid().equals("108")){
				error(m, "add the dictionary  exception", e);
				this.message = "添加行业失败";
				this.statusCode = "300";
			this.navTabId = "addTrade";
			}else if(dictionary.getDictid().equals("107")){
				error(m, "add the dictionary  exception", e);
				this.message = "添加地区失败";
				this.statusCode = "300";
			this.navTabId = "addArea";
			}
			info(m, "add the dictionary failed with title="
					+ dictionary.getName());
			return "ajaxDone";
		}catch(Exception e){
			error(m, "unknown exeption", e);
		}
		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		if(dictionary.getDictid().equals("108")){
			this.callbackType = "forward";
			this.message = "添加行业成功";
			this.statusCode = "200";
			this.navTabId = "listTrades";
			this.forwardUrl = "listTrades.action?dictid=108";
			
			}else if(dictionary.getDictid().equals("107")){
				this.callbackType = "forward";
				this.message = "添加地区成功";
				this.statusCode = "200";
				this.navTabId = "listAreas";
				this.forwardUrl = "listAreas.action?dictid=107";
			}
		info(m, "add the dictionary success with dictionary title="
				+ dictionary.getName());
		return "ajaxDone";
	}
	
	
	
	
	/*
	 * 删除单条，行业，地区
	 * */
	public String removeDictionary(){
		String m = "removeDictionary";
		info(m, "dictionary Id is" +code);
		int result = 0;
		try {
			result = dictionaryService.removeDictionaryById(code);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the dictionary with id=" + code, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			if(dictid.equals("108")){
			this.callbackType = "forward";
			this.message = "删除行业成功";
			this.statusCode = "200";
			this.navTabId = "listTrade";
			this.forwardUrl = "listTrades.action?dictid=108";
			}else if(dictid.equals("107")){
				this.callbackType = "forward";
				this.message = "删除地区成功";
				this.statusCode = "200";
				this.navTabId = "listTrade";
				this.forwardUrl = "listTrades.action?dictid=107";
			}
			info(m, "remove the dictionary successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the dictionary failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}
	
	
	
	/*
	 * 
	 * 批量删除,行业,地区
	 * 
	 * */
	public String removeDictionarys() {
		String m = "removeDictionarys";
		info(m, "dictionarys id is" + entityIds);
		int result = 0;
		try {
			for (String code : entityIds.split(",")) {
				result = dictionaryService.removeDictionaryById(Integer.parseInt(code.trim()));
			}
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the dictionary with id=" + entityIds, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			if(dictid.equals("108")){
			this.callbackType = "forward";
			this.message = "删除行业成功";
			this.statusCode = "200";
			this.navTabId = "listTrades";
			this.forwardUrl = "listTrades.action?dictid=108";
			}else if(dictid.equals("107")){
				this.callbackType = "forward";
				this.message = "删除地区成功";
				this.statusCode = "200";
				this.navTabId = "listAreas";
				this.forwardUrl = "listAreas.action?dictid=107";
			}
			info(m, "remove the dictionary successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the dictionary failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "ajaxDone";
	}
	
	
	
	/**
	 * 编辑一个行业,地区,跳转到编辑页面
	 * 
	 * @return
	 */
	public String editDictionary() {
		String m = "editDictionary";
		info(m, "edit the Dictionary  with Dictionary id=" + code);
		try {
			dictionary = dictionaryService.findDictionaryById(code);
		} catch (ServiceException e) {
			error(m, "find the Dictionary exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (null != dictionary) {
			request.setAttribute("dictionary", dictionary);
			info(m, "find the partment  success with dictionary Id=" + code);
			return "success";
		} else {
			if(dictionary.getDictid().equals("108")){
			this.callbackType = "forward";
			this.callbackType = "listTrades.action?dictid=108";
			this.message = "操作行业失败";
			this.statusCode = "300";
			this.navTabId = "listTrades";
			info(m, "find the dictionary failed with dictionary Id=" + code);
			}else if(dictionary.getDictid().equals("107")){
				this.callbackType = "forward";
				this.callbackType = "listAreas.action?dictid=107";
				this.message = "操作地区失败";
				this.statusCode = "300";
				this.navTabId = "listAreas";
				info(m, "find the dictionary failed with dictionary Id=" + code);
			}
			return "ajaxDone";
		}
	}
	
	/**
	 * 编辑一个行业,地区
	 * 
	 * @return
	 */
	public String doEditDictionary() {
		String m = "doEditDictionary";
		info(m, "edit the Dictionary  with Dictionary id="+dictionary.getCode());
		int result = 0;
		try {
			/*
			 *   由于行业和地区在一个表中,使用字典的形式,根据code 来修改,不会产生表内容混乱,所以去掉这段查询重复的代码!
			 * */
//			ZyDictionary dictionaryTemp = dictionaryService.findDictionaryById(dictionary.getCode());
//			ZyDictionary temp = dictionaryService.findDictionaryByName(dictionary.getName(),dictionary.getDictid());
			result = dictionaryService.updateDictionary(dictionary);
//			 if ((temp != null) && (dictionaryTemp.getCode() != temp.getCode())) {
//				 this.message = "编辑失败,行业已存在！";
//				 this.statusCode = "300";
//				 this.navTabId = "addTrade";
//				 info(m, "update the Dictionary failed Dictionary name existsed with name="
//				 + dictionary.getName());
//				 return "ajaxDone";
//				 }
		} catch (ServiceException e) {
			error(m, "find the Dictionary  exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			if(dictionary.getDictid().equals("108")){
			this.callbackType = "forward";
			this.message = "编辑行业成功";
			this.statusCode = "200";
			this.navTabId = "listTrades";
			this.forwardUrl="listTrades.action?dictid=108";
			}else if(dictionary.getDictid().equals("107")){
				this.callbackType = "forward";
				this.message = "编辑地区成功";
				this.statusCode = "200";
				this.navTabId = "listAreas";
				this.forwardUrl="listAreas.action?dictid=107";
			}
			info(m, "update the Dictionary  success with Dictionary id="+ dictionary.getCode());
		} else {
			if(dictionary.getDictid().equals("108")){
			this.message = "编辑行业失败";
			this.statusCode = "300";
			this.navTabId = "editTrade";
			}else if(dictionary.getDictid().equals("107")){
				this.message = "编辑地区失败";
				this.statusCode = "300";
				this.navTabId = "editArea";
			}
			info(m, "find the Dictionary type failed with Dictionary id="
					+ dictionary.getCode());
		}
		return "ajaxDone";
	}
	
	
	
	
	
	
	
	
	public ZyDictclass getDictclass() {
		return dictclass;
	}

	public void setDictclass(ZyDictclass dictclass) {
		this.dictclass = dictclass;
	}

	public ZyDictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(ZyDictionary dictionary) {
		this.dictionary = dictionary;
	}

	public String getDictid() {
		return dictid;
	}

	public void setDictid(String dictid) {
		this.dictid = dictid;
	}

	public String getDictname() {
		return dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
