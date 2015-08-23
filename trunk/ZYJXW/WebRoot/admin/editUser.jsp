<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#showCompany").change(function(){
			var vale=$(this).val();
			if(vale=="1"){
				$(".company").show();
				$("#companyName").addClass("required");
				$("#companyAddress").addClass("required");
				$("#companyMobile").addClass("required");
			}else{
					$("#companyName").val("");
					$("#companyAddress").val("");
					$("#companyPostCode").val("");
					$("#companyMobile").val("");
					$(".company").hide();
				$("#companyName").removeClass("required");
				$("#companyAddress").removeClass("required");
				$("#companyMobile").removeClass("required");
			}
		});
	});
</script>

<h2 class="contentTitle">编辑用户</h2>
<div class="pageContent">
    <form method="post" action="doEditUser.action" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
             <div class="pageFormContent nowrap" layoutH="97">
             <input type="hidden" name="user.userId" value="${user.userId }"/>
              <input type="hidden" name="user.companyId" value="${user.companyId }"/>
                <input type="hidden" name="company.companyId" value="${company.companyId }"/>
                <dl>
                <dt>
                   名字：
                </dt>
                <dd>
                    <input type="text" name="user.loginname" maxlength="20" class="required" size="20" value="${user.loginname }"/><span class="info">必填</span>
                </dd>
            </dl>
            <dl>
                <dt>
                   真实名字：
                </dt>
                <dd>
                    <input type="text" name="user.username" maxlength="20" class="required" size="20" value="${user.username }"/><span class="info">必填</span>
                </dd>
            </dl>
			 <dl>
                <dt>
                   密码：
                </dt>
                <dd>
                    <input type="text" name="user.password" maxlength="25" class="required" size="25" value="${user.password }"/><span class="info">必填</span>
                </dd>
            </dl>
             <dl>
                <dt>
                   手机：
                </dt>
                <dd>
                    <input type="text" name="user.mobile" maxlength="25" class="required" size="25" alt="输入数字" value="${user.mobile }"/>
                </dd>
            </dl>
            <dl>
                <dt>
                    部门：
                </dt>
                <dd>
                    <select class="combox" name="user.pid">
						<option value="0">
							选择部门
						</option>
						<c:forEach items="${partments}" var="part">
							<option value="${part.partmentId }" ${part.partmentId eq user.pid ?"selected=selected":'' }>
								${part.partmentName }
							</option>
						</c:forEach>
					</select>
                </dd>
            </dl>
			 <dl>
                <dt>
                    职位：
                </dt>
                <dd>
                    <input type="text" name="user.position" size="20" value="${user.position }"/>
                </dd>
            </dl>
            <dl>
                <dt>
                    用户类型：
                </dt>
                <dd>
                    <select class="combox" name="user.userType" id="showCompany">
                        <option value="0" ${'0' eq user.userType ?"selected=selected":'' }>个人</option>
                        <option value="1"${'1' eq user.userType ?"selected=selected":'' }>企业</option>
                    </select>
                </dd>
            </dl>
            <c:choose>
            	<c:when test="${'0' eq user.userType}">
            	            <dl class="company" style="display:none;">
            	</c:when>
            	<c:otherwise>
            	            <dl class="company">
            	</c:otherwise>
            </c:choose>
                <dt>
                    企业名称：
                </dt>
                <dd>
                 <input type="text" id="companyName" name="company.companyName" size="50" value="${company.companyName}" /><span class="info">必填</span>
                </dd>
            </dl>
           <c:choose>
            	<c:when test="${'0' eq user.userType}">
            	            <dl class="company" style="display:none;">
            	</c:when>
            	<c:otherwise>
            	           <dl class="company">
            	</c:otherwise>
            </c:choose>
                <dt>
                   企业地址：
                </dt>
                <dd>
                     <input type="text" id="companyAddress" name="company.companyAddress" size="100"  value="${company.companyAddress}"/><span class="info">必填</span>
                </dd>
            </dl>
                   <c:choose>
            	<c:when test="${'0' eq user.userType}">
            	            <dl class="company" style="display:none;">
            	</c:when>
            	<c:otherwise>
            	             <dl class="company">
            	</c:otherwise>
            </c:choose>
                <dt>
                    邮政编码：
                </dt>
                <dd>
                     <input type="text" id="companyPostCode" name="company.postCode" size="20" value="${company.postCode}"/>
                </dd>
            </dl>
                    <c:choose>
            	<c:when test="${'0' eq user.userType}">
            	            <dl class="company" style="display:none;">
            	</c:when>
            	<c:otherwise>
            	             <dl class="company">
            	</c:otherwise>
            </c:choose>
                <dt>
                   电话：
                </dt>
                <dd>
                     <input type="text" id="companyMobile" name="company.mobile" size="50"  value="${company.mobile}"/><span class="info">必填</span>
                </dd>
            </dl>
            <dl>
                <dt>
                    角色：
                </dt>
                <dd>
                   	<select class="combox" name="user.roleId">
                     <c:forEach items="${roles}" var="role">
							<option value="${role.roleId }" ${role.roleId eq user.roleId ?"selected=selected":'' } >
								${role.roleName }
							</option>
						</c:forEach>
                    </select>
                </dd>
            </dl>
               <dl>
                <dt>
                   状态：
                </dt>
                <dd>
                        <input type="radio" name="user.active" value="0" ${"0" eq user.active?"checked":""} />已审核
                        <input type="radio" name="user.active" value="1" ${"1" eq user.active?"checked":""} />未审核
                </dd>
            </dl>
             <dl>
                <dt>
                    简介：
                </dt>
                <dd>
                    <textarea name="user.remarks" cols="100" rows="3">${user.remarks }</textarea>
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
