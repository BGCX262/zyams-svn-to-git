<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<c:if test="${not empty singleFlag}">
	<h2 class="contentTitle">单独页面文章</h2>
</c:if>
<c:if test="${empty singleFlag}">
	<h2 class="contentTitle">编辑新闻</h2>
</c:if>

<div class="pageContent">
<c:if test="${zyArticle.typeId>0}">
	<form method="post" action="doEditArticle.action" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone)">
</c:if>
<c:if test="${empty zyArticle.typeId}">
	<form method="post" action="doAddArticle.action" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone)">
</c:if>
    
    <input type="hidden" name="zyArticle.articleId" value="${zyArticle.articleId}"/>
        <input type="hidden" name="zyArticle.createTime" value="${zyArticle.createTime}"/>
                <input type="hidden" name="zyArticle.userId" value="${zyArticle.userId}"/>
        <div class="pageFormContent nowrap" layoutH="97">
            <dl>
                <dt>
                    标题：
                </dt>
                <dd>
                    <input type="text" name="zyArticle.title" maxlength="200" class="required" size="100" value="${zyArticle.title }"/><span class="info">必填</span>
                </dd>
            </dl>
            <dl>
                <dt>
                    来源自：
                </dt>
                <dd>
                    <input type="text" name="zyArticle.comeFrom" size="100" value="${zyArticle.comeFrom }"/>
                </dd>
            </dl>
            <dl>
                <dt>
                    部门：
                </dt>
                <dd>
                    <select class="combox" name="zyArticle.partmentId">
                    	<option value="0">选择部门</option>
                    	<c:forEach items="${partments}" var="part">
                        <option value="${part.partmentId}" ${part.partmentId eq zyArticle.partmentId?"selected=selected":""}>${part.partmentName }</option>
                      </c:forEach>
                    </select>
                </dd>
            </dl>
            <c:if test="${empty singleFlag}">
            	<dl>
					<dt>
								栏目：
							</dt>
							<dd>
								<input name="zyArticle.typeId" value="${zyArticle.typeId }" type="hidden" />
								<input class="required" name="zyArticle.typeName" type="text" value="${articleTypeName}"
									readonly />
								<a class="btnLook" href="lookupTypes.action"  rel="dialog2"
									lookupGroup="zyArticle">选择 </a>
							</dd>
						</dl>
            </c:if>
     		<c:if test="${not empty singleFlag}">
     		<input type="hidden" name="zyArticle.typeId" value="${typeId}"/>
     		</c:if>		
            <dl>
                <dt>
                    新闻内容：
                </dt>
                <dd>
                    <div class="unit">
                        <textarea class="editor" name="zyArticle.content" rows="15" cols="80" tools="simple">${zyArticle.content }</textarea>
                    </div>
                </dd>
            </dl>
            <dl>
                <dt>
                    图片新闻：
                </dt>
                <dd>
                        <input type="radio" name="zyArticle.imgFlag" value="0" ${"0" eq zyArticle.imgFlag?"checked":""} />是
                        <input type="radio" name="zyArticle.imgFlag" value="1" ${"1" eq zyArticle.imgFlag?"checked":""} />否
                </dd>
            </dl>
            <dl>
				<dt>
					首页摘要图：
				</dt>
				<dd>
					<input type="text" name="zyArticle.imgUrl" id="imageUrl" size="100" readonly="readonly" value="${zyArticle.imgUrl }"/>
					<b><a href="selectPicture.jsp" target="dialog" rel="selectPicture" width="640" height="180">点击上传图片</a></b>
					<span class="info">如果不是图片新闻，可以忽略</span>
				</dd>
			</dl>
            <dl>
                <dt>
                    关键字：
                </dt>
                <dd>
                    <input type="text" name="zyArticle.keywords" size="100" value="${ zyArticle.keywords}"/><span class="info">请以逗号分割</span>
                </dd>
            </dl>
            <dl>
                <dt>
                    简介：
                </dt>
                <dd>
                    <textarea name="zyArticle.description" cols="80" rows="3">${zyArticle.description }</textarea>
                </dd>
            </dl>
            <dl>
                <dt>
                    备注：
                </dt>
                <dd>
                    <textarea name="zyArticle.remarks" cols="80" rows="2">${zyArticle.remarks}</textarea>
                </dd>
            </dl>
           
            <dl>
                <dt>
                   发布到政务接口：
                </dt>
                <dd>
                     <input type="checkbox" name="zyArticle.innerFlag" ${"0" eq zyArticle.innerFlag?"checked=checked":""} value="0" />   
                        是
                </dd>
            </dl>
                        <input type="hidden" name="zyArticle.status" value="${zyArticle.status}" />
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
