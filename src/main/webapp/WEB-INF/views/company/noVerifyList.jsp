<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title></title>
<script type="text/javascript">
	var companyTypeArray = "${applicationScope.sys_param.company_type}";
    $ (function () {
	    $ (function () {
		    $ ('#dg').datagrid ({
		        url : '${basePath}/company/noVerifyList',
		        fitColumns : true,
		        nowrapL : true,
		        idField : 'companyid',
		        rownumbers : true,
		        singleSelect : true,
		        pagination : true,
		        pageSize : 5,
		        pageList : [
		                3, 5, 10, 20
		        ],
		        toolbar : [
			        {
			            text : '审核',
			            iconCls : 'icon-ok',
			            handler : function () {
				            var select = $ ("#dg").datagrid ("getSelected");
				            if (select != null){
					            var id = select.companyid;
					            parent.$.messager.confirm ('确认对话框', '您确认要审核所选单位吗？', function (r) {
						            if (r){
							            $.ajax ({
							                url : "${basePath}/company/verifyCompany",
							                type : "POST",
							                //设置为传统方式传送参数
							                traditional : true,
							                data : {
								                id : id
							                },
							                success : function (html) {
							                	$ ("#dg").datagrid ("clearChecked");
								                //重新刷新页面
								                $ ("#dg").datagrid ("reload");
								                //请除所有勾选的行
								                
							                },
							                error : function (XMLHttpRequest, textStatus, errorThrown) {
								                $.messager.alert ('删除错误', '请联系管理员！', 'error');
							                },
							                dataType : 'json'
							            });
							            
						            }
					            });
					            
				            } else{
					            $.messager.show ({
					                title : '操作提示',
					                msg : '请先选择要审核的单位。',
					                timeout : 4000,
					                showType : 'slide'
					            });
					            
				            }//else
				            
			            }//function
			            
			        }
		        ],
		        /*字段**************************************/
		        columns : [
			        [
			                {
			                    field : 'ck',
			                    checkbox : true
			                }, {
			                    field : 'companyid',
			                    title : '编号',
			                    width : 100
			                }, {
			                    field : 'companyname',
			                    title : '名称',
			                    width : 100
			                }, {
			                    field : 'companytypeid',
			                    title : '单位类型',
			                    width : 100,
			                    formatter : function (value, row, index) {
				                    return valueToText (companyTypeArray, value);
			                    }
			                
			                }, {
			                    field : 'companyphone',
			                    title : '联系电话',
			                    width : 100,
			                
			                }, {
			                    field : 'email',
			                    title : '邮箱',
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
