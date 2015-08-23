<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<script type="text/javascript">

	function check(json){
			var names=eval(json);
			var checked=names["checked"];
			var items=names["items"];
if( items instanceof  Array ){
				for(var j=0;j<items.length;j++){
					if(items[j]["value"]!="on"){
				//如果是添加
				if(checked==true){
						if($("#phonesText").val()==""){
							$("#phonesText").val(items[j]["text"]);
						}else{
							if(items[j]["value"]){
								$("#phonesText").val($("#phonesText").val()+","+items[j]["text"]);
							}
						}
					if($("#phones").val()==""){
						$("#phones").val(items[j]["value"]);
					}else{
						if(items[j]["value"]){
							$("#phones").val($("#phones").val()+","+items[j]["value"]);
						}
					}
			}else{
				//如果是删除
				if($("#phonesText").val()==""){
							$("#phonesText").val(items[j]["text"]);
						}else{
							if(items[j]["value"]){
								var orginal=$("#phonesText").val();
								var result="";
								//先替换带“，”的字符，如果没有替换成功，再去替换不带","的字符
								if(orginal.replace(new RegExp(items[j]["text"]+",","gm"),"").length==orginal.length){
									result=orginal.replace(new RegExp(items[j]["text"],"gm"),"");
								}else{
									result=orginal.replace(new RegExp(items[j]["text"]+",","gm"),"");
								}
								
								$("#phonesText").val(result);
							}
						}
						
					if($("#phones").val()==""){
						$("#phones").val(items[j]["value"]);
					}else{
						if(items[j]["value"]){
								var orginal=$("#phones").val();
								var result="";
									//先替换带“，”的字符，如果没有替换成功，再去替换不带","的字符
								if(orginal.replace(new RegExp(items[j]["value"]+",","gm"),"").length==orginal.length){
									result=orginal.replace(new RegExp(items[j]["value"],"gm"),"");
								}else{
									result=orginal.replace(new RegExp(items[j]["value"]+",","gm"),"");
								}
								$("#phones").val(result);
						}
					}
				
				}
			}
		}
}else{
			if(items["value"]!="on"){
			//如果是添加
				if(checked==true){	
				if($("#phonesText").val()==""){
							$("#phonesText").val(items["text"]);
						}else{
							if(items["value"]){
								$("#phonesText").val($("#phonesText").val()+","+items["text"]);
							}
						}
						
						
			if($("#phones").val()==""){
				$("#phones").val(items["value"]);
			}else{
			if(items["value"]){
				$("#phones").val($("#phones").val()+","+items["value"]);
				}
			}
			//如果是删除
			}else{
						if($("#phonesText").val()==""){
				$("#phonesText").val(items["text"]);
			}else{
				if(items["value"]){
							var orginal=$("#phonesText").val();
								var result="";
								//先替换带“，”的字符，如果没有替换成功，再去替换不带","的字符
								if(orginal.replace(new RegExp(items["text"]+",","gm"),"").length==orginal.length){
									result=orginal.replace(new RegExp(items["text"],"gm"),"");
								}else{
									result=orginal.replace(new RegExp(items["text"]+",","gm"),"");
								}
								$("#phonesText").val(result);
				}
			}
			if($("#phones").val()==""){
						$("#phones").val(items["value"]);
					}else{
						if(items["value"]){
								var orginal=$("#phones").val();
								var result="";
									//先替换带“，”的字符，如果没有替换成功，再去替换不带","的字符
								if(orginal.replace(new RegExp(items["value"]+",","gm"),"").length==orginal.length){
									result=orginal.replace(new RegExp(items["value"],"gm"),"");
								}else{
									result=orginal.replace(new RegExp(items["value"]+",","gm"),"");
								}
								$("#phones").val(result);
						}
					}
			
			}
			}
			}
	}
</script>
<div class="pageContent" >
		<ul class="tree treeFolder treeCheck expand" oncheck="check">
			<li>
				<a tname="name" tvalue="">用户</a>
				<ul>
					<c:forEach items="${types}" var="type" varStatus="s">
						<li>
							<a tname="types" tvalue="">${type.typeName }</a>
							<ul>
							<c:forEach items="${usersMap[s.index]}" var="user">
									<li>
											<a tname="user" tvalue="${user.mobile}">${user.username }</a>
									</li>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>
				</ul>
			</li>
		</ul>
		</div>
	

