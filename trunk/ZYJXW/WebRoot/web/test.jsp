<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
System.out.println("页面里获取编码格式为:"+request.getCharacterEncoding()+"获取的参数为:"+request.getParameter("t"));
out.println(request.getCharacterEncoding());
out.println(request.getParameter("t"));
%>