<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<script type="text/javascript">
function keydown(){
	  document.ff.input2.value=document.ff.input1.value;
	}
</script>
<h2 class="contentTitle">
	添加企业
</h2>
<div class="pageContent">
	<form method="post" action="doAddCorporation.action" name="ff" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>
					企业编号：
				</dt>
				<dd>
					<input type="text" name="corporation.id" maxlength="20" id="input1" class="required" size="50" onkeyup="keydown()"/> <span class="info">必填</span>
					<span class="info">必填,企业编号一旦新增，则无法修改，请注意企业编号的唯一性</span>
					<input type="hidden" name="corporationProduct.corportationid" id="input2"/> 
				</dd>
			</dl>
			<dl>
				<dt>
					企业登录密码：
				</dt>
				<dd>
					<input type="text" name="corporation.password" size="50" class="required"/>
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>
					企业名称：
				</dt>
				<dd>
					<input type="text" name="corporation.name" size="50" class="required"/>
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>
					税务登记证号：
				</dt>
				<dd>
					<input type="text" name="corporation.taxnumber" size="50" />
				</dd>
			</dl>
			<dl>
				<dt>
					所在区域：
				</dt>
				<dd>
					<select name="corporation.area">
					<c:forEach items="${dictionarys}" var="dictionary">
					<c:set value="${ dictionary}" var="item"></c:set>
               	 		<option value="${item.name}"> ${item.name}</option>
            		</c:forEach>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>
					排序：
				</dt>
				<dd>
					<input type="text" name="corporation.byorder" size="50" />
				</dd>
			</dl>
			<dl>
				<dt>
					邮编：
				</dt>
				<dd>
					<input type="text" name="corporation.postcode" size="50" />
					
				</dd>
			</dl>
			<dl>
				<dt>
					地址：
				</dt>
				<dd>
					<input type="text" name="corporation.address" size="50" />
					
				</dd>
			</dl>
			<dl>
				<dt>
					联系人：
				</dt>
				<dd>
					<input type="text" name="corporation.workername" size="50" />
					
				</dd>
			</dl>
			<dl>
				<dt>
					联系电话：
				</dt>
				<dd>
					<input type="text" name="corporation.tel" size="50" />
					
				</dd>
			</dl>
			<dl>
				<dt>
					手机：
				</dt>
				<dd>
					<input type="text" name="corporation.mobile" size="50" />
					
				</dd>
			</dl>
			<dl>
				<dt>
					邮件：
				</dt>
				<dd>
					<input type="text" name="corporation.email" size="50" />
					
				</dd>
			</dl>
			<dl>
				<dt>
					传真：
				</dt>
				<dd>
					<input type="text" name="corporation.faxes" size="50" />
					
				</dd>
			</dl>
			<dl>
				<dt>
					网址：
				</dt>
				<dd>
					<input type="text" name="corporation.weburl" size="50" />
					
				</dd>
			</dl>
			<dl>
				<dt>
					开户行：
				</dt>
				<dd>
					<input type="text" name="corporation.bak1" size="50" />
					
				</dd>
			</dl>
			<dl>
				<dt>
					银行帐号：
				</dt>
				<dd>
					<input type="text" name="corporation.bak2" size="50" />
				</dd>
			</dl>
			<dl>
				<dt>
					地区：
				</dt>
				<dd>
					<select name="corporation.areaid">
					<c:forEach items="${areas}" var="area">
					<c:set value="${ area}" var="item"></c:set>
               	 		<option value="${item.code}"> ${item.name}</option>
            		</c:forEach>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>
					行业：
				</dt>
				<dd>
					<select name="corporation.tradeid">
					<c:forEach items="${trades}" var="teade">
					<c:set value="${ teade}" var="item"></c:set>
               	 		<option value="${item.code}"> ${item.name}</option>
            		</c:forEach>
					</select>
					
				</dd>
			</dl>
			<dl>
				<dt>
					是否重点骨干企业：
				</dt>
				<dd>
					<select name="corporation.is50" >
						<option value="是">是</option>
						<option value="否">否</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>
					是否专辑特新：
				</dt>
				<dd>
					<select name="corporation.isnew" >
					<option value="是">是</option>
					<option value="否">否</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>
					企业介绍：
				</dt>
				<dd>
					<textarea type="text" name="corporation.infor" cols=45 rows=5></textarea>
				</dd>
			</dl>
			<dl>
				<dt>
					备注：
				</dt>
				<dd>
					<textarea type="text" name="corporation.remark" cols=45 rows=5></textarea>
				</dd>
			</dl>
			<dl>
				<dt>
					产品信息：
				</dt>
				<dd>
				<c:forEach items="${product}" var="item">
				<c:set value="${item}" var="product"></c:set>
				<input type="checkbox" name="corporationProduct.productid" value="${product.productid}"/>${product.productName} &nbsp;
				</c:forEach>
				<input type="hidden" name="corporationProduct.s01" value="0"/>
				<input type="hidden" name="corporationProduct.v01" value="0"/>
				<input type="hidden" name="corporationProduct.activation" value="1"/>  
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
