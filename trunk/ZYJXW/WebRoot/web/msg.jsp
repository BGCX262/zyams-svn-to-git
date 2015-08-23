<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
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
							<input type="hidden" value="" name="typeId3" id="typeId3" />
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
			</div>
			<div id="mainRight">
				<div id="mainRightTop">
					您所在当前的位置：
					<a href="index.action">首页</a>> 咨询投诉
				</div>
				<div id="mainContent">
					<div id="content">
						<span style="font-size:14px;font-weight:bold;color:red;"><s:fielderror fieldName="kap"></s:fielderror>
						${msg1}</span>
						<form style="margin: 0px;font-size:12px;" name="form"
							method="post" action="addMsg.action" onsubmit="return check();">
							<table cellspacing="1" cellpadding="0" bgcolor="#cccccc"
								width="100%">
								<tbody>
								<c:if test="${not empty flag}">
									<td height="25" bgcolor="#f1f1f1" align="right">
											写给：
										</td><td gcolor="#ffffff" align="left" style="padding: 1px;"><select name="msg.userId">
									<option value="0">请选择</option>
									<c:forEach items="${users}" var="user">
										<option value="${user.userId }">${user.username }</option>
										</c:forEach>					
									</select>
										<input type="hidden" name="flag" value="flag"/>
									</td>
								</c:if>
								<c:if test="${empty flag}">
									<input type="hidden" name="msg.userId" value="0"/>
								</c:if>
									<tr>
										<td height="25" bgcolor="#f1f1f1" align="right">
											姓名：
										</td>
										<td bgcolor="#ffffff" align="left" style="padding: 1px;">
											<input type="text" maxlength="20" class="input_text_name"
												size="20" name="msg.username" id="username" />
											<span style="color: rgb(255, 0, 0);">*</span>
										</td>
									</tr>
									<tr>
										<td height="25" bgcolor="#f1f1f1" align="right">
											性别：
										</td>
										<td bgcolor="#ffffff" align="left" style="padding: 1px;">
											<input type="radio" name="msg.gender" value="0" checked=""
												style="border: 0px none;" />
											男
											<input type="radio" name="msg.gender" value="1"
												style="border: 0px none;" />
											女
										</td>
									</tr>
									<tr>
										<td height="25" bgcolor="#f1f1f1" align="right">
											电话：
										</td>
										<td bgcolor="#ffffff" align="left" style="padding: 1px;">
											<input type="text" maxlength="50" size="40"
												class="input_text_title" name="msg.mobile" id="mobile" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
											<span style="color: rgb(255, 0, 0);">*</span>(保密)
										</td>
									</tr>
									<tr>
										<td height="25" bgcolor="#f1f1f1" align="right">
											邮箱：
										</td>
										<td bgcolor="#ffffff" align="left" style="padding: 1px;">
											<input type="text" maxlength="50" class="input_text_title"
												size="40" name="msg.email" />
											没有可不填
										</td>
									</tr>
									<tr>
										<td bgcolor="#f1f1f1" align="right" width="87">
											内容：
										</td>
										<td bgcolor="#ffffff" align="left" width="634"
											style="padding: 1px;">
											<textarea style="width: 80%;" class="textfield" rows="10"
												cols="88" name="msg.content" id="msgcontent"></textarea>
										</td>
									</tr>


									<tr>
										<td bgcolor="#f1f1f1" align="right" width="87">
											验证码：
										</td>
										<td bgcolor="#ffffff" align="left" style="padding: 1px;">
											<input type="text" class="codeText" id="code" name="rand" />
											<span class="codeImg"><img id="codeImg"
													src="../admin/image.jsp" onclick="javascript:changeKaptcha();" />
											</span>
										</td>
									</tr>
									<tr>
										<td bgcolor="#f1f1f1" align="center" style="padding: 1px;"
											colspan="2">
											<input type="submit" value="提交" class="button" />
											<input type="reset" value="重写" class="button" name="button" />
										</td>
									</tr>
								</tbody>
							</table>
						</form>
						<script type="text/javascript">
							function check(){
								var name=jq("#username").val();
								var mobile=jq("#mobile").val();
								var content=jq("#msgcontent").val();
								var code=jq("#code").val();
								
								if(!name||name.trim().length==0){
									alert("请输入姓名！");
									return false;
								}1
								if(!mobile||mobile.trim().length==0){
									alert("请输入电话！");
									return false;
								}
								if(!content||content.trim().length==0){
									alert("请输入内容！");
									return false;
								}
								if(!code||code.trim().length==0){
									alert("请输入验证码！");
									return false;
								}
							}
						</script>
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
