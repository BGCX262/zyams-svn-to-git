<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#articleType").change(function(){
			var vale=$(this).val();
			if(vale=="2"){
				$("#typeLink").show();
			}else{
					$("#typeLink").val("");
					$("#typeLink").hide();
			}
		});
	});
</script>
<h2 class="contentTitle">
	添加子分类
</h2>
<c:set var="parentId" value="${parentId}"></c:set>

<div class="pageContent">
	<form method="post" action="doAddArticleType.action"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>
					分类名称：
				</dt>
				<dd>
					<input type="text" name="zyType.typeName" maxlength="20"
						class="required" size="20" />
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>
					父级分类：
				</dt>
				<dd>
					<input name="zyType.parentId" value="${parentId }" type="hidden" />
					<input class="required" name="zyType.parentName" type="text"
						value="${parentName }" readonly />
					<a class="btnLook" href="lookupParentTypes.action" rel="dialog3"
						lookupGroup="zyType">选择 </a>
				</dd>
			</dl>
			<dl>
				<dt>
					分类类型：
				</dt>
				<dd>
					<select name="zyType.type" class="combox" id="articleType">
						<option value="0">
							新闻
						</option>
						<option value="1">
							页面
						</option>
						<option value="2">
							链接
						</option>
					</select>
					<input type="text" name="zyType.link" size="50"  value="" id="typeLink" style="display:none;"/>
				</dd>
			</dl>
			<dl>
				<dt>
					是否显示：
				</dt>
				<dd>
				<input type="radio" name="zyType.visiable" value="0" checked="checked"/>
					是
					<input type="radio" name="zyType.visiable" value="1" />
					否
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
