package com.zhiye.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.zhiye.common.bean.ZyArticleType;
import com.zhiye.common.bean.ZyPartment;
import com.zhiye.common.bean.ZyPremission;
import com.zhiye.common.bean.ZyPremissionParams;
import com.zhiye.common.bean.ZyRole;
import com.zhiye.common.bean.ZyRolePremission;
import com.zhiye.common.bean.ZyRolePremissionParams;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Constant;
import com.zhiye.common.util.Pager;
import com.zhiye.services.ArticleTypeService;
import com.zhiye.services.PremissionService;
import com.zhiye.services.RolePremissionService;
import com.zhiye.services.RoleService;
import com.zhiye.services.ServiceException;
import com.zhiye.services.UserService;

public class RoleAction extends GenericActionSupport<ZyRole> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ZyRole role;

	int roleId;

	String title;

	String viewIds;

	String modifyIds;

	String manageIds;

	String roleName;

	RolePremissionService rolePremissionService;

	PremissionService premissionService;

	RoleService roleService;

	ArticleTypeService articleTypeService;

	UserService userService;

	List<ZyRole> roles;

	public ArticleTypeService getArticleTypeService() {
		return articleTypeService;
	}

	public void setArticleTypeService(ArticleTypeService articleTypeService) {
		this.articleTypeService = articleTypeService;
	}

	public List<ZyRole> getRoles() {
		return roles;
	}

	public void setRoles(List<ZyRole> roles) {
		this.roles = roles;
	}

	/**
	 * 列出所有的角色,根据类型ID
	 * 
	 * @return
	 */
	public String listRoles() {
		String m = "listRoles";
		List<ZyRole> roles = null;
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
			roles = roleService.searchForPager(params);

			params.remove("start");
			params.remove("size");
			int count = roleService.countSearchPager(params);
			pager = new Pager<ZyRole>(pageNum, numPerPage);

			pager.setPageRecords(roles);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " roles");

		} catch (ServiceException e) {
			error(m, "find all roles exeption", e);
		} catch (Exception e) {
			error(m, "find all roles exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		return "success";

	}

	// 删除ROLE
	public String removeRole() {
		String m = "removeRole";
		info(m, "roleIdis" + roleId);
		int result = 0;
		try {
			// 删除以前此角色的所有权限
			ZyRolePremissionParams params = new ZyRolePremissionParams();
			params.createCriteria().andRoleIdEqualTo(roleId);
			rolePremissionService.removeRolePremissionById(params);
			
			result = roleService.removeRoleById(roleId);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the role with id=" + roleId, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listRoles";
			this.forwardUrl = "listRoles.action";

			info(m, "remove the role successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the role failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	// 批量删除ROLE
	public String removeRoles() {
		String m = "removeRoles";
		info(m, "roles ids is" + entityIds);
		int result = 0;
		try {
			for (String id : entityIds.split(",")) {
				result = roleService
						.removeRoleById(Integer.parseInt(id.trim()));
			}
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the role with id=" + entityIds, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listRoles";
			this.forwardUrl = "listRoles.action";
			info(m, "remove the role successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the role failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	/**
	 * 添加一个角色，跳转到添加页面
	 * 
	 * @return
	 */
	public String addRole() {
		String m = "addRole";
		try {
			int count=0;
			try {
				count=articleTypeService.countAllArticleTypes();
				typesMap = articleTypeService.getAllTypeMap();
			} catch (Exception e) {
				error(m, "find article types exception", e);
			}
			// 获得ROOT节点
			List<ZyArticleType> roots = typesMap.get(0);
			request.setAttribute("allTypes",getTypesHtmlsWithOperations(roots));
			
		} catch (Exception e) {
			error(m, "find all article types exception", e);
		}

		return "add";
	}

	/**
	 * 添加一个角色
	 * 
	 * @return
	 */
	public String doAddRole() {
		String m = "doAddRole";
		info(m, "add the role  =" + role);
		try {
			ZyRole temp = roleService.findRoleByName(role.getRoleName());
			// 查看的权限
//			List<String> viewIdList = new ArrayList<String>();
//			if (null != manageIds) {
//				for (String id : viewIds.split(",")) {
//					viewIdList.add(id);
//				}
//			}
//			// 修改/添加、删除权限
//			List<String> modifyIdList = new ArrayList<String>();
//			if (null != manageIds) {
//				for (String id : modifyIds.split(",")) {
//					modifyIdList.add(id);
//				}
//			}
			// 审核管理的权限
			List<String> manageIdList = new ArrayList<String>();
			if (null != manageIds) {
				for (String id : manageIds.split(",")) {
					manageIdList.add(id);
				}
			}
			if (temp != null) {
				this.message = "添加失败,角色名已存在！";
				this.statusCode = "300";
				this.navTabId = "addRole";
				info(m, "add the role failed role name existsed ,with title="
						+ role.getRoleName());
				return "ajaxDone";
			}
			roleService.addRole(role);

			roleId = roleService.findRoleByName(role.getRoleName()).getRoleId();
//			// 给角色添加查看权限
//			for (String id : viewIdList) {
//				ZyPremissionParams params = new ZyPremissionParams();
//				params.createCriteria().andPremissionTypeEqualTo(Constant.VIEW)
//						.andSectionIdEqualTo(Integer.parseInt(id.trim()));
//				List<ZyPremission> prs = premissionService
//						.findPremissionList(params);
//				if (prs == null || prs.size() == 0) {
//					warn(m, "add premission failed with type id=" + id);
//					continue;
//				}
//				ZyRolePremission temp1 = new ZyRolePremission();
//				temp1.setPremissionId(prs.get(0).getPremissionId());
//				temp1.setRoleId(roleId);
//				info(m, "add role view  premisison,roleId=" + roleId
//						+ ",premisison is=" + prs.get(0).getPremissionId());
//				rolePremissionService.addRolePremission(temp1);
//			}
//
//			// 给角色添加添加，修改，删除权限
//			for (String id : modifyIdList) {
//				ZyPremissionParams params = new ZyPremissionParams();
//				params.createCriteria()
//						.andPremissionTypeEqualTo(Constant.A_M_D)
//						.andSectionIdEqualTo(Integer.parseInt(id.trim()));
//				List<ZyPremission> prs = premissionService
//						.findPremissionList(params);
//				if (prs == null || prs.size() == 0) {
//					warn(m, "add premission failed with type id=" + id);
//					continue;
//				}
//				ZyRolePremission temp1 = new ZyRolePremission();
//				temp1.setPremissionId(prs.get(0).getPremissionId());
//				temp1.setRoleId(roleId);
//				info(m, "add role add/modify/delete premisison,roleId="
//						+ roleId + ",premisison is="
//						+ prs.get(0).getPremissionId());
//				rolePremissionService.addRolePremission(temp1);
//			}

			// 给角色添加审核管理权限
			for (String id : manageIdList) {
				ZyPremissionParams params = new ZyPremissionParams();
				params.createCriteria().andPremissionTypeEqualTo(
						Constant.MANAGE).andSectionIdEqualTo(
						Integer.parseInt(id.trim()));
				List<ZyPremission> prs = premissionService
						.findPremissionList(params);
				if (prs == null || prs.size() == 0) {
					warn(m, "add premission failed with type id=" + id);
					continue;
				}
				ZyRolePremission temp1 = new ZyRolePremission();
				temp1.setPremissionId(prs.get(0).getPremissionId());
				temp1.setRoleId(roleId);
				info(m, "add role manage premisison,roleId=" + roleId
						+ ",premisison is=" + prs.get(0).getPremissionId());
				rolePremissionService.addRolePremission(temp1);
			}
		} catch (ServiceException e) {
			error(m, "add the role  exception", e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addRole";
			info(m, "add the role failed with title=" + role.getRoleName());
			return "ajaxDone";
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		this.navTabId = "listRoles";

		info(m, "add the role success with role title=" + role.getRoleName());
		return "ajaxDone";
	}

	/**
	 * 编辑一个角色，跳转到编辑页面
	 * 
	 * @return
	 */
	public String editRole() {
		String m = "editRole";
		info(m, "edit the role  with role id=" + roleId);
		try {
			role = roleService.findRoleById(roleId);
		} catch (ServiceException e) {
			error(m, "find the role exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		try {
			typesMap = articleTypeService.getAllTypeMap();
		} catch (Exception e) {
			error(m, "find article types exception", e);
		}
		List<ZyArticleType> roots = typesMap.get(0);
		List<ZyArticleType> types=getTypesHtmlsWithOperations(roots);
		// 获得ROOT节点
		request.setAttribute("allTypes",types);
		
		List<ZyRolePremission> rolePremissions = null;

		ZyRolePremissionParams params = new ZyRolePremissionParams();
		params.createCriteria().andRoleIdEqualTo(role.getRoleId());
		try {
			rolePremissions = rolePremissionService
					.findRolePremissionList(params);
		} catch (ServiceException e) {
			error(m, "find role premissions excpetion", e);
		}
		Map<Integer, List<ZyPremission>> premissionMap = getPremissionMap(rolePremissions);
		List<String[]> premissions = new ArrayList<String[]>(types.size());

		for (ZyArticleType type : types) {
			Integer typeId = type.getTypeId();
			if (premissionMap.containsKey(typeId)) {
				List<ZyPremission> prs = premissionMap.get(typeId);
				String[] preStr = new String[3];
				for (ZyPremission pr : prs) {
					if (pr.getPremissionType().equals(Constant.MANAGE)) {
						preStr[2] = "2";
					} else if (pr.getPremissionType().equals(Constant.A_M_D)) {
						preStr[1] = "1";
					} else if (pr.getPremissionType().equals(Constant.VIEW)) {
						preStr[0] = "0";
					}
				}
				premissions.add(preStr);
			}
		}
		// List<Integer> viewsPremission=null;
		// List<Integer> modifyPremission=null;
		// List<Integer> managePremission=null;
		// for(ZyRolePremission premission:rolePremissions){
		// try {
		// ZyPremission
		// temp=premissionService.findPremissionById(premission.getPremissionId());
		// if(temp!=null){
		// if(temp.getPremissionType().equals(Constant.VIEW)){
		// viewsPremission.add(temp.getSectionId());
		// }else if(temp.getPremissionType().equals(Constant.A_M_D)){
		// modifyPremission.add(temp.getSectionId());
		// }else if(temp.getPremissionType().equals(Constant.MANAGE)){
		// managePremission.add(temp.getSectionId());
		// }
		// }else{
		// error(m,"the premission is invalid with premission
		// id="+premission.getPremissionId());
		// }
		// } catch (ServiceException e) {
		// error(m,"find the premission exception",e);
		// }
		// }

		if (role != null) {
			request.setAttribute("role", role);
			request.setAttribute("premissions", premissions);
			info(m, "find the role  success with roleId=" + roleId);
			return "success";
		} else {
			this.callbackType = "forward";
			this.callbackType = "listRoles.action";

			this.message = "操作失败";
			this.statusCode = "300";
			this.navTabId = "listRoles";
			info(m, "find the role failed with roleId=" + roleId);
			return "ajaxDone";
		}
	}

	/**
	 * 获得PREMISSION MAP，把同样的PREMISSION放到一个MAP
	 * 
	 * @return
	 */
	private Map<Integer, List<ZyPremission>> getPremissionMap(
			List<ZyRolePremission> premissions) {
		String m = "getPremissionMap";
		Map<Integer, List<ZyPremission>> resultMap = new TreeMap<Integer, List<ZyPremission>>();
		Integer key = 0;
		List<ZyPremission> values = null;
		try {
			for (int i = 0; i < premissions.size(); i++) {
				ZyPremission pre = premissionService
						.findPremissionById(premissions.get(i)
								.getPremissionId());
				if (pre == null) {
					error(m,
							"premission Id is invalid!, can not find premission with id="
									+ premissions.get(i).getPremissionId());
				}
				key = pre.getSectionId();
				if (resultMap.containsKey(key)) {
					values = resultMap.get(key);
				} else {
					values = new ArrayList<ZyPremission>();
				}
				values.add(pre);
				resultMap.put(key, values);
			}
		} catch (Exception e) {
			error(m, "convert role premission list to premission map", e);
		}
		return resultMap;
	}

	/**
	 * 编辑一个角色
	 * 
	 * @return
	 */
	public String doEditRole() {
		String m = "doEditRole";
		info(m, "edit the role  with role id=" + role.getRoleId());
		int result = 0;
		try {
//			// 查看的权限
//			List<String> viewIdList = new ArrayList<String>();
//			if (null != viewIds) {
//				for (String id : viewIds.split(",")) {
//					viewIdList.add(id);
//				}
//			}
			// 删除以前此角色的所有权限
			ZyRolePremissionParams params = new ZyRolePremissionParams();
			params.createCriteria().andRoleIdEqualTo(role.getRoleId());
			rolePremissionService.removeRolePremissionById(params);

//			// 修改/添加、删除权限
//			List<String> modifyIdList = new ArrayList<String>();
//			if (null != modifyIds) {
//				for (String id : modifyIds.split(",")) {
//					modifyIdList.add(id);
//				}
//			}
			// 审核管理的权限
			List<String> manageIdList = new ArrayList<String>();
			if (null != manageIds) {
				for (String id : manageIds.split(",")) {
					manageIdList.add(id);
				}
			}

			ZyRole roleTemp = roleService.findRoleById(role.getRoleId());
			ZyRole temp = roleService.findRoleByName(role.getRoleName());
			result = roleService.updateRole(role);
//			if ((temp != null) && (roleTemp.getRoleId() != temp.getRoleId())) {
//				this.message = "编辑失败,角色名已存在！";
//				this.statusCode = "300";
//				this.navTabId = "addRole";
//				info(m, "update the role failed role name existsed ,with title="
//						+ role.getRoleName());
//				return "ajaxDone";
//			}
//			// 给角色添加查看权限
//			for (String id : viewIdList) {
//				ZyPremissionParams params1 = new ZyPremissionParams();
//				params1.createCriteria()
//						.andPremissionTypeEqualTo(Constant.VIEW)
//						.andSectionIdEqualTo(Integer.parseInt(id.trim()));
//				List<ZyPremission> prs = premissionService
//						.findPremissionList(params1);
//				if (prs == null || prs.size() == 0) {
//					warn(m, "add premission failed with type id=" + id);
//					continue;
//				}
//				ZyRolePremission temp1 = new ZyRolePremission();
//				temp1.setPremissionId(prs.get(0).getPremissionId());
//				temp1.setRoleId(role.getRoleId());
//				info(m, "add role view  premisison,roleId=" + role.getRoleId()
//						+ ",premisison is=" + prs.get(0).getPremissionId());
//				rolePremissionService.addRolePremission(temp1);
//			}
//
//			// 给角色添加添加，修改，删除权限
//			for (String id : modifyIdList) {
//				ZyPremissionParams params2 = new ZyPremissionParams();
//				params2.createCriteria().andPremissionTypeEqualTo(
//						Constant.A_M_D).andSectionIdEqualTo(
//						Integer.parseInt(id.trim()));
//				List<ZyPremission> prs = premissionService
//						.findPremissionList(params2);
//				if (prs == null || prs.size() == 0) {
//					warn(m, "add premission failed with type id=" + id);
//					continue;
//				}
//				ZyRolePremission temp1 = new ZyRolePremission();
//				temp1.setPremissionId(prs.get(0).getPremissionId());
//				temp1.setRoleId(role.getRoleId());
//				info(m, "add role add/modify/delete premisison,roleId="
//						+ role.getRoleId() + ",premisison is="
//						+ prs.get(0).getPremissionId());
//				rolePremissionService.addRolePremission(temp1);
//			}

			// 给角色添加审核管理权限
			for (String id : manageIdList) {
				ZyPremissionParams params3 = new ZyPremissionParams();
				params3.createCriteria().andPremissionTypeEqualTo(
						Constant.MANAGE).andSectionIdEqualTo(
						Integer.parseInt(id.trim()));
				List<ZyPremission> prs = premissionService
						.findPremissionList(params3);
				if (prs == null || prs.size() == 0) {
					warn(m, "add premission failed with type id=" + id);
					continue;
				}
				ZyRolePremission temp1 = new ZyRolePremission();
				temp1.setPremissionId(prs.get(0).getPremissionId());
				temp1.setRoleId(role.getRoleId());
				info(m, "add role manage premisison,roleId=" + role.getRoleId()
						+ ",premisison is=" + prs.get(0).getPremissionId());
				rolePremissionService.addRolePremission(temp1);
			}
		} catch (ServiceException e) {
			error(m, "find the role  exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "closeCurrent";
			this.message = "编辑成功";
			this.statusCode = "200";
			this.navTabId = "listRoles";
			info(m, "update the role  success with role id=" + role.getRoleId());
		} else {
			this.message = "编辑失败";
			this.statusCode = "300";
			this.navTabId = "editRole";

			info(m, "find the role type failed with role id="
					+ role.getRoleId());
		}
		return "ajaxDone";
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public ZyRole getRole() {
		return role;
	}

	public void setRole(ZyRole role) {
		this.role = role;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public RolePremissionService getRolePremissionService() {
		return rolePremissionService;
	}

	public void setRolePremissionService(
			RolePremissionService rolePremissionService) {
		this.rolePremissionService = rolePremissionService;
	}

	public PremissionService getPremissionService() {
		return premissionService;
	}

	public void setPremissionService(PremissionService premissionService) {
		this.premissionService = premissionService;
	}

	public String getManageIds() {
		return manageIds;
	}

	public void setManageIds(String manageIds) {
		this.manageIds = manageIds;
	}

	public String getModifyIds() {
		return modifyIds;
	}

	public void setModifyIds(String modifyIds) {
		this.modifyIds = modifyIds;
	}

	public String getViewIds() {
		return viewIds;
	}

	public void setViewIds(String viewIds) {
		this.viewIds = viewIds;
	}
}
