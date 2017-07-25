<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title></title>
<script type="text/javascript">
	var sexTypeArray = "${applicationScope.sys_param.sex_type}";
    $ (function () {
	    $ (function () {
		    $ ('#dg').datagrid ({
		        url : '${basePath}/company/unitpiList',
		        fitColumns : true,
		        nowrapL : true,
		        idField : 'upiid',
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
			                    field : 'upiid',
			                    title : '个人编号',
			                    width : 100
			                }, {
			                    field : 'name',
			                    title : '姓名',
			                    width : 100
			                }, {
			                    field : 'sex',
			                    title : '性别',
			                    width : 100,
			                    formatter : function (value, row, index) {
				                    return valueToText (sexTypeArray, value);
			                    }
			                
			                }, {
			                    field : 'phone',
			                    title : '电话',
			                    width : 100,
			                
			                }, {
			                    field : 'msg',
			                    title : '个人描述',
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
			<div style="margin-bottom: 20px; font-size: 14px; border-bottom: 1px solid #ccc">单位人员信息</div>
			<div style="margin-bottom: 10px">
				<input name="name" class="easyui-textbox" required="true" label="姓名" labelPosition="top"
					style="width: 100%">
			</div>
			<div style="margin-bottom: 10px">
				<input name="phone" class="easyui-textbox" required="true" label="电话" labelPosition="top"
					style="width: 100%">
			</div>
			<div style="margin-bottom: 10px">
				<select id="cc" class="easyui-combobox" label="性别" labelPosition="top" name="sex"
					editable="false" panelHeight="60px" value="0" style="width: 100%;">
					<option value="0" selected="selected">男</option>
					<option value="1">女</option>
				</select>
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" name="msg" label="描述" required="true" labelPosition="top"
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
	    url = '${basePath}/company/addUnitpi';
    }
    function editUser () {
	    var row = $ ('#dg').datagrid ('getSelected');
	    if (row){
		    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '修改用户');
		    $ ('#fm').form ('load', row);
		    url = '${basePath}/company/updateUnitpi?upiid=' + row.upiid;
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
			            msg : "人员操作失败"
			        });
		        } else{
			        $ ('#dlg').dialog ('close');
			        $ ('#dg').datagrid ('reload');
		        }
	        }
	    });
    }
    function destroyUser () {
	    var row = $ ('#dg').datagrid ('getSelected');
	    if (row){
		    $.messager.confirm ('Confirm', 'Are you sure you want to destroy this user?', function (r) {
			    if (r){
				    $.post ('destroy_user.php', {
					    id : row.id
				    }, function (result) {
					    if (result.success){
						    $ ('#dg').datagrid ('reload'); // reload the user data
					    } else{
						    $.messager.show ({
						        title : 'Error',
						        msg : result.errorMsg
						    });
					    }
				    }, 'json');
			    }
		    });
	    }
    }
</script>
</html>
