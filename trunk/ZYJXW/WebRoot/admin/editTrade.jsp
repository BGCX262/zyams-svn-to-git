<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<h2 class="contentTitle">
	修改行业
</h2>
<div class="pageContent">
	<form method="post" action="doEditTrade.action" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	 <input type="hidden" name="dictionary.code" value="${dictionary.code}"/>
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>
					编号：
				</dt>
				<dd>
					<input type="text" name="dictionary.dictid" maxlength="20"
						class="required" size="20" value="108" readOnly="true "/>
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>
					行业名称：
				</dt>
				<dd>
					<input type="text" name="dictionary.name" size="20" class="required" value="${dictionary.name}"/>
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>
					标记：
				</dt>
				<dd>
					<input type="text" name="dictionary.flag" size="20" value="${dictionary.flag}"/>
				</dd>
			</dl>
			<dl>
				<dt>
					备注：
				</dt>
				<dd>
					<input type="text" name="dictionary.remarks" size="20" value="${dictionary.remarks}" />
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