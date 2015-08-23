package com.zhiye.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyPartment;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Pager;
import com.zhiye.services.PartmentService;
import com.zhiye.services.ServiceException;
import com.zhiye.services.UserService;

public class PartmentAction extends GenericActionSupport<ZyPartment> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ZyPartment partment;

	int partmentId;

	String partmentName;

	PartmentService partmentService;

	UserService userService;

	List<ZyPartment> partments;

	public List<ZyPartment> getPartments() {
		return partments;
	}

	public void setPartments(List<ZyPartment> partments) {
		this.partments = partments;
	}

	/**
	 * 列出所有的部门,根据类型ID
	 * 
	 * @return
	 */
	public String listPartments() {
		String m = "listPartments";
		List<ZyPartment> partments = null;
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
			partments = partmentService.searchForPager(params);

			params.remove("start");
			params.remove("size");
			int count = partmentService.countSearchPager(params);
			pager = new Pager<ZyPartment>(pageNum, numPerPage);

			pager.setPageRecords(partments);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " partments");

		} catch (ServiceException e) {
			error(m, "find all partments exeption", e);
		} catch (Exception e) {
			error(m, "find all partments exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		return "success";

	}

	// 删除PARTMENT
	public String removePartment() {
		String m = "removePartment";
		info(m, "partmentIdis" + partmentId);
		int result = 0;
		try {
			// 删除以前此部门的所有权限
			result = partmentService.removePartmentById(partmentId);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the partment with id=" + partmentId, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listPartments";
			this.forwardUrl = "listPartments.action";

			info(m, "remove the partment successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the partment failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	// 批量删除PARTMENT
	public String removePartments() {
		String m = "removePartments";
		info(m, "partments ids is" + entityIds);
		int result = 0;
		try {
			for (String id : entityIds.split(",")) {
				result = partmentService.removePartmentById(Integer.parseInt(id
						.trim()));
			}
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the partment with id=" + entityIds, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listPartments";
			this.forwardUrl = "listPartments.action";
			info(m, "remove the partment successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the partment failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	/**
	 * 添加一个部门，跳转到添加页面
	 * 
	 * @return
	 */
	public String addPartment() {
		String m = "addPartment";
		return "add";
	}

	/**
	 * 添加一个部门
	 * 
	 * @return
	 */
	public String doAddPartment() {
		String m = "doAddPartment";
		info(m, "add the partment  =" + partment);
		try {
			ZyPartment temp = partmentService.findPartmentByName(partment
					.getPartmentName());
			if (temp != null) {
				this.message = "添加失败,部门名已存在！";
				this.statusCode = "300";
				this.navTabId = "addPartment";
				info(m,
						"add the partment failed partment name existsed ,with title="
								+ partment.getPartmentName());
				return "ajaxDone";
			}
			partmentService.addPartment(partment);

			info(m, "add partment view  premisison,partmentId=" + partmentId);

		} catch (ServiceException e) {
			error(m, "add the partment  exception", e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addPartment";
			info(m, "add the partment failed with title="
					+ partment.getPartmentName());
			return "ajaxDone";
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		this.navTabId = "listPartments";

		info(m, "add the partment success with partment title="
				+ partment.getPartmentName());
		return "ajaxDone";
	}

	/**
	 * 编辑一个部门，跳转到编辑页面
	 * 
	 * @return
	 */
	public String editPartment() {
		String m = "editPartment";
		info(m, "edit the partment  with partment id=" + partmentId);
		try {
			partment = partmentService.findPartmentById(partmentId);
		} catch (ServiceException e) {
			error(m, "find the partment exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (null != partment) {
			request.setAttribute("partment", partment);
			info(m, "find the partment  success with partmentId=" + partmentId);
			return "success";
		} else {
			this.callbackType = "forward";
			this.callbackType = "listPartments.action";

			this.message = "操作失败";
			this.statusCode = "300";
			this.navTabId = "listPartments";
			info(m, "find the partment failed with partmentId=" + partmentId);
			return "ajaxDone";
		}
	}

	/**
	 * 编辑一个部门
	 * 
	 * @return
	 */
	public String doEditPartment() {
		String m = "doEditPartment";
		info(m, "edit the partment  with partment id="
				+ partment.getPartmentId());
		int result = 0;
		try {
			ZyPartment partmentTemp = partmentService.findPartmentById(partment
					.getPartmentId());
			ZyPartment temp = partmentService.findPartmentByName(partment
					.getPartmentName());
			result = partmentService.updatePartment(partment);
			 if ((temp != null) && (partmentTemp.getPartmentId() != temp.getPartmentId())) {
				 this.message = "编辑失败,部门名已存在！";
				 this.statusCode = "300";
				 this.navTabId = "addPartment";
				 info(m, "update the partment failed partment name existsed with name="
				 + partment.getPartmentName());
				 return "ajaxDone";
				 }
		} catch (ServiceException e) {
			error(m, "find the partment  exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "closeCurrent";
			this.message = "编辑成功";
			this.statusCode = "200";
			this.navTabId = "listPartments";
			info(m, "update the partment  success with partment id="
					+ partment.getPartmentId());
		} else {
			this.message = "编辑失败";
			this.statusCode = "300";
			this.navTabId = "editPartment";

			info(m, "find the partment type failed with partment id="
					+ partment.getPartmentId());
		}
		return "ajaxDone";
	}

	public PartmentService getPartmentService() {
		return partmentService;
	}

	public void setPartmentService(PartmentService partmentService) {
		this.partmentService = partmentService;
	}

	public ZyPartment getPartment() {
		return partment;
	}

	public void setPartment(ZyPartment partment) {
		this.partment = partment;
	}

	public String getPartmentName() {
		return partmentName;
	}

	public void setPartmentName(String partmentName) {
		this.partmentName = partmentName;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getPartmentId() {
		return partmentId;
	}

	public void setPartmentId(int partmentId) {
		this.partmentId = partmentId;
	}
}
