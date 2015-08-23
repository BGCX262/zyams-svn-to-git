package com.zhiye.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyArticle;
import com.zhiye.common.bean.ZyCorporation;
import com.zhiye.common.bean.ZyCorporationParams;
import com.zhiye.common.bean.ZyPremission;
import com.zhiye.common.bean.ZyRole;
import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Constant;
import com.zhiye.services.ArticleService;
import com.zhiye.services.ArticleTypeService;
import com.zhiye.services.CorporationService;
import com.zhiye.services.PremissionService;
import com.zhiye.services.RoleService;
import com.zhiye.services.ServiceException;
import com.zhiye.services.UserService;

public class LoginAction extends GenericActionSupport {
	String kaptcha;

	ZyUser user;

	String rand;

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	UserService userService;

	RoleService roleService;

	CorporationService copService;

	ArticleService articleService;

	ArticleTypeService articleTypeService;

	PremissionService premissionService;

	/**
	 * 企业登录
	 * 
	 * @return
	 */
	public String loginSys() {
		String m = "loginSys";
		String logiName = request.getParameter("loginName");
		String password = request.getParameter("password");

		ZyCorporation tempcorp = null;

		ZyCorporationParams param = new ZyCorporationParams();
		param.createCriteria().andIdEqualTo(logiName);
		List<ZyCorporation> coprs = copService.findCorpsWithParams(param);
		if (coprs == null || coprs.size() == 0) {
			error(m, "can't find any user by logiName=" + logiName);
			this.addFieldError("loginName", "企业用户名不存在.");
			return INPUT;
		}
		tempcorp = coprs.get(0);
		if (!tempcorp.getPassword().equals(password)) {
			error(m, "can't find any user by logiName=" + logiName);
			this.addFieldError("password", "企业密码不正确.");
			return INPUT;
		}
		session.put("loginCorp", tempcorp);
		
//		查询办事指南
		List<ZyArticle> articleList1=articleService.findArticlesByCountAndArticleType(Config.getInt("banshizhinan_id"),10,1,true,true);
		
		request.setAttribute("articleList1", articleList1);
		//查询下载中心
		List<ZyArticle> articleList2=articleService.findArticlesByCountAndArticleType(Config.getInt("xiazaizhongxin_id"),10,1,true,true);
		request.setAttribute("articleList2", articleList2);
		return "success";

	}

	/**
	 * 用户登录方法
	 * 
	 * @return
	 */
	public String login() {
		String m = "login";
		clearSystemData();
		String username = user.getLoginname();
		String password = user.getPassword();
		String rand = user.getRand();
		info(m, "username=" + user.getLoginname() + ",password="
				+ user.getPassword() + ",rand=" + user.getRand());
		// 验证码验证

		String kaptchaExpected = (String) request.getSession().getAttribute(
				"rand");
		if (!rand.equals(kaptchaExpected)) {
			this.addFieldError("kap", "对不起，您输入的验证码有误!");
			return INPUT;
		}

		try {
			user = userService.findUserByName(username);
		} catch (ServiceException e) {
			error(m, "find user by username exception", e);
			return INPUT;
		}
		// 如果用户不存在
		if (user == null) {
			error(m, "can't find any user by username=" + username);
			this.addFieldError("username", "用户名不存在.");
			return INPUT;
		}
		// 如果需要加密，这里需要调用CommonUtils.encryptPassword方法
		if (!password.equals(user.getPassword())) {
			this.addFieldError("password", "密码不正确.");
			return INPUT;
		}
		// 判断用户是否可用
		if (user.getActive().equals(Constant.USER_INACTIVE)) {
			this.addFieldError("username", "用户不可用，请联系管理员.");
			return INPUT;
		}

		// 把用户加入到SESSION
		session.put("loginUser", user);
		session.put("loginId", user.getUserId());

		// 如果登录用户是领导，则取出该用户角色所有的栏目ID，然后查询出这些栏目的未审核文章
		// 准备查询未审核的数据
//		try {
//			ZyRole role = roleService.findRoleById(user.getRoleId());
//			session.put("sessionRoleName", role.getRoleName());
//			Map<String, Object> params2 = new HashMap<String, Object>();
//			params2.put("roleId", role.getRoleId());
//			params2.put("typeId", Constant.MANAGE);
//			List<ZyPremission> premisisons = premissionService
//					.findSectionIdByRoleId(params2);
//			StringBuffer sbs = new StringBuffer();
//			int count = 0;
//			for (ZyPremission p : premisisons) {
//				if (count == premisisons.size() - 1) {
//					sbs.append(p.getSectionId());
//				} else {
//					sbs.append(p.getSectionId() + ",");
//				}
//				count++;
//			}
//			List<ZyArticle> articles = null;
//			articles = articleService.findArticlesWhichUncheck(sbs.toString(),
//					Config.getInt("pager.page_size"), 1);
//			if (articles != null && articles.size() > 0)
//				session.put("manageFlag", "yes");
//		} catch (Exception e) {
//			error(m, "find all uncheck articles", e);
//		}
		try {
			ZyRole role = roleService.findRoleById(user.getRoleId());
			session.put("sessionRoleName", role.getRoleName());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("status", "1");
			params.put("roleId", role.getRoleId());
			int count = articleService.countSearchPagerWithRoleId(params);
			
			if(count>0){
				session.put("manageFlag", "yes");
			}
		} catch (Exception e) {
			error(m, "find all uncheck articles", e);
		}
		return SUCCESS;
	}

	public String logout() {
		String method = "logout";
		try {
			// 清除系统数据
			clearSystemData();
			return SUCCESS;
		} catch (Exception e) {
			error(method, "error : ", e);
			return ERROR;
		}
	}

	public ZyUser getUser() {
		return user;
	}

	public void setUser(ZyUser user) {
		this.user = user;
	}

	public ArticleTypeService getArticleTypeService() {
		return articleTypeService;
	}

	public void setArticleTypeService(ArticleTypeService articleTypeService) {
		this.articleTypeService = articleTypeService;
	}

	public String getKaptcha() {
		return kaptcha;
	}

	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public PremissionService getPremissionService() {
		return premissionService;
	}

	public void setPremissionService(PremissionService premissionService) {
		this.premissionService = premissionService;
	}

	public CorporationService getCopService() {
		return copService;
	}

	public void setCopService(CorporationService copService) {
		this.copService = copService;
	}
}
