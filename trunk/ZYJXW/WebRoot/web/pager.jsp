<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:set var="pageCount"
	value='<%=Integer.parseInt(request.getParameter("pageCount"))%>' />
	<c:set var="pag"
	value='<%=request.getParameter("pag")%>' />
	<c:set var="child"
	value='<%=request.getParameter("child")%>' />
<c:set var="pageNum"
	value='<%=Integer.parseInt(request.getParameter("pageNum"))%>' />
<c:set var="postToUrl" value='<%=request.getParameter("targetUrl")%>' />
	<%
	    String pageCountStr = request.getParameter("pageCount");
	    String pageNumStr = request.getParameter("pageNum");
	    
	    int pageCount = Integer.parseInt(pageCountStr);
	    int pageNum = Integer.parseInt(pageNumStr);
	    int liststep = 10;
	    int listbegin = (pageNum - (int) Math.ceil((double) liststep / 2));
	    if (listbegin < 1) {
	        listbegin = 1;
	    }
	    int listend = pageNum + liststep / 2;
	    if (listend > pageCount) {
	        listend = pageCount + 1;
	    }
	%>

	<%
	    if (pageNum == 1) {
	%>
	<span class="disabled"> 首页</span>
	<span class="disabled"> < </span>
	<%
	    } else {
	%>
		<a href="javascript:;" onclick="goPage('1','${postToUrl }');">首页</a>
	<a href="javascript:;" onclick="goPage('${pageNum-1}','${postToUrl }');"><</a>
	<%
	    }
	    if (listbegin > 1) {
	%>
	...
	<%
	    }
	    for (int i = listbegin; i < listend; i++) {
	%>
	<%
	    if (i == pageNum) {
	%>
	<span class="current"><%=i%></span>
	<%
	    continue;
	        }
	%>


	<a href="javascript:void(0);" onclick="goPage('<%=i%>','${postToUrl }');return false;"><%=i%></a>

	<%
	    }
	    if (listend <= pageCount) {
	%>
	...
	<%
	    }
	    if (pageCount == pageNum) {
	%>
	<span class="disabled"> > </span>
		<span class="disabled"> 末页</span>
	<%
	    } else {
	%>
	<a href="javascript:;"
		onclick="goPage('${pageNum+1}','${postToUrl }');" >></a>
		<a href="javascript:;"
		onclick="goPage('${pageCount}','${postToUrl }');" >末页</a>
	<%
	    }
	%>
	<form id="pageForm" name="pageForm" method="post" action="${postToUrl }" target="_self">
		<input type="hidden" value="1" id="currentPage" name="pageNum"/>
		<input type="hidden" name="children" value="${child}"/>
		<input type="hidden" name="pagnation" value="${pag }"/>
	</form>
<script type="text/javascript">
function goPage(pageNum1, url) {
		document.pageForm.pageNum.value=pageNum1;
		document.pageForm.submit();
		return false;
}
</script>
