<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<script type="text/javacript">
function manageArticle(articleId){
if(confirm("你要发布此文章到远程接口吗?")){
window.location.href="manageArticle.action?articleId="+articleId+"&web=yes";
}esle{
window.location.href="manageArticle.action?articleId="+articleId;
}
}
</script>
<h3>
下面是您需要审核的文章：
</h3>
<br />
<div class="pageHeader" style="padding:0;">
	<form id="pagerForm" action="showUnCheckArticleList.action"
		method="post">
		<input type="hidden" name="pageNum" value="1" />
		<input type="hidden" name="numPerPage" value="${pager.pageSize}" />
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
			 <a title="审核后此信息会自动发布,确认审核通过?" target="selectedTodo" rel="entityIds" href="manageArticles.action" class="delete"><span>审核</span></a>
			</li>
			<li class="line">
				line
			</li>
		</ul>
	</div>
	<table class="table" width="900" layoutH="168">
		<thead>
			<tr>
				<th width="22">
					<input type="checkbox" group="entityIds" class="checkboxCtrl" />
				</th>
				<th orderField="accountNo" class="asc" width="460">
					标题
				</th>
				<th width="100" orderField="accountName">
					作者
				</th>
				<th width="80" orderField="accountType">
					创建时间
				</th>
				<th width="80" orderField="accountCert">
					修改时间
				</th>
				<th width="60">
					操作
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pager.pageRecords}" var="article" varStatus="s">
				<tr target="sid_user" rel="1">
					<td>
						<input name="entityIds" value="${article.articleId }"
							type="checkbox" />
					</td>
					<td>
						${article.title}
					</td>
					<td>
						${users[s.index] .username}
					</td>
					<td>
						<fmt:formatDate var="startDate" value="${article.createTime}"
							pattern="yyyy-MM-dd" />
						${startDate }
					</td>
					<td>
						<fmt:formatDate var="startDate" value="${article.updateTime}"
							pattern="yyyy-MM-dd" />
						${startDate }
					</td>
					<td>
					<a title="编辑" target="dialog" href="editArticle.action?articleId=${article.articleId }" class="btnEdit"  rel="editArticleDialog" width="1000" height="580">编辑</a>
						<a title="审核后此信息会自动发布,确认审核通过?" target="ajaxTodo"
							href="manageArticle.action?articleId=${article.articleId }"
							style="color:green;" >审核</a>
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
