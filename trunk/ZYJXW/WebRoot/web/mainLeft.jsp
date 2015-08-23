<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
		<!--sideMenu start-->
				<div id="side">
					<div id="sideTop">
						企业登录
					</div>
					<ul id="list8">
						<li>
							<span class="zyTableName">用户名：${loginCorp.id}</span>
						</li>
						<li>
							<span class="zyTableName">${loginCorp.name}</span>
						</li>
						<li>
							<input type="button" value="数据上传" class="zyBtn zyBtn2" />
						</li>
						<li>
							<input type="button" value="信息维护" class="zyBtn zyBtn2" onclick="javascript:window.location.href='editCorpPage.action'"/>
						</li>
						<li>
							<input type="button" value="退出登录" class="zyBtn zyBtn2" />
						</li>
					</ul>
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
							<input type="hidden" value="" name="children" id="children3" />
							<input type="hidden" value="" name="pagnation" id="pagnation3" />
							<input type="hidden" value="" name="typeId" id="typeId3" />
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
							<a href="javascript:;">更多>></a>
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
								<a id="navC" target="_blank" hidefocus="true"
									href="login.jsp"></a>
							</li>
							<li>
								<a id="navD" target="_blank" hidefocus="true"
									href="http://xczb.mas.gov.cn/"></a>
							</li>
						</ul>
					</div>
					<!--网上直报 over-->
				</div>