<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<h2 class="contentTitle">发送成功${zy_message.successSize }条,失败${zy_message.failSize }条.</h2>
<div class="pageContent">
<div class="pageFormContent nowrap" layoutH="65">
            <dl>
                <dt>
             	编号:
                </dt>
                <dd>
                ${zy_message.msgId }
                </dd>
            </dl>
            <dl>
                <dt>
             	内容:
                </dt>
                <dd>
               ${zy_message.msgContent }
                </dd>
            </dl>
             <dl>
                <dt>
             	发送成功:
                </dt>
                <dd>
               ${zy_message.successList }
                </dd>
            </dl>
             <dl>
                <dt>
             	发送失败:
                </dt>
                <dd>
             ${zy_message.failList }
                </dd>
            </dl>
            </div>
</div>
