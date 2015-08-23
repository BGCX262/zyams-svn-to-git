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
<h2 class="contentTitle">编辑新闻分类 <a style="margin-left:800px;" class="add" href="getChildrenTypes.action?typeId=${zyType.typeId }" target="navTab"><span>管理子分类</span></a></h2>

<div class="pageContent">
    <form method="post" action="doEditArticleType.action" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
            <dl>
                <dt>
                    分类名称：
                </dt>
                <dd>
                    <input type="text" name="zyType.typeName" maxlength="200" class="required" size="50" value="${zyType.typeName }"/><span class="info">必填</span>
                    <input type="hidden" name="zyType.typeId"  value="${zyType.typeId }"/>
                    <input type="hidden" name="typeName"  value="${zyType.typeName }"/>
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
                <select name="zyType.type" class="combox"  id="articleType">
                	<option value="0" ${zyType.type eq "0"?"selected=selected":""}>新闻</option>
                	<option value="1" ${zyType.type eq "1"?"selected=selected":""}>页面</option>
                	<option value="2" ${zyType.type eq "2"?"selected=selected":""}>链接</option>
                </select>
                <c:choose>
                	<c:when test="${zyType.type eq '2'}">
                	 <input type="text" name="zyType.link" size="50" value="${zyType.link }" id="typeLink" />
                	</c:when>
                	<c:otherwise>
                	<input type="text" name="zyType.link" size="50" value="" id="typeLink" style="display:none;"/>
                	</c:otherwise>
                </c:choose>
                </dd>
            </dl>
            <dl>
				<dt>
					是否显示：
				</dt>
				<dd>
				<input type="radio" name="zyType.visiable" value="0" ${"0" eq zyType.visiable?"checked":""} />
					是
					<input type="radio" name="zyType.visiable" value="1" ${"1" eq zyType.visiable?"checked":""}/>
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
  