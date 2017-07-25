<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>欢迎进入建筑工程多主体交互平台</title>
<link rel="stylesheet" type="text/css"
	href="${basePath}/css/easyform.css">
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
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
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
			<li><a href="${basePath}">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>
	<div class="loginbody">
		<form:form id="registerForm" method="post"
			action="${basePath}/company/register" modelAttribute="company">
			<div class="loginbox registerbox">
				<ul>
					<li>
						<div class="register-font">单位名称：</div> <input type="text"
						id="companyname" name="companyname" class="dfinput" maxlength="15"
						data-easyform="length:10 30;char-chinese;real-time;"
						data-message="单位名称必须为5—15位的汉字" data-easytip="class:easy-blue;"
						data-message-ajax="用户名已存在!" />
					</li>
					<li>
						<div class="register-font">单位类型：</div> <select
						class="register-select" name="companytypeid">
							<c:forEach items="${applicationScope.sys_param.company_type}"
								var="company_type">
								<option value="${company_type.key}">${company_type.value}</option>
							</c:forEach>
					</select>
					</li>
					<li>
						<div class="register-font">地 址：</div> <select id="city"
						name="city" class="register-select" style="width: 148px;">
							<option value="0">请选择城市</option>
							<c:forEach items="${citys}" var="city">
								<option value="${city.addressid}">${city.name}</option>
							</c:forEach>
					</select> <select id="area" name="adressid" class="register-select"
						style="width: 148px;">
							<option value="0">选择区域</option>
					</select>
					</li>
					<li>
						<div class="register-font">登录帐号：</div> <input id="username"
						name="username" type="text" class="dfinput" maxlength="15"
						data-easyform="length:5 15;char-normal;real-time;"
						data-message="登录帐号必须为5—15位的英文字母或数字"
						data-easytip="class:easy-blue;" data-ajax-message="用户名已存在!" />
					</li>
					<li>
						<div class="register-font">邮 箱：</div> <input name="email"
						type="text" class="dfinput" data-easyform="email;real-time;"
						data-message="Email格式要正确" data-easytip="class:easy-blue;" />
					</li>
					<li>
						<div class="register-font">联系电话：</div> <input name="companyphone"
						type="text" class="dfinput" maxlength="11" 
						data-easyform="uint:0;real-time;length:7 11"
						data-message="号码必须为7-11位" data-easytip="class:easy-blue;" /> <form:errors
							path="companyphone" />
					</li>
					<li><input type="submit" class="loginbtn" id="send"
						style="margin-left: 260px" value="注册" /></li>

					<li><span style="color: red;">${requestScope.formErrors}</span></li>
				</ul>
			</div>
		</form:form>
	</div>
	<div class="loginbm" style="position: fixed; bottom: 0px;">版权所有
		2016&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;西安电子科技大学软件学院10组</div>
</body>
<!-- 城市--区域 -->
<script type="text/javascript">
	//定位"城市"下拉框，同时提交change事件
	$("#city").change(
			function() {
				//清空区域下拉框中的内容，除第一项外
				$("#area option:gt(0)").remove();
				//获取选中的城市
				var city = $("#city option:selected").val();
				//如果不是"选择省份"的话
				if ("选择城市" != city) {
					//异步发送请求到服务器
					//参数一：url表示请求的路径
					var url = "${basePath}/find/area?time="
							+ new Date().getTime();
					//参数二：sendData表示以JSON格式发送的数据
					var sendData = {
						"city" : city
					};
					//参数三：function(){}处理或回调函数
					$.post(url, sendData, function(backData, textStatus, ajax) {
						//数组的长度
						var size = backData.length;
						var addressid = "addressid";
						var name = "name";
						//迭代数组
						for (var i = 0; i < size; i++) {
							//获取数组中的每个元素
							var value = backData[i].addressid;
							var name = backData[i].name;
							//创建option元素
							var $option = $("<option value='"+value+"'>" + name
									+ "</option>");
							//将option元素添加到区域下拉框中
							$("#area").append($option);
						}
					});
				}
			});
	//加载 easyform插件
	$(document).ready(function() {
		var ef = $('#registerForm').easyform();
	});

	$("#registerForm").submit(function() {
		
		var a = $("#registerForm .errorExit");
		if (a.length) {
			a.each(function() {
				$(this).easytip().show("已经注册");
			})
			return false;
		}

	});
	//异步验证用户名  和 公司名是否存在
	$("#companyname").focusout(
			function() {
				if ($.trim(this.value) == ""
						|| !/^[\u4e00-\u9fa5]{5,15}$/.test(this.value))
					return;

				var url = "${basePath}/find/Iscompanyname?time="
						+ new Date().getTime();
				//参数二：sendData表示以JSON格式发送的数据
				var companyname = this.value;
				var sendData = {
					"companyname" : companyname
				};
				//参数三：function(){}处理或回调函数
				$.post(url, sendData, function(backData, textStatus, ajax) {
					if (backData == false) {
						$("#companyname").addClass("errorExit");
						var tip = $("#companyname").easytip();
						tip.show("该单位名称已注册");
						return;
					}
					$("#companyname").removeClass("errorExit");
				});

			});
	//验证用户名是否已经存在
	$("#username").focusout(function() {
		if ($.trim(this.value) == "" || !/^[\w]{5,15}$/.test(this.value)) {
			return;
		}

		var url = "${basePath}/find/Isusername?time=" + new Date().getTime();
		var username = this.value;
		var sendData = {
			"username" : username
		};
		$.post(url, sendData, function(backData, textStatus, ajax) {
			if (backData == false) {
				$("#username").addClass("errorExit");
				var tip = $("#username").easytip();
				tip.show("该帐号已注册");
				return;
			}
			$("#username").removeClass("errorExit");

		});

	});
</script>
</html>
