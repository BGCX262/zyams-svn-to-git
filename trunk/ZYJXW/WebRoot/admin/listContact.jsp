<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pager.currentPage}" />
    <input type="hidden" name="numPerPage" value="${pager.pageSize}" />
</form>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="listContacts.action" method="post">
    <input type="hidden" name="typeId" value="${contact.id }"/>
        <div class="searchBar">
            <ul class="searchContent">
                <li>
                    <label>
                       名称：
                    </label>
                    <input type="text" name=username value="${username }"/>
                </li>
                 <li>
                    <label>
                      手机：
                    </label>
                    <input type="text" name=mobile value="${mobile }"/>
                </li>
            </ul>
            <div class="subBar">
                <ul>
                    <li>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">
                                    搜索
                                </button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li>
                <c:if test="${sessionRoleName eq '管理员'}"><a class="add" href="addContact.action"  target="navTab" rel="addContact"><span>添加</span></a></c:if>
            </li>
            <li>
                <c:if test="${sessionRoleName eq '管理员'}"><a title="确实要删除这些记录吗?" target="selectedTodo" rel="entityIds" href="removeContacts.action" class="delete"><span>删除</span></a></c:if>
            </li>
            <!--<li>
            <a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="demo/common/ajaxDone.html" class="delete"><span>批量删除逗号分隔</span></a>
            </li>
            <li>
                <a class="edit" href="editArticle.action" target="navTab" warn="请选择一条记录"><span>修改</span></a>
            </li>-->
            <li class="line">
                line
            </li>
        </ul>
    </div>
    <table class="table" width="1100" layoutH="138">
        <thead>
            <tr>
                <th width="22">
                    <input type="checkbox" group="entityIds" class="checkboxCtrl">
                </th>
                <th width="100" orderField="accountName">
                    联系人名字
                </th>
                 <th width="100" orderField="accountName">
                    手机
                </th>
                <th width="80" orderField="accountType">
                    分组
                </th>
                <th width="70">
                    操作
                </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${pager.pageRecords}" var="contact" varStatus="s">
            <tr target="sid_user" rel="1">
                <td>
                    <input name="entityIds" value="${contact.contactId }" type="checkbox">
                </td>
                <td>
                         ${contact.username }
                </td>
                 <td>
                         ${contact.mobile }
                </td>
				  <td>
				    <c:forEach items=" ${types[s.index]}" var="ss">
                     ${ss}  &nbsp;
                     </c:forEach>
                </td>
                <td>
                    <c:if test="${sessionRoleName eq '管理员'}"><a title="删除" target="ajaxTodo" href="removeContact.action?contactid=${contact.contactId}" class="btnDel">删除</a></c:if>
                    <c:if test="${sessionRoleName eq '管理员'}"><a title="编辑" target="navTab" href="editContact.action?contactid=${contact.contactId}" class="btnEdit" rel="editContact">编辑</a></c:if>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
     <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
  					<option value="5" ${pager.pageSize eq 5?'selected="selected"':''}>5</option>
  					<option value="10" ${pager.pageSize eq 10?'selected="selected"':''}>10</option>
  					<option value="15" ${pager.pageSize eq 15?'selected="selected"':''}>15</option>
  					<option value="20" ${pager.pageSize eq 20?'selected="selected"':''}>20</option>
  					<option value="25" ${pager.pageSize eq 25?'selected="selected"':''}>25</option>
  					<option value="30" ${pager.pageSize eq 30?'selected="selected"':''}>30</option>
  					<option value="35" ${pager.pageSize eq 35?'selected="selected"':''}>35</option>
  					<option value="40" ${pager.pageSize eq 40?'selected="selected"':''}>40</option>
  					<option value="45" ${pager.pageSize eq 45?'selected="selected"':''}>45</option>
  					<option value="50" ${pager.pageSize eq 50?'selected="selected"':''}>50</option>
  					<option value="100" ${pager.pageSize eq 100?'selected="selected"':''}>100</option>
  					<option value="150" ${pager.pageSize eq 150?'selected="selected"':''}>150</option>
  					<option value="200" ${pager.pageSize eq 200?'selected="selected"':''}>200</option>
            </select>
             <span>条，共${pager.totalRecords}条</span>
        </div>
        <div class="pagination"  targetType="navTab" totalCount="${pager.totalRecords}" numPerPage="${pager.pageSize}" pageNumShown="10" currentPage="${pager.currentPage}">
        </div>
    </div>
</div>