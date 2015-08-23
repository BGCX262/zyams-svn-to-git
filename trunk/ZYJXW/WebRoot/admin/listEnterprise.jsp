<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<form id="pagerForm" method="post" action="#rel#?dictid=107">
    <input type="hidden" name="pageNum" value="${pager.currentPage}" />
    <input type="hidden" name="numPerPage" value="${pager.pageSize}" />
</form>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="listCorporation.action" method="post">
    <input type="hidden" name="typeId" value="${corporations.rowid}"/>
        <div class="searchBar">
            <ul class="searchContent">
                <li>
                    <label>
                       企业名称：
                    </label>
                    <input type="text" name="name" value="${corporation.name }"/>
                </li>
                 <li>
                    <label>
                        企业编号：
                    </label>
                    <input type="text" name="id" value="${corporation.id}"/>
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
                <a class="add" href="addCorporation.action"  target="navTab"><span>添加</span></a>
            </li>
            <li>
                <a title="确实要删除这些记录吗?" target="selectedTodo" rel="entityIds" href="removeCorporation.action" class="delete"><span>删除</span></a>
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
                <th orderField="accountNo" class="asc" width="40">
                   企业 编号
                </th>
                <th width="150" orderField="accountName">
                   企业名称
                </th>
                <th width="100" orderField="accountName">
                   区域名称
                </th>
                <th width="120" orderField="accountName">
                   行业名称
                </th>
                <th width="100" orderField="accountName">
                   是否重点骨干
                </th>
                <th width="100" orderField="accountName">
                   是否专精特新
                </th>
                <th width="70">
                    操作
                </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${pager.pageRecords}" var="corporation" varStatus="s">
            <tr target="sid_user" rel="1">
                <td>
                    <input name="entityIds" value="${corporation.rowid }" type="checkbox">
                </td>
                <td>
                         ${corporation.id }
                </td>
                <td>
                		 ${corporation.name }
                </td>
				 <td>
               			 ${corporation.areaid}
                </td>
                <td>
                		 ${corporation.tradeid }
                </td>
                <td>
                		 ${corporation.is50 }
                </td>
                <td>
                		 ${corporation.isnew }
                </td>
                <td>
                    <a title="删除" target="ajaxTodo" href="removeCorporation.action?rowid=${corporation.rowid}&corportationid=${corporation.id}" class="btnDel">删除</a>
                    <a title="编辑" target="navTab" href="editCorporation.action?rowid=${corporation.rowid}&id=${corporation.id}" class="btnEdit">编辑</a>
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