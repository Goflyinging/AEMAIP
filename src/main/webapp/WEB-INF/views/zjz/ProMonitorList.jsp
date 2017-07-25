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
		        url : '${basePath}/project/programList',
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
		                    iconCls : 'icon-search',
		                    text : '查看监督方案',
		                    handler : function () {
		                    	seeUser ();
		                    }
		                
		                }, '-', {
		                    iconCls : 'icon-add',
		                    text : '添加监督方案',
		                    handler : function () {
			                    addNew ();
		                    }
		                }, '-', {
		                    iconCls : 'icon-edit',
		                    text : '修改监督方案',
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
			                    width : 60
			                }, {
			                    field : 'name',
			                    title : '项目名称',
			                    width : 200
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
			                    width : 200,
			                
			                }, {
			                    field : 'mpid',
			                    title : '监督方案编号',
			                    width : 80,
			                
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
				<input class="easyui-textbox" name="mpmsg" label="方案内容" required="true" labelPosition="top"
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
	
	
	<div id="dlgss" class="easyui-dialog" style="width: 400px" closed="true" ">
		<form id="fmss" method="post" novalidate style="margin: 0; padding: 20px 50px">
			<div style="margin-bottom: 20px; font-size: 14px; border-bottom: 1px solid #ccc">监督方案信息</div>
			<div style="margin-bottom: 10px">
				<input id ="ss" class="easyui-textbox" name="mpmsg" label="方案内容"  labelPosition="top"
					multiline="true"  readonly="true" style="border: none;width: 100%; height: 120px">
			</div>
		</form>
	</div>
	<table id="dg"></table>
</body>
<script type="text/javascript">
	var url;
    function addNew () {
    	
    	var row = $ ('#dg').datagrid ('getSelected');
	    if (row.mpid==null){
		    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '添加监督方案');
		    $ ('#fm').form ('clear');
		    url = '${basePath}/project/addProgram?projectid=' + row.projectid;
	    }else{
	    	 $.messager.show ({
	 		        title : '操作提示',
	 		        msg : '请先选择一项没有添加监督方案的项目',
	 		        timeout : 4000,
	 		        showType : 'slide'
	 		    });
	    }
	    
    }
    function editUser () {
	    var row = $ ('#dg').datagrid ('getSelected');
	    if (row){
		    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '修改监督方案');
		    $ ('#fm').form ('load', '${basePath}/find/projectProgram?mpid=' + row.mpid);
		    url = '${basePath}/project/updateProgram?mpid=' + row.mpid;
	    }else{
	    	 $.messager.show ({
	 		        title : '操作提示',
	 		        msg : '请先选择一项项目',
	 		        timeout : 4000,
	 		        showType : 'slide'
	 		    });
	    }
    }
    
    
    function seeUser () {
	    var row = $ ('#dg').datagrid ('getSelected');
	    if (row.mpid!=null){
	    	$ ('#fmss').form ('clear');
		    $ ('#dlgss').dialog ('open').dialog ('center').dialog ('setTitle', '监督方案');
		    $ ('#fmss').form ('load', '${basePath}/find/projectProgram?mpid=' + row.mpid);
	    }else{
	    	 $.messager.show ({
	 		        title : '操作提示',
	 		        msg : '请先选择一项已有监督方案的项目',
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
			            msg : "人员操作失败"
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
