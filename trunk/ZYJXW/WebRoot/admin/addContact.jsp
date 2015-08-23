<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<h2 class="contentTitle">
	添加联系人
</h2>
<div class="pageContent">
	<form method="post" action="doAddContact.action" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>
					联系人名称：
				</dt>
				<dd>
					<input type="text" name="contact.username" size="20" class="required"/>
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>
					手机：
				</dt>
				<dd>
					<input type="text" name="contact.mobile" size="20" class="required" maxlength="11"/>
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>
					分组：
				</dt>
				<dd>
					选择分组:
						<c:forEach items="${contactTypes}" var="type" varStatus="s">
							<input type="checkbox" name="typeids"  value="${type.typeId }"/>
								${type.typeName }
						</c:forEach>
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
