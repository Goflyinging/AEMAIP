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
		        url : '${basePath}/project/startList',
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
		                {
		                    iconCls : 'icon-add',
		                    text : '新增',
		                    handler : function () {
			                    addNew ();
		                    }
		                
		                }, '-', {
		                    iconCls : 'icon-edit',
		                    text : '修改',
		                    handler : function () {
			                    editUser ();
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
			                    field : 'regao',
			                    title : '审核意见',
			                    width : 100
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
			<div style="margin-bottom: 20px; font-size: 14px; border-bottom: 1px solid #ccc">项目信息</div>
			<div style="margin-bottom: 10px">
				<input name="name" class="easyui-textbox" required="true" label="项目名称" labelPosition="top"
					style="width: 100%">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" name="msg" label="项目描述" required="true" labelPosition="top"
					multiline="true" style="width: 100%; height: 120px">
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
	    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '新增项目');
	    $ ('#fm').form ('clear');
	    url = '${basePath}/project/addPro';
    }
    //修改项目
    function editUser () {
	    var row = $ ('#dg').datagrid ('getSelected');
	    if (row){
		    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '修改项目');
		    $ ('#fm').form ('load', row);
		    url = '${basePath}/project/updatePro?projectid=' + row.projectid;
	    }
    }
    //报存项目
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
			            msg : "项目操作失败"
			        });
		        } else{
			        $ ('#dlg').dialog ('close');
			        $ ('#dg').datagrid ('reload');
		        }
	        }
	    });
    }
</script>
</html>
