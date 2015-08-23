<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<form id="pagerForm" method="post" action="#rel#">
</form>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="listArticleTypes.action" method="post">
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
           <li>
                <a class="add" href="addArticleType.action" target="navTab" rel="addArticleType"><span>添加</span></a>
            </li>
            <!--<li>
                <a title="确实要删除这些记录吗?" target="selectedTodo" rel="entityIds" href="removeArticleTypes.action" class="delete"><span>删除</span></a>
            </li>
            <li>
            <a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="demo/common/ajaxDone.html" class="delete"><span>批量删除逗号分隔</span></a>
            </li>
            <li>
                <a class="edit" href="editArticleType.action" target="navTab" rel="editArticleType" warn="请选择一条记录"><span>修改</span></a>
            </li>-->
            <li class="line">
                line
            </li>
        </ul>
    </div>
    <table class="table" width="1100" layoutH="138">
        <thead>
            <tr>
               <th  width="80">
                  编号
                </th>
                <th  width="300">
                    名称
                </th>
                <th width="100" >
                    类型
                </th>
          	   <th width="100" >
                    是否显示
                </th>
                <th width="300" >
                    链接
                </th>
                <th width="120" >
                    创建时间
                </th>
                <th width="120" >
                    修改时间
                </th>
                <th width="70">
                    操作
                </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${allTypes}" var="articleType">
            <tr target="sid_user" rel="1">
             <td>
                    ${articleType.typeId}
                </td>
                <td>
                    ${articleType.typeName}
                </td>
                 <td>
                    <c:choose>
                    	<c:when test="${articleType.type eq '0'}">新闻</c:when>
                    	<c:when test="${articleType.type eq '1'}">页面</c:when>
                    	<c:when test="${articleType.type eq '2'}">链接</c:when>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                    	<c:when test="${articleType.visiable eq '0'}">显示</c:when>
                    	<c:when test="${articleType.visiable eq '1'}">不显示</c:when>
                    </c:choose>
                </td>
                <td>
                	<a href="${articleType.link }">${articleType.link }</a>
                </td>
                <td>
                <fmt:formatDate var="startDate" value="${articleType.createTime}" pattern="yyyy-MM-dd"/>
                   ${startDate}
                </td>
				  <td>
				  <fmt:formatDate var="updateDate" value="${articleType.updateTime}" pattern="yyyy-MM-dd"/>
                     ${updateDate}
                </td>
                <td>
                    <a title="删除" target="ajaxTodo" href="removeArticleType.action?typeId=${articleType.typeId}" class="btnDel">删除</a>
                    <a title="编辑" target="navTab" href="editArticleType.action?typeId=${articleType.typeId}" class="btnEdit" rel="editArticleType">编辑</a>
                </td>
            </tr></c:forEach>
        </tbody>
    </table>
</div>
  