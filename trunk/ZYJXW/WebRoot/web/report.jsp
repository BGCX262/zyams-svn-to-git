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
		<title>企业申报</title>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		<!--[if IE 6]>
	<script type="text/javascript" src="js/DD_belatedPNG.js" ></script>
	<script type="text/javascript">
	DD_belatedPNG.fix('img, #searchBox, #menu ul li a, #box1, #box2Left, #box2Middle, #box2Right, #box3Right, #sideBottom, ul#list8 li, #sideTop, #mainRightTop, #mainRightBottom, #mainContent, ');
	</script>
<![endif]-->
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
	function submitForm(){
		document.indexForm.submit();
	}
	
		function subSearch(){
		document.indexForm1.submit();
	}
</script>
	</head>
	<body
		onload="new Accordian('basic-accordian',10,'header_highlight'); new Accordian('basic-accordian2',10,'header_highlight2'); new Accordian('basic-accordian3',10,'header_highlight3'); ">

	
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
					<span>${loginCorp.name}数据上报</span>
				</div>
				<div id="mainContent">
					<div id="content">
						<!--table start-->
						<div id="zyTable">
							<form action="searchIndex.action" method="post" name="indexForm1">
								<TABLE WIDTH="100%" BORDER="0" ALIGN="center" CELLPADDING="0"
									CELLSPACING="0">
									<TR>
										<TD WIDTH="26%" HEIGHT="30">
											<LABEL>
												<%
													Calendar cal = Calendar.getInstance();
													int year = cal.get(Calendar.YEAR);
													int month = cal.get(Calendar.MONTH);
													int day = cal.get(Calendar.DAY_OF_MONTH);

													String ms = "";
													if (month + 1 < 10) {

														ms = "0" + (month + 1);
													} else {
														ms = (month + 1) + "";
													}
													String ds = "";
													if (day < 10) {
														ds = "0" + (day);
													} else {
														ds = (day) + "";
													}
													String currentDate = year + "-" + ms + "-" + ds;
												%>
												今天日期是：
												<%=currentDate%>
											</LABEL>
											<c:set var="curYear" value="<%=year%>" />
											<c:set var="curMonth" value="<%=month%>" />
											<c:set var="today" value="<%=day%>" />
										</TD>
										<TD WIDTH="74%" ALIGN="right">
											<LABEL>
												<SELECT name="year" ID="yyyy">
													<c:forEach begin="1970" end="2099" step="1" var="year">
														<c:choose>
															<c:when test="${year1==null||year1==0}">
																<option value="${year }" ${year eq
																	curYear?"selected=selected":""}>
															</c:when>
															<c:otherwise>
																<option value="${year }" ${year eq
																	year1?"selected=selected":""}>
															</c:otherwise>
														</c:choose>
														${year }
													</option>
													</c:forEach>
												</SELECT>
												<c:choose>
												<c:when test="${today<=15}">
												<SELECT name="month" ID="mm">
													<c:forEach begin="1" end="12" step="1" var="month">
														<c:choose>
															<c:when test="${month1==null||month1==0}">
																<option value="${month}" ${month
																	eq (curMonth)?"selected=selected":""}>
															</c:when>
															<c:otherwise>
																<option value="${month }" ${month eq
																	(month1-1)?"selected=selected":""}>
															</c:otherwise>
														</c:choose>
														${month-1}
													</option>
													</c:forEach>
												</SELECT>
												</c:when>
																<c:otherwise>
																						<SELECT name="month" ID="mm">
													<c:forEach begin="1" end="12" step="1" var="month">
														<c:choose>
															<c:when test="${month1==null||month1==0}">
																<option value="${month}" ${month
																	eq (curMonth+1)?"selected=selected":""}>
															</c:when>
															<c:otherwise>
																<option value="${month }" ${month eq
																	month1?"selected=selected":""}>
															</c:otherwise>
														</c:choose>
														${month }
													</option>
													</c:forEach>
												</SELECT>
																</c:otherwise>
															</c:choose>
											</LABEL>
											&nbsp;
											<INPUT TYPE="button" NAME="btnCreatEmpty2"
												onClick="javascript:subSearch();" ID="btnCreatEmpty2"
												VALUE="查询" class="zyBtn" />
											<INPUT TYPE="button" NAME="btnCreatEmpty"
												onClick="javacript:subcreat();" style='display:none'
												ID="btnCreatEmpty" VALUE="创建空表 class=" zyBtn""/>
											&nbsp;
											<INPUT type="button" NAME="btnpost"
												onClick="javacript:submitForm();" ID="btnpost" VALUE="保存数据"
												class="zyBtn" />
											&nbsp;
											<INPUT style='display:none' type="button" NAME="btnpost"
												onClick="javacript:submitForm();" ID="btnpost" VALUE="修改数据"
												class="zyBtn" />
										</TD>
									</TR>
								</TABLE>
							</form>
							<div class="clear"></div>
							<form action="addIndex.action" method="post" name="indexForm">

								<c:choose>
									<c:when test="${year1==null||year1==0}">
											<input type="hidden" name="index.year" value="${curYear }" />
									</c:when>
									<c:otherwise>
										<input type="hidden" name="index.year" value="${year }" />
									</c:otherwise>
								</c:choose>
								
								<c:choose>
													<c:when test="${month1==null||month1==0}">
												<input type="hidden" name="index.month" value="${curMonth +1}" />
													</c:when>
													<c:otherwise>
													<input type="hidden" name="index.month" value="${month }" />
													</c:otherwise>
												</c:choose>
								
								<input  type="hidden" name="index.id" value="${index.id }"/>
									<input  type="hidden" name="index.corporationid" value="${index.corporationid }"/>
								<table width="95%" cellspacing="1" cellpadding="0" border="0"
									bgcolor="#D40007" align="center" class="table00">
									<tbody>
										<tr height="24" bgcolor="#D40007">
											<td width="28%" height="24" bgcolor="#D40007">
												<font color="#ffffff"><strong>指标名称</strong> </font>
											</td>
											<td width="23%" height="24" bgcolor="#D40007">
												<font color="#ffffff"><strong>一至本月累计</strong> </font>
											</td>
											<td width="21%" height="24" bgcolor="#D40007">
												<font color="#ffffff"><strong>上年同期实际</strong> </font>
											</td>
											<td width="19%" height="24" bgcolor="#D40007">
												<font color="#ffffff"><strong>一至上月实际</strong> </font>
											</td>
											<td width="9%" bgcolor="#D40007" align="center">
												<font color="#ffffff"><strong>单位</strong> </font>
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												工业总产值（现价）
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" value="${index.gyzczv1 }"
													size="12" name="index.gyzczv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" value="${index.gyzczv2 }"
													size="12" name="index.gyzczv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" value="${index.gyzczv3 }"
													size="12" name="index.gyzczv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												工业增加值
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.gyzjzv1 }" id="v13" name="index.gyzjzv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.gyzjzv2 }" id="s13" name="index.gyzjzv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.gyzjzv3 }" id="l13" name="index.gyzjzv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td height="24" bgcolor="#FFFFFF">
												其中:新产品产值
											</td>
											<td height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.xcpczv1 }" id="v19" name="index.xcpczv1" />
											</td>
											<td height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.xcpczv2 }" id="s19" name="index.xcpczv2" />
											</td>
											<td height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.xcpczv3 }" id="l19" name="index.xcpczv3" />
											</td>
											<td height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												工业销售产值（现价）
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.gyxsczv1 }" id="v02" name="index.gyxsczv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.gyxsczv2 }" id="s02" name="index.gyxsczv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.gyxsczv3 }" id="l02" name="index.gyxsczv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td height="24" bgcolor="#FFFFFF">
												其中:出口交货值
											</td>
											<td height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.ckjhzv1 }" id="v20" name="index.ckjhzv1" />
											</td>
											<td height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.ckjhzv2 }" id="s20" name="index.ckjhzv2" />
											</td>
											<td height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.ckjhzv3 }" id="l20" name="index.ckjhzv3" />
											</td>
											<td height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												产品销售收入
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxssrv1 }" id="v03" name="index.cpxssrv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxssrv2}" id="s03" name="index.cpxssrv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxssrv3}" id="l03" name="index.cpxssrv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												产品销售成本
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxscbv1 }" id="v04" name="index.cpxscbv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxscbv2 }" id="s04" name="index.cpxscbv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxscbv3 }" id="l04" name="index.cpxscbv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												产品销售费用
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxsfyv1 }" id="v21" name="index.cpxsfyv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxsfyv2 }" id="s21" name="index.cpxsfyv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxsfyv3 }" id="l21" name="index.cpxsfyv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												产品销售税金及附加
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxssjjfjv1 }" id="v22"
													name="index.cpxssjjfjv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxssjjfjv2 }" id="s22"
													name="index.cpxssjjfjv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cpxssjjfjv3 }" id="l22"
													name="index.cpxssjjfjv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												管理费用
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.glfyv1 }" id="v05" name="index.glfyv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.glfyv2}" id="s05" name="index.glfyv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.glfyv3 }" id="l05" name="index.glfyv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												财务费用
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cwfyv1 }" id="v06" name="index.cwfyv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cwfyv2 }" id="s06" name="index.cwfyv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.cwfyv3 }" id="l06" name="index.cwfyv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												其中:利息支出
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.lxzcv1 }" id="v23" name="index.lxzcv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.lxzcv2}" id="s23" name="index.lxzcv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.lxzcv3 }" id="l23" name="index.lxzcv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												利润总额
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.lrzev1 }" id="v07" name="index.lrzev1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.lrzev2 }" id="s07" name="index.lrzev2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.lrzev3}" id="l07" name="index.lrzev3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												利税总额
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.lszev1 }" id="v08" name="index.lszev1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.lszev2}" id="s08" name="index.lszev2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.lszev3}" id="l08" name="index.lszev3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												其中：应交增值税
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.yjzzsv1 }" id="v09" name="index.yjzzsv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.yjzzsv2 }" id="s09" name="index.yjzzsv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.yjzzsv3}" id="l09" name="index.yjzzsv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												全部流动资产( 期末值)
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.qbldzcv1 }" id="v10" name="index.qbldzcv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.qbldzcv2 }" id="s10" name="index.qbldzcv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.qbldzcv3 }" id="l10" name="index.qbldzcv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												固定资产净值(期末值)
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.gdzcjzv1 }" id="v24" name="index.gdzcjzv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.gdzcjzv2 }" id="s24" name="index.gdzcjzv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.gdzcjzv3}" id="l24" name="index.gdzcjzv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												产成品存货 (期末值)
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.ccpchv1 }" id="v11" name="index.ccpchv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.ccpchv2 }" id="s11" name="index.ccpchv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.ccpchv3 }" id="l11" name="index.ccpchv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td width="28%" height="24" bgcolor="#FFFFFF">
												应收帐款净额(期末值)
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.yszkjev1 }" id="v12" name="index.yszkjev1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.yszkjev2}" id="s12" name="index.yszkjev2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.yszkjev3 }" id="l12" name="index.yszkjev3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td height="24" bgcolor="#FFFFFF">
												资产合计( 期末值)
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.zchjv1 }" id="v14" name="index.zchjv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.zchjv2 }" id="s14" name="index.zchjv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.zchjv3 }" id="l14" name="index.zchjv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td height="24" bgcolor="#FFFFFF">
												负债合计(期末值)
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.fzhjv1 }" id="v15" name="index.fzhjv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.fzhjv2 }" id="s15" name="index.fzhjv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.fzhjv3 }" id="l15" name="index.fzhjv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td height="24" bgcolor="#FFFFFF">
												当年固定资产投资累计
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.dngdzctzljv1 }" id="v16"
													name="index.dngdzctzljv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.dngdzctzljv1 }" id="s16"
													name="index.dngdzctzljv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.dngdzctzljv1 }" id="l16"
													name="index.dngdzctzljv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td height="24" bgcolor="#FFFFFF">
												其中：设备投资
											</td>
											<td width="23%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.sbtzv1 }" id="v17" name="index.sbtzv1" />
											</td>
											<td width="21%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.sbtzv2}" id="s17" name="index.sbtzv2" />
											</td>
											<td width="19%" height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut" size="12"
													value="${index.sbtzv3}" id="l17" name="index.sbtzv3" />
											</td>
											<td width="9%" height="24" bgcolor="#FFFFFF" align="center">
												万元
											</td>
										</tr>
										<tr>
											<td height="24" bgcolor="#FFFFFF">
												全部从业人员人数(期末值)
											</td>
											<td height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut"
													value="${index.qbcyryrsv1 }" size="12"
													name="index.qbcyryrsv1" />
											</td>
											<td height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut"
													value="${index.qbcyryrsv2 }" size="12"
													name="index.qbcyryrsv2" />
											</td>
											<td height="24" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" class="TxtOut"
													value="${index.qbcyryrsv3}" size="12"
													name="index.qbcyryrsv3" />
											</td>
											<td height="24" bgcolor="#FFFFFF" align="center">
												人
											</td>
										</tr>
									</tbody>
								</table>
								<div class="clear"></div>
								<TABLE WIDTH=100% BORDER="0" ALIGN="center" CELLPADDING="0"
									CELLSPACING="1" BGCOLOR="#D40007">
									<TR HEIGHT="27" bgcolor="#D40007">
										<TD WIDTH="15%" HEIGHT="24" bgcolor="#D40007">
											<FONT COLOR="#ffffff"><STRONG>&nbsp;&nbsp;产品名称</STRONG>
											</FONT>
										</TD>
										<TD WIDTH="14%" HEIGHT="24" bgcolor="#D40007">
											<FONT COLOR="#ffffff"><STRONG>&nbsp;&nbsp;产销情况</STRONG>
											</FONT>
										</TD>
										<TD WIDTH="7%" HEIGHT="24" bgcolor="#D40007">
											<FONT COLOR="#ffffff"><STRONG>&nbsp;计量</STRONG> </FONT>
										</TD>
										<TD WIDTH="16%" HEIGHT="24" bgcolor="#D40007">
											<FONT COLOR="#ffffff"><STRONG>本月实际</STRONG> </FONT>
										</TD>
										<TD WIDTH="16%" HEIGHT="24" bgcolor="#D40007">
											<FONT COLOR="#ffffff"><STRONG>一至本月累计</STRONG> </FONT>
										</TD>
										<TD WIDTH="16%" HEIGHT="24" bgcolor="#D40007">
											<FONT COLOR="#ffffff"><STRONG>去年本月实际</STRONG> </FONT>
										</TD>
										<TD WIDTH="16%" HEIGHT="24" bgcolor="#D40007">
											<FONT COLOR="#ffffff"><STRONG>上年同期实际</STRONG> </FONT>
										</TD>
									</TR>
									<c:forEach items="${corpProducts}" var="product" varStatus="s">
									
									<TR height=24>
										<TD WIDTH="15%" rowspan="3" bgcolor="#FFFFFF">
										<input type="hidden" name="product_${product.productid}" value="${corpProducts2[s.index].id }"/>
											&nbsp;${s.index+1}&nbsp;&nbsp;${product.productName}
										</TD>
										<TD WIDTH="14%" HEIGHT="24" bgcolor="#FFFFFF">
											&nbsp;生产量
										</TD>
										<TD WIDTH="7%" rowspan="3" bgcolor="#FFFFFF">
											&nbsp;&nbsp;吨
										</TD>
										<TD WIDTH="16%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<INPUT TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].b01 }"
												name="product_b01_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<INPUT TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].v01 }"
												name="product_v01_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<INPUT TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].q01 }"
												name="product_q01_${product.productid}" />
										</TD>
										<TD WIDTH="20%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<INPUT TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].s01 }"
												name="product_s01_128" />
										</TD>
									</TR>
									<TR height=24>
										<TD WIDTH="14%" HEIGHT="24" bgcolor="#FFFFFF">
											&nbsp;销售量
										</TD>
										<TD WIDTH="16%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<INPUT TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].b02 }"
												name="product_b02_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<INPUT TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].v02 }"
												name="product_v02_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<INPUT TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].q02 }"
												name="product_q02_${product.productid}" />
										</TD>
										<TD WIDTH="20%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input type="text" Class=TxtOut size="10" value="${corpProducts2[s.index].s02 }"
												name="product_s02_${product.productid}" />
										</TD>
									</TR>
									<TR height=24>
										<TD WIDTH="14%" HEIGHT="24" bgcolor="#FFFFFF">
											&nbsp;期末库存量
										</TD>
										<TD WIDTH="16%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<INPUT TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].b03 }"
												name="product_b03_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<INPUT TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].v03 }"
												name="product_v03_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<INPUT TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].q03 }"
												name="product_q03_${product.productid}" />
										</TD>
										<TD WIDTH="20%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<INPUT TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].s03 }"
												name="product_s03_${product.productid}" />
										</TD>
									</TR>
								</c:forEach>
								</TABLE>
							</form>
							<div class="clear"></div>
						</div>
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
