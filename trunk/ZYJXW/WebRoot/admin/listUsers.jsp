<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="1" /><input type="hidden" name="numPerPage" value="${pager.pageSize}" />
</form>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="listUsers.action" method="post">
        <div class="searchBar">
            <ul class="searchContent">
                <li>
                    <label>
                        名字：
                    </label>
                    <input type="text" name="loginName" value="${loginName }"/>
                </li>
                <li>
                    <label>
                        部门：
                    </label>
                    <select class="combox" name="partmentId">
                        <option value="all">所有部门</option>
                     	<c:forEach items="${allPartments}" var="part">
							<option value="${part.partmentId }" ${part.partmentId eq
								pId?"selected=selected":"" }>
								${part.partmentName }
							</option>
						</c:forEach>
                    </select>
                </li>
                <li>
                    <label>
                        状态：
                    </label>
                   <select class="combox" name="active">
                        <option value="all">所有状态</option>
                        <option value="0" ${"0" eq status1?"checked":""}>可用</option>
                        <option value="1" ${"1" eq status1?"checked":""}>不可用</option>
                    </select>
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
                <a class="add" href="addUser.action" target="navTab"><span>添加</span></a>
            </li>
            <li>
                <a title="确实要删除这些记录吗?" target="selectedTodo" rel="entityIds" href="removeUsers.action" class="delete"><span>删除</span></a>
            </li>
            <!--<li>
            <a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="demo/common/ajaxDone.html" class="delete"><span>批量删除逗号分隔</span></a>
            </li>
            <li>
                <a class="edit" href="editUser.action" target="navTab" warn="请选择一个用户"><span>修改</span></a>
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
                <th width="50" orderField="accountNo" class="asc">
                    名字
                </th>
                 <th width="50" orderField="accountNo" class="asc">
                    真实名字
                </th>
                <th width="50">
                    部门
                </th>
                <th width="50">
                    职位
                </th>
				 <th width="40">
                    角色
                </th>
                <th width="40">
                    用户类型
                </th>
                <th width="60" align="center" orderField="accountLevel">
                    状态
                </th>
                <th width="70">
                    操作
                </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${pager.pageRecords}" var="user" varStatus="s">
            <tr target="sid_user" rel="1">
                <td>
                    <input name="entityIds" value="${user.userId }" type="checkbox">
                </td>
                <td>
                    ${user.loginname }
                </td>
                  <td>
                    ${user.username }
                </td>
                <td>
                    ${partments[s.index] .partmentName}
                </td>
                <td>
                    ${user.position }
                </td>
                <td>
                       ${roles[s.index] .roleName}
                </td>
				 <td>
                      <c:if test="${user.userType==0}">
                    个人
                    </c:if>
                   <c:if test="${user.userType==1}">
                   企业
                    </c:if>
                </td>
                <td>
                 <c:if test="${user.active==1}">
                    不可用
                    </c:if>
                   <c:if test="${user.active==0}">
                   可用
                    </c:if>
                </td>
                <td>
                    <a title="删除" target="ajaxTodo" href="removeUser.action?uid=${user.userId }" class="btnDel">删除</a>
                    <a title="编辑" target="navTab" href="editUser.action?uid=${user.userId }" rel="editUser" class="btnEdit">编辑</a>
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
        <div class="pagination" targetType="navTab" totalCount="${pager.totalRecords}" numPerPage="${pager.pageSize}" pageNumShown="10" currentPage="${pager.currentPage}">
        </div>
    </div>
</div>
