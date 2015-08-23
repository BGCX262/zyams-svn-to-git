<%@ page contentType="text/html" language="java" pageEncoding="utf-8" import="java.util.*;"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%
Calendar currTime=new GregorianCalendar();
int year=currTime.get(currTime.YEAR);
int month=currTime.get(currTime.MONTH)+1;
%>
<c:set var="year2" value="<%=year%>"></c:set>
<c:set var="month2" value="<%=month%>"></c:set>
<form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${pager.pageSize}" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);"
		action="listIndexs.action" method="post">
		<div class="searchBar">
		${errorMsg}
			<ul class="searchContent">
				<li>
					<label>
						年份：
					</label>
					<c:choose>
						<c:when test="${empty year1||year1==0}">
								<select class="combox" name="year">
						<c:forEach begin="1970" end="2099" step="1" var="year">
							<option value="${year }" ${year eq year2?"selected=selected":""}>
								${year }
							</option>
						</c:forEach>
					</select>
						</c:when>
						<c:otherwise>
							<select class="combox" name="year">
						<c:forEach begin="1970" end="2099" step="1" var="year">
							<option value="${year }" ${year eq year1?"selected=selected":""}>
								${year }
							</option>
						</c:forEach>
					</select>
						</c:otherwise>
					</c:choose>
				
				</li>
				<li>
					<label>
						月份：
					</label>
					<c:choose>
						<c:when test="${empty month1||month1==0}">
					<select class="combox" name="month">
						<c:forEach begin="1" end="12" step="1" var="month">
							<option value="${month }" ${month eq month2?"selected=selected":""}>
								${month }
							</option>
						</c:forEach>
					</select>
					</c:when>
					<c:otherwise>
					<select class="combox" name="month">
						<c:forEach begin="1" end="12" step="1" var="month">
							<option value="${month }" ${month eq month1?"selected=selected":""}>
								${month }
							</option>
						</c:forEach>
					</select>
					</c:otherwise>
					</c:choose>
				</li>
				<li>
					<label>
						状态：
					</label>
					<select class="combox" name="status">
						<option value="all">
							所有状态
						</option>
						<option value="0" ${"0" eq status?"selected=selected":""}>
							已审核
						</option>
						<option value="1" ${"1" eq status?"selected=selected":""}>
							未审核
						</option>
					</select>
				</li>
			</ul>
			<div class="subBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									查询
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
			<!--<li>
            <a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="demo/common/ajaxDone.html" class="delete"><span>批量删除逗号分隔</span></a>
            </li>
            <li>
                <a class="edit" href="editIndex.action" target="navTab" warn="请选择一个用户"><span>修改</span></a>
            </li>-->
			<li class="line">
				line
			</li>
			<li>
				<a class="icon" href="download.action" 
					target="_blank" title="要下载这些记录吗?"><span>下载EXCEL</span>
				</a>
				
			</li>
		</ul>
	</div>
	<table class="table" width="1100" layoutH="138">
		<thead>
			<tr>
				<th width="50" orderField="accountNo" class="asc">
					企业名字
				</th>
				<th width="50" orderField="accountNo" class="asc">
					是否申报
				</th>
				<th width="50">
					审核状态
				</th>
				<th width="50">
					操作
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pager.pageRecords}" var="corp" varStatus="s">
				<tr target="sid_index" rel="1">
					<td>
						${corp.name }
					</td>
					<td>
						<c:choose>
							<c:when test="${corp.id==0||fn:length(corp.id)==0}">
                  	未申报
                  	</c:when>
							<c:otherwise>
                  	已申报
                  	</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${corp.id==0}">
                  	</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${corp.status=='0'}">
               						   	 已审核
              		    			</c:when>
									<c:otherwise>
										未审核
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${corp.id==0}">
                  	无
                  	</c:when>
							<c:otherwise>
                  <a href="viewIndex.action?indexId=${corp.id }" style="color:red;" target="navTab" title="查看" rel="editIndex">查看</a>&nbsp;&nbsp;
            	     <c:choose>
							<c:when test="${corp.id!=0}">
								<c:choose>
									<c:when test="${corp.status=='1'}">
               						   	  <a href="manageIndex.action?indexId=${corp.id }" style="color:red;" target="ajaxTodo" title="审核" rel="editIndex">审核</a>
              		    			</c:when>
								</c:choose>
							</c:when>
						</c:choose>
                  	</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage"
				onchange="navTabPageBreak({numPerPage:this.value})">
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
		<div class="pagination" targetType="navTab"
			totalCount="${pager.totalRecords}" numPerPage="${pager.pageSize}"
			pageNumShown="10" currentPage="${pager.currentPage}">
		</div>
	</div>
</div>
               