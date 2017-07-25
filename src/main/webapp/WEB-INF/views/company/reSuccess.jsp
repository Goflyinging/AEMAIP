<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>欢迎进入建筑工程多主体交互平台</title>
<link rel="stylesheet" type="text/css" href="${basePath}/css/easyform.css">
<script src="${basePath}/js/cloud.js" type="text/javascript"></script>
<script src="${basePath}/js/easyform.js" type="text/javascript"></script>
<style type="text/css">
* {
	font-size: 9pt;
	border: 0;
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript">
	$ (function () {
	    $ ('.registerbody').css ({
	        'position' : 'absolute',
	        'left' : ($ (window).width () - 692) / 2
	    });
	    $ (window).resize (function () {
		    $ ('.registerbody').css ({
		        'position' : 'absolute',
		        'left' : ($ (window).width () - 692) / 2
		    });
	    })
    });
</script>
<title>欢迎进入建筑工程多主体交互平台</title>
</head>
<body
	style="background-color: #1c77ac; background-image: url(${basePath}/images/light.png); background-repeat: no-repeat; background-position: center top; ">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>
	<div class="logintop">
		<span>欢迎进入建筑工程多主体交互平台</span>
		<ul>
			<li>
				<a href="${basePath}">回首页</a>
			</li>
			<li>
				<a href="#">帮助</a>
			</li>
			<li>
				<a href="#">关于</a>
			</li>
		</ul>
	</div>
	<div class="registerbody">
		<div class="registerbox" style="margin-top: 50px">
					<div style="position: absolute;top:100px;left:250px;font-size: 12pt;">
						<h3 style="font-size: 15pt;margin-top:20px">${requestScope.company.companyname},您已成功提交注册信息</h3>
						 待管理员成功审核后将发帐号和初始密码到您注册的邮箱
					</div>
		</div>

	</div>
	<div class="loginbm" style="position: fixed; bottom: 0px;">版权所有 2016&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;西安电子科技大学软件学院10组</div>
</body>
</html>
