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
	DD_belatedPNG.fix('img, #searchBox, #menu ul li a, #box1, #box2Left, #box2Middle, #box2Right, #box3Right, #sideBottom, ul#list8 li, #sideTop, #mainRightTop, #mainRightBottom, #mainContent, ');
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
</script>
	</head>
	<body
		onload="new Accordian('basic-accordian',10,'header_highlight'); new Accordian('basic-accordian2',10,'header_highlight2'); new Accordian('basic-accordian3',10,'header_highlight3'); ">
		<jsp:include page="top.jsp"></jsp:include>
		<!--main start-->
		<div id="main">
			<div id="mainLeft">
				<!--sideMenu start-->
				<div id="side">
					<div id="sideTop">
						网站导航
					</div>
					<ul id="list8">
				<c:forEach items="${allPartments}" var="part1">
						<li>
						<c:choose>
						<c:when test="${part.partmentId==part1.partmentId}">
							<a style="color:#d40007;" href="showPartmentArticles.action?pid=${part1.partmentId}"
								hidefocus="true">${part1.partmentName }</a>
						</c:when>
						<c:otherwise>
						<a href="showPartmentArticles.action?pid=${part1.partmentId}"
								hidefocus="true">${part1.partmentName }</a>
						</c:otherwise>
						</c:choose>
						</li>
						</c:forEach>
					</ul>
					<div id="sideBottom"></div>
				</div>
				<!--sideMenu over-->
				
				<div id="box2Left">
					<!--网上办事 start-->
					<div id="box2LeftTop">
						<div id="box2LeftTitle">
							<a href="javascript:;" onclick="query3('yes','yes');">更多>></a>
						</div>
						<form id="pageForm3" name="pageForm3" method="post"
							action="listArticleForTypeId.action" target="_self">
							<input type="hidden" value="" name="children" id="children3" />
							<input type="hidden" value="" name="pagnation" id="pagnation3" />
							<input type="hidden" value="" name="typeId" id="typeId3" />
						</form>
						<script type="text/javascript">
function query3(pag,child) {
	document.getElementById("typeId3").value=1301;
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
													target="_blank"> ${article.title } </a>
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
													target="_blank">${article.title }</a>
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

						</div>
						<ul id="nav">
							<li>
								<a id="navA" target="_blank" hidefocus="true"
									href="http://218.22.10.238:8080/user/login.jsp"></a>
							</li>
							<li>
								<a id="navB" target="_blank" hidefocus="true"
									href="http://www.ahjgtz.gov.cn/sjw/admin/index.jsp"></a>
							</li>
							<li>
								<a id="navC" target="_blank" hidefocus="true" href="login.jsp"></a>
							</li>
							<li>
								<a id="navD" target="_blank" hidefocus="true"
									href="http://xczb.mas.gov.cn/"></a>
							</li>
						</ul>
					</div>
					<!--网上直报 over-->
				</div>
			</div>
			<div id="mainRight">
				<div id="mainRightTop">
					您所在当前的位置：
					<a href="index.action">首页</a>><a href="javascript:;">内设机构</a> > ${part.partmentName }
				</div>
						<div id="mainContent">
					<div id="content">
				<img src="img/title.gif" style="margin-top: 20px;" />
						<ul id="list9">
							<li>
								<a href="showArticle.action?aid=${firstArticle.articleId }"
										target="_blank">${firstArticle.title }</a><span> <fmt:formatDate
											var="startDate" value="${firstArticle.createTime}"
											pattern="yyyy-MM-dd" /> ${startDate }</span>
								</li>
							<c:forEach items="${pager.pageRecords}" var="article">
								<li>
									<a href="showArticle.action?aid=${article.articleId }"
										target="_blank">${article.title }</a><span> <fmt:formatDate
											var="startDate" value="${article.createTime}"
											pattern="yyyy-MM-dd" /> ${startDate }</span>
								</li>
							</c:forEach>
							<div class="clear"></div>
						</ul>
						<div class="clear"></div>
						<div class="black">
							<c:if test="${null != pager}">
								<jsp:include page="pager.jsp">
									<jsp:param name="pageNum" value="${pager.currentPage}" />
									<jsp:param name="pageCount" value="${pager.pageCount}" />
									<jsp:param name="child" value="${child}" />
									<jsp:param name="pag" value="${pag}" />
									<jsp:param name="targetUrl"
										value="showPartmentArticles.action?pid=${part.partmentId}" />
								</jsp:include>
							</c:if>
						</div>

						<div class="clear"></div>
					</div>
				</div>
				<div id="mainRightBottom"></div>
			</div>
			<div class="clear"></div>
		</div>
		<!--main over-->
		<jsp:include page="footer.jsp"></jsp:include>
		<script type="text/javascript">
new slider({id:'slider'});
</script>
	</body>
</html>
