package com.zhiye.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyContactType;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Pager;
import com.zhiye.services.ContactTypeService;
import com.zhiye.services.ServiceException;

public class ContactTypeAction extends GenericActionSupport<ZyContactType>{

	private static final long serialVersionUID = 1L;
	
	ZyContactType contactType;
	
	ContactTypeService contactTypeService;
	
	public int contactTypeid;
	
	public String username;
	
	List<ZyContactType> contactTypes;
	
	public List<ZyContactType> getContactTypes() {
		return contactTypes;
	}

	public void setContactTypes(List<ZyContactType> contactTypes) {
		this.contactTypes = contactTypes;
	}
	
	/*
	 * 列出所有联系人类型
	 * 
	 * */
	public String listContactTypes() {
		String m = "listContactTypes";
		List<ZyContactType> contactTypes=null;
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
			if(null!=username&&username.trim().length()>0&&!username.equals("all")){
				params.put("username",username);
			}
			if(null!=username && username.toString().trim().length()>0 && !username.equals("all")){
				params.put("contactTypeId",contactTypeid);
			}
			contactTypes = contactTypeService.searchForPager(params);
			params.remove("start");
			params.remove("size");
			int count = contactTypeService.countSearchPager(params);
			
			pager = new Pager<ZyContactType>(pageNum, numPerPage);
			
			pager.setPageRecords(contactTypes);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " contactTypes");

		} catch (ServiceException e) {
			error(m, "find all contactTypes exeption", e);
		} catch (Exception e) {
			error(m, "find all contactTypes exeption", e);
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
	public String addContactType() {
		String m = "addContactType";
		return "add";
	}
	
	/**
	 * 添加一个联系人类型
	 * 
	 * @return
	 */
	public String doAddContactType() {
		String m = "doAddContactType";
		info(m, "add the contactType  =" + contactType);
		try {
			contactTypeService.addContactType(contactType);

			info(m, "add contactType view  premisison,contactTypeid=" + contactTypeid);

		} catch (ServiceException e) {
			error(m, "add the contactType  exception", e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addContactType";
			info(m, "add the contactType failed with title="
					+ contactType.getTypeName());
			return "ajaxDone";
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		this.navTabId = "listContactTypes";

		info(m, "add the partment success with partment title="
				+ contactType.getTypeName());
		return "ajaxDone";
	}
	
	
	// 删除contactType
	public String removeContactType() {
		String m = "removeContactType";
		info(m, "contactType Id is" +contactTypeid);
		long result = 0;
		try {
			result = contactTypeService.deleteContactType(contactTypeid);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the ContactType with id=" + contactTypeid, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listContactTypes";
			this.forwardUrl = "listContactTypes.action";

			info(m, "remove the ContactType successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the ContactType failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}
	
	
	// 批量删除contactType
	public String removeContactTypes() {
		String m = "removeContactTypes";
		info(m, "contactTypes ids is" + entityIds);
		long result = 0;
		try {
			for (String id : entityIds.split(",")) {
				result = contactTypeService.deleteContactType(Integer.parseInt(id.trim()));
			}
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the contactType with id=" + entityIds, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listContactTypes";
//			this.forwardUrl = "listContactTypes.action";
			info(m, "remove the contactType successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the contactType failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "ajaxDone";
	}
	
	/**
	 * 编辑一个联系人类型，跳转到编辑页面
	 * 
	 * @return
	 */
	public String editContactType() {
		String m = "editContactType";
		info(m, "edit the ContactType  with ContactType id=" + contactTypeid);
		try {
			contactType = contactTypeService.findcontactTypeById(contactTypeid);
		} catch (ServiceException e) {
			error(m, "find the ContactType exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (null != contactType) {
			request.setAttribute("contactType", contactType);
			info(m, "find the partment  success with contactType Id=" + contactTypeid);
			return "success";
		} else {
			this.callbackType = "forward";
			this.callbackType = "listContactTypes.action";

			this.message = "操作失败";
			this.statusCode = "300";
			this.navTabId = "listContactTypes";
			info(m, "find the contactType failed with contactType Id=" + contactTypeid);
			return "ajaxDone";
		}
	}
	
	/**
	 * 编辑一个联系人类型
	 * 
	 * @return
	 */
	public String doEditContactType() {
		String m = "doEditContactType";
		info(m, "edit the contactType  with contactType id="+contactType.getTypeId());
		int result = 0;
		try {
			result = contactTypeService.updateContactType(contactType);
		} catch (ServiceException e) {
			error(m, "find the ContactType  exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "closeCurrent";
			this.message = "编辑成功";
			this.statusCode = "200";
			this.navTabId = "listContactTypes";
			info(m, "update the ContactType  success with ContactType id="
					+ contactType.getTypeId());
		} else {
			this.message = "编辑失败";
			this.statusCode = "300";
			this.navTabId = "editContactType";

			info(m, "find the ContactType type failed with ContactType id="
					+ contactType.getTypeId());
		}
		return "ajaxDone";
	}

	public ZyContactType getContactType() {
		return contactType;
	}

	public void setContactType(ZyContactType contactType) {
		this.contactType = contactType;
	}

	public ContactTypeService getContactTypeService() {
		return contactTypeService;
	}

	public void setContactTypeService(ContactTypeService contactTypeService) {
		this.contactTypeService = contactTypeService;
	}



	public int getContactTypeid() {
		return contactTypeid;
	}

	public void setContactTypeid(int contactTypeid) {
		this.contactTypeid = contactTypeid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
