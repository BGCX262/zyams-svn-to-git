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
				document.getElementById("qh_con"+id).style.display="block";
				document.getElementById("mynav"+id).className="nav_on";
			}
			else
			{
				document.getElementById("qh_con"+id).style.display="none";
				document.getElementById("mynav"+id).className="";
			}
		}
	}
</script>
</head>
<body onload="new Accordian('basic-accordian',10,'header_highlight'); new Accordian('basic-accordian2',10,'header_highlight2'); new Accordian('basic-accordian3',10,'header_highlight3'); ">
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
						<c:if test="${null!=articleTypes}">
							<c:forEach items="${articleTypes}" var="type">
								<c:choose>
									<c:when test="${type.type=='0'}">
										<li>
										
										<c:choose>
											<c:when test="${type.typeId==articleType.typeId}">
											<a style="color:#d40007;" href="javascript:;"
												onclick="query2('yes','yes',${type.typeId})"
												hidefocus="true">${type.typeName }</a>
												</c:when>
												<c:otherwise>
												<a href="javascript:;"
												onclick="query2('yes','yes',${type.typeId})"
												hidefocus="true">${type.typeName }</a>
												</c:otherwise>
												</c:choose>
										</li>
									</c:when>
									<c:when test="${type.type=='1'}">
										<li>
										<c:choose>
											<c:when test="${type.typeId==articleType.typeId}">
											<a href="showSinglePageForWeb.action?typeId=${type.typeId}"
												hidefocus="true" style="color:#d40007;">${type.typeName }</a>
												</c:when>
												<c:otherwise>
												<a href="showSinglePageForWeb.action?typeId=${type.typeId}"
												hidefocus="true">${type.typeName }</a>
												</c:otherwise>
												</c:choose>
										</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="javascript:;" hidefocus="true"></a>${type.typeName }
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:if>
					</ul>
					<form id="pageForm" name="pageForm2" method="post"
						action="listArticleForTypeId.action" target="_self">
						<input type="hidden" value="" name="typeId" id="typeId2"/>
						<input type="hidden" name="children" id="children2"/>
						<input type="hidden" name="pagnation" id="pagnation2"/>
					</form>
					<script type="text/javascript">
function query2(pag,child,typeId) {
		document.getElementById("typeId2").value=typeId;
				document.getElementById("children2").value=child;
						document.getElementById("pagnation2").value=pag;
		document.pageForm2.submit();
		return false;
}
</script>

					<div id="sideBottom"></div>
				</div>
				<!--sideMenu over-->
				<div id="box2Left">
					<!--网上办事 start-->
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
													target="_blank">
													${article.title }
													</a>
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
        <div id="box2LeftTitle"><a href="javascript:;">更多>></a></div>
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
  </div>
  <div id="mainRight">
    <div id="mainRightTop">您所在当前的位置：<a href="index.jsp">首页</a>>
    <c:forEach items="${parentTypes}" var="type">
   <a href="javascript:;" onclick="query4('yes','yes',${type.typeId});">${type.typeName}</a> >
    </c:forEach>    <span>正文</span></div>
    <form id="pageForm4" name="pageForm4" method="post"
							action="listArticleForTypeId.action" target="_self">
						<input type="hidden" value="" name="children" id="children4"/>
						<input type="hidden" value="" name="pagnation" id="pagnation4"/>
							<input type="hidden" value="" name="typeId" id="typeId4"/>
						</form>
						<script type="text/javascript">
function query4(pag,child,typeId) {
	document.getElementById("typeId4").value=typeId;
				document.getElementById("children4").value=child;
						document.getElementById("pagnation4").value=pag;
		document.pageForm4.submit();
		return false;
}
</script>

    <div id="mainContent">
      <div id="content">
         <h4>${article.title }</h4>
         <span class="span">内容分类：   
         <c:if test="${null!=articleType}">
       	  ${articleType.typeName}
         </c:if>
         </span>
      
        
        <span class="span">及职成文日期：<fmt:formatDate var="startDate" value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        ${startDate }</span> 
          
           ${article.content }
           
       
        <div class="clear"></div>
      </div>
</div>
    <div id="mainRightBottom" />
  </div>
  <div class="clear"></div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
new slider({id:'slider'})
</script>
</body>
</html>
