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
		        url : '${basePath}/project/applyCompletionList',
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
		                    text : '提交竣工',
		                    handler : function () {
			                    var select = $ ("#dg").datagrid ("getSelected");
			                    if (select != null){
				                    var id = select.projectid;
				                    parent.$.messager.confirm ('确认对话框', '您确认要提交所选项目吗？', function (r) {
					                    if (r){
						                    $.ajax ({
						                        url : "${basePath}/project/applyCompletionProject",
						                        type : "POST",
						                        //设置为传统方式传送参数
						                        traditional : true,
						                        data : {
							                        id : id
						                        },
						                        success : function (html) {
							                        //重新刷新页面
							                        $ ("#dg").datagrid ("reload");
							                        //请除所有勾选的行
							                        $ ("#dg").datagrid ("clearSelections");
						                        },
						                        error : function (XMLHttpRequest, textStatus, errorThrown) {
							                        $.messager.alert ('操作失败', '请联系管理员！', 'error');
						                        },
						                        dataType : 'json'
						                    });
						                    
					                    }
				                    });
				                    
			                    } else{
				                    $.messager.show ({
				                        title : '操作提示',
				                        msg : '请先选择要提交的项目',
				                        timeout : 4000,
				                        showType : 'slide'
				                    });
				                    
			                    }//else
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

	<table id="dg"></table>
</body>
</html>
