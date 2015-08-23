<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix ="s" uri = "/struts-tags" %> 
<script type="text/javascript">
	function success(imageUrl){
		$("#imageUrl").val("../"+imageUrl);
		alert("上传图片成功");
	}
	
	function fail(msg){
		alert(msg);
	}
</script>
<div class="pageFormContent nowrap" layoutH="108">
	<div class="selectPciture">
		<b id="msg"></b>
		<form action="uploadPicture.action" method="post" enctype ="multipart/form-data" target="hiddenIframe">
			<s:file name="imageFile"/>
			<s:submit  value="上传"/>
			
			<iframe id="hiddenIframe" name="hiddenIframe" style="display:none;"></iframe>
		</form>
	</div>
</div>
<div class="formBar">
		<ul>
			<li>
				<div class="button">
					<div class="buttonContent">
						<button class="close" type="button">
							关闭
						</button>
					</div>
				</div>
			</li>
		</ul>
	</div>


