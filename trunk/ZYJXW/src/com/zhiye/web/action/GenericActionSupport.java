package com.zhiye.web.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zhiye.common.bean.ZyArticleType;
import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Constant;
import com.zhiye.common.util.Pager;
import com.zhiye.log.Logger;
import com.zhiye.log.LoggerFactory;
import com.zhiye.services.ArticleTypeService;

public abstract class GenericActionSupport<T> extends ActionSupport implements
		ServletResponseAware, ServletRequestAware, SessionAware {

	/**
	 * Logger object.
	 */
	private Logger _logger = LoggerFactory.getPresentationLog(this.getClass());

	protected static final String LOGIN = "login";

	protected static final String CHANGE_PASS = "changePass";

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected Map<String, Object> session;

	Map<Integer, List<ZyArticleType>> typesMap = null;

	protected ServletContext servletContext = ServletActionContext
			.getServletContext();

	protected int numPerPage ; // 每页显示多少条 可以不用Set

	public int pageNumShown = 5;// 页标数字多少个 可以不用Set

	int count1 = 0;

	int count2 = 0;

	int count3 = 0;

	int count4 = 0;
	int count5=0;

	protected String message; // 生成Set Get 略

	protected String statusCode; // 生成Set Get 略

	protected String forwardUrl; // 生成Set Get 略

	protected String callbackType; // 生成Set Get 略

	protected String navTabId; // 生成Set Get 略

	protected int pageNum; // 当前页码 上一页加1

	protected Pager<T> pager;

	List<ZyArticleType> results = new ArrayList<ZyArticleType>();
	// 要删除的对象的ID,以逗号分割
	protected String entityIds;

	private String blanks;

	public Map<Integer, List<ZyArticleType>> getTypesMap() {
		return typesMap;
	}

	public void setTypesMap(Map<Integer, List<ZyArticleType>> typesMap) {
		this.typesMap = typesMap;
	}

	public String getEntityIds() {
		return entityIds;
	}

	public void setEntityIds(String entityIds) {
		this.entityIds = entityIds;
	}

	public int getPageNum() {

		return pageNum;

	}

	/**
	 * 准备用于主页的左边新闻分类的数据,和新闻选择分类，以及分类选择父级分类的时候
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void initArticleTypeData(ArticleTypeService articleTypeService,
			boolean selectable, boolean parentFlag) {
		String m = "initArticleTypeData";
		try {
			// 用于选择分类
			if (selectable && !parentFlag) {
				typesMap = articleTypeService.getAllNewsTypeMap();
			} else {
				// 用于显示
				typesMap = articleTypeService.getAllTypeMap();
			}

		} catch (Exception e) {
			error(m, "find article type exception", e);
		}

		if (selectable) {
			request.setAttribute("typeSelectHTMLs", getTypeHtmls(typesMap,
					selectable, parentFlag));
		} else {
			request.setAttribute("typeHTMLs", getTypeHtmls(typesMap,
					selectable, parentFlag));
			session.put("typesMap", typesMap);
		}

	}

	/**
	 * 用于在管理栏目的时候，显示按照树形结构的LIST
	 * 
	 * @return
	 */
	public List<ZyArticleType> getOrderedTypeList(
			ArticleTypeService articleTypeService) {
		String m = "getOrderedTypeList";
		int count=0;
		try {
			count=articleTypeService.countAllArticleTypes();
			typesMap = articleTypeService.getAllTypeMap();
		} catch (Exception e) {
			error(m, "find article types exception", e);
		}
		// 获得ROOT节点
		List<ZyArticleType> roots = typesMap.get(0);
		return getTypesHtmlsWithOperations(roots);
	}
	

	/**
	 * 获得类型的HTML代码 并返回 AJAX调用
	 * 
	 * @return
	 */
	public String retrieveTypeHtml(ArticleTypeService articleTypeService) {
		String m = "retrieveTypeHtml";
		try {
			typesMap = articleTypeService.getAllTypeMap();
		} catch (Exception e) {
			error(m, "find article type exception", e);
		}
		// 获得ROOT节点
		List<ZyArticleType> roots = typesMap.get(0);
		try {
			return getSpecHtmlsForRefresh(roots);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 获得在添加用户时，需要选择的 类型列表 返回页面用树形结构显示
	 * 
	 * @param map
	 * @param selectable
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String getTypeHtmls(Map<Integer, List<ZyArticleType>> map,
			boolean selectable, boolean parentFlag) {
		String m = "getTypeHtmls";
		Set keys = map.entrySet();
		Iterator it = keys.iterator();
		// 获得ROOT节点
		List<ZyArticleType> roots = map.get(0);
		try {
			if (selectable) {
				if (parentFlag) {
					StringBuffer htmls=new StringBuffer();
					htmls.append("<ul class=\"tree expand\"><li><a href=\"javascript:\" onclick=\"$.bringBack({parentId:'0', parentName:'Root'})\">ROOT</a>");
					htmls.append(getChildrenHtmlForTypes(roots));
					htmls.append("</li></ul>");
					return  htmls.toString();
				} else {
					return getChildrenHtml(roots);
				}

			} else {
				return getSpecHtmls(roots);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 递归获得子节点HTML selectable 是可否选择选择栏目，并赋值到INPUT TEXT 添加、编辑新闻时
	 * 
	 * @return
	 */
	private String getChildrenHtml(List<ZyArticleType> types) {
		StringBuffer sb1 = new StringBuffer();
		if (count1 == 0) {
			sb1.append("<ul class=\"tree expand\">");
		} else {
			sb1.append("<ul>");
		}
		count1++;

		for (ZyArticleType type : types) {
			sb1.append("<li>");
			sb1
					.append("<a href=\"javascript:\" onclick=\"$.bringBack({typeId:'"
							+ type.getTypeId()
							+ "', typeName:'"
							+ type.getTypeName()
							+ "'})\">"
							+ type.getTypeName() + "</a>");
			if (typesMap.containsKey(type.getTypeId())) {
				sb1.append(getChildrenHtml(typesMap.get(type.getTypeId())))
						.toString();
			}
			sb1.append("</li>");
		}
		sb1.append("</ul>");
		return sb1.toString();
	}

	/**
	 * 递归获得子节点HTML selectable 是可否选择选择栏目，并赋值到INPUT TEXT 添加、编辑分类栏目时
	 * 
	 * @return
	 */
	private String getChildrenHtmlForTypes(List<ZyArticleType> types) {
		StringBuffer sb1 = new StringBuffer();
			sb1.append("<ul>");
		for (ZyArticleType type : types) {
			sb1.append("<li>");
			sb1
					.append("<a href=\"javascript:\" onclick=\"$.bringBack({parentId:'"
							+ type.getTypeId()
							+ "', parentName:'"
							+ type.getTypeName()
							+ "'})\">"
							+ type.getTypeName() + "</a>");
			if (typesMap.containsKey(type.getTypeId())) {
				sb1
						.append(
								getChildrenHtmlForTypes(typesMap.get(type
										.getTypeId()))).toString();
			}
			sb1.append("</li>");
		}
		sb1.append("</ul>");
		return sb1.toString();
	}

	/**
	 * 
	 * @param types
	 * @return
	 */
	private String getSpecHtmls(List<ZyArticleType> types) {
		StringBuffer sb1 = new StringBuffer();
		if(count5==0){
			sb1.append("<ul class=\"tree collapse\">");
		}else{
			sb1.append("<ul>");
		}
		
		count5++;
		for (ZyArticleType type : types) {
			sb1.append("<li>");
			if (type.getType().equals(Constant.NEWS)) {
				sb1.append("<a href='showArticleList.action?typeId="
						+ type.getTypeId() + "' target='ajax' rel='jbsxBox'>"
						+ type.getTypeName() + "</a>");
			} else if (type.getType().equals(Constant.PAGE)) {
				sb1.append("<a href='showSinglePage.action?typeId="
						+ type.getTypeId() + "' target='ajax' rel='jbsxBox'>"
						+ type.getTypeName() + "</a>");
			} else {
				sb1.append("<a href='javascript:void(0);' >"
						+ type.getTypeName() + "</a>");
			}

			if (typesMap.containsKey(type.getTypeId())) {
				sb1.append(getSpecHtmls(typesMap.get(type.getTypeId())))
						.toString();
			}
			sb1.append("</li>");
		}
		sb1.append("</ul>");

		return sb1.toString();
	}

	/**
	 * 在点击内容管理的时候 会调用此方法 用于刷新所有的 栏目
	 * 
	 * @param types
	 * @return
	 */
	private String getSpecHtmlsForRefresh(List<ZyArticleType> types) {
		StringBuffer sb1 = new StringBuffer();
		if (count4 == 0) {
			sb1.append("<ul id=\"typeHTMLS\">");
		} else {
			sb1.append("<ul>");
		}
		for (ZyArticleType type : types) {
			if (!typesMap.containsKey(type.getTypeId())) {
				sb1.append("<li class=\"last\">");
			} else {
				sb1.append("<li>");
			}
			sb1.append("<div class=\"\">");
			for (int i = 0; i < count4; i++) {
				sb1.append("<div class=\"indent\"></div>");
				if (i % 2 == 0) {
					sb1.append("<div class=\"line\"></div>");
				}
			}
			if (typesMap.containsKey(type.getTypeId())) {
				sb1.append("<div class=\"folder_collapsable\"></div>");
			} else {
				sb1.append("<div class=\"node\"></div>");
				sb1.append("<div class=\"file\"></div>");
			}
			sb1
					.append("<a href='listArticles.action?typeId="
							+ type.getTypeId()
							+ "' target='navTab' rel='listArticles' class='articleType_class' id='articleType_"
							+ type.getTypeId() + "'>" + type.getTypeName()
							+ "</a>");
			sb1.append("</div>");
			if (typesMap.containsKey(type.getTypeId())) {
				sb1.append(
						getSpecHtmlsForRefresh(typesMap.get(type.getTypeId())))
						.toString();
			}
			sb1.append("</li>");
		}
		sb1.append("</ul>");

		return sb1.toString();
	}

	/**
	 * 用于在栏目管理的时候 显示栏目列表
	 * 
	 * @param types
	 * @return
	 */
	public List<ZyArticleType> getTypesHtmlsWithOperations(
			List<ZyArticleType> types) {
		blanks = blanks + Constant.SPERATOR;
		for (ZyArticleType type : types) {
			if (type.getParentId() == 0) {
				blanks = "";
			}
			type.setTypeName(blanks + type.getTypeName());
			results.add(type);
			if (typesMap.containsKey(type.getTypeId())) {
				getTypesHtmlsWithOperations(typesMap.get(type.getTypeId()));
			} 
		}
		if (blanks.length() > 0)
			blanks = blanks.substring(Constant.SPERATOR.length());
		return results;
	}

	public void clearSystemData() {
		if (session != null) {
			session.remove("loginUser");
			session.remove("sessionRoleName");
			session.remove("loginId");
			session.remove("manageFlag");
		}
	}

	public void setPageNum(int pageNum) {

		this.pageNum = pageNum;

	}

	public int pageStart() {

		if (getPageNum() <= 0) {
			pageNum = 1;
		}

		return (getPageNum() - 1) * Config.getInt("pager.page_size");

	}

	public Pager<T> getPager() {
		return pager;
	}

	public void setPager(Pager<T> pager) {
		this.pager = pager;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ZyUser getCurrentUser() {
		return (ZyUser) session.get("loginUser");
	}

	public String getCurrentUserName() {
		ZyUser user = getCurrentUser();
		if (user != null) {
			return user.getLoginname();
		} else {
			return null;
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse
	 *      (javax.servlet.http.HttpServletResponse)
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(
	 *      javax.servlet.http.HttpServletRequest)
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * debug log
	 */
	protected void debug(String method, String message) {
		_logger.debug(method, getCurrentUserName(), message);
	}

	/**
	 * warn log
	 */
	protected void warn(String method, String message) {
		_logger.warn(method, getCurrentUserName(), message);
	}

	/**
	 * fatal log
	 */
	protected void error(String method, String message) {
		_logger.error(method, getCurrentUserName(), message);
	}

	/**
	 * fatal log
	 */
	protected void error(String method, String message, Throwable t) {
		_logger.error(method, getCurrentUserName(), message, t);
	}

	/**
	 * info log
	 */
	protected void info(String method, String message) {
		_logger.info(method, getCurrentUserName(), message);
	}

	protected String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public String getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
