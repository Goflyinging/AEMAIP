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
		        url : '${basePath}/zjz/oversightGroupList',
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
		        /*toolbar : [
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
		                    iconCls : 'icon-remove',
		                    text : '删除',
		                    handler : function () {
		                        destroyUser ();
		                    }
		                }
		        ],*/
		        /*字段**************************************/
		        columns : [
			        [
			                {
			                    field : 'ck',
			                    checkbox : true
			                }, {
			                    field : 'ogid',
			                    title : '监督组编号',
			                    width : 100
			                }, {
			                    field : 'leader',
			                    title : '组长编号',
			                    width : 100
			                }, {
			                    field : 'leadername',
			                    title : '组长姓名',
			                    width : 100
			                }
			        ]
		        ]
		    });
		    
	    });
    });
</script>
</head>
<body>
	<table id="dg"></table>
</body>
</html>
