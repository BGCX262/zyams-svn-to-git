<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>

<div class="pageContent" >
	<form method="post" action="doAddMessage.action" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	
	<div class="tabs" >
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>短信发送:剩余${bulance}条短信</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent" layoutH="115" style="padding:15px">
			<div class="pageFormContent" style="overflow-y:hidden;">
		
					<div  style="float:left; display:block; overflow:hidden; width:480px;height:360px;border:solid 1px #CCC; line-height:26px; background:#fff;margin-right:15px;">
					<dl style="width:100%;">
						<dt >
							内容：
						</dt>
						<dd>
							<textarea class="required" name="zy_message.msgContent" rows="10" cols="40"></textarea>
						</dd>
					</dl>
					<dl style="margin-top:150px;width:100%;" >
						<dt >
							收件人：
						</dt>
						<dd>
							<textarea class="required" name="phonesText" rows="10" cols="40" id="phonesText" readonly="readonly"></textarea>
								<input name="phones" value="" type="hidden" id="phones"/>
						</dd>
					</dl>
					</div>
				 	<div layoutH="100" style="float:left; display:block; overflow:hidden; width:500px; border:solid 1px #CCC; line-height:21px; background:#fff">
					<h3 style="height:30px;line-height:30px;padding-left:15px;">选择收件人:</h3>
				<jsp:include flush="true" page="selectUsers.jsp"></jsp:include>
					</div>	
			</div>			 
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
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
