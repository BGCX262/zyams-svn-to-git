package com.zhiye.web.servlets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiye.common.bean.ZyCorporation;
import com.zhiye.common.bean.ZyCorporationParams;
import com.zhiye.common.bean.ZyIndex;
import com.zhiye.common.util.DBConnect;
import com.zhiye.services.ArticleService;
import com.zhiye.services.ArticleTypeService;
import com.zhiye.services.CorporationService;
import com.zhiye.services.IndexService;
import com.zhiye.services.LinkService;
import com.zhiye.services.PartmentService;
import com.zhiye.services.PremissionService;
import com.zhiye.services.ServiceException;
import com.zhiye.services.UserService;

public class SQLServlet extends HttpServlet {
	private WebApplicationContext ctx;

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this
				.getServletContext());
		ArticleService as = (ArticleService) ctx.getBean("articleService");
		ArticleTypeService ats = (ArticleTypeService) ctx
				.getBean("articleTypeService");
		PartmentService ps = (PartmentService) ctx.getBean("partmentService");
		UserService us = (UserService) ctx.getBean("userService");
		LinkService ls = (LinkService) ctx.getBean("linkService");

		IndexService iService = (IndexService) ctx.getBean("indexService");
		CorporationService cs=(CorporationService)ctx.getBean("corporationService");
		PremissionService premissionService = (PremissionService) ctx.getBean("premissionService");
		Statement stmt = null;
		Connection conn = null;
		try {
			conn = DBConnect.getConnection();
			if (null == conn) {
				System.out.println("connection is null");
				System.exit(0);
			}
			stmt=conn.createStatement();
			 ResultSet rs =
			 stmt.executeQuery("select RowID,ID,YEAR,MONTH,S01,S02,S03,S04,S05,S06,S07,S08,S09,S10,S11,S12,S13,S14,S15,S16,S17,S18,S19,S20,S21,S22,S23,S24" +
			 		",V01,V02,V03,V04,V05,V06,V07,V08,V09,V10,V11,V12,V13,V14,V15,V16,V17,V18,V19,V20,V21,V22,V23,V24,ISAUDI,L01,L02,L03,L04,L05,L06,L07,L08,L09,L10" +
			 		",L11,L12,L13,L14,L15,L16,L17,L18,L19,L20,L21,L22,L23,L24 from jjzb_book;");
			 // 对结果集进行处理
			 while (rs.next()) {
				 ZyIndex index=new ZyIndex();
				 String copId=rs.getString("ID");
				 ZyCorporationParams params=new ZyCorporationParams();
				 params.createCriteria().andIdEqualTo(copId);
				 List<ZyCorporation> cops=cs.findCorpsWithParams(params);
				 if(cops!=null&&cops.size()>0){
					 index.setCorporationid(cops.get(0).getRowid());
				 }else{
					 continue;
				 }
				 
					index.setCreatetime(new Date());
					
					index.setGyzczv1(rs.getLong("V01"));
					index.setGyzczv2(rs.getLong("S01"));
					index.setGyzczv3(rs.getLong("L01"));
					
					index.setGyzjzv1(rs.getLong("V02"));
					index.setGyzjzv2(rs.getLong("S02"));
					index.setGyzjzv3(rs.getLong("L02"));
					index.setYear(Integer.parseInt(rs.getString("YEAR")));
					index.setMonth(Integer.parseInt(rs.getString("MONTH")));
					
					if(rs.getString("ISAUDI").equals("未审核")){
						index.setStatus("1");
					}else{
						index.setStatus("0");
					}
					
					
					index.setUpdatetime(new Date());
					
					index.setXcpczv1(rs.getLong("V19"));
					index.setXcpczv2(rs.getLong("S19"));
					index.setXcpczv3(rs.getLong("L19"));
					
					
					index.setGyxsczv1(rs.getLong("V03"));
					index.setGyxsczv2(rs.getLong("S03"));
					index.setGyxsczv3(rs.getLong("L03"));
					
					index.setCkjhzv1(rs.getLong("V20"));
					index.setCkjhzv2(rs.getLong("S20"));
					index.setCkjhzv3(rs.getLong("L20"));
	
					
					index.setCpxssrv1(rs.getLong("V04"));
					index.setCpxssrv2(rs.getLong("S04"));
					index.setCpxssrv3(rs.getLong("L04"));
					
					index.setCpxscbv1(rs.getLong("V05"));
					index.setCpxscbv2(rs.getLong("S05"));
					index.setCpxscbv3(rs.getLong("L05"));
					
					index.setCpxsfyv1(rs.getLong("V21"));
					index.setCpxsfyv2(rs.getLong("S21"));
					index.setCpxsfyv3(rs.getLong("L21"));
					
					index.setCpxssjjfjv1(rs.getLong("V22"));
					index.setCpxssjjfjv2(rs.getLong("S22"));
					index.setCpxssjjfjv3(rs.getLong("L22"));
					
					index.setGlfyv1(rs.getLong("V06"));
					index.setGlfyv2(rs.getLong("S06"));
					index.setGlfyv3(rs.getLong("L06"));
					
					index.setCwfyv1(rs.getLong("V07"));
					index.setCwfyv2(rs.getLong("S07"));
					index.setCwfyv3(rs.getLong("L07"));
					
					index.setLxzcv1(rs.getLong("V23"));
					index.setLxzcv2(rs.getLong("S23"));
					index.setLxzcv3(rs.getLong("L23"));
					
					index.setLrzev1(rs.getLong("V08"));
					index.setLrzev2(rs.getLong("S08"));
					index.setLrzev3(rs.getLong("L08"));
					
					index.setLszev1(rs.getLong("V09"));
					index.setLszev2(rs.getLong("S09"));
					index.setLszev3(rs.getLong("L09"));
					
					index.setYjzzsv1(rs.getLong("V10"));
					index.setYjzzsv2(rs.getLong("S10"));
					index.setYjzzsv3(rs.getLong("L10"));
					
					
					index.setQbldzcv1(rs.getLong("V11"));
					index.setQbldzcv2(rs.getLong("S11"));
					index.setQbldzcv3(rs.getLong("L11"));
					
					index.setGdzcjzv1(rs.getLong("V24"));
					index.setGdzcjzv2(rs.getLong("S24"));
					index.setGdzcjzv3(rs.getLong("L24"));
					
					index.setCcpchv1(rs.getLong("V12"));
					index.setCcpchv2(rs.getLong("S12"));
					index.setCcpchv3(rs.getLong("L12"));
					
					index.setYszkjev1(rs.getLong("V13"));
					index.setYszkjev2(rs.getLong("S13"));
					index.setYszkjev3(rs.getLong("L13"));
					
					index.setZchjv1(rs.getLong("V14"));
					index.setZchjv2(rs.getLong("S14"));
					index.setZchjv3(rs.getLong("L14"));
					
					index.setFzhjv1(rs.getLong("V15"));
					index.setFzhjv2(rs.getLong("S15"));
					index.setFzhjv3(rs.getLong("L15"));
					
					index.setDngdzctzljv1(rs.getLong("V16"));
					index.setDngdzctzljv2(rs.getLong("S16"));
					index.setDngdzctzljv3(rs.getLong("L16"));
					
					index.setSbtzv1(rs.getLong("V17"));
					index.setSbtzv2(rs.getLong("S17"));
					index.setSbtzv3(rs.getLong("L17"));
					
				 
					index.setQbcyryrsv1(rs.getLong("V18"));
					index.setQbcyryrsv2(rs.getLong("S18"));
					index.setQbcyryrsv3(rs.getLong("L18"));
				 iService.addIndex(index);
				 
			 }
			
			
//			List<ZyArticleType> zyArticleTypes=ats.findAllArticleTypes();
//			for(ZyArticleType type:zyArticleTypes){
//				ZyPremission premission=new ZyPremission();
//				premission.setPremissionType(Constant.VIEW);
//				premission.setSectionId(type.getTypeId());
//				premission.setRemarks("查看访问");
//				premissionService.addPremission(premission);	
//				premission.setPremissionType(Constant.A_M_D);
//				premission.setRemarks("添加，修改，删除");
//				premissionService.addPremission(premission);	
//				premission.setPremissionType(Constant.MANAGE);
//				premission.setRemarks("审核");
//				premissionService.addPremission(premission);	
//				
//			}
//					添加模块权限
						
					 
			//
//			 ResultSet rs =
//			 stmt.executeQuery("select webname,webaddress,webpic,flag,Vis,CreateDate from yp_link");
//			 // 对结果集进行处理
//			 while (rs.next()) {
//				 ZyLink link=new ZyLink();
//				 link.setCreatetime(rs.getDate("CreateDate"));
//				 link.setLink(rs.getString("webaddress"));
//				 link.setLinkname(rs.getString("webname"));
//				 link.setLinktype(rs.getString("flag"));
//				 
//				 ls.addLink(link);
//				 
//			 }
			// 执行SQL语句，返回结果集
			// 文章分类
			// ResultSet rs =
			// stmt.executeQuery("select SortID,SortName,ParentId,Remarks from ass_newsort");
			// // 对结果集进行处理
			// while (rs.next()) {
			// ZyArticleType articleType=new ZyArticleType();
			// articleType.setTypeId(Integer.parseInt(rs.getString("SortId").trim()));
			// articleType.setCreateTime(new Date());
			// String remark= rs.getString("Remarks");
			// if(null!=remark&&remark.trim().startsWith("goto")){
			// articleType.setType("1");
			// }else if(null!=remark&&remark.trim().startsWith("http")){
			// articleType.setType("2");
			// articleType.setLink(remark);
			// }else{
			// articleType.setType("0");
			// }
			//			
			// articleType.setParentId(Integer.parseInt(rs.getString("ParentId").trim()));
			// articleType.setTypeName(rs.getString("SortName"));
			// articleType.setUpdateTime(new Date());
			// articleType.setVisiable("0");
			// ats.addArticleType(articleType);
			// }
			// 用户
			// ResultSet rs = stmt
			// .executeQuery("select SysID,UserName,DepartNo,PositionName,Enable,Password,Remarks,UserType,CompName,"
			// +
			// "CompAddress,PostCode,CompTel from pdm_userid");
			// // 对结果集进行处理
			// while (rs.next()) {
			// ZyUser user=new ZyUser();
			// String enable=rs.getString("Enable");
			// if(null!=enable&&enable.equals("1")){
			// user.setActive("0");
			// }else{
			// user.setActive("1");
			// }
			// String com=rs.getString("CompName");
			// if(com==null){
			// user.setCompanyId(0);
			// user.setUserType("0");
			// }else if(com.length()>1){
			// user.setCompanyId(1);
			// user.setUserType("1");
			// }
			// String partNo=rs.getString("DepartNo");
			// if(partNo!=null&&partNo.trim().length()>0)
			// user.setPid(Integer.parseInt(partNo.trim()));
			//				
			// user.setCreateTime(new Date());
			// user.setPassword(rs.getString("Password"));
			// user.setPosition(rs.getString("PositionName"));
			// user.setRemarks(rs.getString("Remarks"));
			// if(rs.getString("UserName").equals("系统超级管理员")){
			// user.setRoleId(1);
			// }else{
			// user.setRoleId(0);
			// }
			//				
			// user.setUpdateTime(new Date());
			// user.setUsername(rs.getString("UserName"));
			// user.setUserId(rs.getInt("SysID"));
			// us.addUser(user);
			// }
			// 部门
			// ResultSet rs = stmt
			// .executeQuery("select DeptID,DeptName from base_department");
			// // 对结果集进行处理
			// while (rs.next()) {
			// ZyPartment partment=new ZyPartment();
			// partment.setPartmentId(Integer.parseInt(rs.getString("DeptID")));
			// partment.setPartmentName(rs.getString("DeptName"));
			// ps.addPartment(partment);
			//				
			// }
			// 文章
//			ResultSet rs = stmt
//			.executeQuery("select distinct(Sort)from ass_news");
//			
//			while(rs.next()){
//				ZyArticleType articleType=new ZyArticleType();
//				 articleType.setCreateTime(new Date());
//				 articleType.setType("0");
//				 articleType.setParentId(-2);
//				 String typeName=rs.getString("Sort");
//				 if(typeName!=null&&typeName.trim().length()>2)
//				 articleType.setTypeName(typeName);
//				 articleType.setUpdateTime(new Date());
//				 articleType.setVisiable("0");
//				 ats.addArticleType(articleType);
//			}
//						ResultSet rs = stmt
//					.executeQuery("select Title,Sort,State,DeptID,Inside,Origin,RelateImage,Content,Creater,CreateDate,Click from ass_news");
//			
//			while (rs.next()) {
//				ZyArticleWithBLOBs article = new ZyArticleWithBLOBs();
//				article.setArticleType("0");
//				article.setClick(rs.getInt("Click"));
//				article.setComeFrom(rs.getString("Origin"));
//				String c=rs.getString("Content");
//				if(c!=null){
//					article.setContent(rs.getString("Content"));
//				}else{
//					article.setContent(" ");
//				}
//				
//				article.setCreateTime(rs.getDate("CreateDate"));
//				article.setUpdateTime(rs.getDate("CreateDate"));
//				String imageFlag = rs.getString("RelateImage");
//				if (null != imageFlag && imageFlag.trim().length() > 0) {
//					article.setImgFlag("0");
//					article.setImgUrl(imageFlag);
//				} else {
//					article.setImgFlag("1");
//				}
//				String inner = rs.getString("Inside");
//				if (null == inner || inner.trim().equals("0")) {
//					article.setInnerFlag("1");
//				} else {
//					article.setInnerFlag("0");
//				}
//				String dept=rs.getString("DeptID");
//				if(dept!=null&&dept.trim().length()>0)
//				article.setPartmentId(Integer.parseInt(dept
//						.trim()));
//				
//				String status = rs.getString("State");
//				if (status != null && status.equals("1")) {
//					article.setStatus("0");
//				} else {
//					article.setStatus("1");
//				}
//				
//				article.setTitle(rs.getString("Title"));
//				String sort=rs.getString("Sort");
//				if(sort!=null&&sort.trim().length()>0){
//					ZyArticleType type=ats.findArticleTypeByTypeName(sort);
//				if(type!=null){
//					article
//					.setTypeId(type.getTypeId());
//				}else{
//					article
//					.setTypeId(Integer
//							.parseInt(rs.getString("Sort").trim()));
//				}
//				}
//				String userName = rs.getString("Creater");
//				if (null != userName) {
//					ZyUser tempUser=us.findUserByName(userName);
//					if(tempUser!=null)
//					article.setUserId(tempUser.getUserId());
//					
//				} else {
//					article.setUserId(0);
//				}
//				
//				as.addArticle(article);
//				// }
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 释放资源
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * Constructor of the object.
	 */
	public SQLServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

}
