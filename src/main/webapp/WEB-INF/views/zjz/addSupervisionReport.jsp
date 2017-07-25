<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title></title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<form id="fm" method="post" novalidate
		style="margin: 0; padding: 20px 50px; width: 800px; margin-left: 100px;">
		<div style="margin-bottom: 20px; font-size: 14px; border-bottom: 1px solid #ccc">监督报告</div>
		<div style="margin-bottom: 10px">
			<input id="cc" class="easyui-combobox" name="projectid" required="true" label="项目名称"
				labelPosition="top" style="width: 40%" editable="false" panelHeight="100";
				data-options="valueField:'projectid',textField:'name',url:'${basePath}/find/project'" />
		</div>
		<div style="margin-bottom: 10px">
			<input class="easyui-textbox" name="report" label="报告内容" required="true" labelPosition="top"
				multiline="true" style="width: 100%; height: 300px">
		</div>
	</form>
	<div id="dlg-buttons" style="text-align: center">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()"
			style="width: 90px">提交</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlg').dialog('close')" style="width: 90px">取消</a>
	</div>
</body>
<script type="text/javascript">
    function saveUser () {
    	var url  = '${basePath}/project/addSupervisionReport';
	    $ ('#fm').form ('submit', {
	    	url : url,
	        onSubmit : function () {
		        return $ (this).form ('validate');
	        },
	        success : function (result) {
		        var result = eval ('(' + result + ')');
		        if (!result){
			        $.messager.show ({
			            title : 'Error',
			            msg : "操作失败"
			        });
		        } else{
		        	$.messager.show ({
			            title : 'ok',
			            msg : "提交成功"
			        });
		        	$('#cc').combobox('reload'); 
		        	$ ('#fm').form ('clear');
		        }
	        }
	    });
    }
    
</script>
</html>
