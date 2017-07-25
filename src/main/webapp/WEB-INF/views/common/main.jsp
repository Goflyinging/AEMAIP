<%@ page language="java" pageEncoding="utf-8"%>
<script type="text/javascript">
	$ (function () {
	    function DateDemo () {
		    var d, s = "今天是:<br/>"; // 声明变量。
		    d = new Date (); // 创建 Date 对象。
		    s += (d.getMonth () + 1) + "/"; // 获取月份。
		    s += d.getDate () + "/"; // 获取日。
		    s += d.getYear (); // 获取年份。
		    return (s);// 返回日期。
	    }
	    var a = new Date ().toLocaleString ();
	    $ ("#time").text (a);
    });
</script>
<div id="mainPanle" region="center" style="background: #f0f9fd; overflow-y: hidden">
	<div id="tabs" class="easyui-tabs" fit="true" border="false" plain="true">
		<!--right main-->
		<div title="欢迎使用" style="padding: 20px; overflow: hidden; color: red;">
			<h1 style="font-size: 24px;">今天是：</h1>
			<h1 id="time" style="font-size: 24px;"></h1>
			<h1 style="font-size: 24px;">欢迎您使用建筑工程多主体交互平台！</h1>
		</div>
		<!--right main end-->
	</div>
</div>