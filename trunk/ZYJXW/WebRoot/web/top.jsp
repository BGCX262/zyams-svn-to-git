<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--header start-->
<div id="header"><script type="text/javascript">
function CurentTime(){
        var now = new Date();
       
        var year = now.getFullYear();       //年
        var month = now.getMonth() + 1;     //月
        var day = now.getDate();            //日
		var s ="";
		switch((new Date()).getDay()){
		  case 0: s = "星期日";break;
		  case 1: s = "星期一";break;
		  case 2: s = "星期二";break;
		  case 3: s = "星期三";break;
		  case 4: s = "星期四";break;
		  case 5: s = "星期五";break;
		  case 6: s = "星期六";break;
		}
        var clock = year + "-";
       
        if(month < 10)
            clock += "0";
       
        clock += month + "-";
       
        if(day < 10)
            clock += "0";
           
        clock += day + " ";
		clock += s + " ";
		return (clock);
}
</script>
  <div id="headerBox">
    <div id="headerBoxLeft">
      <div id="logo"><img src="img/logo.png" /></div>
      <!--menu start-->
      <div id="menu">
        <ul>
          <li><a href="javascript:;" ${navId=='mynav0'?'class="Current nav_on"':''} id=mynav0 onmouseover="javascript:qiehuan(0);" onclick="query5('mynav0');">首  页</a></li>
          <li><a href="javascript:;" ${navId=='mynav1'?'class="Current nav_on"':''} class="nav_off" id=mynav1 onmouseover=javascript:qiehuan(1)>政务公开</a></li>
          <li><a href="javascript:;" ${navId=='mynav2'?'class="Current nav_on"':''} class="nav_off" id=mynav2 onmouseover=javascript:qiehuan(2)>网上办事</a></li>
          <li><a href="listArticleForTypeId.action?typeId=20" ${navId=='mynav3'?'class="Current nav_on"':''} class="nav_off" id=mynav3 onmouseover=javascript:qiehuan(3)>经信信息</a></li>
          <li><a href="javascript:;" class="nav_off" ${navId=='mynav4'?'class="Current nav_on"':''} id=mynav4 onmouseover=javascript:qiehuan(4)>互动服务</a></li>
        </ul>
        <form id="pageForm5" name="pageForm5" method="post"
	action="index.action" target="_self">
	<input type="hidden" value="" name="nav" id="nav5" />
</form>
<script type="text/javascript">

function query5(nav) {
		document.getElementById("nav5").value=nav;
		document.pageForm5.submit();
		return false;
}
</script>
      </div>
      <!--menu over-->
    </div>
    <!--search start-->
    <div id="searchBox"> <span>站内搜索：</span>
    <form id="pageForm0" name="pageForm0" method="post" action="search.action" onsubmit="return validate();">
      <input type="text" class=" searchInputText" name="title" id="title" value="${title }"/>
      <input type="submit" class="searchInputBtn" value=""/>
      </form>
    </div>
    <script>
     function validate(){
		var title=document.getElementById("title").value;
		if(title.length==0){
			alert("请输入关键字!");
			return false;
		}
		return true;
     }
    </script>
    <!--search over-->
  </div>
  <div id="submenu">
    <div id="submenuBox">
      <!--subMenu start-->
      <div id="submenuBoxLeft">
        <div id="qh_con0" class="submenuNo1" style="DISPLAY: block;"> 欢迎光临！您是本站第<span>${totalCount}</span>位访问者 </div>
        <div id=qh_con1 style="DISPLAY: none"> <a href="http://jxw.mas.gov.cn/bmsite/listSub.action?affairSort=551&orgCode=EA003&parentAffair=551">机构领导</a>| <a href="http://jxw.mas.gov.cn/bmsite/listSub.action?affairSort=552&orgCode=EA003&parentAffair=552">机构设置</a>| <a href="http://jxw.mas.gov.cn/bmsite/listSub.action?affairSort=567&orgCode=EA003&parentAffair=567">部门动态</a>| <a href="http://jxw.mas.gov.cn/bmsite/listSub.action?affairSort=559&orgCode=EA003&parentAffair=559">政策法规</a>| <a href="http://jxw.mas.gov.cn/bmsite/listSub.action?affairSort=562&orgCode=EA003&parentAffair=562">规划计划</a>| <a href="http://jxw.mas.gov.cn/bmsite/listSub.action?affairSort=556&orgCode=EA003&parentAffair=556">人事信息</a>  </div>
        <div id=qh_con2 style="DISPLAY: none"> <a href="javascript:;" onclick="query('yes','yes',1301);">办事指南</a>| <a href="javascript:query('yes','yes',1302);">下载中心</a>| <a href="javascript:;">企业黄页</a>| <a href="javascript:;">网上直报</a> </div>
        <div id=qh_con3 style="DISPLAY: none"> <a href="javascript:query('yes','yes',2003);">经济运行</a>| <a href="javascript:query('yes','yes',2005);">两化融合</a>| <a href="javascript:query('yes','yes',2002);" >技术进步</a>| <a href="javascript:query('yes','yes',2001);;">中小企业</a>| <a href="javascript:query('yes','yes',2004);" >节能降耗</a>| <a href="javascript:query('yes','yes',2006);">党群工作</a> </div>
        <div id=qh_con4 style="DISPLAY: none"> <a href="msg.action?flag=true">主任信箱</a>| <a href="msg.action">咨询投诉</a>| <a href="javascript:;">网上调查</a>| <a href="showArticle.action?aid=2932">联系方式</a></div>
      </div>
      <!--subMenu over-->
      <div id="submenuBoxright"> <span><script type="text/javascript">document.write(CurentTime());</script></span> <span><img style="padding-top:5px;" src="img/date.gif" /></span> </div>
    </div>
  </div>
</div>
<form id="pageForm1" name="pageForm1" method="post"
	action="listArticleForTypeId.action" target="_self">
	<input type="hidden" value="" name="typeId" id="typeId1" />
	<input type="hidden" value="" name="children" id="children1" />
	<input type="hidden" value="" name="nav" id="nav1" />
	<input type="hidden" value="" name="pagnation" id="pagnation1" />
</form>
<script type="text/javascript">
var jq = jQuery.noConflict();
function query(pag,child,typeId) {
		document.getElementById("typeId1").value=typeId;
				document.getElementById("children1").value=child;
						document.getElementById("pagnation1").value=pag;
		var nav_id=jq(jq(".nav_on")[0]).attr("id");	
		document.getElementById("nav1").value=nav_id;
		document.pageForm1.submit();
		return false;
}

</script>
<!--header over-->
