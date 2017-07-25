<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title></title>
<script type="text/javascript">
	$ (function () {
	    $ (function () {
		    $ ('#dg').datagrid ({
		        url : '${basePath}/sys/resourceList',
		        fitColumns : true,
		        nowrapL : true,
		        idField : 'resourceid',
		        rownumbers : true,
		        singleSelect : true,
		        pagination : true,
		        pageSize : 10,
		        pageList : [
		                3, 5, 10, 20
		        ],
		        toolbar : [
		                '-', {
		                    iconCls : 'icon-add',
		                    text : '添加资源',
		                    handler : function () {
			                    addNew ();
		                    }
		                }, '-', {
		                    iconCls : 'icon-edit',
		                    text : '修改资源',
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
			                    field : 'resourceid',
			                    title : '资源编号',
			                    width : 60
			                },
			                {
			                    field : 'res_resourceid',
			                    title : '父资源编号',
			                    width : 200
			                },
			                {
			                    field : 'resourcename',
			                    title : '资源名称',
			                    width : 200
			                }, {
			                    field : 'adress',
			                    title : '资源地址',
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
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" name="resourcename" label="资源名称" required="true" labelPosition="top"
					style="width: 100%;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" name="res_resourceid" label="父资源编号"  labelPosition="top"
					style="width: 100%;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" name="adress" label="资源地址"  labelPosition="top"
					style="width: 100%;">
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
	    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '添加监督方案');
	    $ ('#fm').form ('clear');
	    url = '${basePath}/sys/addResource';
    }
    function editUser () {
	    var row = $ ('#dg').datagrid ('getSelected');
	    if (row){
		    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '修改监督方案');
		    $ ('#fm').form ('load', row);
		    url = '${basePath}/sys/updateResource?resourceid=' + row.resourceid;
	    }else{
	    	 $.messager.show ({
			        title : '操作提示',
			        msg : '请先选择要修改的资源',
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
		        alert (result);
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
</script>
</html>
