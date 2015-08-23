package com.zhiye.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhiye.common.bean.ZyArticle;
import com.zhiye.common.bean.ZyArticleType;
import com.zhiye.common.bean.ZyArticleWithBLOBs;
import com.zhiye.common.bean.ZyLink;
import com.zhiye.common.bean.ZyLinkParams;
import com.zhiye.common.bean.ZyPartment;
import com.zhiye.common.bean.ZyPartmentParams;
import com.zhiye.common.bean.ZyUser;
import com.zhiye.common.bean.ZyUserParams;
import com.zhiye.common.util.Config;
import com.zhiye.common.util.Constant;
import com.zhiye.common.util.StringHelper;
import com.zhiye.services.ArticleService;
import com.zhiye.services.ArticleTypeService;
import com.zhiye.services.CorporationService;
import com.zhiye.services.LinkService;
import com.zhiye.services.PartmentService;
import com.zhiye.services.ServiceException;
import com.zhiye.services.UserService;

public class IndexAction extends GenericActionSupport<ZyArticle> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ZyUser user;

	String typeId;

	long articleId;

	long aid;

	String flag;
	String pagnation;

	String children;

	String title;

	String loginName;;

	String status;

	UserService userService;
	
	LinkService linkService;

	ZyArticleWithBLOBs zyArticle;

	ZyArticleType zyType;

	ArticleTypeService articleTypeService;

	PartmentService partmentService;
	

	ArticleService articleService;

	List<ZyUser> users;

	/**
	 * 为首页准备数据
	 * @return
	 * @throws ServiceException 
	 */
	public String index() throws ServiceException{
//		查询办事指南
		List<ZyArticle> articleList1=articleService.findArticlesByCountAndArticleType(Config.getInt("banshizhinan_id"),10,1,true,true);
		
		request.setAttribute("articleList1", articleList1);
		//查询下载中心
		List<ZyArticle> articleList2=articleService.findArticlesByCountAndArticleType(Config.getInt("xiazaizhongxin_id"),10,1,true,true);
		request.setAttribute("articleList2", articleList2);
		
//		查询通知通告
		List<ZyArticle> articleList3=articleService.findArticlesByCountAndArticleType(Config.getInt("tongzhitonggao_id"),10,1,true,true);
		request.setAttribute("articleList3", articleList3);
		
		//查找首页的5个图片新闻
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("start", 0);
		params.put("size", 5);
		params.put("img_flag", Constant.YES);
		List<ZyArticle> imageArticles=articleService.searchForPager(params);
		request.setAttribute("imageArticles", imageArticles);
		
		//查找首页7itiao新闻
		List<ZyArticle> articleList4=articleService.findArticlesByCountAndArticleType(Config.getInt("shouyexinwen_id"),7,1,true,true);
		List<ZyArticleWithBLOBs> blobArticles=new ArrayList<ZyArticleWithBLOBs>(2);
		List<ZyArticle> noBlobArticles=new ArrayList<ZyArticle>(5);
		int c=0;
		for(ZyArticle a:articleList4){
			if(c<2){
				ZyArticleWithBLOBs bolb=(ZyArticleWithBLOBs)articleService.findArticleById(a.getArticleId());
				//去掉图片链接
				bolb.setContent(StringHelper.splitAndFilterString(bolb.getContent(),200));
				blobArticles.add(bolb);
			}else{
				noBlobArticles.add(a);
			}
			
			c++;
		}
		request.setAttribute("blobArticles", blobArticles);
		request.setAttribute("noBlobArticles", noBlobArticles);
		
		//经济运行
		List<ZyArticle> articleList5=articleService.findArticlesByCountAndArticleType(Config.getInt("jingjiyunxing_id"),10,1,true,true);
		request.setAttribute("articleList5", articleList5);
		//俩花融合
		List<ZyArticle> articleList6=articleService.findArticlesByCountAndArticleType(Config.getInt("liahuaronghe_id"),10,1,true,true);
		request.setAttribute("articleList6", articleList6);
		//技术进步
		List<ZyArticle> articleList7=articleService.findArticlesByCountAndArticleType(Config.getInt("jishujinbu_id"),10,1,true,true);
		request.setAttribute("articleList7", articleList7);
		//中小企业
		List<ZyArticle> articleList8=articleService.findArticlesByCountAndArticleType(Config.getInt("zhongxiaoqiye_id"),10,1,true,true);
		request.setAttribute("articleList8", articleList8);
		//节能降耗
		List<ZyArticle> articleList9=articleService.findArticlesByCountAndArticleType(Config.getInt("jienengjianghao_id"),10,1,true,true);
		request.setAttribute("articleList9", articleList9);
		//党群工作
		List<ZyArticle> articleList10=articleService.findArticlesByCountAndArticleType(Config.getInt("dangqungongzuo_id"),10,1,true,true);
		request.setAttribute("articleList10", articleList10);
		
		//查询通知通告 排行
		List<ZyArticle> articleList11=articleService.findArticlesByCountAndArticleType(Config.getInt("tongzhitonggao_id"),5,1,true,true);
		request.setAttribute("articleList11", articleList11);
		
		//部门
		ZyPartmentParams params2=new ZyPartmentParams();
		params2.createCriteria().andPartmentIdGreaterThan(8);
		List<ZyPartment> partments=partmentService.findPartmentList(params2);
		request.setAttribute("allPartments", partments);
		
		//友情链接
		ZyLinkParams param3=new ZyLinkParams();
		List<ZyLink> links=linkService.findLinkListWithBLOB(param3);
		request.setAttribute("links", links);
		return "success";
	}
	
	public String msg(){
		
		//查询通知通告
		List<ZyArticle> articleList3=articleService.findArticlesByCountAndArticleType(Config.getInt("tongzhitonggao_id"),10,1,true,true);
		request.setAttribute("articleList3", articleList3);
		
		List<ZyArticle> articleList1=articleService.findArticlesByCountAndArticleType(Config.getInt("banshizhinan_id"),10,1,true,true);
		
		request.setAttribute("articleList1", articleList1);
		//查询下载中心
		List<ZyArticle> articleList2=articleService.findArticlesByCountAndArticleType(Config.getInt("xiazaizhongxin_id"),10,1,true,true);
		request.setAttribute("articleList2", articleList2);
		if(request.getParameter("flag")!=null){
		try {
			List<ZyUser> users=userService.findUserList(new ZyUserParams());
			request.setAttribute("users", users);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("flag", true);
		}
		
		return "success";
	}
	
	public List<ZyUser> getUsers() {
		return users;
	}

	public void setUsers(List<ZyUser> users) {
		this.users = users;
	}

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

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public ArticleTypeService getArticleTypeService() {
		return articleTypeService;
	}

	public void setArticleTypeService(ArticleTypeService articleTypeService) {
		this.articleTypeService = articleTypeService;
	}

	public PartmentService getPartmentService() {
		return partmentService;
	}

	public void setPartmentService(PartmentService partmentService) {
		this.partmentService = partmentService;
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

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public ZyUser getUser() {
		return user;
	}

	public void setUser(ZyUser user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public LinkService getLinkService() {
		return linkService;
	}

	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}


}
