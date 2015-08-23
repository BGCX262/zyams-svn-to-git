<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>马鞍山市经济和信息化委员会</title>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		<!--[if IE 6]>
	<script type="text/javascript" src="js/DD_belatedPNG.js" ></script>
	<script type="text/javascript">
	DD_belatedPNG.fix('img, #searchBox, #menu ul li a, #box1, #box2Left, #box2Middle, #box2Right, #box3Right ');
	</script>
<![endif]-->
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/Scroll.js"></script>
		<script type="text/javascript" src="js/Focus.js"></script>
		<script type="text/javascript" src="js/accordian.pack.js"></script>
		
		<script language="javascript">
		var jq = jQuery.noConflict();
function qiehuan(num){

		for(var id = 0;id<=9;id++)
		{
			if(id==num)
			{
				if(document.getElementById("qh_con"+id)){
					document.getElementById("qh_con"+id).style.display="block";
				}
				if(document.getElementById("mynav"+id)){
					document.getElementById("mynav"+id).className="nav_on";
				}
				
			}
			else
			{
				if(document.getElementById("qh_con"+id)){
					document.getElementById("qh_con"+id).style.display="none";
				}
				if(document.getElementById("mynav"+id)){
				document.getElementById("mynav"+id).className="";
				}
			}
		}
	}
jq(document).ready(function(){	
	jq("#box3RightImg a").scrollable({easing: 'custom', speed: 1500, circular: true}).autoscroll({ autoplay: true });
	
});
</script>
	</head>
	<body onload="new Accordian('basic-accordian',10,'header_highlight'); new Accordian('basic-accordian2',10,'header_highlight2'); new Accordian('basic-accordian3',10,'header_highlight3'); ">
		<jsp:include page="top.jsp"></jsp:include>		
		<!--header over-->
		<!--main start-->
		<div id="main">
			<!--box1 start-->
			<div id="box1">
				<!--left-->
				<div id="box1Left">
					<!--login-->
					 <form method="post" action="http://mail.mas.gov.cn/remote.php" name="frmmail" target="_blank">
					 <script language="javascript" type="text/javascript">
					 
					function submitmail(){
	
	var LoginName=document.getElementById("LoginName");

	var Password=document.getElementById("Password");

	if(LoginName.value.length==0){

		alert("请输入用户名！");

		LoginName.focus();

		return false;

	}

	if(Password.value.length==0){

		alert("请输入密码！");

		Password.focus();

		return false;

	}

	frmmail.action="http://mail.mas.gov.cn/remote.php";

	frmmail.submit();

	LoginName.value="";

	Password.value="";			

}
</script>
					
					<div class="login">
						<dl>
							<dt>
								用户名：
							</dt>
							<dd>
								<input type="text" class="input" id="LoginName" name="LoginName"/>
								<input type="hidden" name="domain" id="domain" value="mas.gov.cn" />
							</dd>
						</dl>
						<div class="clear"></div>
						<dl>
							<dt>
								密 &nbsp;码：
							</dt>
							<dd>
								<input type="password" class="input" id="Password" name="Password"/>
							</dd>
						</dl>
						<input type="button" class="loginBtn" value="" onclick="javascript:submitmail();"/>
						<div class="clear"></div>
					</div>
					</form>
					<!--slider-->
					<div id="box1LeftList">
						<ul id="slider" class="slider">
							<c:forEach items="${articleList3}" var="article">
								<li>
									<a href="showArticle.action?aid=${article.articleId }"> <c:choose>
											<c:when test="${fn:length(article.title)>13}">
													${fn:substring(article.title,0,13) }...
													</c:when>
											<c:otherwise>
													${article.title }
													</c:otherwise>
										</c:choose> </a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<!--middle-->
				<div id="box1Middle">
					<!--Focus start-->
					<div id="focus">
						<div class="sub_box">
							<div class="sub_no" id="bd1lfsj">
								<ul>
									<li class="show">
										1
									</li>
									<li class="">
										2
									</li>
									<li class="">
										3
									</li>
									<li class="">
										4
									</li>
									<li class="">
										5
									</li>
								</ul>
							</div>
							<div id="bd1lfimg">
								<div>
									<dl class="show">
									</dl>
									<c:forEach items="${imageArticles}" var="article">
										<dl>
											<dt>
												<c:set var="end" value="${fn:length(article.imgUrl)}" />
												<a href="javascript:void(0)"><img
														src="${article.imgUrl}" /> </a>
											</dt>
											<dd>
												<h2>
													<a href="showArticle.action?aid=${article.articleId }">${article.title
														}</a>
												</h2>
											</dd>
										</dl>
									</c:forEach>
								</div>
							</div>
						</div>
						<script type="text/javascript">movec();</script>
					</div>
					<!--Focus over-->
				</div>
				<!--middle-->
				<div id="box1Right">
					<div>
						<div class="mainNewsTitle">
							<a href="showArticle.action?aid=${blobArticles[0].articleId }">${fn:substring(blobArticles[0].title,0,50)
								}</a>
						</div>
						<div class="mainNewsText">
							<p>
								${fn:substring(blobArticles[0].content,0,200) }
							</p>
						</div>
					</div>
					<div style="margin-top:5px;">
						<div class="mainNewsTitle">
							<a href="showArticle.action?aid=${blobArticles[1].articleId }">${fn:substring(blobArticles[1].title,0,50)
								}</a>
						</div>
						<div class="mainNewsText">
							<p>
								${fn:substring(blobArticles[1].content,0,200) }
							</p>
						</div>
					</div>
					<ul id="list1">
						<c:forEach items="${noBlobArticles}" var="article">
							<li>
								<a href="showArticle.action?aid=${article.articleId }">${fn:substring(article.title,0,50)
									}</a><span>[ <fmt:formatDate var="startDate"
										value="${article.createTime}" pattern="yyyy-MM-dd" />
									${startDate }]</span>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--box1 over-->
			<div class="clear"></div>
			<!--box2 start-->
			<div id="box2">
				<div id="box2Left">
					<div id="box2LeftTop">
					<div id="box2LeftTitle">
							<a href="javascript:;" onclick="query3('yes','yes')">更多>></a>
						</div>
						<form id="pageForm3" name="pageForm3" method="post"
							action="listArticleForTypeId.action" target="_self">
						<input type="hidden" value="" name="children" id="children3"/>
						<input type="hidden" value="" name="pagnation" id="pagnation3"/>
							<input type="hidden" value="" name="typeId" id="typeId3"/>
						</form>
						<script type="text/javascript">
