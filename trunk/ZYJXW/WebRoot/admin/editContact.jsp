<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<h2 class="contentTitle">编辑联系人</h2>
<div class="pageContent">
    <form method="post" action="doEditContact.action" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
    <input type="hidden" name="contact.contactId" value="${contact.contactId}"/>
        <div class="pageFormContent nowrap" layoutH="97">
             <dl>
                <dt>
                    联系人名称：
                </dt>
                <dd>
                    <input type="text" name="contact.username" maxlength="20" class="required" size="20" value="${contact.username }"/><span class="info">必填</span>
                </dd>
            </dl>
           <dl>
				<dt>
					手机：
				</dt>
				<dd>
					<input type="text" name="contact.mobile" size="20" class="required" value="${contact.mobile }" maxlength="11"/>
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
				<c:set value="0" var="flag" />
				
					<c:forEach items="${ownTypes}" var="own">
					
					<c:if test="${own.typeId==type.typeId}">
					
					<input type="checkbox" name="typeids"  value="${type.typeId }" checked="checked"/>
								${type.typeName }
					
					<c:set value="1" var="flag" />
					
					</c:if>
					
					</c:forEach>
					
					<c:if test="${flag=='0'}">
					
					<input type="checkbox" name="typeids"  value="${type.typeId }"/>
								${type.typeName }
					</c:if>
							
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
