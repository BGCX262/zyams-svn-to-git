package com.zhiye.web.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyArticle;
import com.zhiye.common.bean.ZyArticleParams;
import com.zhiye.common.bean.ZyArticleType;
import com.zhiye.common.bean.ZyArticleWithBLOBs;
import com.zhiye.common.bean.ZyPartment;
import com.zhiye.common.bean.ZyPartmentParams;
import com.zhiye.common.bean.ZyPremission;
import com.zhiye.common.bean.ZyRole;
import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Constant;
import com.zhiye.common.util.Pager;
import com.zhiye.services.ArticleService;
import com.zhiye.services.ArticleTypeService;
import com.zhiye.services.PartmentService;
import com.zhiye.services.PremissionService;
import com.zhiye.services.RoleService;
import com.zhiye.services.ServiceException;
import com.zhiye.services.UserService;
import com.zhiye.web.services.WebServiceUtil;

public class ArticleAction extends GenericActionSupport<ZyArticle> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ZyUser user;

	String typeId;

	long articleId;

	long aid;

	int pid;

	int flag;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	String pagnation;

	String children;

	List<ZyArticleType> parents = new ArrayList<ZyArticleType>();

	public String getPagnation() {
		return pagnation;
	}

	public void setPagnation(String pagnation) {
		this.pagnation = pagnation;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	String title;

	String loginName;

	String status;

	UserService userService;

	RoleService roleService;

	ZyArticleWithBLOBs zyArticle;

	ZyArticleType zyType;

	PremissionService premissionService;

	ArticleTypeService articleTypeService;

	PartmentService partmentService;

	ArticleService articleService;

	List<ZyUser> users;

	public List<ZyUser> getUsers() {
		return users;
	}

	public void setUsers(List<ZyUser> users) {
		this.users = users;
	}

	/**
	 * 列出所有的新闻,根据类型ID
	 * 
	 * @return
	 */
	public String listArticles() {
		String m = "listArticles";
		try {
			// 获得配置的每页数量
			if (numPerPage == 0) {
				numPerPage = Config.getInt("pager.page_size");
			}
			int start = 0;
			if (pageNum > 1) {
				start = (pageNum - 1) * numPerPage;
			}
			Map<String, Object> params = new HashMap<String, Object>();
			List<ZyArticle> articles = null;
			if (loginName != null && loginName.trim().length() > 0) {
				// 根据用户名称查询USER
				ZyUser zUser = userService.findUserByName(loginName);
				if (null != zUser) {
					params.put("userId", zUser.getUserId());
				} else {
					params.put("userId", "-1");
				}

			}
			if (null != typeId && Integer.parseInt(typeId.trim()) > 0) {
				params.put("typeId", typeId.trim());
			}
			params.put("start", start);
			params.put("size", numPerPage);
			params.put("title", title);
			if (null != status && !status.equals("all")) {
				params.put("status", status);
			}
			articles = articleService.searchForPager(params);

			params.remove("start");
			params.remove("size");
			int count = articleService.countSearchPager(params);
			users = new ArrayList<ZyUser>(articles.size());
			for (ZyArticle article : articles) {
				user = userService.findUserById(article.getUserId());
				users.add(user);
			}
			pager = new Pager<ZyArticle>(pageNum, numPerPage);

			pager.setPageRecords(articles);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " articles");

		} catch (ServiceException e) {
			error(m, "find all articles exeption", e);
		} catch (Exception e) {
			error(m, "find all articles exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		request.setAttribute("users", users);
		request.setAttribute("status1", status);
		// 准备数据
		initArticleTypeData(articleTypeService, false, false);
		return "success";

	}

	/**
	 * 列出所有的新闻,根据类型ID
	 * 
	 * @return
	 */
	public String listUnCheckArticles() {
		String m = "listUnCheckArticles";
		try {
			// 获得配置的每页数量
			if (numPerPage == 0) {
				numPerPage = Config.getInt("pager.page_size");
			}
			int start = 0;
			if (pageNum > 1) {
				start = (pageNum - 1) * numPerPage;
			}
			ZyUser user=(ZyUser)session.get("loginUser");
			if(user==null){
				return ERROR;
			}
			ZyRole role=roleService.findRoleById(user.getRoleId());
			
			if(role==null){
				return ERROR;
			}
			
			Map<String, Object> params = new HashMap<String, Object>();
			List<ZyArticle> articles = null;
			params.put("status", "1");
			params.put("start", start);
			params.put("size", numPerPage);
			params.put("roleId", role.getRoleId());
			articles = articleService.searchForPagerWithRoleId(params);
			
			params.remove("start");
			params.remove("size");
			int count = articleService.countSearchPagerWithRoleId(params);
			pager = new Pager<ZyArticle>(pageNum, numPerPage);

			pager.setPageRecords(articles);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " articles");

		} catch (ServiceException e) {
			error(m, "find all uncheck articles exeption", e);
		} catch (Exception e) {
			error(m, "find all uncheck articles exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		request.setAttribute("status1", status);

		// 准备数据
		initArticleTypeData(articleTypeService, false, false);
		return "success";

	}

	/**
	 * 列出所有的新闻,根据类型ID
	 * 
	 * @return
	 */
	public String showArticleList() {
		String m = "showArticleList";
		try {
			// 获得配置的每页数量
			if (numPerPage == 0) {
				numPerPage = Config.getInt("pager.page_size");
			}
			int start = 0;
			if (pageNum > 1) {
				start = (pageNum - 1) * numPerPage;
			}
			Map<String, Object> params = new HashMap<String, Object>();
			List<ZyArticle> articles = null;
			if (loginName != null && loginName.trim().length() > 0) {
				// 根据用户名称查询USER
				ZyUser zUser = userService.findUserByName(loginName);
				if (null != zUser) {
					params.put("userId", zUser.getUserId());
				} else {
					params.put("userId", "-1");
				}

			}
			if (null != typeId && Integer.parseInt(typeId.trim()) > 0) {
				params.put("typeId", typeId.trim());
			}
			params.put("start", start);
			params.put("size", numPerPage);
			params.put("title", title);
			if (null != status && !status.equals("all")) {
				params.put("status", status);
			}
			articles = articleService.searchForPager(params);

			params.remove("start");
			params.remove("size");
			int count = articleService.countSearchPager(params);
			users = new ArrayList<ZyUser>(articles.size());
			for (ZyArticle article : articles) {
				if (article.getUserId() == null) {
					users.add(new ZyUser());
				} else {
					user = userService.findUserById(article.getUserId());
					users.add(user);
				}
			}
			pager = new Pager<ZyArticle>(pageNum, numPerPage);

			pager.setPageRecords(articles);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " articles");

		} catch (ServiceException e) {
			error(m, "find all articles exeption", e);
		} catch (Exception e) {
			error(m, "find all articles exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		request.setAttribute("users", users);
		request.setAttribute("status1", status);
		// 准备数据
		initArticleTypeData(articleTypeService, false, false);
		return "success";

	}

	/**
	 * 获得单独页面
	 * 
	 * @return
	 */
	public String showSinglePage() {
		String m = "showSinglePage";
		if (typeId != null) {
			try {
				ZyArticleType temType = articleTypeService
						.findArticleTypeById(Integer.parseInt(typeId));
				List<ZyArticleWithBLOBs> articles = null;
				ZyArticleParams param = new ZyArticleParams();
				param.createCriteria().andTypeIdEqualTo(
						Integer.parseInt(typeId));
				articles = articleService.findArticleListWithBLOB(param);

				if (articles != null && articles.size() > 0) {
					info(m, "find single page with " + articles.get(0));
					request.setAttribute("zyArticle", articles.get(0));
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("singleFlag", "true");
		request.setAttribute("typeId", typeId);
		// get 部门列表
		List<ZyPartment> partments = null;
		// GET 新闻分类列表
		try {
			partments = partmentService.findAllPartments();
		} catch (ServiceException e) {
			error(m, "find all  partments exception", e);
		}
		request.setAttribute("partments", partments);

		return "success";
	}

	public String lookupTypes() {
		initArticleTypeData(articleTypeService, true, false);
		return "success";

	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	// 删除ARTICLE
	public String removeArticle() {
		String m = "removeArticle";
		info(m, "articleId id is" + articleId);
		int result = 0;
		try {
			result = articleService.removeArticleById(articleId);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the article with id=" + articleId, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "jbsxBox";
			this.forwardUrl = "listArticles.action?typeId=" + typeId;

			info(m, "remove the article successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "200";
			info(m, "remove the article failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	// 批量删除ARTICLE
	public String removeArticles() {
		String m = "removeArticles";
		info(m, "type ids is" + entityIds);
		int result = 0;
		try {
			for (String id : entityIds.split(",")) {
				result = articleService.removeArticleById(Integer.parseInt(id
						.trim()));
			}
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the article with id=" + entityIds, e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "jbsxBox";
			this.forwardUrl = "listArticles.action?typeId=" + typeId;
			info(m, "remove the article successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the article failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	/**
	 * 添加一个新闻，跳转到添加页面
	 * 
	 * @return
	 */
	public String addArticle() {
		String m = "addArticleType";
		// get 部门列表
		List<ZyPartment> partments = null;
		// GET 新闻分类列表
		List<ZyArticleType> articleTypes = null;
		try {
			articleTypes = articleTypeService.findAllArticleTypes();
		} catch (ServiceException e) {
			error(m, "find all  article types exception", e);
		}
		try {
			partments = partmentService.findAllPartments();

			if (null != typeId) {
				ZyArticleType type = articleTypeService
						.findArticleTypeById(Integer.parseInt(typeId.trim()));
				if (null != type)
					request.setAttribute("typeName", type.getTypeName());
			}
		} catch (ServiceException e) {
			error(m, "find all  partments exception", e);
		}

		ZyUser user = getCurrentUser();
		if (user != null) {
			request.setAttribute("myPartment", user.getPid());
		}
		request.setAttribute("partments", partments);
		request.setAttribute("typeId", typeId);
		request.setAttribute("articleTypes", articleTypes);
		return "add";
	}

	/**
	 * 添加一个新闻
	 * 
	 * @return
	 */
	public String doAddArticle() {
		String m = "doAddArticle";
		info(m, "add the article  =" + zyArticle);
		try {
			Date newDate = new Date();
			zyArticle.setCreateTime(newDate);
			zyArticle.setUpdateTime(newDate);
			// 未审核状态
			zyArticle.setStatus(Constant.UNCHECKED);
			// 新闻状态1
			zyArticle.setArticleType(Constant.NEWS_TYPE);
			zyArticle.setUserId(getCurrentUser().getUserId());
			if (zyArticle.getInnerFlag() == null
					|| zyArticle.getInnerFlag().equals("")) {
				zyArticle.setInnerFlag("1");
			}
			articleService.addArticle(zyArticle);

		} catch (ServiceException e) {
			error(m, "add the article  exception", e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addArticle";
			info(m, "add the article failed with title=" + zyArticle.getTitle());
			return "ajaxDone";
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		this.navTabId = "listArticlePage";

		info(m, "add the article success with article title="
				+ zyArticle.getTitle());
		return "ajaxDone";
	}

	/**
	 * 编辑一个新闻，跳转到编辑页面
	 * 
	 * @return
	 */
	public String editArticle() {
		String m = "editArticle";
		info(m, "edit the article  with article id=" + articleId);
		try {
			ZyArticleParams params = new ZyArticleParams();
			params.createCriteria().andArticleIdEqualTo(articleId);
			zyArticle = articleService.findArticleListWithBLOB(params).get(0);
			ZyArticleType temptype = articleTypeService
					.findArticleTypeById(zyArticle.getTypeId());

			if (temptype != null) {
				request.setAttribute("articleTypeName", temptype.getTypeName());
			}
		} catch (ServiceException e) {
			error(m, "find the article exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		// get 部门列表
		List<ZyPartment> partments = null;
		// GET 新闻分类列表
		try {
			partments = partmentService.findAllPartments();
		} catch (ServiceException e) {
			error(m, "find all  partments exception", e);
		}
		request.setAttribute("partments", partments);

		if (zyArticle != null) {
			request.setAttribute("zyArticle", zyArticle);
			info(m, "find the article  success with articleId=" + articleId);
			return "success";
		} else {
			this.callbackType = "forward";
			this.forwardUrl = "showArticleList.action?typeId="
					+ session.get("typeId");

			this.message = "操作失败";
			this.statusCode = "300";
			this.navTabId = "listArticlePage";
			info(m, "find the article failed with articleId=" + articleId);
			return "ajaxDone";
		}
	}

	/**
	 * 编辑一个新闻
	 * 
	 * @return
	 */
	public String doEditArticle() {
		String m = "doEditArticle";
		info(m, "edit the article  with article id=" + zyArticle.getArticleId());
		int result = 0;
		try {
			ZyArticle articleTemp = articleService.findArticleById(zyArticle
					.getArticleId());
			if (articleTemp != null) {
				zyArticle.setCreateTime(articleTemp.getCreateTime());
			}
			zyArticle.setUpdateTime(new Date());
			result = articleService.updateArticle(zyArticle);
		} catch (ServiceException e) {
			error(m, "find the article  exception", e);
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "closeCurrent";
			this.message = "编辑成功";
			this.statusCode = "200";
			this.navTabId = "listArticlePage";
			info(m, "update the article  success with article id="
					+ zyArticle.getArticleId());
		} else {
			this.message = "编辑失败";
			this.statusCode = "300";
			this.navTabId = "editArticle";

			info(m, "find the article type failed with article id="
					+ zyArticle.getArticleId());
		}
		return "ajaxDone";
	}

	public String manageArticle() {
		String m = "manageArticle";
		info(m, "edit the article  with article id=" + articleId);
		int result = 0;
		ZyArticle articleTemp = null;
		try {
			articleTemp = articleService.findArticleById(articleId);
			if (articleTemp != null) {
				if (Constant.UNCHECKED.equals(articleTemp.getInnerFlag())) {
					articleTemp.setStatus(Constant.CHECKED);
				}
			}
			articleTemp.setUpdateTime(new Date());
			result = articleService
					.updateArticle((ZyArticleWithBLOBs) articleTemp);
			ZyArticleParams params1 = new ZyArticleParams();
			params1.createCriteria().andArticleIdEqualTo(articleId);

			zyArticle = articleService.findArticleListWithBLOB(params1).get(0);
			if (articleTemp.getInnerFlag().equals("0")) {
				Map<String, String> params = new HashMap<String, String>();
				params.put("title", zyArticle.getTitle());
				params.put("data", zyArticle.getContent());
				params.put("categoryCode", zyArticle.getTypeId() + "");
				// 参考http://jxw.mas.gov.cn/bmsite/admin/login.action, jxw.jjyxk
				// 123456
				params.put("navigationID", "2");
				params.put("keywords", zyArticle.getKeywords());
				params.put("orgCode", "EA003");
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:MM:SS");
				params.put("addTime", sdf.format(zyArticle.getCreateTime()));
				params.put("orgType", "4");

				String result1 = WebServiceUtil.sendInfo(params);
				if (result1 == null) {
					warn(m,
							"send article info to JXW SERVER via web service failed!");
				} else {
					info(m,
							"send article info to JXW SERVER via web service success!");
				}
			}
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "审核成功";
			this.statusCode = "200";
			this.navTabId = "listUncheckArticles";
			this.forwardUrl = "showUnCheckArticleList.action";
			info(m, "update the article  success with article id="
					+ articleTemp.getArticleId());
		} else {
			this.message = "审核失败";
			this.statusCode = "300";
			info(m, "find the article type failed with article id="
					+ articleTemp.getArticleId());
		}
		return "ajaxDone";
	}

	public String manageArticles() {
		String m = "manageArticles";
		info(m, "edit the article  with article id=" + entityIds);
		int result = 0;
		try {
			ZyArticle articleTemp = null;
			for (String id : entityIds.split(",")) {
				articleTemp = articleService.findArticleById(Integer
						.parseInt(id.trim()));
				if (articleTemp != null) {
					articleTemp.setStatus(Constant.CHECKED);
				}
				articleTemp.setUpdateTime(new Date());
				result = articleService
						.updateArticle((ZyArticleWithBLOBs) articleTemp);

				zyArticle = (ZyArticleWithBLOBs) articleTemp;

				if (articleTemp.getInnerFlag().equals(Constant.CHECKED)) {
					Map<String, String> params = new HashMap<String, String>();
					params.put("title", zyArticle.getTitle());
					params.put("data", zyArticle.getContent());
					params.put("categoryCode", zyArticle.getTypeId() + "");
					// 参考http://jxw.mas.gov.cn/bmsite/admin/login.action,
					// jxw.jjyxk
					// 123456
					params.put("navigationID", "2");
					params.put("keywords", zyArticle.getKeywords());
					params.put("orgCode", "EA003");
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:MM:SS");
					params
							.put("addTime", sdf.format(zyArticle
									.getCreateTime()));
					params.put("orgType", "4");

					String result1 = WebServiceUtil.sendInfo(params);
					if (result1 == null) {
						warn(m,
								"send article info to JXW SERVER via web service failed!");
					} else {
						info(m,
								"send article info to JXW SERVER via web service success!");
					}
				}
			}
			if (result > 0) {
				this.callbackType = "forward";
				this.message = "审核成功";
				this.statusCode = "200";
				this.navTabId = "listUncheckArticles";
				this.forwardUrl = "showUnCheckArticleList.action";
				info(m, "update the article  success with article id="
						+ articleTemp.getArticleId());
			} else {
				this.message = "审核失败";
				this.statusCode = "300";
				info(m, "find the article type failed with article id="
						+ articleTemp.getArticleId());
			}
		} catch (Exception e) {
			error(m, "unknown exeption", e);
		}

		return "ajaxDone";
	}

	public String showUnCheckArticleList() {
		String m = "showUnCheckArticleList";
		// 获得配置的每页数量
		if (numPerPage == 0) {
			numPerPage = Config.getInt("pager.page_size");
		}
		int start = 0;
		if (pageNum > 1) {
			start = (pageNum - 1) * numPerPage;
		}
		// 准备查询未审核的数据
		try {
			user = (ZyUser) session.get("loginUser");
			ZyRole role = roleService.findRoleById(user.getRoleId());
			session.put("sessionRoleName", role.getRoleName());
			Map<String, Object> params = new HashMap<String, Object>();
			List<ZyArticle> articles = null;
			params.put("status", "1");
			params.put("start", start);
			params.put("size", numPerPage);
			params.put("roleId", role.getRoleId());
			articles = articleService.searchForPagerWithRoleId(params);
			
			params.remove("start");
			params.remove("size");
			int count = articleService.countSearchPagerWithRoleId(params);
			pager = new Pager<ZyArticle>(pageNum, numPerPage);

			pager.setPageRecords(articles);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " articles");
			pager.setCurrentPage(pageNum);
			pager.setPageSize(numPerPage);
			request.setAttribute("pager", pager);
			request.setAttribute("users", users);
		} catch (Exception e) {
			error(m, "find all uncheck articles", e);
		}
		return SUCCESS;
	}

	// ////////////////////////////////////////////////////////////WEB
	// 页面///////////////////////////////////////////////////////////////////////////////////

	/**
	 * 点击栏目时，查询此栏目文章
	 * 
	 * @return
	 */
	public String listArticleForTypeId() {
		String m = "listArticleForTypeId";
		try {
			// 获得配置的每页数量
			if (numPerPage == 0) {
				numPerPage = Config.getInt("web_page_size");
			}
			Map<String, Object> params = new HashMap<String, Object>();
			List<ZyArticle> articles = null;
			ZyArticleType currentType = null;
			if (null != typeId && Integer.parseInt(typeId.trim()) > 0) {
				params.put("typeId", typeId.trim());
				currentType = articleTypeService.findArticleTypeById(Integer
						.parseInt(typeId));
				request.setAttribute("articleType", currentType);
				// 获得所有父类
				findAllParentTypes(Integer.parseInt(typeId));
				request.setAttribute("parentTypes", parents);
			}
			boolean child = false;
			boolean pag = false;
			// 如果需要查子分类
			if (children != null && children.trim().length() > 0) {
				child = true;
			}
			// 如果需要分页
			if (pagnation != null && pagnation.trim().length() > 0) {
				pag = true;
			}
			articles = articleService.findArticlesByCountAndArticleType(Integer
					.parseInt(typeId), numPerPage, pageNum, pag, child);
			// 查询办事指南
			List<ZyArticle> articleList1 = articleService
					.findArticlesByCountAndArticleType(Config
							.getInt("banshizhinan_id"), 10, 1, true, true);

			request.setAttribute("articleList1", articleList1);
			// 查询下载中心
			List<ZyArticle> articleList2 = articleService
					.findArticlesByCountAndArticleType(Config
							.getInt("xiazaizhongxin_id"), 10, 1, true, true);
			request.setAttribute("articleList2", articleList2);
			int count = articleService.countSearchPagerForWeb(params, child);
			pager = new Pager<ZyArticle>(pageNum, numPerPage);
			if (null != currentType) {
				List<ZyArticleType> articleTypes = articleTypeService
						.findArticleTypeListByParentId(currentType.getTypeId());
				if (articleTypes != null && articleTypes.size() > 0) {
					request.setAttribute("articleTypes", articleTypes);
				} else {
					articleTypes = articleTypeService
							.findArticleTypeListByParentId(currentType
									.getParentId());
					request.setAttribute("articleTypes", articleTypes);
				}
			}
			pager.setPageRecords(articles);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " articles");

		} catch (ServiceException e) {
			error(m, "find all articles by typeid exeption", e);
		} catch (Exception e) {
			error(m, "find all articles by typeid exeption", e);
		}
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		request.setAttribute("child", children);
		request.setAttribute("pag", pagnation);
		return "success";
	}

	public String showArticle() throws ServiceException {
		String m = "showArticle";
		if (aid <= 0) {
			error(m, "article id is invalid!");
			return "error";
		}
		ZyArticleType currentType = null;
		zyArticle = (ZyArticleWithBLOBs) articleService.findArticleById(aid);
		if (zyArticle != null) {
			ZyArticleType temp = articleTypeService
					.findArticleTypeById(zyArticle.getTypeId());
			if (temp != null) {
				request.setAttribute("articleType", temp);
				findAllParentTypes(temp.getTypeId());
				request.setAttribute("parentTypes", parents);
			}
			request.setAttribute("article", zyArticle);
			currentType = articleTypeService.findArticleTypeById(zyArticle
					.getTypeId());
		}

		// 查询办事指南
		List<ZyArticle> articleList1 = articleService
				.findArticlesByCountAndArticleType(Config
						.getInt("banshizhinan_id"), 10, 1, true, true);

		request.setAttribute("articleList1", articleList1);
		// 查询下载中心
		List<ZyArticle> articleList2 = articleService
				.findArticlesByCountAndArticleType(Config
						.getInt("xiazaizhongxin_id"), 10, 1, true, true);
		request.setAttribute("articleList2", articleList2);

		if (null != currentType) {
			List<ZyArticleType> articleTypes = articleTypeService
					.findArticleTypeListByParentId(currentType.getParentId());
			if (articleTypes != null && articleTypes.size() > 0) {
				request.setAttribute("articleTypes", articleTypes);
			}
		}
		return "success";
	}

	public String showSinglePageForWeb() {
		String m = "showSinglePageForWeb";
		if (typeId != null) {
			try {
				ZyArticleType currentType = articleTypeService
						.findArticleTypeById(Integer.parseInt(typeId));
				List<ZyArticleWithBLOBs> articles = null;
				ZyArticleParams param = new ZyArticleParams();
				param.createCriteria().andTypeIdEqualTo(
						Integer.parseInt(typeId));
				articles = articleService.findArticleListWithBLOB(param);

				if (articles != null && articles.size() > 0) {
					info(m, "find single page with " + articles.get(0));
					request.setAttribute("article", articles.get(0));
				}
				// 查询办事指南
				List<ZyArticle> articleList1 = articleService
						.findArticlesByCountAndArticleType(Config
								.getInt("banshizhinan_id"), 10, 1, true, true);

				request.setAttribute("articleList1", articleList1);
				// 查询下载中心
				List<ZyArticle> articleList2 = articleService
						.findArticlesByCountAndArticleType(Config
								.getInt("xiazaizhongxin_id"), 10, 1, true, true);
				request.setAttribute("articleList2", articleList2);
				if (null != currentType) {
					List<ZyArticleType> articleTypes = articleTypeService
							.findArticleTypeListByParentId(currentType
									.getParentId());
					if (articleTypes != null && articleTypes.size() > 0) {
						request.setAttribute("articleTypes", articleTypes);
					}
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		return "success";
	}

	/**
	 * 获得所有父类，逐级列出来用于显示导航
	 * 
	 * @param typeId
	 * @return
	 */
	private void findAllParentTypes(int typeId) {
		try {
			if (typeId > 0) {
				ZyArticleType type;

				type = articleTypeService.findArticleTypeById(typeId);

				if (type.getParentId() != 0) {
					findAllParentTypes(type.getParentId());
					parents.add(type);
				} else {
					parents.add(type);
				}
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 显示部门的信息，文章
	 * 
	 * @return
	 */
	public String showPartmentArticles() {
		String m = "showPartmentArticle";
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
		params.put("partment_id", pid);

		try {
			List<ZyArticle> articles = articleService.searchForPager(params);
			params.remove("start");
			params.remove("size");
			int count = articleService.countSearchPager(params);
			pager = new Pager<ZyArticle>(pageNum, numPerPage);
			ZyArticleParams p1 = new ZyArticleParams();
			p1.createCriteria().andPartmentIdEqualTo(pid).andTitleEqualTo(
					"机构职责");
			List<ZyArticle> articles1 = articleService
					.findArticleListWithOutBLOB(p1);
			if (articles1 != null && articles1.size() > 0)

				request.setAttribute("firstArticle", articles1.get(0));
			pager.setPageRecords(articles);

			pager.setTotalRecords(count);
			pager.setCurrentPage(pageNum);
			pager.setPageSize(numPerPage);

			ZyPartment part = partmentService.findPartmentById(pid);
			request.setAttribute("part", part);
		} catch (ServiceException e) {
			error(m, "find article with partment id exception", e);
		}
		// 查询办事指南
		List<ZyArticle> articleList1 = articleService
				.findArticlesByCountAndArticleType(Config
						.getInt("banshizhinan_id"), 10, 1, true, true);

		request.setAttribute("articleList1", articleList1);
		// 查询下载中心
		List<ZyArticle> articleList2 = articleService
				.findArticlesByCountAndArticleType(Config
						.getInt("xiazaizhongxin_id"), 10, 1, true, true);
		request.setAttribute("articleList2", articleList2);
		// 所有部门
		ZyPartmentParams params2 = new ZyPartmentParams();
		params2.createCriteria().andPartmentIdGreaterThan(8);
		try {
			List<ZyPartment> partments = partmentService
					.findPartmentList(params2);
			request.setAttribute("allPartments", partments);
		} catch (ServiceException e) {
			error(m, "find article with partment id exception", e);
		}
		return "success";
	}

	/**
	 * 搜索方法
	 * 
	 * @return
	 */
	public String search() {
		String m = "search";
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
		if (title != null) {
			params.put("title", title);
			request.setAttribute("title", title);
		} else {
			if (null != session.get("sessionTitle")) {
				params.put("title", session.get("sessionTitle"));
			}
		}

		params.put("status", 0);

		try {
			List<ZyArticle> articles = articleService.searchForPager(params);
			params.remove("start");
			params.remove("size");
			int count = articleService.countSearchPager(params);
			pager = new Pager<ZyArticle>(pageNum, numPerPage);
			pager.setPageRecords(articles);

			pager.setTotalRecords(count);
			pager.setCurrentPage(pageNum);
			pager.setPageSize(numPerPage);

			// 查询办事指南
			List<ZyArticle> articleList1 = articleService
					.findArticlesByCountAndArticleType(Config
							.getInt("banshizhinan_id"), 10, 1, true, true);

			request.setAttribute("articleList1", articleList1);
			// 查询下载中心
			List<ZyArticle> articleList2 = articleService
					.findArticlesByCountAndArticleType(Config
							.getInt("xiazaizhongxin_id"), 10, 1, true, true);
			request.setAttribute("articleList2", articleList2);

			List<ZyArticleType> articleTypes = articleTypeService
					.findArticleTypeListByParentId(0);
			if (articleTypes != null && articleTypes.size() > 0) {
				request.setAttribute("articleTypes", articleTypes);
			}
		} catch (ServiceException e) {
			error(m, "find article with partment id exception", e);
		} catch (Exception e) {
			error(m, "find article with partment id exception", e);
		}
		request.setAttribute("title", title);
		return "success";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ArticleTypeService getArticleTypeService() {
		return articleTypeService;
	}

	public void setArticleTypeService(ArticleTypeService articleTypeService) {
		this.articleTypeService = articleTypeService;
	}

	public ZyUser getUser() {
		return user;
	}

	public void setUser(ZyUser user) {
		this.user = user;
	}

	public ZyArticleType getZyType() {
		return zyType;
	}

	public void setZyType(ZyArticleType zyType) {
		this.zyType = zyType;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public PartmentService getPartmentService() {
		return partmentService;
	}

	public void setPartmentService(PartmentService partmentService) {
		this.partmentService = partmentService;
	}

	public ZyArticleWithBLOBs getZyArticle() {
		return zyArticle;
	}

	public void setZyArticle(ZyArticleWithBLOBs zyArticle) {
		this.zyArticle = zyArticle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public PremissionService getPremissionService() {
		return premissionService;
	}

	public void setPremissionService(PremissionService premissionService) {
		this.premissionService = premissionService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}