function query3(pag,child) {
	document.getElementById("typeId3").value=13;
				document.getElementById("children3").value=child;
						document.getElementById("pagnation3").value=pag;
		document.pageForm3.submit();
		return false;
}
</script>
						<div id="basic-accordian">
							<div class="tab_container">
								<div id="test1-header"
									class="accordion_headings header_highlight">
									办事指南
								</div>
								<div id="test2-header" class="accordion_headings">
									下载中心
								</div>
							</div>
							<div style="float: left;">
								<!--list1 start-->
								<div id="test1-content" style="height: 200px;">
									<ul id="list2">
										<c:forEach items="${articleList1}" var="article">
											<li>
												<a href="showArticle.action?aid=${article.articleId }"
													target="_blank"> <c:choose>
														<c:when test="${fn:length(article.title)>15}">
													${fn:substring(article.title,0,15) }...
													</c:when>
														<c:otherwise>
													${article.title }
													</c:otherwise>
													</c:choose> </a>
											</li>
										</c:forEach>
									</ul>
								</div>
								<!--list1 over-->
								<!--list2 start-->
								<div id="test2-content" style="height: 200px;">
									<ul id="list2">
										<c:forEach items="${articleList2}" var="article">
											<li>
												<a href="showArticle.action?aid=${article.articleId }"
													target="_blank"><c:choose>
														<c:when test="${fn:length(article.title)>15}">
													${fn:substring(article.title,0,15) }...
													</c:when>
														<c:otherwise>
													${article.title }
													</c:otherwise>
													</c:choose> </a>
											</li>
										</c:forEach>
									</ul>
								</div>
								<!--list2 ovar-->
							</div>
						</div>
					</div>
					<!--网上办事 over-->
					<!--网上直报 start-->
					<div id="box2Bottom">
						<div id="box2LeftTitle">
							<!-- <a href="javascript:;">更多>></a> -->
						</div>
						<ul id="nav">
							<li>
								<a id="navA" target="_blank" hidefocus="true" href="http://218.22.10.238:8080/user/login.jsp"></a>
							</li>
							<li>
								<a id="navB" target="_blank" hidefocus="true" href="http://www.ahjgtz.gov.cn/sjw/admin/index.jsp"></a>
							</li>
							<li>
								<a id="navC" target="_blank" hidefocus="true" href="login.jsp"></a>
							</li>
							<li>
								<a id="navD" target="_blank" hidefocus="true" href="http://xczb.mas.gov.cn/"></a>
							</li>
						</ul>
					</div>
					<!--网上直报 over-->
				</div>
				<div id="box2Middle">
					<div id="box2MiddleBox1">
						<ul>
							<li>
								<a target="_blank" href="http://jxw.mas.gov.cn/bmsite/loadInfoSub.action?applyKey=companion&itemId=1022&orgCode=EA003">信息公开指南</a>
							</li>
							<li>
								<a target="_blank" href="http://jxw.mas.gov.cn/bmsite/childIndex.action?orgCode=EA003">信息公开目录</a>
							</li>
							<li>
								<a target="_blank" href="http://zwgk.mas.gov.cn/zwgk/listRequestInfo.action">依申请公开</a>
							</li>
							<li>
								<a target="_blank" href="http://jxw.mas.gov.cn/bmsite/listInfoSub.action?itemId=896&orgCode=EA003">政府信息公开年报</a>
							</li>
							<li>
								<a target="_blank" href="http://jxw.mas.gov.cn/bmsite/listSub.action?affairSort=588&orgCode=EA003&parentAffair=588">政府信息公开制度</a>
							</li>
						</ul>
					</div>
					<!--tab start-->
					<div id="box2MiddleBox2" style="height:215px;">
						<div id="basic-accordian2">
							<div style="width:125px; float:left">
								<div id="test3-header"
									class="accordion_headings2 header_highlight2">
									经济运行
								</div>
								<div id="test4-header" class="accordion_headings2">
									两岸融合
								</div>
								<div id="test5-header" class="accordion_headings2">
									技术进步
								</div>
								<div id="test6-header" class="accordion_headings2">
									中小企业
								</div>
								<div id="test7-header" class="accordion_headings2">
									节能降耗
								</div>
								<div id="test8-header" class="accordion_headings2">
									党群工作
								</div>
							</div>
							<div style="float:right; width:390px;">
								<div id="test3-content">
									<div class="accordion_child2">
										<ul id="list3">
											<c:forEach items="${articleList5}" var="article">
												<li>
													<a href="showArticle.action?aid=${article.articleId }">
														<c:if test="${fn:length(article.title)>25}">
													${fn:substring(article.title,0,25)}
													</c:if> <c:if test="${fn:length(article.title)<=25}">
													${article.title}
													</c:if> </a><span>[ <fmt:formatDate var="startDate"
															value="${article.createTime}" pattern="yyyy-MM-dd" />
														${startDate }]</span>
												</li>
											</c:forEach>

										</ul>
									</div>
								</div>
								<div id="test4-content">
									<div class="accordion_child2">
										<ul id="list3">
											<c:forEach items="${articleList6}" var="article">
												<li>
													<a href="showArticle.action?aid=${article.articleId }">
														<c:if test="${fn:length(article.title)>25}">
													${fn:substring(article.title,0,25)}
													</c:if> <c:if test="${fn:length(article.title)<=25}">
													${article.title}
													</c:if> </a><span>[ <fmt:formatDate var="startDate"
															value="${article.createTime}" pattern="yyyy-MM-dd" />
														${startDate }]</span>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
								<div id="test5-content">
									<div class="accordion_child2">
										<ul id="list3">
											<c:forEach items="${articleList7}" var="article">
												<li>
													<a href="showArticle.action?aid=${article.articleId }">
														<c:if test="${fn:length(article.title)>25}">
													${fn:substring(article.title,0,25)}
													</c:if> <c:if test="${fn:length(article.title)<=25}">
													${article.title}
													</c:if> </a><span>[ <fmt:formatDate var="startDate"
															value="${article.createTime}" pattern="yyyy-MM-dd" />
														${startDate }]</span>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
								<div id="test6-content">
									<div class="accordion_child2">
										<ul id="list3">
											<c:forEach items="${articleList8}" var="article">
												<li>
													<a href="showArticle.action?aid=${article.articleId }">
														<c:if test="${fn:length(article.title)>25}">
													${fn:substring(article.title,0,25)}
													</c:if> <c:if test="${fn:length(article.title)<=25}">
													${article.title}
													</c:if> </a><span>[ <fmt:formatDate var="startDate"
															value="${article.createTime}" pattern="yyyy-MM-dd" />
														${startDate }]</span>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
								<div id="test7-content">
									<div class="accordion_child2">
										<ul id="list3">
											<c:forEach items="${articleList9}" var="article">
												<li>
													<a href="showArticle.action?aid=${article.articleId }">
														<c:if test="${fn:length(article.title)>25}">
													${fn:substring(article.title,0,25)}
													</c:if> <c:if test="${fn:length(article.title)<=25}">
													${article.title}
													</c:if> </a><span>[ <fmt:formatDate var="startDate"
															value="${article.createTime}" pattern="yyyy-MM-dd" />
														${startDate }]</span>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
								<div id="test8-content">
									<div class="accordion_child2">
										<ul id="list3">
											<c:forEach items="${articleList10}" var="article">
												<li>
													<a href="showArticle.action?aid=${article.articleId }">${fn:substring(article.title,0,25)
														}</a><span>[ <fmt:formatDate var="startDate"
															value="${article.createTime}" pattern="yyyy-MM-dd" />
														${startDate }]</span>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--tab over-->
					<div class="clear"></div>
					<!--机构 start-->
					<div id="box2MiddleBox2">
						<div id="basic-accordian3">
							<div class="tab_container3">
								<div id="test9-header"
									class="accordion_headings3 header_highlight3">
									内设机构
								</div>
								<div id="test10-header" class="accordion_headings3">
									下属单位
								</div>
							</div>
							<div
								style="float:left; border-top:1px solid #d40007; width:337px;">
								<!--list1 start-->
								<div id="test9-content" style="height:170px;">
									<ul id="Btn">									
										<li><a href="showPartmentArticles.action?pid=9&flag=2">办公室</a></li>
										<li><a href="showPartmentArticles.action?pid=10&flag=2">经济运行科</a></li>
										<li><a href="showPartmentArticles.action?pid=13&flag=2">综合信息科</a></li>
										<li><a href="showPartmentArticles.action?pid=12&flag=2">中小企业局</a></li>
										<li><a href="showPartmentArticles.action?pid=14&flag=2">法规培训科</a></li>
										<li><a href="showPartmentArticles.action?pid=15&flag=2">产业规划科</a></li>
										<li><a href="showPartmentArticles.action?pid=16&flag=2">技改科技科</a></li>
										<li><a href="showPartmentArticles.action?pid=11&flag=2">资源电力科</a></li>
										<li><a href="showPartmentArticles.action?pid=17&flag=2">企业改革与发展科</a></li>
										<li><a href="showPartmentArticles.action?pid=18&flag=2">经济协作科</a></li>										
										<li><a href="showPartmentArticles.action?pid=19&flag=2">生产运输协调科</a></li>
										<li><a href="showPartmentArticles.action?pid=25&flag=2">信息产业发展科</a></li>
										<li><a href="showPartmentArticles.action?pid=22&flag=2">离退休工作办</a></li>
										<li><a href="showPartmentArticles.action?pid=21&flag=2">机关党委</a></li>
									</ul>
								</div>
								<!--list1 over-->
								<!--list2 start-->
								<div id="test10-content" style="height:170px;">
									<ul id="Btn">
											<li><a href="showPartmentArticles.action?pid=21&flag=2">信息化管理办公室</a></li>
											<li><a href="showPartmentArticles.action?pid=23&flag=2">市墙体改革办</a></li>
										
									</ul>
								</div>
								<!--list2 ovar-->
							</div>
						</div>
					</div>
					<!--机构 over-->
					<!--排名 start-->
					<div id="paiming">
						<div id="paimingTitle">
							<img src="img/paiming.gif" />
						</div>
						<ul id="list4">
							<c:forEach items="${articleList11}" var="article" varStatus="s">
								<li>
									<img src="img/${s.index +1}.png" />
									<a href="showArticle.action?aid=${article.articleId }"> <c:if
											test="${fn:length(article.title)>10}">
													${fn:substring(article.title,0,10)}
													</c:if> <c:if test="${fn:length(article.title)<=10}">
													${article.title}
													</c:if> </a>
								</li>
							</c:forEach>
							<li>
						</ul>
					</div>
					<!--排名 over-->
				</div>
				<!--box2Right start-->
				<div id="box2Right">
					<div style="height:240px;">
						<div id="box2LeftTitle">
							<a href="javascript:query('yes','yes',19);">更多>></a>
						</div>
						<ul id="nav2">
							<li style="margin-right:5px;">
								<a id="nav2A" hidefocus="true" href="javascript:query('yes','yes',1901);"></a>
							</li>
							<li>
								<a id="nav2B" hidefocus="true" href="javascript:query('yes','yes',1902)"></a>
							</li>
							<li style="margin-right:5px;">
								<a id="nav2C" hidefocus="true" href="javascript:query('yes','yes',1903);"></a>
							</li>
							<li>
								<a id="nav2D" hidefocus="true" href="javascript:query('yes','yes',1904);"></a>
							</li>
						</ul>
						<div id="box2RightImg">
							<a href="javascript:query('yes','yes',16);"><img src="img/img.png" /> </a>
							<a href="javascript:void(0)"><img src="img/img.gif" /> </a>
						</div>
					</div>
					<div style="height:248px;">
						<div id="box2LeftTitle">
							<!--<a href="javascript:1;">更多>></a>  -->
						</div>
						<ul id="nav3">
							<li>
								<a hidefocus="true" href="msg.action?flag=true"><img
										src="img/btn3_01.gif" /> </a>
							</li>
							<li>
								<a hidefocus="true" href="msg.action"><img
										src="img/btn3_03.gif" /> </a>
							</li>
							<li>
								<a hidefocus="true" href="javascript:void(0)"><img
										src="img/btn3_04.gif" /> </a>
							</li>
							<li>
								<a hidefocus="true" href="showArticle.action?aid=2932"><img
										src="img/btn3_05.gif" /> </a>
							</li>
						</ul>
					</div>
				</div>
				<!--box2Right over-->
				<div class="clear"></div>
			</div>
			<!--box2 over-->
			<!--box3 start-->
			<div id="box3">
				<div id="box3Right">
					<div id="box3RightImg">
					<marquee>
					<c:forEach items="${links}" var="link">
						<a href="${link.link }" style="border:0px;"><img  style="border:0px;" src="../imageservlet/${link.linkId}.jpg" width="133" height="39"/></a>
					</c:forEach>	
					</marquee>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<!--box3 over-->
		</div>
		<!--main over-->
		<jsp:include page="footer.jsp"></jsp:include>
		<script type="text/javascript">
new slider({id:'slider'})
</script>
	</body>
</html>



