package com.zhiye.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyContact;
import com.zhiye.common.bean.ZyContactAndType;
import com.zhiye.common.bean.ZyContactType;
import com.zhiye.common.bean.ZyContactTypeParams;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Pager;
import com.zhiye.services.ContactAndTypeService;
import com.zhiye.services.ContactService;
import com.zhiye.services.ContactTypeService;
import com.zhiye.services.ServiceException;

public class ContactAction extends GenericActionSupport<ZyContact> {

	private static final long serialVersionUID = 1L;

	ZyContact contact;

	ContactService contactService;

	ContactTypeService contactTypeService;

	ContactAndTypeService contactAndTypeService;

	public int contactid;

	String mobile;

	public String username;

	List<ZyContact> contacts;

	public List<ZyContact> getContacts() {
		return contacts;
	}

	public void setContacts(List<ZyContact> contacts) {
		this.contacts = contacts;
	}

	/*
	 * 列出所有联系人
	 * 
	 */
	public String listContacts() {
		String m = "listContacts";
		List<ZyContact> contacts = null;
		try {
			if (numPerPage == 0) {
				numPerPage = Config.getInt("pager.page_size");
			}
			int start = 0;
			if (pageNum > 1) {
				start = (pageNum - 1) * numPerPage;
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("start", start);
			params.put("size", numPerPage);
			// //搜索功能
			if (null != username && username.trim().length() > 0) {
				params.put("username", username);
			}
			if (null != mobile && mobile.trim().length() > 0) {
				params.put("mobile", mobile);
			}
			contacts = contactService.searchForPager(params);
			List<List> types = new ArrayList<List>();
			for (ZyContact co : contacts) {
				Map<String, Object> pmd = new HashMap<String, Object>();
				pmd.put("contactid", co.getContactId());
				List<ZyContactType> types1 = contactService
						.selectTypesByContactId(pmd);
				if (types1 == null || types1.size() == 0) {
					types.add(new ArrayList());
					continue;
				}
				List sts = new ArrayList();
				for (int i = 0; i < types1.size(); i++) {
					sts.add(types1.get(i).getTypeName());
				}
				types.add(sts);
			}
			request.setAttribute("types", types);
			params.remove("start");
			params.remove("size");
			int count = contactService.countSearchPager(params);

			pager = new Pager<ZyContact>(pageNum, numPerPage);

			pager.setPageRecords(contacts);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " contacts");

		} catch (ServiceException e) {
			error(m, "find all contacts exeption", e);
		} catch (Exception e) {
			error(m, "find all contacts exeption", e);
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
	public String addContact() {
		String m = "addContact";
		ZyContactTypeParams params = new ZyContactTypeParams();
		// FIND ALL 联系人类型
		List<ZyContactType> types = contactTypeService
				.findContactTypeWithParams(params);
		request.setAttribute("contactTypes", types);

		return "add";
	}

	/**
	 * 添加一个联系人
	 * 
	 * @return
	 */
	public String doAddContact() {
		String m = "doAddContact";
		info(m, "add the contact  =" + contact);
		try {
			contact.setCreateTime(new Date());
			try {
				Long.parseLong(contact.getMobile().trim());
			} catch (Exception e) {
				error(m, "add the contact  exception");
				this.message = "添加失败,手机号码必须为数字";
				this.statusCode = "300";
				this.navTabId = "addContact";
				info(m, "add the contact failed with title="
						+ contact.getUsername());
				return "ajaxDone";
			}
			int contactid = contactService.addContact(contact);
			String[] typeIds = request.getParameterValues("typeids");
			// 添加关联表
			for (String t : typeIds) {
				if (t == null || t.trim().length() == 0) {
					continue;
				}
				ZyContactAndType type = new ZyContactAndType();
				type.setContactId(contactid);
				type.setTypeId(Integer.parseInt(t.trim()));
				contactAndTypeService.addContactAndType(type);

			}
			info(m, "add contact view  premisison,contactid=" + contactid);

		} catch (ServiceException e) {
			error(m, "add the contact  exception", e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addContact";
			info(m, "add the contact failed with title="
					+ contact.getUsername());
			return "ajaxDone";
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		this.navTabId = "listContacts";

		info(m, "add the partment success with partment title="
				+ contact.getUsername());
		return "ajaxDone";
	}

	// 删除contact
	public String removeContact() {
		String m = "removeContact";
		info(m, "contact Id is" + contactid);
		long result = 0;
		try {
			result = contactService.deleteContact(contactid);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the Contact with id=" + contactid, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listContacts";
			this.forwardUrl = "listContacts.action";

			info(m, "remove the Contact successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the Contact failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	// 批量删除contact
	public String removeContacts() {
		String m = "removeContacts";
		info(m, "contacts ids is" + entityIds);
		long result = 0;
		try {
			for (String id : entityIds.split(",")) {
				result = contactService.deleteContact(Integer.parseInt(id
						.trim()));
			}
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the contact with id=" + entityIds, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listContacts";
			// this.forwardUrl = "listContacts.action";
			info(m, "remove the contact successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the contact failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "ajaxDone";
	}

	/**
	 * 编辑一个联系人，跳转到编辑页面
	 * 
	 * @return
	 */
	public String editContact() {
		String m = "editContact";
		info(m, "edit the Contact  with Contact id=" + contactid);
		try {
			contact = contactService.findcontactById(contactid);

			// FIND ALL 联系人类型\
			ZyContactTypeParams params = new ZyContactTypeParams();
			List<ZyContactType> types = contactTypeService
					.findContactTypeWithParams(params);
			request.setAttribute("contactTypes", types);

			Map<String, Object> pmd = new HashMap<String, Object>();
			pmd.put("contactid", contactid);
			List<ZyContactType> types1 = contactService
					.selectTypesByContactId(pmd);
			request.setAttribute("ownTypes", types1);
		} catch (ServiceException e) {
			error(m, "find the Contact exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (null != contact) {
			request.setAttribute("contact", contact);
			info(m, "find the partment  success with contact Id=" + contactid);
			return "success";
		} else {
			this.callbackType = "forward";
			this.callbackType = "listContacts.action";

			this.message = "操作失败";
			this.statusCode = "300";
			this.navTabId = "listContacts";
			info(m, "find the contact failed with contact Id=" + contactid);
			return "ajaxDone";
		}
	}

	/**
	 * 编辑一个联系人
	 * 
	 * @return
	 */
	public String doEditContact() {
		String m = "doEditContact";
		info(m, "edit the contact  with contact id=" + contact.getContactId());
		int result = 0;
		try {
			try {
				Long.parseLong(contact.getMobile().trim());
			} catch (Exception e) {
				error(m, "add the contact  exception");
				this.message = "编辑失败,手机号码必须为数字";
				this.statusCode = "300";
				this.navTabId = "editContact";
				info(m, "edit the contact failed with title="
						+ contact.getUsername());
				return "ajaxDone";
			}
			result = contactService.updateContact(contact);

			String[] typeIds = request.getParameterValues("typeids");
			// 先删除 再添加
			contactAndTypeService.deleteContactAndTypeByContactId(contact
					.getContactId());
			// 添加关联表
			for (String t : typeIds) {
				if (t == null || t.trim().length() == 0) {
					continue;
				}
				ZyContactAndType type = new ZyContactAndType();
				type.setContactId(contact.getContactId());
				type.setTypeId(Integer.parseInt(t.trim()));
				contactAndTypeService.addContactAndType(type);
			}

		} catch (ServiceException e) {
			error(m, "find the Contact  exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "closeCurrent";
			this.message = "编辑成功";
			this.statusCode = "200";
			this.navTabId = "listContacts";
			info(m, "update the Contact  success with Contact id="
					+ contact.getContactId());
		} else {
			this.message = "编辑失败";
			this.statusCode = "300";
			this.navTabId = "editContact";

			info(m, "find the Contact type failed with Contact id="
					+ contact.getContactId());
		}
		return "ajaxDone";
	}

	public ZyContact getContact() {
		return contact;
	}

	public void setContact(ZyContact contact) {
		this.contact = contact;
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public int getContactid() {
		return contactid;
	}

	public void setContactid(int contactid) {
		this.contactid = contactid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ContactTypeService getContactTypeService() {
		return contactTypeService;
	}

	public void setContactTypeService(ContactTypeService contactTypeService) {
		this.contactTypeService = contactTypeService;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public ContactAndTypeService getContactAndTypeService() {
		return contactAndTypeService;
	}

	public void setContactAndTypeService(
			ContactAndTypeService contactAndTypeService) {
		this.contactAndTypeService = contactAndTypeService;
	}

}
