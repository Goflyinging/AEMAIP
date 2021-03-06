<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title></title>
<script type="text/javascript">
	var stateTypeArray = "${applicationScope.sys_param.prjState_type}";
    $ (function () {
	    $ (function () {
		    $ ('#dg').datagrid ({
		        url : '${basePath}/project/endProList',
		        fitColumns : true,
		        nowrapL : true,
		        idField : 'projectid',
		        rownumbers : true,
		        singleSelect : true,
		        pagination : true,
		        pageSize : 5,
		        pageList : [
		                3, 5, 10, 20
		        ],
		        toolbar : [
		                '-', {
		                    iconCls : 'icon-ok',
		                    text : '竣工审核',
		                    handler : function () {
			                    addNew ();
		                    }
		                }
		        
		        ],
		        /*字段**************************************/
		        columns : [
			        [
			                {
			                    field : 'ck',
			                    checkbox : true
			                }, {
			                    field : 'projectid',
			                    title : '项目编号',
			                    width : 100
			                }, {
			                    field : 'name',
			                    title : '项目名称',
			                    width : 100
			                }, {
			                    field : 'begintime',
			                    title : '开始时间',
			                    width : 100,
			                    formatter : function (value, row, index) {
				                    return getLocalTime (value);
			                    }
			                }, {
			                    field : 'prjsid',
			                    title : '项目状态',
			                    width : 100,
			                    formatter : function (value, row, index) {
				                    return valueToText (stateTypeArray, value);
			                    }
			                }, {
			                    field : 'msg',
			                    title : '项目描述',
			                    width : 100,
			                
			                }
			        ]
		        ]
		    });
		    
	    });
    });
</script>
</head>
<body>
	<div id="dlg" class="easyui-dialog" style="width: 400px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post" novalidate style="margin: 0; padding: 20px 50px">
			<div style="margin-bottom: 20px; font-size: 14px; border-bottom: 1px solid #ccc">审核信息</div>
			<div style="margin-bottom: 10px">
				<select id="cc" class="easyui-combobox" name="value" label="结果" required="true" editable="false"
					panelHeight="60" labelPosition="top" style="width: 200px;">
					<option value="0">同意</option>
					<option value="1">不同意</option>
				</select>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()"
			style="width: 90px">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlg').dialog('close')" style="width: 90px">Cancel</a>
	</div>
	<table id="dg"></table>
</body>
<script type="text/javascript">
	var url;
    function addNew () {
	    var row = $ ('#dg').datagrid ('getSelected');
	    if (row){
		    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '审核信息');
		    $ ('#fm').form ('clear');
		    url = '${basePath}/project/endApply?id=' + row.projectid;
	    } else{
		    $.messager.show ({
		        title : '操作提示',
		        msg : '请先选择一项要审核的项目',
		        timeout : 4000,
		        showType : 'slide'
		    });
	    }
	    
    }
    function saveUser () {
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
			        $ ('#dlg').dialog ('close');
			        $ ('#dg').datagrid ('clearChecked');
			        $ ('#dg').datagrid ('reload');
		        }
	        }
	    });
    }
</script>
</html>
