<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title></title>
<script type="text/javascript">
	$ (function () {
	    $ (function () {
		    $ ('#dg').datagrid ({
		        url : '${basePath}/sys/usersList',
		        fitColumns : true,
		        nowrapL : true,
		        idField : 'account',
		        rownumbers : true,
		        singleSelect : true,
		        pagination : true,
		        pageSize : 5,
		        pageList : [
		                3, 5, 10, 20
		        ],
		        toolbar : [
		                '-', {
		                    iconCls : 'icon-add',
		                    text : '添加用户',
		                    handler : function () {
			                    addNew ();
		                    }
		                }, '-', {
		                    iconCls : 'icon-edit',
		                    text : '修改密码',
		                    handler : function () {
			                    mmdlg ();
		                    }
		                }, '-', {
		                    iconCls : 'icon-edit',
		                    text : '分配角色',
		                    handler : function () {
		                    	fqdlg ();
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
			                    field : 'account',
			                    title : '用户编号',
			                    width : 60
			                }, {
			                    field : 'username',
			                    title : '用户姓名',
			                    width : 200
			                }
			        ]
		        ]
		    });
		    
	    });
    });
</script>
</head>
<body>

	<!-- 添加用户 -->
	<div id="dlg" class="easyui-dialog" style="width: 400px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post" novalidate style="margin: 0; padding: 20px 50px">
			<div style="margin-bottom: 10px">
				<input name="username" class="easyui-textbox" required="true"
					validtype="remote['${basePath}/find/Isusername','username']" invalidMessage="用户名已存在"
					label="登录名" labelPosition="top" style="width: 100%">
			</div>
			<div style="margin-bottom: 10px">
				<input id="pwd" name="passwd" class="easyui-textbox" type="password" required="true" label="密码"
					labelPosition="top" style="width: 100%">
			</div>
			<div style="margin-bottom: 10px;">
				<input class="easyui-textbox" type="password" name="repassword" id="repassword" required="true"
					label="确认密码" required="true" labelPosition="top" validType="equalTo['#pwd']"
					invalidMessage="两次输入密码不匹配" style="width: 100%;">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()"
			style="width: 90px">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlg').dialog('close')" style="width: 90px">Cancel</a>
	</div>

	<!-- 修改密码 -->
	<div id="dlgmm" class="easyui-dialog" style="width: 400px" closed="true" buttons="#dlgmm-buttons">
		<div style="margin-bottom: 10px; margin-left: 30px">
			<input id="password" class="easyui-textbox" type="password" name="password" label="密码"
				required="true" labelPosition="top" style="width: 80%;">
		</div>
		<div style="margin-bottom: 10px; margin-left: 30px">
			<input class="easyui-textbox" type="password" name="repassword" id="repassword" required="true"
				label="确认密码" required="true" labelPosition="top" validType="equalTo['#password']"
				invalidMessage="两次输入密码不匹配" style="width: 80%;">
		</div>
	</div>
	<div id="dlgmm-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="mmSave()"
			style="width: 90px">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlgmm').dialog('close')" style="width: 90px">Cancel</a>
	</div>


	<!-- 分配权限 -->

	<div id="dlgfm" class="easyui-dialog" style="width: 400px" closed="true" buttons="#dlgfm-buttons">
		<div style="margin-bottom: 10px;text-align:center;margin-top: 10px;">
			<input id="jscom" class="easyui-combobox" name="projectid" required="true" 
				style="width: 40%" editable="false" panelHeight="100"
				multiple="true"
				data-options="valueField:'cid',textField:'mdg',url:'${basePath}/find/roles'" />
		</div>
	</div>
	<div id="dlgfm-buttons" style="text-align: center">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="fqSave()"
			style="width: 90px">提交</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlgfm').dialog('close')" style="width: 90px">取消</a>
	</div>


	<table id="dg"></table>
</body>
<script type="text/javascript">
	var url;
    function addNew () {
	    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '添加监督方案');
	    $ ('#fm').form ('clear');
	    url = '${basePath}/sys/addUser';
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
		        	$.messager.show ({
			            title : 'OK',
			            msg : "人员操作成功"
			        });
			        $ ('#dlg').dialog ('close');
			        $ ('#dg').datagrid ('reload');
		        }
	        }
	    });
    }

    //账户ID
    var accountID;
    //修改密码弹出框
    function mmdlg () {
	    var array = $ ('#dg').datagrid ("getSelected");
	    if (array){
		    accountID = array.account;
		    $ ('#dlgmm').dialog ('open').dialog ('center').dialog ('setTitle', '修改密码');
		    
	    } else{
		    $.messager.show ({
		        title : '操作提示',
		        msg : '请先选择要修改的1位用户',
		        timeout : 4000,
		        showType : 'slide'
		    });
	    }
    }
    //保存修改的密码
    function mmSave () {
	    var password = $ ("#password").val ();
	    $.ajax ({
	        url : "${basePath}/sys/changePass",
	        type : "POST",
	        traditional : true,
	        data : {
	            accountID : accountID,
	            password : password
	        },
	        success : function (result) {
		        if (!result){
			        $.messager.show ({
			            title : 'Error',
			            msg : "修改密码失败"
			        });
		        } else{
			        $.messager.show ({
			            title : 'ok',
			            msg : "操作成功"
			        });
			        $ ('#dlgmm').dialog ('close');
			        $ ('#dg').datagrid ('reload');
		        }
	        },
	        error : function (XMLHttpRequest, textStatus, errorThrown) {
		        $.messager.alert ('修改错误', '请联系管理员！', 'error');
	        },
	        dataType : 'json'
	    });
    }

    //分配权限
    
    //修改密码弹出框
    function fqdlg() {
	    var array = $ ('#dg').datagrid ("getSelected");
	    if (array){
		    accountID = array.account;
		    $ ('#dlgfm').dialog ('open').dialog ('center').dialog ('setTitle', '分配角色');
		    
	    } else{
		    $.messager.show ({
		        title : '操作提示',
		        msg : '请先选择要修改的1位用户',
		        timeout : 4000,
		        showType : 'slide'
		    });
	    }
    }
    //保存修改的角色
    function fqSave() {
	    var array = $('#jscom').combobox('getValues');
	    $.ajax ({
	        url : "${basePath}/sys/assigningroles",
	        type : "POST",
	        traditional : true,
	        data : {
	        	account : accountID,
	        	roleids : array
	        },
	        success : function (result) {
		        if (!result){
			        $.messager.show ({
			            title : 'Error',
			            msg : "修改密码失败"
			        });
		        } else{
			        $.messager.show ({
			            title : 'ok',
			            msg : "操作成功"
			        });
			        $ ('#dlgfm').dialog ('close');
			        $ ('#dg').datagrid ('reload');
		        }
	        },
	        error : function (XMLHttpRequest, textStatus, errorThrown) {
		        $.messager.alert ('修改错误', '请联系管理员！', 'error');
	        },
	        dataType : 'json'
	    }); 
    }

    $.extend ($.fn.validatebox.defaults.rules, {
	    /*必须和某个字段相等*/
	    equalTo : {
	        validator : function (value, param) {
		        return $ (param[0]).val () == value;
	        },
	        message : '字段不匹配'
	    }
    });
</script>
</html>
