<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#showCompany").change(function(){
			var vale=$(this).val();
			if(vale=="1"){
				$("#companyInfo").show();
				$("#companyName").addClass("required");
				$("#companyAddress").addClass("required");
				$("#companyMobile").addClass("required");
			}else{
					$("#companyName").val("");
					$("#companyAddress").val("");
					$("#companyPostCode").val("");
					$("#companyMobile").val("");
					$("#companyInfo").hide();
				$("#companyName").removeClass("required");
				$("#companyAddress").removeClass("required");
				$("#companyMobile").removeClass("required");
			}
		});
	});
</script>
<h2 class="contentTitle">添加用户</h2>
<div class="pageContent">
    <form method="post" action="doAddUser.action" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
        <div class="pageFormContent nowrap" layoutH="97">
        <dl>
                <dt>
                   名字：
                </dt>
                <dd>
                    <input type="text" name="user.loginname" maxlength="20" class="required" size="20"/><span class="info">必填</span>
                </dd>
            </dl>
            <dl>
                <dt>
                   真实名字：
                </dt>
                <dd>
                    <input type="text" name="user.username" maxlength="20" class="required" size="20"/><span class="info">必填</span>
                </dd>
            </dl>
			 <dl>
                <dt>
                   密码：
                </dt>
                <dd>
                    <input type="text" name="user.password" maxlength="25" class="required" size="25"/><span class="info">必填</span>
                </dd>
            </dl>
              <dl>
                <dt>
                   手机：
                </dt>
                <dd>
                    <input type="text" name="user.mobile" maxlength="25" class="required" size="25" alt="输入数字"/>
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
							<option value="${part.partmentId }" >
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
                    <input type="text" name="user.position" size="20"/>
                </dd>
            </dl>
            <dl>
                <dt>
                    用户类型：
                </dt>
                <dd>
                    <select class="combox" name="user.userType" id="showCompany">
                        <option value="0">个人</option>
                        <option value="1">企业</option>
                    </select>
                </dd>
            </dl>
            <div id="companyInfo" style="display:none;">
            <dl>
                <dt>
                    企业名称：
                </dt>
                <dd>
                 <input type="text" id="companyName" name="company.companyName" size="50" /><span class="info">必填</span>
                </dd>
            </dl>
            <dl>
                <dt>
                   企业地址：
                </dt>
                <dd>
                     <input type="text" id="companyAddress" name="company.companyAddress" size="100" /><span class="info">必填</span>
                </dd>
            </dl>
                        <dl>
                <dt>
                    邮政编码：
                </dt>
                <dd>
                     <input type="text" id="companyPostCode" name="company.postCode" size="20"/>
                </dd>
            </dl>
                     <dl>
                <dt>
                   电话：
                </dt>
                <dd>
                     <input type="text" id="companyMobile" name="company.mobile" size="50" /><span class="info">必填</span>
                </dd>
            </dl>
            </div>
            <dl>
                <dt>
                    角色：
                </dt>
                <dd>
                   	<select class="combox" name="user.roleId">
                     <c:forEach items="${roles}" var="role">
							<option value="${role.roleId }" >
								${role.roleName }
							</option>
						</c:forEach>
                    </select>
                </dd>
            </dl>
             <dl>
                <dt>
                    简介：
                </dt>
                <dd>
                    <textarea name="user.remarks" cols="100" rows="3"></textarea>
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
