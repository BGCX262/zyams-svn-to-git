<%@ page contentType="image/jpeg" import="javax.imageio.*,java.io.*;" pageEncoding="utf-8"%>
<jsp:useBean id="image" scope="session" class="com.zhiye.common.util.Image"/>
<%

response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);



OutputStream servletos = response.getOutputStream();

//		输出图象到页面   
ImageIO.write(image.creatImage(), "JPEG",servletos);
servletos.flush();
servletos.close();
servletos = null;
response.flushBuffer();
out.clear();
out = pageContext.pushBody();
session.setAttribute("rand",image.sRand);
image.sRand="";
%> 
