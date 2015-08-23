package com.zhiye.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyCompany;
import com.zhiye.common.bean.ZyCorporation;
import com.zhiye.common.bean.ZyPartment;
import com.zhiye.common.bean.ZyRole;
import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.bean.ZyUserParams;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Constant;
import com.zhiye.common.util.Pager;
import com.zhiye.common.util.Validity;
import com.zhiye.services.CompanyService;
import com.zhiye.services.CorporationService;
import com.zhiye.services.PartmentService;
import com.zhiye.services.RoleService;
import com.zhiye.services.ServiceException;
import com.zhiye.services.UserService;

public class UserAction extends GenericActionSupport<ZyUser> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ZyUser user;
	
	ZyCompany company;

	String partmentId;
	
	String tempPhones;
	
	String tempTexts;
	int uid;
	
	int pid;
	
	String title;
	
	String loginName;
	
	String active;
	CorporationService corporationService;
	UserService userService;

	RoleService roleService;
	CompanyService companyService;
	PartmentService partmentService;

	List<ZyUser> users;

	public List<ZyUser> getUsers() {
		return users;
	}

	public void setUsers(List<ZyUser> users) {
		this.users = users;
	}

	/**
	 * 列出所有的用户,根据类型ID
	 * 
	 * @return
	 */
	public String listUsers() {
		String m = "listUsers";
		List<ZyRole> roles=null;
		List<ZyPartment> partments=null;
		try {
			// 获得配置的每页数量
			if(numPerPage==0){
				numPerPage = Config.getInt("pager.page_size");
			}
			int start = 0;
			if (pageNum > 1) {
				start = (pageNum - 1) * numPerPage;
			}
			Map<String,Object> params=new HashMap<String,Object>();
			List<ZyUser> users=null;
//			if(userName!=null&&userName.trim().length()>0){
//				//根据用户名称查询USER
//				ZyUser zUser=userService.findUserByName(userName);
//				if(null!=zUser){
//					params.put("uid",zUser.getUserId());
//				}else{
//					params.put("uid","-1");
//				}
//				
//			}
				params.put("start", start);
				params.put("size", numPerPage);
				if(null!=partmentId&&partmentId.trim().length()>0&&!partmentId.equals("all")){
					params.put("pid",partmentId);
				}
				if(null!=loginName&&loginName.trim().length()>0){
					params.put("loginname",loginName);
				}
				if(null!=active&&!active.equals("all")){
					params.put("active",active);
				}
				users=userService.searchForPager(params);
			
				params.remove("start");
				params.remove("size");
			int count = userService.countSearchPager(params);
			
			roles = new ArrayList<ZyRole>(users.size());
			ZyRole role=null;
			partments = new ArrayList<ZyPartment>(users.size());
			ZyPartment partment=null;
			for (ZyUser user : users) {
				role = roleService.findRoleById(user.getRoleId());
				roles.add(role);
				partment=partmentService.findPartmentById(user.getPid());
				partments.add(partment);
			}
			pager = new Pager<ZyUser>(pageNum, numPerPage);

			pager.setPageRecords(users);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " users");

		} catch (ServiceException e) {
			error(m, "find all users exeption", e);
		}catch(Exception e){
			error(m, "find all users exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		request.setAttribute("roles", roles);
		request.setAttribute("partments", partments);
		List<ZyPartment> allPartments=null;
		//ALL PARTMENTS
		try {
			allPartments = partmentService.findAllPartments();
		} catch (ServiceException e) {
			error(m, "find all  partments exception", e);
		}
		request.setAttribute("allPartments", allPartments);
		request.setAttribute("status1", active);
		request.setAttribute("pid", pid);
		return "success";

	}

	// 删除ARTICLE
	public String removeUser() {
		String m = "removeUser";
		info(m, "uidis" + uid);
		int result = 0;
		try {
			result = userService.removeUserById(uid);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the user with id=" + uid, e);
		}catch(Exception e){
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listUsers";
			this.forwardUrl = "listUsers.action";

			info(m, "remove the user successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "200";
			info(m, "remove the user failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	// 批量删除ARTICLE
	public String removeUsers() {
		String m = "removeUsers";
		info(m, "users ids is" + entityIds);
		int result = 0;
		try {
			for (String id : entityIds.split(",")) {
				result = userService.removeUserById(Integer.parseInt(id
						.trim()));
			}
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the user with id=" + entityIds, e);
		}catch(Exception e){
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listUsers";
			this.forwardUrl = "listUsers.action";
			info(m, "remove the user successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the user failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	/**
	 * 添加一个用户，跳转到添加页面
	 * 
	 * @return
	 */
	public String addUser() {
		String m = "addUserType";
		// get 部门列表
		List<ZyPartment> partments = null;
		// GET 用户角色列表
		List<ZyRole> roles = null;
		try {
			roles = roleService.findAllRoleList();
		} catch (ServiceException e) {
			error(m, "find all  users exception", e);
		}
		try {
			partments = partmentService.findAllPartments();
		} catch (ServiceException e) {
			error(m, "find all  partments exception", e);
		}

		request.setAttribute("partments", partments);
		request.setAttribute("roles", roles);
		return "add";
	}

	/**
	 * 添加一个用户
	 * 
	 * @return
	 */
	public String doAddUser() {
		String m = "doAddUser";
		info(m, "add the user  =" + user);
		try {
			Date newDate = new Date();
			user.setCreateTime(newDate);
			user.setUpdateTime(newDate);
			if(!Validity.isNumber(user.getMobile())){
				this.message = "添加失败,手机号码不是数字！";
				this.statusCode = "300";
				this.navTabId = "addUser";
				info(m, "add the user moible is not number ,with title=" + user.getLoginname());
				return "ajaxDone";
			}
			// 可用状态
			user.setActive(Constant.USER_ACTIVE);
			
			ZyUser temp=userService.findUserByName(user.getLoginname());
			if(temp!=null){
				this.message = "添加失败,用户名已存在！";
				this.statusCode = "300";
				this.navTabId = "addUser";
				info(m, "add the user failed user name existsed ,with title=" + user.getLoginname());
				return "ajaxDone";
			}
			int companyId=0;
			if(company!=null&&company.getCompanyName().trim().length()>0){
				company.setCreateTime(newDate);
				company.setUpdateTime(newDate);
				companyId=companyService.addCompany(company);
			}
			if(companyId>0)
			user.setCompanyId(companyId);
			userService.addUser(user);
		} catch (ServiceException e) {
			error(m, "add the user  exception", e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addUser";
			info(m, "add the user failed with title=" + user.getLoginname());
			return "ajaxDone";
		}catch(Exception e){
			error(m, "unknown exeption", e);
		}

		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		this.navTabId = "listUsers";

		info(m, "add the user success with user title="
				+ user.getLoginname());
		return "ajaxDone";
	}

	/**
	 * 编辑一个用户，跳转到编辑页面
	 * 
	 * @return
	 */
	public String editUser() {
		String m = "editUser";
		info(m, "edit the user  with user id=" + uid);
		try {
			user = userService.findUserById(uid);
			if(user.getCompanyId()>0){
				company=companyService.findCompanyById(user.getCompanyId());
			}
		} catch (ServiceException e) {
			error(m, "find the user exception", e);
		}catch(Exception e){
			error(m, "unknown exeption", e);
		}
		// get 部门列表
		List<ZyPartment> partments = null;
		// GET 用户分类列表
		try {
			partments = partmentService.findAllPartments();
		} catch (ServiceException e) {
			error(m, "find all  partments exception", e);
		}
		List<ZyRole> roles = null;
		try {
			roles = roleService.findAllRoleList();
		} catch (ServiceException e) {
			error(m, "find all  users exception", e);
		}
		request.setAttribute("partments", partments);
		request.setAttribute("roles", roles);
		
		if (user != null) {
			request.setAttribute("user", user);
			request.setAttribute("company", company);
			info(m, "find the user  success with uid=" + uid);
			return "success";
		} else {
			this.callbackType = "forward";
			this.callbackType = "listUsers.action";

			this.message = "操作失败";
			this.statusCode = "300";
			this.navTabId = "listUsers";
			info(m, "find the user failed with uid=" + uid);
			return "ajaxDone";
		}
	}

	/**
	 * 编辑一个用户
	 * 
	 * @return
	 */
	public String doEditUser() {
		String m = "doEditUser";
		info(m, "edit the user  with user id=" + user.getUserId());
		int result = 0;
		try {
			ZyUser userTemp=userService.findUserById(user.getUserId());
			if(userTemp!=null){
				user.setCreateTime(userTemp.getCreateTime());
			}
			user.setUpdateTime(new Date());
			int companyId=0;
			if(company!=null&&company.getCompanyName().trim().length()>0){
				company.setUpdateTime(new Date());
				//如果用户以前是个人用呼，现在变成企业用户
				if(userTemp.getCompanyId()==0){
					company.setCreateTime(new Date());
					companyId=companyService.addCompany(company);
					user.setCompanyId(companyId);
				}else{
					companyService.updateCompany(company);
				}
				
			}
			ZyUser temp=userService.findUserByName(user.getLoginname());
			if(temp!=null&&userTemp.getUserId()!=temp.getUserId()){
				this.message = "更新失败,用户名已存在！";
				this.statusCode = "300";
				this.navTabId = "addUser";
				info(m, "add the user failed user name existsed ,with title=" + user.getLoginname());
				return "ajaxDone";
			}
			//如果用户从企业用户 变成个人用户 则删除企业和关联
			if(userTemp.getUserType().equals(Constant.COMPANY)&&user.getUserType().equals(Constant.PERSONAL)){
				companyService.removeCompanyById(company.getCompanyId());
				user.setCompanyId(0);
			}
			if(!Validity.isNumber(user.getMobile())){
				this.message = "编辑失败,手机号码不是数字！";
				this.statusCode = "300";
				this.navTabId = "editUser";
				info(m, "edit the user moible is not number ,with title=" + user.getLoginname());
				return "ajaxDone";
			}
			result = userService.updateUser(user);
		} catch (ServiceException e) {
			error(m, "find the user  exception", e);
		}catch(Exception e){
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "closeCurrent";
			this.message = "编辑成功";
			this.statusCode = "200";
			this.navTabId = "listUsers";
			info(m, "update the user  success with user id="
					+ user.getUserId());
		} else {
			this.message = "编辑失败";
			this.statusCode = "300";
			this.navTabId = "editUser";

			info(m, "find the user type failed with user id="
					+ user.getUserId());
		}
		return "ajaxDone";
	}
	
	/**
	 * 获得用于发送短信的用户和企业
	 * @return
	 */
	public String lookupCompanysAndUsers(){
		String m="lookupCompanysAndUsers";
		// get 部门列表
		List<ZyPartment> partments = null;
		// GET 用户分类列表
		try {
			partments = partmentService.findAllPartments();
	
		Map<Integer,Object> usersMap=new HashMap<Integer,Object>();
		int count=0;
		if(partments!=null&&partments.size()>0){
			//根据部门查询出每个部门的用户
			for(ZyPartment partment:partments){
				ZyUserParams userParams=new ZyUserParams();
				userParams.createCriteria().andPidEqualTo(partment.getPartmentId());
				List<ZyUser> users=null;
					users = userService.findUserList(userParams);
				if(users!=null){
					usersMap.put(count, users);
				}else{
					usersMap.put(count, new ArrayList<ZyUser>());
				}
					
				count++;
			}
		}
		
		//获得所有企业
		List<ZyCorporation> corporations =corporationService.findAllCorporations();
		request.setAttribute("corporations", corporations);
		
		request.setAttribute("partments", partments);
		request.setAttribute("userMap", usersMap);
		} catch (Exception e) {
			error(m, "find all  user and companys exception", e);
		}
		
		request.setAttribute("texts", tempTexts);
		request.setAttribute("phones", tempPhones);
		return "success";
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ZyUser getUser() {
		return user;
	}

	public void setUser(ZyUser user) {
		this.user = user;
	}

	public long getUrId() {
		return uid;
	}

	public void setUId(int uid) {
		this.uid = uid;
	}

	public PartmentService getPartmentService() {
		return partmentService;
	}

	public void setPartmentService(PartmentService partmentService) {
		this.partmentService = partmentService;
	}


	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPartmentId() {
		return partmentId;
	}

	public void setPartmentId(String partmentId) {
		this.partmentId = partmentId;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public ZyCompany getCompany() {
		return company;
	}

	public void setCompany(ZyCompany company) {
		this.company = company;
	}

	public String getLoginname() {
		return loginName;
	}

	public void setLoginname(String loginName) {
		this.loginName = loginName;
	}

	public CorporationService getCorporationService() {
		return corporationService;
	}

	public void setCorporationService(CorporationService corporationService) {
		this.corporationService = corporationService;
	}

	public String getTempPhones() {
		return tempPhones;
	}

	public void setTempPhones(String tempPhones) {
		this.tempPhones = tempPhones;
	}

	public String getTempTexts() {
		return tempTexts;
	}

	public void setTempTexts(String tempTexts) {
		this.tempTexts = tempTexts;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
