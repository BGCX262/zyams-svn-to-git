<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<h2 class="contentTitle">
	添加产品
</h2>
<div class="pageContent">
	<form method="post" action="doAddProduct.action" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>
					编号：
				</dt>
				<dd>
					<input type="text" name="product.productid" maxlength="3"
						class="required" size="20" />
					<span class="info">必填,请勿输入中文</span>
				</dd>
			</dl>
			<dl>
				<dt>
					产品名称：
				</dt>
				<dd>
					<input type="text" name="product.productName" size="20" class="required"/>
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>
					单位：
				</dt>
				<dd>
					<input type="text" name="product.unit" size="20" class="required"/>
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>
					排序：
				</dt>
				<dd>
					<input type="text" name="product.orderno" size="20"  maxlength="5"/><span class="info">数字</span>
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
