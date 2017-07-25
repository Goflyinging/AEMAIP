<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title></title>
<script type="text/javascript">
	var toolbar = [ {
		text : '审核',
		iconCls : 'icon-ok',
		handler : function() {
			var select = $("#dg").datagrid("getSelected");
			if (select != null) {
				var id = select.companyid;
				alert(id);
				parent.$.messager.confirm('确认对话框', '您确认要审核所选单位吗？', function(r) {
					if (r) {
						/*  异步提交	
						$.ajax({
							  url: "${proPath}/company/verifyCompany",
							  type:"POST",
							  //设置为传统方式传送参数
							  traditional:true,
							  data:{id:id},
							  success: function(html){
							  //重新刷新页面
							    $("#dg").datagrid("reload");
							    //请除所有勾选的行
							    $("#dg").datagrid("clearSelections");
							  },
							  error: function (XMLHttpRequest, textStatus, errorThrown) {
								    $.messager.alert('删除错误','请联系管理员！','error');
								},
							  dataType:'json'
							}); ***异步提交***/

					}
				});

			} else {
				$.messager.show({
					title : '操作提示',
					msg : '请先选择要审核的单位。',
					timeout : 4000,
					showType : 'slide'
				});

			}//else

		}//function

	} ];
</script>
</head>
<body>
	<table id="dg" class="easyui-datagrid"
		data-options="
			rownumbers:true,
			singleSelect:true,
			url:'${basePath}/company/noVerifyList',
			idField : 'companyid',
			fitColumns:true,
			pagination:true,
			pageSize : 5,  
	        pageList : [ 2, 5, 10, 20 ],
			toolbar:toolbar">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'companyid',width:80">编号</th>
				<th data-options="field:'companyname',width:100">名称</th>
				<th data-options="field:'companytypeid',width:80">类型</th>
				<th data-options="field:'companyphone',width:100">联系电话</th>
				<th data-options="field:'email',width:100">邮箱</th>
				<th data-options="field:'test',width:100">test</th>

			</tr>
		</thead>
	</table>
</body>
</html>
