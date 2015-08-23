<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>

<h2 class="contentTitle">查看申报</h2>
<div class="pageContent">
    <form method="post" action="doEditUser.action" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
             <div class="pageFormContent nowrap" layoutH="97">
            <table width="95%" cellspacing="1" cellpadding="0" border="0" bgcolor="#6396D6" align="center" class="table00">
        <tbody><tr height="24" bgcolor="#6396D6">
          <td width="28%" height="24" bgcolor="#6396D6"><font color="#ffffff"><strong>指标名称</strong></font></td>
          <td width="23%" height="24" bgcolor="#6396D6"><font color="#ffffff"><strong>一至本月累计</strong></font> </td>
          <td width="21%" height="24" bgcolor="#6396D6"><font color="#ffffff"><strong>上年同期实际</strong></font></td>
          <td width="19%" height="24" bgcolor="#6396D6"><font color="#ffffff"><strong>一至上月实际</strong></font></td>
          <td width="9%" bgcolor="#6396D6" align="center"><font color="#ffffff"><strong>单位</strong></font></td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 工业总产值（现价）</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" value="${index.gyzczv1 }" size="12" name="v01">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" value="${index.gyzczv2 }" size="12" name="s01">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" value="${index.gyzczv3 }" size="12" name="l01">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 工业增加值</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.gyzjzv1 }" id="v13" name="v13">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.gyzjzv2 }" id="s13" name="s13">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.gyzjzv3 }" id="l13" name="l13">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td height="24" bgcolor="#FFFFFF"> 其中:新产品产值</td>
          <td height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.xcpczv1 }" id="v19" name="v19">          </td>
          <td height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.xcpczv2 }" id="s19" name="s19">          </td>
          <td height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.xcpczv3 }" id="l19" name="l19">          </td>
          <td height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 工业销售产值（现价）</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.gyxsczv1 }" id="v02" name="v02">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.gyxsczv2 }" id="s02" name="s02">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.gyxsczv3 }" id="l02" name="l02">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td height="24" bgcolor="#FFFFFF">其中:出口交货值</td>
          <td height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.ckjhzv1 }" id="v20" name="v20">          </td>
          <td height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.ckjhzv2 }" id="s20" name="s20">          </td>
          <td height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.ckjhzv3 }" id="l20" name="l20">          </td>
          <td height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 产品销售收入</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxssrv1 }" id="v03" name="v03">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxssrv2}" id="s03" name="s03">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxssrv3}" id="l03" name="l03">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 产品销售成本 </td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxscbv1 }" id="v04" name="v04">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxscbv2 }" id="s04" name="s04">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxscbv3 }" id="l04" name="l04">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 产品销售费用 </td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxsfyv1 }" id="v21" name="v21">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxsfyv2 }" id="s21" name="s21">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxsfyv3 }" id="l21" name="l21">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 产品销售税金及附加</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxssjjfjv1 }" id="v22" name="v22">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxssjjfjv2 }" id="s22" name="s22">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cpxssjjfjv3 }" id="l22" name="l22">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 管理费用</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.glfyv1 }" id="v05" name="v05">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.glfyv2}" id="s05" name="s05">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.glfyv3 }" id="l05" name="l05">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 财务费用 </td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cwfyv1 }" id="v06" name="v06">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cwfyv2 }" id="s06" name="s06">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.cwfyv3 }" id="l06" name="l06">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 其中:利息支出 </td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.lxzcv1 }" id="v23" name="v23">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.lxzcv2}" id="s23" name="s23">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.lxzcv3 }" id="l23" name="l23">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 利润总额</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.lrzev1 }" id="v07" name="v07">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.lrzev2 }" id="s07" name="s07">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.lrzev3}" id="l07" name="l07">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 利税总额</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.lszev1 }" id="v08" name="v08">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.lszev2}" id="s08" name="s08">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.lszev3}" id="l08" name="l08">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 其中：应交增值税 </td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.yjzzsv1 }" id="v09" name="v09">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.yjzzsv2 }" id="s09" name="s09">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.yjzzsv3}" id="l09" name="l09">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 全部流动资产( 期末值) </td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.qbldzcv1 }" id="v10" name="v10">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.qbldzcv2 }" id="s10" name="s10">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.qbldzcv3 }" id="l10" name="l10">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 固定资产净值(期末值)</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.gdzcjzv1 }" id="v24" name="v24">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.gdzcjzv2 }" id="s24" name="s24">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.gdzcjzv3}" id="l24" name="l24">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 产成品存货 (期末值)</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.ccpchv1 }" id="v11" name="v11">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.ccpchv2 }" id="s11" name="s11">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.ccpchv3 }" id="l11" name="l11">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td width="28%" height="24" bgcolor="#FFFFFF"> 应收帐款净额(期末值)</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.yszkjev1 }" id="v12" name="v12">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.yszkjev2}" id="s12" name="s12">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.yszkjev3 }" id="l12" name="l12"></td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td height="24" bgcolor="#FFFFFF">资产合计( 期末值)</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.zchjv1 }" id="v14" name="v14">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.zchjv2 }" id="s14" name="s14">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.zchjv3 }" id="l14" name="l14">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td height="24" bgcolor="#FFFFFF">负债合计(期末值) </td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.fzhjv1 }" id="v15" name="v15">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.fzhjv2 }" id="s15" name="s15">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.fzhjv3 }" id="l15" name="l15">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td height="24" bgcolor="#FFFFFF">当年固定资产投资累计</td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.dngdzctzljv1 }" id="v16" name="v16">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.dngdzctzljv1 }" id="s16" name="s16">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.dngdzctzljv1 }" id="l16" name="l16">          </td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td height="24" bgcolor="#FFFFFF">其中：设备投资 </td>
          <td width="23%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.sbtzv1 }" id="v17" name="v17">          </td>
          <td width="21%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.sbtzv2}" id="s17" name="s17">          </td>
          <td width="19%" height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" size="12" value="${index.sbtzv3}" id="l17" name="l17"></td>
          <td width="9%" height="24" bgcolor="#FFFFFF" align="center">万元</td>
        </tr>
        <tr>
          <td height="24" bgcolor="#FFFFFF">全部从业人员人数(期末值)</td>
          <td height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" value="${index.qbcyryrsv1 }" size="12" name="v18">          </td>
          <td height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" value="${index.qbcyryrsv2 }" size="12" name="s18">          </td>
          <td height="24" bgcolor="#FFFFFF">&nbsp;
                <input readonly="readonly"  type="text" class="TxtOut" value="${index.qbcyryrsv3}" size="12" name="l18"></td>
          <td height="24" bgcolor="#FFFFFF" align="center">人</td>
        </tr>
      </tbody></table>
      						<TABLE WIDTH=100% BORDER="0" ALIGN="center" CELLPADDING="0"
									CELLSPACING="1" BGCOLOR="#6396D6">
									<TR HEIGHT="27" bgcolor="#6396D6">
										<TD WIDTH="15%" HEIGHT="24" bgcolor="#6396D6">
											<FONT COLOR="#ffffff"><STRONG>&nbsp;&nbsp;产品名称</STRONG>
											</FONT>
										</TD>
										<TD WIDTH="14%" HEIGHT="24" bgcolor="#6396D6">
											<FONT COLOR="#ffffff"><STRONG>&nbsp;&nbsp;产销情况</STRONG>
											</FONT>
										</TD>
										<TD WIDTH="7%" HEIGHT="24" bgcolor="#6396D6">
											<FONT COLOR="#ffffff"><STRONG>&nbsp;计量</STRONG> </FONT>
										</TD>
										<TD WIDTH="16%" HEIGHT="24" bgcolor="#6396D6">
											<FONT COLOR="#ffffff"><STRONG>本月实际</STRONG> </FONT>
										</TD>
										<TD WIDTH="16%" HEIGHT="24" bgcolor="#6396D6">
											<FONT COLOR="#ffffff"><STRONG>一至本月累计</STRONG> </FONT>
										</TD>
										<TD WIDTH="16%" HEIGHT="24" bgcolor="#6396D6">
											<FONT COLOR="#ffffff"><STRONG>去年本月实际</STRONG> </FONT>
										</TD>
										<TD WIDTH="16%" HEIGHT="24" bgcolor="#6396D6">
											<FONT COLOR="#ffffff"><STRONG>上年同期实际</STRONG> </FONT>
										</TD>
									</TR>
									<c:forEach items="${corpProducts}" var="product" varStatus="s">
									
									<TR height=24>
										<TD WIDTH="15%" rowspan="3" bgcolor="#FFFFFF">
										<input readonly="readonly"  type="hidden" name="product_${product.productid}" value="${corpProducts2[s.index].id }"/>
											&nbsp;${s.index+1}&nbsp;&nbsp;${product.productName}
										</TD>
										<TD WIDTH="14%" HEIGHT="24" bgcolor="#FFFFFF">
											&nbsp;生产量
										</TD>
										<TD WIDTH="7%" rowspan="3" bgcolor="#FFFFFF">
											&nbsp;&nbsp;吨
										</TD>
										<TD WIDTH="16%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].b01 }"
												name="product_b01_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].v01 }"
												name="product_v01_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].q01 }"
												name="product_q01_${product.productid}" />
										</TD>
										<TD WIDTH="20%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].s01 }"
												name="product_s01_128" />
										</TD>
									</TR>
									<TR height=24>
										<TD WIDTH="14%" HEIGHT="24" bgcolor="#FFFFFF">
											&nbsp;销售量
										</TD>
										<TD WIDTH="16%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].b02 }"
												name="product_b02_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].v02 }"
												name="product_v02_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].q02 }"
												name="product_q02_${product.productid}" />
										</TD>
										<TD WIDTH="20%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  type="text" Class=TxtOut size="10" value="${corpProducts2[s.index].s02 }"
												name="product_s02_${product.productid}" />
										</TD>
									</TR>
									<TR height=24>
										<TD WIDTH="14%" HEIGHT="24" bgcolor="#FFFFFF">
											&nbsp;期末库存量
										</TD>
										<TD WIDTH="16%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].b03 }"
												name="product_b03_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].v03 }"
												name="product_v03_${product.productid}" />
										</TD>
										<TD WIDTH="14%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].q03 }"
												name="product_q03_${product.productid}" />
										</TD>
										<TD WIDTH="20%" HEIGHT="24" align="center" bgcolor="#FFFFFF">
											<input readonly="readonly"  TYPE="text" Class=TxtOut SIZE="10" VALUE="${corpProducts2[s.index].s03 }"
												name="product_s03_${product.productid}" />
										</TD>
									</TR>
								</c:forEach>
								</TABLE>
        </div>
    </form>
</div>
