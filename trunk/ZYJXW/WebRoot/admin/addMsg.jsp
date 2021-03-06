<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<h2 class="contentTitle">
	添加留言
</h2>
<div class="pageContent">
	<form method="post" action="doAddMsg.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
		<dl>
				<dt>
					 写给：
				</dt>
				<dd>
					<select name="msg.userId">
					<option value="0">谁也不选</option>
					<c:forEach items="${users}" var="user">
						<option value="${user.userId }">${user.username }</option>
						</c:forEach>					
					</select>
				</dd>
			</dl>
			<dl>
				<dt>
					用户名：
				</dt>
				<dd>
					<input type="text" name="msg.username" maxlength="50"
						class="required" size="50" />
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>
					性别：
				</dt>
				<dd>
					<input type="radio" name="msg.gender" checked="checked"  value="0" />
					男
					<input type="radio" name="msg.gender" value="1" />
					女
				</dd>
			</dl>
			<dl>
				<dt>
					电话：
				</dt>
				<dd>
					<input type="text" name="msg.mobile" maxlength="20" size="20" />
				</dd>
			</dl>
			<dl>
				<dt>
					邮箱：
				</dt>
				<dd>
					<input type="text" name="msg.email" maxlength="20" size="20" />
				</dd>
			</dl>
			<dl>
				<dt>
					内容：
				</dt>
				<dd>
					<div class="unit">
						<textarea  name="msg.content" rows="15" cols="100"></textarea>
					</div>
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
