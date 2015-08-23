<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*;"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>信息维护</title>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		<!--[if IE 6]>
	<script type="text/javascript" src="js/DD_belatedPNG.js" ></script>
	<script type="text/javascript">
	DD_belatedPNG.fix('img, #searchBox, #menu ul li a, #box1, #box2Left, #box2Middle, #box2Right, #box3Right, #sideBottom, ul#list8 li, #sideTop, #mainRightTop, #mainRightBottom, #mainContent, ');
	</script>
<![endif]-->
<style type="text/css">
table{font-size:12px;}
input,select{border:1px solid #ccc;}
</style>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/Scroll.js"></script>
		<script type="text/javascript" src="js/Focus.js"></script>
		<script type="text/javascript" src="js/accordian.pack.js"></script>
		<script language="javascript">
		var jq = jQuery.noConflict();
function qiehuan(num){

		for(var id = 0;id<=9;id++)
		{
			if(id==num)
			{
				if(document.getElementById("qh_con"+id)){
					document.getElementById("qh_con"+id).style.display="block";
				}
				if(document.getElementById("mynav"+id)){
					document.getElementById("mynav"+id).className="nav_on";
				}
				
			}
			else
			{
				if(document.getElementById("qh_con"+id)){
					document.getElementById("qh_con"+id).style.display="none";
				}
				if(document.getElementById("mynav"+id)){
				document.getElementById("mynav"+id).className="";
				}
			}
		}
	}
	function subEdit(){
		document.corpForm.submit();
	}
	
</script>
	</head>
	<body
		onload="new Accordian('basic-accordian',10,'header_highlight'); new Accordian('basic-accordian2',10,'header_highlight2'); new Accordian('basic-accordian3',10,'header_highlight3'); ">

		<jsp:include page="top.jsp"></jsp:include>
		<!--header over-->
		<!--main start-->
		<div id="main">
			<div id="mainLeft">
				<jsp:include page="mainLeft.jsp"></jsp:include>
			</div>
			<div id="mainRight">
				<div id="mainRightTop">
					您所在当前的位置：
					<a href="index.action">首页</a>>
					<span>${loginCorp.name}信息维护</span>
				</div>
				<div id="mainContent">
					<div id="content">
						<!--table start-->
						<form action="editCorp.action" name="corpForm" method="post">
						<input type="hidden" name="corporation.rowid" value="${corporation.rowid }"/>
							<div align="left">
								<table width="580" cellspacing="1" cellpadding="0" border="0"
									align="center" >
									<tbody>
										<tr>
											<td width="581" height="25" align="right">
												<span class="STYLE1">&nbsp; <input type="submit"
														style="width:60px;height:20px;line-height:20px;background-color:#D40007;color:#fff;border:1px solid #fff;" class="ButtonCss" id="btnOK"
														onclick="subEdit();" value="提交保存" name="btnOK" /> </span>
											</td>
										</tr>
									</tbody>
								</table>
								<table width="580" cellspacing="1" cellpadding="0" border="0"
									bgcolor="#D40007" align="center">
									<tbody>
										<tr>
											<td width="581" height="25">
												<span class="STYLE1" style="color:#fff;">&nbsp;企业信息</span>
											</td>
										</tr>
									</tbody>
								</table>
								<table width="580" cellspacing="1" cellpadding="0" border="0"
									bgcolor="#D40007" align="center">

									<tbody>
										<tr>
											<td width="106" bgcolor="#FFFFFF" align="right"
												style="height: 25px">
												企业编号：
											</td>
											<td width="501" bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text"
													style="width:252px;background-color:#E0E0E0" id="txtID"
													readonly="readonly" value="${corporation.id}"
													name="corporation.id" />
												企业编号一旦新增，则无法修改
											</td>
										</tr>
										<tr>
											<td height="25" bgcolor="#FFFFFF" align="right">
												企业登录密码：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" id="txtPassword"
													value="${corporation.password }"
													name="corporation.password" />
												<span style="color:Red;visibility:hidden;"
													id="RequiredFieldValidator1">请输入企业登陆密码</span>
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												企业名称：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" style="width:252px;" id="txtNAME"
													value="${corporation.name }" name="corporation.name" />
												<span style="color:Red;visibility:hidden;" initialvalue=""
													id="RequiredFieldValidator2">请输入企业名称</span>
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												税务登记证号：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" id="txtTaxNumber"
													name="corporation.taxnumber"
													value="${corporation.taxnumber }" />
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												所在区域：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
													&nbsp;						
													<select name="corporation.area">
													<c:forEach items="${dictionarys}" var="dictionary">
														<c:set value="${dictionary}" var="item" />
														<c:if test="${item.name == corporation.area}">
															<%
															String select = "selected=\"selected\"";
															%>
															<option value="${item.code}" <%=select%>>
																${item.name}
															</option>
														</c:if>
														<c:if test="${(item.name != corporation.area)}">
															<option value="${item.code}">
																${item.name}
															</option>
														</c:if>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												邮编：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" name="corporation.postcode" size="50"
													value="${corporation.postcode }" />
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												地址：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" name="corporation.address" size="50"
													value="${corporation.address }" />
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												联系人：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" name="corporation.workername" size="50"
													value="${corporation.workername }" />
												<span style="color:Red;visibility:hidden;" initialvalue=""
													id="RequiredFieldValidator4">请输入联系人</span>
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												联系电话：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" name="corporation.tel" size="50"
													value="${corporation.tel }" />
												<span style="color:Red;visibility:hidden;"
													id="RequiredFieldValidator5">请输入联系电话</span>
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												手机：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" name="corporation.mobile" size="50"
													value="${corporation.mobile }" />
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												邮件：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" name="corporation.email" size="50"
													value="${corporation.email }" />
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												传真：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" name="corporation.faxes" size="50"
													value="${corporation.faxes }" />
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												网址：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" name="corporation.weburl" size="50"
													value="${corporation.weburl }" />
											</td>
										</tr>

										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												开户行：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" name="corporation.bak1" size="50"
													value="${corporation.bak1 }" />
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												银行帐号：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<input type="text" name="corporation.bak2" size="50"
													value="${corporation.bak2 }" />
											</td>
										</tr>
										<tr>
											<td height="25" bgcolor="#FFFFFF" align="right">
												地区：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<select name="corporation.areaid">
													<c:forEach items="${areas}" var="area">
														<c:set value="${area}" var="item" />
														<c:if test="${item.code == corporation.areaid}">
															<%
															String select1 = "selected=\"selected\"";
															%>
															<option value="${item.code}" <%=select1%>>
																${item.name}
															</option>
														</c:if>
														<c:if test="${item.code != corporation.areaid}">
															<option value="${item.code}">
																${item.name}
															</option>
														</c:if>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td height="25" bgcolor="#FFFFFF" align="right">
												行业：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<select name="corporation.tradeid">
													<c:forEach items="${trades}" var="teade">
														<c:set value="${teade}" var="item"></c:set>
														<c:if test="${item.code == corporation.tradeid}">
															<option value="${item.code}" selected="selected">
																${item.name}
															</option>
														</c:if>
														<c:if test="${item.code != corporation.tradeid}">
															<option value="${item.code}">
																${item.name}
															</option>
														</c:if>
													</c:forEach>
												</select>

											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												是否重点骨干企业：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<select name="corporation.is50">
													<c:if test="${corporation.is50 == '是'}">
														<option value="是" selected="selected">
															是
														</option>
														<option value="否">
															否
														</option>
													</c:if>
													<c:if test="${corporation.is50 != '是'}">
														<option value="是">
															是
														</option>
														<option value="否" selected="selected">
															否
														</option>
													</c:if>
												</select>
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 25px">
												是否专辑特新：
											</td>
											<td bgcolor="#FFFFFF" style="height: 25px">
												&nbsp;
												<select disabled="disabled" id="txtIsNew" name="txtIsNew">
													<option value="是" selected="selected">
														是
													</option>
													<option value="否">
														否
													</option>

												</select>
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 100px">
												企业介绍：
											</td>
											<td bgcolor="#FFFFFF" style="height: 100px">
												&nbsp;
												<textarea type="text" name="corporation.infor" cols=45
													rows=5>${corporation.infor }</textarea>
											</td>
										</tr>
										<tr>
											<td bgcolor="#FFFFFF" align="right" style="height: 70px">
												备注：
											</td>
											<td bgcolor="#FFFFFF" style="height: 70px">
												&nbsp;
												<textarea type="text" name="corporation.remark" cols=45
													rows=5>${corporation.remark }</textarea>
											</td>
										</tr>
									</tbody>
								</table>
								<br />
								<table width="580" cellspacing="1" cellpadding="0" border="0"
									bgcolor="#D40007" align="center">

									<tbody>
										<tr>
											<td width="581" height="25">
												<span class="STYLE1" style="color:#fff;">&nbsp;产品信息</span>
											</td>
										</tr>
									</tbody>
								</table>
								<table width="580" cellspacing="1" cellpadding="0" border="0"
									bgcolor="#EBEBEB" align="center">
									<tbody>
										<tr>
											<td valign="top" bgcolor="#FFFFFF">
												<!--div  style="overflow-y:scroll;overflow-x:hidden; width:100%; height:100%;"-->
												<table width="100%" cellspacing="0" cellpadding="0"
													border="0" bgcolor="#D40007" align="center">
													<tbody>
														<tr>
															<td bgcolor="#FFFFFF">
																&nbsp;
																<table border="0" style="width:100%;" id="txtPRODUCT">
																	<tbody>
																		<c:forEach items="${product}" var="itemall"
																			varStatus="s">
																			<c:if test="${s.index%5==0}">
																				<tr>
																			</c:if>
																			<c:set value="0" var="flag" />

																			<c:forEach items="${corporactonproduct}" var="pro">

																				<c:if test="${itemall.productid==pro.productid}">

																					<td>
																						<span > <input
																								type="checkbox" checked="checked"
																								name="productIds"
																								value="${itemall.productid}" />
																							<label>
																								${itemall.productName}
																							</label> </span>
																					</td>

																					<c:set value="1" var="flag" />

																				</c:if>

																			</c:forEach>

																			<c:if test="${flag=='0'}">
																				<td>
																					<span > <input
																							type="checkbox"
																							name="productIds"
																							value="${itemall.productid}" />
																						<label>
																							${itemall.productName}
																						</label> </span>
																				</td>
																			</c:if>
																			<c:if test="${s.index%5==0}">
																				</tr>
																			</c:if>
																		</c:forEach>

																	</tbody>
																</table>

																<br />
																<br />
															</td>
														</tr>
													</tbody>
												</table>
												<!--/div-->
											</td>
										</tr>
									</tbody>
								</table>
								<table width="580px;" cellspacing="0" cellpadding="0" border="0"
									align="center">
									<tbody>
										<tr>
											<td valign="bottom" align="center" style="height: 35px"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</form>
						<!--table over-->
					</div>
				</div>
				<div id="mainRightBottom"></div>
			</div>
			<div class="clear"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
		<script type="text/javascript">
new slider({id:'slider'})
</script>
	</body>
</html>
