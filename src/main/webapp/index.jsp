<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title>建筑工程多主体交互平台</title>
<script src="${basePath}/js/cloud.js" type="text/javascript"></script>
<style type="text/css">
* {
	font-size: 9pt;
	border: 0;
	margin: 0;
	padding: 0;
}
</style>
<script language="javascript">
	$(function() {
		$('.loginbox0').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 810) / 2
		});
		$(window).resize(function() {
			$('.loginbox0').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 810) / 2
			});
		})
	});
</script>

</head>

<body
	style="background-color: #1c77ac; background-image: url(${basePath}/images/light1.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>

	<div class="logintop">
		<span>欢迎进入建筑工程多主体交互平台</span>
		<ul>
			<li><a href="#">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>

	<div class="loginbody1">

		<span class="systemlogo"></span>

		<div class="loginbox0">

			<ul class="loginlist">
				<li><a href="${basePath}/login/sysLogin"><img
						src="${basePath}/images/l01.png" alt="建筑工程多主体交互平台" />
						<p>系统管理员入口</p></a></li>
				<li><a href="${basePath}/login/zjzLogin"><img
						src="${basePath}/images/l04.png" alt="建筑工程多主体交互平台" />
						<p>质监站入口</p></a></li>
				<li><a href="${basePath}/login/zrdwLogin"><img
						src="${basePath}/images/l02.png" alt="建筑工程多主体交互平台" />
						<p>责任单位入口</p></a></li>
				<li><a href="${basePath}/login/register"><img
						src="${basePath}/images/l03.png" alt="建筑工程多主体交互平台" />
						<p>注册入口</p></a></li>
			</ul>

		</div>

	</div>

	<div class="loginbm">版权所有 2016&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;西安电子科技大学软件学院10组</div>


</body>

</html>
