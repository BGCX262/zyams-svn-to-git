
<%@ page contentType="text/html" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=7" />
		<title>马鞍山经信委后台管理平台</title>
		<link href="themes/default/style.css" rel="stylesheet" type="text/css"
			media="screen" />
		<link href="themes/css/core.css" rel="stylesheet" type="text/css"
			media="screen" />
		<link href="themes/css/print.css" rel="stylesheet" type="text/css"
			media="print" />
		<link href="uploadify/css/uploadify.css" rel="stylesheet"
			type="text/css" media="screen" />
		<!--[if IE]>
            <link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
        <![endif]-->
		<script src="js/speedup.js" type="text/javascript">
        </script>
		<script src="js/jquery-1.7.1.js" type="text/javascript">
        </script>
		<script src="js/jquery.cookie.js" type="text/javascript">
        </script>
		<script src="js/jquery.validate.js" type="text/javascript">
        </script>
		<script src="js/jquery.bgiframe.js" type="text/javascript">
        </script>
		<script src="xheditor/xheditor-1.1.12-zh-cn.min.js"
			type="text/javascript">
        </script>
		<script src="uploadify/scripts/swfobject.js" type="text/javascript">
        </script>
		<script src="uploadify/scripts/jquery.uploadify.v2.1.0.js"
			type="text/javascript">
        </script>
		<script src="js/dwz.core.js" type="text/javascript">
        </script>
		<script src="js/dwz.util.date.js" type="text/javascript">
        </script>
		<script src="js/dwz.validate.method.js" type="text/javascript">
        </script>
		<script src="js/dwz.regional.zh.js" type="text/javascript">
        </script>
		<script src="js/dwz.barDrag.js" type="text/javascript">
        </script>
		<script src="js/dwz.drag.js" type="text/javascript">
        </script>
		<script src="js/dwz.tree.js" type="text/javascript">
        </script>
		<script src="js/dwz.accordion.js" type="text/javascript">
        </script>
		<script src="js/dwz.ui.js" type="text/javascript">
        </script>
		<script src="js/dwz.theme.js" type="text/javascript">
        </script>
		<script src="js/dwz.switchEnv.js" type="text/javascript">
        </script>
		<script src="js/dwz.alertMsg.js" type="text/javascript">
        </script>
		<script src="js/dwz.contextmenu.js" type="text/javascript">
        </script>
		<script src="js/dwz.navTab.js" type="text/javascript">
        </script>
		<script src="js/dwz.tab.js" type="text/javascript">
        </script>
		<script src="js/dwz.resize.js" type="text/javascript">
        </script>
		<script src="js/dwz.dialog.js" type="text/javascript">
        </script>
		<script src="js/dwz.dialogDrag.js" type="text/javascript">
        </script>
		<script src="js/dwz.sortDrag.js" type="text/javascript">
        </script>
		<script src="js/dwz.cssTable.js" type="text/javascript">
        </script>
		<script src="js/dwz.stable.js" type="text/javascript">
        </script>
		<script src="js/dwz.taskBar.js" type="text/javascript">
        </script>
		<script src="js/dwz.ajax.js" type="text/javascript">
        </script>
		<script src="js/dwz.pagination.js" type="text/javascript">
        </script>
		<script src="js/dwz.database.js" type="text/javascript">
        </script>
		<script src="js/dwz.datepicker.js" type="text/javascript">
        </script>
		<script src="js/dwz.effects.js" type="text/javascript">
        </script>
		<script src="js/dwz.panel.js" type="text/javascript">
        </script>
		<script src="js/dwz.checkbox.js" type="text/javascript">
        </script>
		<script src="js/dwz.history.js" type="text/javascript">
        </script>
		<script src="js/dwz.combox.js" type="text/javascript">
        </script>
		<script src="js/dwz.print.js" type="text/javascript">
        </script>
		<!--
        <script src="bin/dwz.min.js" type="text/javascript"></script>
        -->
		<script src="js/dwz.regional.zh.js" type="text/javascript">
        </script>
		<script type="text/javascript">
            $(function(){
                DWZ.init("dwz.frag.xml", {
                    loginUrl: "login_dialog.html",
                    loginTitle: "登录", // 弹出登录对话框
                    //		loginUrl:"login.html",	// 跳到登录页面
                    statusCode: {
                        ok: 200,
                        error: 300,
                        timeout: 301
                    }, //【可选】
                    pageInfo: {
                        pageNum: "pageNum",
                        numPerPage: "numPerPage",
                        orderField: "orderField",
                        orderDirection: "orderDirection"
                    }, //【可选】
                    debug: false, // 调试模式 【true|false】
                    callback: function(){
                        initEnv();
                        $("#themeList").theme({
                            themeBase: "themes"
                        }); // themeBase 相对于index页面的主题base路径
                    }
                });
            });
      </script>
	</head>
	<body scroll="no">
		<div id="layout">
			<div id="header">
				<div class="headerNav">
					<a class="logo" href="index.jsp">LOGO</a>
					<ul class="nav">
						<li>
							<b style="color:#fff;">用户:${session.loginUser.loginname}</b>
						</li>
						<li>
							<b style="color:#fff;">IP:<%=request.getLocalAddr()%>
							</b>
						</li>
						<li>
							<a href="../index.html" target="_blank"><b
								style="color:#fff;">查看网站</b>
							</a>
						</li>
						<li>
							<a href="logout.action"><b style="color:#fff;">退出</b>
							</a>
						</li>
					</ul>
					<ul class="themeList" id="">
						<li style="color:#fff;">

							<script type="text/javascript"> var d = new Date(); var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");document.write(d.getFullYear()+"年"+(d.getMonth()+1)+"月"+d.getDate()+"日   "+arr_week[d.getDay()]);</script>

						</li>

					</ul>
				</div>
				<!-- navMenu -->
			</div>
			<div id="leftside">
				<div id="sidebar_s">
					<div class="collapse">
						<div class="toggleCollapse">
							<div>
							</div>
						</div>
					</div>
				</div>
				<div id="sidebar">
					<div class="toggleCollapse">
						<h2>
							主菜单
						</h2>
						<div>
							收缩
						</div>
					</div>
					<div class="accordion" fillSpace="sidebar">
						<div class="accordionHeader">
							<h2>
								<span>Folder</span>内容管理
							</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder">
							<c:if test="${not empty manageFlag}">
								<li>
									<a href="showUnCheckArticleList.action" target="navTab"
										rel="listUncheckArticles">审核文章</a>
								</li>
								</c:if>
								<li>
									<a href="listArticleTypes.action" target="navTab"
										rel="listArticleTypes">栏目管理</a>
								</li>
								<li>
									<a href="listLinks.action" target="navTab" rel="listLinks">友情链接管理</a>
								</li>
								<li>
									<a href="listArticles.action?typeId=0" target="navTab"
										rel="listArticlePage">新闻管理</a>
								</li>
								<li>
									<a href="listMsgs.action" target="navTab" rel="listMsgs">留言管理</a>
								</li>
							</ul>
						</div>

						<div class="accordionHeader">
							<h2>
								<span>Folder</span>系统功能
							</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder">
								<!-- <li >
									<a href="listIndexs.jsp" target="navTab">企业申报</a>
								</li> -->
								<li>
									<a href="listIndexs.jsp" target="navTab" rel="listIndexs">报表查询</a>
								</li>

								<li>
									<a href="listMessages.action" target="navTab">短信通知</a>
								</li>
								
							</ul>
						</div>
						<c:if test="${sessionRoleName eq '超级管理员'}">
							<div class="accordionHeader">
								<h2>
									<span>Folder</span>系统管理
								</h2>
							</div>
							<div class="accordionContent">
								<ul class="tree treeFolder">
									<li>
										<a href="listUsers.action" rel="listUsers" target="navTab">用户管理</a>
									</li>
									<li>
										<a href="listRoles.action" target="navTab" rel="listRoles">角色管理</a>
									</li>
									<li>
										<a href="listPartments.action" target="navTab"
											rel="listPartments">部门管理</a>
									</li>
									<li>
										<a href="listCorporation.action" rel="listCorporation"
											target="navTab">企业管理</a>
									</li>
									<li>
										<a href="listProducts.action" rel="listProducts"
											target="navTab">产品管理</a>
									</li>
									<li>
										<a href="listTrades.action?dictid=108" rel="listDictionary"
											target="navTab">行业管理</a>
									</li>
								
									<li>
										<a href="listAreas.action?dictid=107&t=哈哈"
											rel="listDictionary" target="navTab">地区管理</a>
									</li>
										<li>
									<a href="listContacts.action" target="navTab" rel="listContacts">联系人管理</a>
								</li>
								<li>
									<a href="listContactTypes.action" target="navTab" rel="listContactTypes">联系人分组管理</a>
								</li>
								</ul>
							</div>
						</c:if>
					</div>
				</div>
			</div>
			<div id="container">
				<div id="navTab" class="tabsPage">
					<div class="tabsPageHeader">
						<div class="tabsPageHeaderContent">
							<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
							<ul class="navTab-tab">
								<li tabid="main" class="main">
									<a href="javascript:;"><span><span class="home_icon">我的主页</span>
									</span>
									</a>
								</li>
							</ul>
						</div>
						<div class="tabsLeft">
							left
						</div>
						<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
						<div class="tabsRight">
							right
						</div>
						<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
						<div class="tabsMore">
							more
						</div>
					</div>
					<ul class="tabsMoreList">
						<li>
							<a href="javascript:;">我的主页</a>
						</li>
					</ul>
					<div class="navTab-panel tabsPageContent layoutBox">
						<div class="page unitBox">
							<div class="pageFormContent" layoutH="10"
								style="margin-right:30px">
								<h3>你好，欢迎您的使用！ </h3>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			Copyright © 2011 www.masec.gov.cn inc.All right reserved.
		</div>

	</body>
</html>
