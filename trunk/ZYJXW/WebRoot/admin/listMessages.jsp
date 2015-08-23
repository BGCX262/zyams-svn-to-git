<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="1" /><input type="hidden" name="numPerPage" value="${pager.pageSize}" />
</form>
<div class="pageHeader">

<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li>
                <a class="add" href="addMessage.action" target="navTab" rel="addLink"><span>添加</span></a>
            </li>
            
          
        </ul>
    </div>
    <table class="table" width="1100" layoutH="80">
        <thead>
            <tr>               
                <th width="100" >
            编号
                </th>
                <th width="300">
        内容
                </th>
                <th width="30">
                    成功数
                </th>
                  <th width="30">
                    失败数
                </th>
                 <th width="120">
        发送时间
                </th>
                <th width="70">
                    操作
                </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${pager.pageRecords}" var="message" varStatus="s">
            <tr>
                <td>
                   ${message.msgId }
                </td>
                <td>
                    ${message.msgContent }
                </td>
                <td>
                 ${message.successSize }
                </td>
                  <td>
                    ${message.failSize }
                </td>
                 <td>
                   
                    <fmt:formatDate var="startDate" value="${message.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                          ${startDate }
                </td>
              
                <td>
                    <a title="查看" target="dialog" href="viewMessage.action?msgId=${message.msgId }" class="btnView">查看</a>
                    
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
