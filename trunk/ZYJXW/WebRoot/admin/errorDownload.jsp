<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/info/";
%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>操作失败</title>
<style>
a,a:link{ color:#2A7FFF; text-decoration:underline;}
</style>
</head><body>
<div class="tip-page">
<div class="tip-bgA"></div>
<div class="tip-bgB"></div>
	<div class="tip-bgC">
	<div class="tip-top"></div>
	<table class="tip-table" cellpadding="0" cellspacing="0">
		<tbody><tr><td height="120">
<div class="lh2" style="padding: 0pt 20px 50px 40px;line-height:200%;font-size: 12px;">
<span style="color:red">对不起,您的操作未成功! </span><br />
<span style="color:red">${errorMsg}</span>

				</div>
			</td>
		</tr>
	</tbody></table>
	</div>
</div>
</body></html>