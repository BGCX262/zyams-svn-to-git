<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<h2 class="contentTitle">添加链接</h2>
<div class="pageContent">
    <form method="post" action="doAddLink.action" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone)" enctype="multipart/form-data">
        <div class="pageFormContent nowrap" layoutH="97">
            <dl>
                <dt>
                   名字：
                </dt>
                <dd>
                    <input type="text" name="link.linkname" maxlength="30" class="required" size="30"/><span class="info">必填</span>
                </dd>
            </dl>
			 <dl>
                <dt>
                   链接：
                </dt>
                <dd>
                    <input type="text" name="link.link" maxlength="100" class="required" size="100"/><span class="info">必填</span>
                </dd>
            </dl>
            <dl>
                <dt>
                    图片：
                </dt>
                <dd>
                   <input name="image" type="file"/>
                   <br/> (链接图片可以为jpg,gif,bmp,png的格式的图片，大小小于1M！)
                </dd>
            </dl>
			 <dl>
                <dt>
                    类型：
                </dt>
                <dd>
                    <select class="combox" name="link.linktype">
                        <option value="0">广告</option>
                        <option value="1">合作</option>
                    </select>
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
