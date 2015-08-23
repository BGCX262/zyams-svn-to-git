<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理系统</title>
<style type="text/css">
input {
	border:0;
}
body {
	background: #000 url(img/bg1.gif);
	color:#666;
}
#box {
	background:url(img/login2.png) no-repeat;
	width:680px;
	height:520px;
	margin:60px auto 0;
}
#box2 { width:230px; float:right; margin-top:150px; margin-right:75px; display:inline;}
#name {
	margin-top:75px;
	margin-left:70px;
	float:left;
}
.input {
	background:url(img/input2.png) no-repeat;
	width:207px;
	height:37px;
	float:left;
	display:inline;
	line-height:37px;
	padding:0 10px;
	font-size:20px;
	font-weight:bold;
	color:#666;
}
.user {
	margin-top:65px;
}
.pass {
	margin-top:52px;
}
#codeBox {
	float:left;
}
.codeText {
	background:url(img/code1.gif) no-repeat;
	width:91px;
	height:31px;
	float:left;
	display:inline;
	line-height:31px;
	padding:0 10px;
	font-size:20px;
	font-weight:bold;
	color:#666;
	margin-left:175px;
	margin-top:35px;
}
.codeImg {
	float:left;
	margin:36px 0 0 10px;
	cursor:pointer;
}
.btn {
	background:url(img/btn.png) no-repeat;
	float:left;
	width:111px;
	height:37px;
	margin-top:0px;
	cursor:pointer;
	font-family:"微软雅黑", Arial, Helvetica, sans-serif;
	color:#4a4f54;
	font-weight:bold; 
	font-size:14px;
	 outline:none;
	 margin-top:10px;
}
.btn:hover { color:#d40007}
ul.errorMessage { display:inline; float:left; margin-left:-20px; _margin-left:0px; margin-top:15px; color:#d40007; font-size:14px; font-family:"微软雅黑", Arial, Helvetica, sans-serif; font-weight:bold; width:100%;}
</style>
<!--[if IE 6]>
	<script type="text/javascript" src="DD_belatedPNG.js" ></script>
	<script type="text/javascript">
	DD_belatedPNG.fix('img, #box, .btn');
	</script>
<![endif]-->
<script type="text/javascript"> 
<!--
                            function changeKaptcha(){
                                $("#kaptcha").attr("src", "Kaptcha.jpg?time=" + new Date().getTime());
                            }
                            
                            function checkForm(){
                            	if($("#username").val()==undefined ||$("#username").val().trim()==""){
                            		alert("请输入用户名!");
                            		return false;
                            	}
                            	if($("#password").val()==undefined ||$("#password").val().trim()==""){
                            		alert("请输入密码！");
                            		return false;
                            	}
                            	return true;
                            }
function _key() { 
 if(event.keyCode ==13) 
  changeKaptcha(); 
} 
//-->
</script>
</head>
<body onkeydown="_key()">
<div id="box">
  <div id="box2">
  <form id="userForm" action="loginSys.action" method="post" onsubmit="checkForm();">
    <input type="text" name="loginName" id="username" size="20"
								class="input user"/>
    <input type="password" name="password" id="password" size="20"
								class="input pass" />
      <div>
			<span><s:fielderror/></span>      </div>
    <input type="submit" class="btn" value="企业登录" />
    <input type="submit" class="btn" value="委内登录" style="margin-left:8px;" />
  </form>
  </div>
</div>
</body>
</html>
