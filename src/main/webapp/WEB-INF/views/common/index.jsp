<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title>建筑工程多主体交互平台</title>
<script type="text/javascript">
	//--菜单点击
    $ (function () {
	    $ ('.menuson li').click (function () {
		    $ ('.menuson li.active').removeClass ("active");
		    $ (this).addClass ("active");
		    //读取a标签中的文本
		    var $a = $ (this).find ("a");
		    var text = $a.text ();
		    var aUrl = $a.attr ('href');
		    if ($ ("#tabs").tabs ("exists", text)){
			    //存在时选中
			    $ ("#tabs").tabs ("select", text);
			    
		    } else{
			    //不存在时创建
			    $ ("#tabs").tabs ("add", {
			        title : text,
			        closable : true,
			        content : "<iframe src='" + aUrl + "' height='100%' width='100%' frameborder='0px' ></iframe>"
			    });
		    }
		    return false; //重点,防止打开新的页面
	    });
    });
</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden; background: #f0f9fd;" scroll="no">
	<!--脚本支持-->
	<noscript>
		<div
			style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">
			<img src="${basePath}/images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
	<!--top -->
	<%@ include file="/WEB-INF/views/common/top.jsp"%>
	<!--top  end-->
	<!--left-->
	<%@ include file="/WEB-INF/views/common/left.jsp"%>
	<!--left end-->
	<!--right -->
	<%@ include file="/WEB-INF/views/common/main.jsp"%>
	<!--right end-->
	<!--footer-->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>
