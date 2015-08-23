<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
	<script type="text/javascript">
										function checkAll(){	
											if($("#checkAllManage").attr("checked")==undefined){
												$(".manageIds").each(function(){
													$(this).attr("checked",false);
													});
												}else{
												$(".manageIds").each(function(){
													$(this).attr("checked",true);
													});
												}
										}
	</script>
<h2 class="contentTitle">
	添加角色
</h2>
<div class="pageContent">
	<form method="post" action="doAddRole.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>
					角色名称：
				</dt>
				<dd>
					<input type="text" name="role.roleName" maxlength="20"
						class="required" size="20" />
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>
					角色权限：
				</dt>
				<dd>
					<table class="table" width="500" layoutH="138">
						<thead>
							<tr>
								<th orderField="accountNo" class="asc">
									权限模块
								</th>
								<!-- <th width="100">
									访问查看
									<input  type="checkbox" name="checkAllView" id="checkAllView" onclick="checkAllView();"/>
								</th>
								<th width="130">
									添加/修改/删除
									<input  type="checkbox" name="checkAllCURD" id="checkAllCURD"/>
								</th> -->
								<th width="100">
									审批
									<input  type="checkbox" name="checkAllManage" id="checkAllManage" onClick="checkAll();"/>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allTypes}" var="type" varStatus="s">
								<tr target="sid_user" rel="1">
									<td>
										${type.typeName }
									</td>
									<!-- <td>
										<input name="viewIds" value="${type.typeId}"  type="checkbox"/>
									</td>
									<td>
										<input name="modifyIds" value="${type.typeId}"	  type="checkbox"/>
									</td> -->
									<td>
										<input class="manageIds" name="manageIds" value="${type.typeId}"  type="checkbox" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">
								提交
							</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">
								取消
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
