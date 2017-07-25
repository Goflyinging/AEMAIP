<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
	    $ ('.loginbox').css ({
	        'position' : 'absolute',
	        'left' : ($ (window).width () - 692) / 2
	    });
	    $ (window).resize (function () {
		    $ ('.loginbox').css ({
		        'position' : 'absolute',
		        'left' : ($ (window).width () - 692) / 2
		    });
	    })
    });
</script>
</head>
<body
	style="background-color:#1c77ac; background-image: url(${basePath}/images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">

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
	<div class="loginbody">
		<span class="systemlogo"></span>
		<div class="loginbox">
			<form id="sysForm" action="${basePath}/login/confirmZrdw" method="post">
				<ul>
					<li>
						<input name="username" type="text" class="loginuser" data-easytip="class:easy-blue;" />
					</li>
					<li>
						<input name="passwd" type="password" class="loginpwd" data-easytip="class:easy-blue;" />
					</li>
					<li style="margin: 0px; margin-left: 20px;">
						<span style="color: red;">${requestScope.error}</span>
					</li>
					<li>
						<input id="confirm" type="button" class="loginbtn" value="登录" />
						<label>
							<input name="" type="checkbox" value="" checked="checked" />
							记住密码
						</label>
						<label>
							<a href="#">忘记密码？</a>
						</label>
					</li>
				</ul>
			</form>
		</div>
	</div>
	<div class="loginbm">版权所有 2016&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;西安电子科技大学软件学院10组</div>
</body>
<script type="text/javascript">
	//按下button提交表单
    $ ("#confirm").click (function () {
	    if (validatorInput ())
		    if (validatorPassword ())
			    $ ("#sysForm").submit ();
	    
    });
    
    //按下回车后提交表单	
    $ (":password").keydown (function (event) {
	    if (event.keyCode == 13){
		    if (validatorInput ())
			    if (validatorPassword ())
				    $ ("#sysForm").submit ();
	    }
    });
    
    //用户名验证函数
    var validatorInput = function () {
	    $input = $ (":text");
	    if ($.trim ($input.val ()) == "" || !/^[\w]{5,15}$/.test ($input.val ())){
		    var tip = $input.easytip ();
		    tip.show ("请输出正确的帐号");
		    return false;
	    }
	    return true;
    }
    //密码验证函数
    var validatorPassword = function () {
	    $password = $ (":password");
	    if ($.trim ($password.val ()) == ""){
		    var tip = $password.easytip ();
		    tip.show ("密码不能为空");
		    return false;
	    }
	    return true;
    }

    //失去焦点使测试
    $ (":text").focusout (validatorInput);
    $ (":password").focusout (validatorPassword);
</script>
</html>
