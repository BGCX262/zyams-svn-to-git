<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
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

	background: #000 url(../web/img/loginbg.gif) center top no-repeat;

	color:#666;

}

#box {

	background:url(../web/img/box.png) no-repeat;

	width:500px;

	height:481px;

	margin:100px auto 0;

}

#name {

	margin-top:75px;

	margin-left:70px;

	float:left;

}

.input {

	background:url(../web/img/input.gif) no-repeat;

	width:347px;

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

	margin-left:65px;

}

.pass {

	margin-top:52px;

	margin-left:65px;

}

#codeBox {

	float:left;

}

.codeText {

	background:url(../web/img/code1.gif) no-repeat;

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

	background:url(../web/img/adminbtn.gif) no-repeat;

	float:right;

	width:162px;

	height:50px;

	margin-right:62px;

	margin-top:20px;

	cursor:pointer;

}

ul.errorMessage { float:left; margin-left:40px; margin-top:35px; color:#d40007; font-size:14px; font-family:"微软雅黑", Arial, Helvetica, sans-serif; font-weight:bold;}
ul.errorMessage li{width:187px;}
</style>

<!--[if IE 6]>
	<script type="text/javascript" src="../web/js/DD_belatedPNG.js" ></script>
	<script type="text/javascript">
	DD_belatedPNG.fix('img, #box');
	</script>
<![endif]-->
<script type="text/javascript" src="../web/js/jquery.min.js"></script>
<script type="text/javascript"> 
<!--
                            function changeKaptcha(){
                                $("#codeImg").attr("src", "image.jsp");
                            }

                            function checkForm(){
                            	if($("#username").val()==undefined ||$("#username").val().trim()==""){
                            		alert("请输入用户名!");
                            		$("#username").focus();
                            		return false;
                            	}
                            	if($("#password").val()==undefined ||$("#password").val().trim()==""){
                            		alert("请输入密码！");
                            		$("#password").focus();
                            		return false;
                            	}
                            	if($("#code").val()==undefined ||$("#code").val().trim()==""){
                            		alert("请输入验证码！");
                            		$("#code").focus();
                            		return false;
                            	}
                            	return true;
                            }
function _key() { 
if(event){
if(event.keyCode ==13) 
 	checkForm(); 
}
} 
//-->
</script> 
</head>
<body onkeydown="_key()">
<div id="box">
  <div id="name"><img src="../web/img/name.gif" /></div>
  <form id="userForm" action="login.action" method="post" onsubmit="return checkForm();">

  <input type="text" name="user.loginname" id="username" size="20"
								class="input user"/>
								

  <input type="password" name="user.password" id="password" size="20"
								class="input pass" />
								
  <div id="cdeBox"><input type="text" class="codeText" id="code" name="user.rand" /><span class="codeImg"><img id="codeImg" src="image.jsp" onclick="javascript:changeKaptcha();"/></span>
 <div>

   <s:fielderror>
  <s:param value="%{'username'}" />
  <s:param value="%{'kap'}" />
    <s:param value="%{'password'}" />
  </s:fielderror>
  </div>
  </div>
  <input type="submit" class="btn" value=""/>
  </form>
</div>
</body>
</html>

