<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<script type="text/javascript">
	$ (function () {
	    $ ('.error').css ({
	        'position' : 'absolute',
	        'left' : ($ (window).width () - 490) / 2
	    });
	    $ (window).resize (function () {
		    $ ('.error').css ({
		        'position' : 'absolute',
		        'left' : ($ (window).width () - 490) / 2
		    });
	    })
    });
</script>

</head>


<body style="background: #edf6fa;">

	<div class="error">

		<h2>非常遗憾，您没有权限访问此页面！</h2>
		<p>看到这个提示，就自认倒霉吧!</p>

	</div>


</body>

</html>