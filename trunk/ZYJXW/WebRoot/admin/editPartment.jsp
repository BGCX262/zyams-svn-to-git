<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<h2 class="contentTitle">编辑部门</h2>
<div class="pageContent">
    <form method="post" action="doEditPartment.action" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
    -${partment.partmentId}-
    <input type="hidden" name="partment.partmentId" value="${partment.partmentId}"/>
        <div class="pageFormContent nowrap" layoutH="97">
            <dl>
                <dt>
                   部门名称：
                </dt>
                <dd>
                    <input type="text" name="partment.partmentName" maxlength="20" class="required" size="20" value="${partment.partmentName }"/><span class="info">必填</span>
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
