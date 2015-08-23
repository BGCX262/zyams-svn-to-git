<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<h2 class="contentTitle">编辑产品</h2>
<div class="pageContent">
    <form method="post" action="doEditProduct.action" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
    <input type="hidden" name="product.id" value="${product.id}"/>
        <div class="pageFormContent nowrap" layoutH="97">
            <dl>
                <dt>
                    产品编号：
                </dt>
                <dd>
                    <input type="text" name="product.productid" maxlength="3" class="required" size="20" value="${product.productid }"/><span class="info">必填</span>
                </dd>
            </dl>
             <dl>
                <dt>
                    产品名称：
                </dt>
                <dd>
                    <input type="text" name="product.productName" maxlength="20" class="required" size="20" value="${product.productName }"/><span class="info">必填</span>
                </dd>
            </dl>
             <dl>
                <dt>
                    产品单位：
                </dt>
                <dd>
                    <input type="text" name="product.unit" maxlength="20" class="required" size="20" value="${product.unit }"/><span class="info">必填</span>
                </dd>
            </dl>
             <dl>
                <dt>
		排序：
                </dt>
                <dd>
                    <input type="text" name="product.orderno" maxlength="5"  size="20" value="${product.orderno }"/><span class="info">数字</span>
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
