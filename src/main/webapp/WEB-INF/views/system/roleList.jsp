<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${basePath}/jquery-easyui-1.5/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basePath}/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="${basePath}/js/common.js"></script>

<link rel="stylesheet" type="text/css" href="${basePath}/jquery-easyui-1.5/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-easyui-1.5/themes/bootstrap/easyui.css">


<link rel="shortcut icon" href="${basePath}/images/favicon.ico" type="image/x-icon" />
<html>
<head>
<title></title>
<script type="text/javascript">
	$ (function () {
	    $ (function () {
		    $ ('#dg').datagrid ({
		        url : '${basePath}/sys/roleList',
		        fitColumns : true,
		        nowrapL : true,
		        idField : 'cid',
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
		                    text : '添加角色',
		                    handler : function () {
			                    addNew ();
		                    }
		                }, '-', {
		                    iconCls : 'icon-edit',
		                    text : '修改角色',
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
			                    field : 'cid',
			                    title : '角色编号',
			                    width : 60
			                }, {
			                    field : 'mdg',
			                    title : '角色名称',
			                    width : 200
			                }
			        ]
		        ]
		    });
		    
	    });
    });
</script>
</head>
<body style="margin: 0px;">
	<div id="dlg" class="easyui-dialog" style="width: 400px; padding: 20px 50px" closed="true"
		buttons="#dlg-buttons">
		<div style="margin-bottom: 10px;">
			<input id="mdgid" class="easyui-textbox" name="mdg" label="角色名称" required="true"
				labelPosition="top" style="width: 100%;">
		</div>
		<div class="easyui-panel" style="margin-bottom: 10px; height: 300px; padding: 5px;" title="可访问资源">
			<ul id="tt" class="easyui-tree"
				data-options="
				url: '${basePath}/find/tree',
				animate: true,
				method: 'get',
				lines:true,
				checkbox:true,
				formatter:function(node,data){
						var s = node.resourcename;
						
					return s; 
			},
			onLoadSuccess: function(node){
			$('#tt').tree('collapseAll');
			}
			">
			</ul>
		</div>
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
	    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '添加角色');
	    url = "${basePath}/sys/addRole";
    }
    function editUser () {
	    var row = $ ('#dg').datagrid ('getSelected');
	    if (row){
		    $ ('#dlg').dialog ('open').dialog ('center').dialog ('setTitle', '修改角色');
		    $ ('#mdgid').textbox ('setText', row.mdg);
		    $ ('#tt').tree ({
			    onLoadSuccess : function () {
				    $ ('#tt').tree ('collapseAll');
				    //绑定权限  
				    $.ajax ({
				        url : '${basePath}/sys/getResources?id=' + row.cid,
				        cache : false,
				        dataType : 'text',
				        success : function (data) {
					        var array = eval ('(' + data + ')');
					        for (var i = 0; i < array.length; i++){
						        var node = $ ('#tt').tree ('find', array[i]);
						        if ($ ('#tt').tree ('isLeaf', node.target)){
							        $ ('#tt').tree ('check', node.target);
						        }
					        }
				        }
				    });
				    
			    }
		    });
		    url = '${basePath}/sys/updateRole?cid=' + row.cid;
	    } else{
		    $.messager.show ({
		        title : '操作提示',
		        msg : '请先选择要修改的角色',
		        timeout : 4000,
		        showType : 'slide'
		    });
	    }
    }

    function saveUser () {
	    var name = $ ('#mdgid').val ();
	    if (name == null || name == ""){
		    alert ("请输入名称！");
		    return;
	    }
	    var nodes = $ ('#tt').tree ('getChecked');
	    var node1 = $ ('#tt').tree ('getChecked','indeterminate');
	    if (nodes == null || nodes == ""){
		    alert ("请选择权限");
		    return;
	    }
	    var ids = new Array ();
	    var i;
	    for (i = 0; i < nodes.length; i++){
		    ids[i] = nodes[i].id;
	    }
	    var j = 0;
	    for (i; i < node1.length+nodes.length; i++){
		    ids[i] = node1[j++].id;
	    }
	    $.ajax ({
	        url : url,
	        type : "POST",
	        traditional : true,
	        data : {
	            mdg : name,
	            ids : ids
	        },
	        success : function (result) {
		        if (!result){
			        $.messager.show ({
			            title : 'Error',
			            msg : "操作失败"
			        });
		        } else{
			        $.messager.show ({
			            title : 'ok',
			            msg : "操作成功"
			        });
			        $ ('#dlg').dialog ('close');
			        $ ('#dg').datagrid ('reload');
		        }
	        },
	        error : function (XMLHttpRequest, textStatus, errorThrown) {
		        $.messager.alert ('修改错误', '请联系管理员！', 'error');
	        },
	        dataType : 'json'
	    });
    }
</script>
</html>
