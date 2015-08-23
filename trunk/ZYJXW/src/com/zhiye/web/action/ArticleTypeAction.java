package com.zhiye.web.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyArticle;
import com.zhiye.common.bean.ZyArticleType;
import com.zhiye.common.bean.ZyPremission;
import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Constant;
import com.zhiye.common.util.Pager;
import com.zhiye.services.ArticleService;
import com.zhiye.services.ArticleTypeService;
import com.zhiye.services.PremissionService;
import com.zhiye.services.ServiceException;
import com.zhiye.services.UserService;

public class ArticleTypeAction extends GenericActionSupport<ZyArticleType> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ZyUser user;

	int typeId;
	String parentId;
	String typeName;

	UserService userService;

	ZyArticleType zyType;

	ArticleService articleService;
	ArticleTypeService articleTypeService;
	PremissionService premissionService;
	/**
	 * 列出所有的新闻分类
	 * 
	 * @return
	 */
	public String listArticleTypes() {
		String m = "listArticleTypes";
		List<ZyArticleType> types=null;
		try {
			types=getOrderedTypeList(articleTypeService);
			info(m, "find the " + types.size() + " article types");
		} catch (Exception e) {
			error(m, "find all article types exeption", e);
		}
		request.setAttribute("allTypes", types);

		return "success";

	}
	public String lookupParentTypes(){
		initArticleTypeData(articleTypeService,true,true);
		return "success";
		
	}
	// 删除ARTICLETYPE
	public String removeArticleType() {
		String m = "removeArticleType";
		info(m, "type id is" + typeId);
		int result = 0;
		try {
			//如果包含子栏目则不允许删除
			List<ZyArticleType> types=articleTypeService.findArticleTypeListByParentId(typeId);
			if(null!=types&&types.size()>0){
				this.message = "删除失败,请先删除此栏目的子栏目!";
				this.statusCode = "300";
				info(m, "remove the article type failed!");
				request.setAttribute("errorMsg", "remove failed!");
				return "success";
			}
			List<ZyArticle> articles=articleService.findArticlesByPageNumAndTypeId(0, 3, typeId);
			if(null!=articles&&articles.size()>0){
				this.message = "删除失败,请先删除此栏目下的文章!";
				this.statusCode = "300";
				info(m, "remove the article type failed!");
				request.setAttribute("errorMsg", "remove failed!");
				return "success";
			}
			result = articleTypeService.removeArticleTypeById(typeId);
			//删除模块权限
			premissionService.removePremissionBySectionId(typeId);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the article type with id=" + typeId, e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listArticleTypes";
			this.forwardUrl = "listArticleTypes.action";

			info(m, "remove the article type successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the article type failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	// 批量删除ARTICLETYPE
	public String removeArticleTypes() {
		String m = "removeArticleType";
		info(m, "type ids is" + entityIds);
		int result = 0;
		try {
//			如果包含子栏目则不允许删除
			List<ZyArticleType> types=articleTypeService.findArticleTypeListByParentId(typeId);
			if(null!=types&&types.size()>0){
				this.message = "删除失败,请先删除此栏目的子栏目!";
				this.statusCode = "300";
				info(m, "remove the article type failed!");
				request.setAttribute("errorMsg", "remove failed!");
				return "success";
			}
			List<ZyArticle> articles=articleService.findArticlesByPageNumAndTypeId(0, 3, typeId);
			if(null!=articles&&articles.size()>0){
				this.message = "删除失败,请先删除此栏目下的文章!";
				this.statusCode = "300";
				info(m, "remove the article type failed!");
				request.setAttribute("errorMsg", "remove failed!");
				return "success";
			}
			
			for (String id : entityIds.split(",")) {
				result = articleTypeService.removeArticleTypeById(Integer
						.parseInt(id.trim()));
			}
			//删除模块权限
			premissionService.removePremissionBySectionId(typeId);
		} catch (NumberFormatException e) {
			error(m, "parse string to int exception", e);
		} catch (ServiceException e) {
			error(m, "remove the article type with id=" + entityIds, e);
		}
		if (result > 0) {
			this.callbackType = "forward";
			this.message = "删除成功";
			this.statusCode = "200";
			this.navTabId = "listArticleTypes";
			this.forwardUrl = "listArticleTypes.action";

			info(m, "remove the article type successed!");
		} else {
			this.message = "删除失败";
			this.statusCode = "300";
			info(m, "remove the article type failed!");
			request.setAttribute("errorMsg", "remove failed!");
		}
		return "success";
	}

	/**
	 * 添加一个新闻分类，跳转到添加页面
	 * 
	 * @return
	 */
	public String addArticleType() {
		String m = "addArticleType";
		if (typeId > 0) {
			info(m, "add the article type with parent id=" + typeId);
			request.setAttribute("parentId", typeId);
		} else {
			List<ZyArticleType> types = null;
			try {
				types = articleTypeService.findAllArticleTypes();
			} catch (ServiceException e) {
				error(m, "find the article types exception", e);
			}
			request.setAttribute("allTypes", types);
		}
		return "add";
	}

	/**
	 * 添加一个新闻分类
	 * 
	 * @return
	 */
	public String doAddArticleType() {
		String m = "doAddArticleType";
		info(m, "add the article type =" + zyType);
		try {
			Date newDate = new Date();
			zyType.setCreateTime(newDate);
			zyType.setUpdateTime(newDate);
			ZyArticleType temp = articleTypeService
					.findArticleTypeByTypeName(zyType.getTypeName());
			if (temp != null) {
				info(m, "article type name exsits with typename="
						+ zyType.getTypeName());
				this.message = "添加失败,名称已存在!";
				this.statusCode = "300";
				this.navTabId = "addArticleType";
				return "ajaxDone";
			}
			articleTypeService.addArticleType(zyType);
			
			ZyArticleType type=articleTypeService.findArticleTypeByTypeName(zyType.getTypeName());
			//添加模块权限
			ZyPremission premission=new ZyPremission();
			premission.setPremissionType(Constant.VIEW);
			premission.setSectionId(type.getTypeId());
			premission.setRemarks("查看访问");
			premissionService.addPremission(premission);	
			premission.setPremissionType(Constant.A_M_D);
			premission.setRemarks("添加，修改，删除");
			premissionService.addPremission(premission);	
			premission.setPremissionType(Constant.MANAGE);
			premission.setRemarks("审核");
			premissionService.addPremission(premission);	
			
		} catch (ServiceException e) {
			error(m, "add the article type exception", e);
			this.message = "添加失败";
			this.statusCode = "300";
			this.navTabId = "addArticleType";
			info(m, "add the article type failed with typename="
					+ zyType.getTypeName());
			return "ajaxDone";
		}

		this.callbackType = "closeCurrent";
		this.message = "添加成功";
		this.statusCode = "200";
		this.navTabId = "listArticleTypes";

		info(m, "add the article type success with typeId="
				+ zyType.getTypeId());
		return "ajaxDone";
	}

	/**
	 * 编辑一个新闻分类，跳转到编辑页面
	 * 
	 * @return
	 */
	public String editArticleType() {
		String m = "editArticleType";
		info(m, "edit the article type with type id=" + typeId);
		ZyArticleType type = null;
		try {
			type = articleTypeService.findArticleTypeById(typeId);
			if(type.getParentId()==0){
				request.setAttribute("parentId", 0);
				request.setAttribute("parentName", "顶级目录");
			}else{
				ZyArticleType parent=articleTypeService.findArticleTypeById(type.getParentId());
				request.setAttribute("parentId", parent.getTypeId());
				request.setAttribute("parentName", parent.getTypeName());
			}
			
		} catch (ServiceException e) {
			error(m, "find the article type exception", e);
		}
		if (type != null) {
			request.setAttribute("zyType", type);
			info(m, "find the article type success with typeId=" + typeId);
			return "success";
		} else {
			this.callbackType = "forward";
			this.callbackType = "listArticleType.action";
			this.message = "操作失败";
			this.statusCode = "300";
			this.navTabId = "listArticleTypes";
			info(m, "find the article type failed with typeId=" + typeId);
			return "ajaxDone";
		}
	}

	/**
	 * 编辑一个新闻分类
	 * 
	 * @return
	 */
	public String doEditArticleType() {
		String m = "doEditArticleType";
		info(m, "edit the article type with type id=" + zyType.getTypeId());
		int result = 0;
		try {
			zyType.setUpdateTime(new Date());
			ZyArticleType temp = articleTypeService
					.findArticleTypeByTypeName(zyType.getTypeName());
			
			if(zyType.getParentId()==zyType.getTypeId()){
				info(m, "selected wrong parentId, can 't  select itself id as parent id");
				this.message = "编辑失败,不可以选择自己作为父级栏目!";
				this.statusCode = "300";
				this.navTabId = "editArticleType";
				return "ajaxDone";
			}
			if (temp != null && !typeName.equals(zyType.getTypeName())) {
				info(m, "article type name exsits with typename="
						+ zyType.getTypeName());
				this.message = "编辑失败,名称已存在!";
				this.statusCode = "300";
				this.navTabId = "editArticleType";
				return "ajaxDone";
			}
			result = articleTypeService.updateArticleType(zyType);
		} catch (ServiceException e) {
			error(m, "find the article type exception", e);
		}
		if (result > 0) {
			this.callbackType = "closeCurrent";
			this.message = "编辑成功";
			this.statusCode = "200";
			this.navTabId = "listArticleTypes";

			info(m, "update the article type success with typeId="
					+ zyType.getTypeId());
		} else {
			this.message = "编辑失败";
			this.statusCode = "300";
			this.navTabId = "editArticleType";

			info(m, "find the article type failed with typeId="
					+ zyType.getTypeId());
		}
		return "ajaxDone";
	}

	/**
	 * 获得子分类数据
	 * 
	 * @return
	 */
	public String getChildrenTypes() {
		String m = "getChildrenTypes";
		info(m, "the parent typeid = " + typeId);
		try {
			// 获得配置的每页数量
			numPerPage = Config.getInt("pager.page_size");
			int start = 0;
			if (pageNum > 1) {
				start = (pageNum - 1) * numPerPage;
			}
			List<ZyArticleType> types = articleTypeService
					.findArticleTypesByPageNumAndParentId(start, numPerPage,
							typeId);
			int count = articleTypeService
					.countArticleTypeListByParentId(typeId);
			pager = new Pager<ZyArticleType>(pageNum, numPerPage);

			pager.setPageRecords(types);
			pager.setTotalRecords(count);
			info(m, "find the " + count + " article types");
		} catch (ServiceException e) {
			error(m, "find all article types exeption", e);
		}
		request.setAttribute("parentId", typeId);
		pager.setCurrentPage(pageNum);
		pager.setPageSize(numPerPage);
		return "success";
	}

	/**
	 * getTYPE HTMLS
	 * 用于AJAX调用，ACTION:getTypeHTMLS
	 * @return
	 */
	public void getTypeHTMLS() {
		String m = "getTypeHTMLS";
		String resultHTMLS = retrieveTypeHtml(articleTypeService);
		PrintWriter out = null;
		try {
			response.setContentType("text/plain");
			out = response.getWriter();
			out.write(resultHTMLS);
			info(m,"wirite the type html:"+resultHTMLS);
		} catch (Exception e) {
			error(m, "write the child types data to response error ", e);
		}finally {
			if (null != out) {
				out.close();
			}
		}

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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public PremissionService getPremissionService() {
		return premissionService;
	}

	public void setPremissionService(PremissionService premissionService) {
		this.premissionService = premissionService;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
}
