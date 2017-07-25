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
		        url : '${basePath}/zjz/qsspiList',
		        fitColumns : true,
		        nowrapL : true,
		        idField : 'qsspiid',
		        rownumbers : true,
		        //singleSelect : true,
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
		                }, '-', {
		                    iconCls : 'icon-add',
		                    text : '组成监督组',
		                    handler : function () {
			                    zuchengjdz ();
		                    }
		                
		                }, '-', {
		                    iconCls : 'icon-edit',
		                    text : '修改密码',
		                    handler : function () {
			                    mmdlg ();
		                    }
		                }
		        /*, '-', {
		            iconCls : 'icon-remove',
		            text : '删除',
		            handler : function () {
		                destroyUser ();
		            }
		        }*/
		        ],
		        /*字段**************************************/
		        columns : [
			        [
			                {
			                    field : 'ck',
			                    checkbox : true
			                }, {
			                    field : 'qsspiid',
			                    title : '质监站人员编号',
			                    width : 100
			                }, {
			                    field : 'name',
			                    title : '姓名',
			                    width : 100
			                }, {
			                    field : 'sex',
			                    title : '性別',
			                    width : 100,
			                    formatter : function (value, row, index) {
				                    return valueToText (sexTypeArray, value);
			                    }
			                }, {
			                    field : 'tel',
			                    title : '电话',
			                    width : 100
			                }, {
			                    field : 'msg',
			                    title : '描述',
			                    width : 100
			                }, {
			                    field : 'username',
			                    title : '账号',
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

	<!-- 注册人员 -->
	<div id="dlg" class="easyui-dialog" style="width: 400px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post" novalidate style="margin: 0; padding: 20px 50px">
			<div style="margin-bottom: 10px">
				<input name="name" class="easyui-textbox" required="true" label="姓名" labelPosition="top"
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
				<input name="username" class="easyui-textbox" required="true"
					validtype="remote['${basePath}/find/Isusername','username']" invalidMessage="用户名已存在"
					label="登录名" labelPosition="top" style="width: 100%">
			</div>
			<div style="margin-bottom: 10px">
				<input id="pwd" name="pwd" class="easyui-textbox" type="password" required="true" label="密码"
					labelPosition="top" style="width: 100%">
			</div>
			<div style="margin-bottom: 10px;">
				<input class="easyui-textbox" type="password" name="repassword" id="repassword" required="true"
					label="确认密码" required="true" labelPosition="top" validType="equalTo['#pwd']"
					invalidMessage="两次输入密码不匹配" style="width: 100%;">
			</div>
			<div style="margin-bottom: 10px">
				<input name="tel" class="easyui-textbox" required="true" label="电话" labelPosition="top"
					style="width: 100%">
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
	<!-- 注册人员end -->


	<!-- 修改人员  -->
	<div id="dlgxg" class="easyui-dialog" style="width: 400px" closed="true" buttons="#dlgxg-buttons">
		<form id="fmxg" method="post" novalidate style="margin: 0; padding: 20px 50px">
			<div style="margin-bottom: 10px">
				<input name="name" class="easyui-textbox" required="true" label="姓名" labelPosition="top"
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
				<input name="tel" class="easyui-textbox" required="true" label="电话" labelPosition="top"
					style="width: 100%">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" name="msg" label="描述" required="true" labelPosition="top"
					multiline="true" style="width: 100%; height: 120px">
			</div>
		</form>
	</div>

	<div id="dlgxg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUserxg()"
			style="width: 90px">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlgxg').dialog('close')" style="width: 90px">Cancel</a>
	</div>
	<!-- 修改人员 end -->




	<div id="dlgzz" class="easyui-dialog" style="width: 400px" closed="true" buttons="#dlgzz-buttons">
		<div style="margin-bottom: 10px">
			<select id="cczz" name="id" class="register-select"
				style="width: 148px; margin-left: 125px; margin-top: 10px">
			</select>
		</div>
	</div>
	<div id="dlgzz-buttons">
		<a id="savebtn" href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok"
			onclick="zuchengjdzSave()" style="width: 90px">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlgzz').dialog('close')" style="width: 90px">Cancel</a>
	</div>



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
	<table id="dg"></table>
</body>
<script type="text/javascript">
	var url;
    function addNew () {
	    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '新增人员');
	    $ ('#fm').form ('clear');
	    url = '${basePath}/zjz/addQsspi';
    }
    function editUser () {
	    var row = $ ('#dg').datagrid ('getSelections');
	    if (row.length == 1){
		    row = row[0];
		    $ ('#dlgxg').dialog ('open').dialog ('center').dialog ('setTitle', '修改人员');
		    $ ('#fmxg').form ('load', row);
		    url = '${basePath}/zjz/updateQsspi?qsspiid=' + row.qsspiid;
	    } else{
		    $.messager.show ({
		        title : '操作提示',
		        msg : '请先选择一位要修改的人员',
		        timeout : 4000,
		        showType : 'slide'
		    });
	    }
    }

    function saveUserxg () {
	    $ ('#fmxg').form ('submit', {
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
			        $ ('#dlgxg').dialog ('close');
			        $ ('#dg').datagrid ('reload');
		        }
	        }
	    });
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

    //组成监督组
    var idsArray;
    function zuchengjdz () {
	    var array = $ ('#dg').datagrid ("getSelections");
	    if (array.length > 2){
		    var ids = new Array ();
		    $ ("#cczz option").remove ();
		    for (i = 0; i < array.length; i++){
			    $ ('#cczz').append ("<option value='"+array[i].qsspiid+"'>" + array[i].name + "</option>")
			    ids[i] = array[i].qsspiid;
		    }
		    idsArray = ids;
		    $('#savebtn').linkbutton('enable');
		    $ ('#dlgzz').dialog ('open').dialog ('center').dialog ('setTitle', '请选择组长');
		    
	    } else{
		    $.messager.show ({
		        title : '操作提示',
		        msg : '请先选择至少选择3位人员',
		        timeout : 4000,
		        showType : 'slide'
		    });
	    }
    }
    //保存组成的监督组
    function zuchengjdzSave () {
    	$('#savebtn').linkbutton('disable');
	    id = $ ('#cczz').val ();
	    $.ajax ({
	        url : "${basePath}/zjz/zuJDZ",
	        type : "POST",
	        traditional : true,
	        data : {
	            ids : idsArray,
	            id : id
	        },
	        success : function (result) {
		        if (!result){
			        $.messager.show ({
			            title : 'Error',
			            msg : "人员操作失败"
			        });
		        } else{
			        $ ('#dlgzz').dialog ('close');
			        $ ('#dg').datagrid ('reload');
		        }
	        },
	        error : function (XMLHttpRequest, textStatus, errorThrown) {
		        $.messager.alert ('删除错误', '请联系管理员！', 'error');
	        },
	        dataType : 'json'
	    });
    }

    //账户ID
    var accountID;
    //修改密码弹出框
    function mmdlg () {
	    var array = $ ('#dg').datagrid ("getSelections");
	    if (array.length == 1){
		    accountID = array[0].account;
		    $ ('#dlgmm').dialog ('open').dialog ('center').dialog ('setTitle', '修改密码');
		    
	    } else{
		    $.messager.show ({
		        title : '操作提示',
		        msg : '请先选择要修改的1位人员',
		        timeout : 4000,
		        showType : 'slide'
		    });
	    }
    }
    //保存修改的密码
    function mmSave () {
	    var password = $ ("#password").val ();
	    $.ajax ({
	        url : "${basePath}/zjz/changePass",
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
			        $ ('#dlgmm').dialog ('close');
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
