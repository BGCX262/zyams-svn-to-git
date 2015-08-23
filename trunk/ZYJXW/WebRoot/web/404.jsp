<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<base target="_blank">
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
					<form id="pageForm2" name="pageForm2" method="post"
						action="listArticleForTypeId.action" target="_self">
						<input type="hidden" value="" name="typeId" id="typeId2"/>
						<input type="hidden" value="" name="children" id="children2"/>
						<input type="hidden" value="" name="pagnation" id="pagnation2"/>
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
						<div id="box2LeftTitle">
							
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
			</div>
  <div id="mainRight">
    <div id="mainRightTop">您所在当前的位置：<a href="#">首页</a>><span>错误提示页面</span></div>
    <div id="mainContent">
      <div id="content">
      
      
      
      
<!--404----------------------------------------------------------------------------404-->
        <div style="height:50px;"></div>
        <div style="background:#ececec; padding:15px; border:1px solid #ccc;">
          <div style="background:url(img/error.gif) no-repeat 0 50%;padding-left: 80px; font-size:24px; line-height:28px; height:61px; font-family:Georgia;">Error 404, 
            <span style="font-size:14px;">We can't seem to find that page!</span>
            <span style="display:block; font-size:14px;">无法找到该网页！请返回上一页或与管理员联系</span>
          </div>
        </div>
        <div style="height:50px;"></div>     <!--404----------------------------------------------------------------------------404-->
        
        
        
        
      </div>
    </div>
    <div id="mainRightBottom"></div>
  </div>
  <div class="clear"></div>
</div>
<!--main over-->
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
new slider({id:'slider'})
</script>
</body>
</html>
