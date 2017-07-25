<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title></title>
<script type="text/javascript">
	var sexTypeArray = "${applicationScope.sys_param.prjState_type}";
	var stateTypeArray = "${applicationScope.sys_param.prjState_type}";
	$ (function () {
	    $ (function () {
		    $ ('#dg').datagrid ({
		        url : '${basePath}/project/groupProList',
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
		                    iconCls : 'icon-add',
		                    text : '分配监督组',
		                    handler : function () {
			                    zuchengjdz ();
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
	<div id="dlgzz" class="easyui-dialog" style="width: 400px" closed="true" buttons="#dlgzz-buttons">
		<div style="margin-bottom: 10px">
			<select id="cczz" name="id" class="register-select"
				style="width: 148px; margin-left: 125px; margin-top: 10px">
			</select>
		</div>
	</div>
	<div id="dlgzz-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok"
			onclick="zuchengjdzSave()" style="width: 90px">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlgzz').dialog('close')" style="width: 90px">Cancel</a>
	</div>
	<table id="dg"></table>
</body>
<script type="text/javascript">
	//组成监督组
    var proID;
    function zuchengjdz () {
	    var array = $ ('#dg').datagrid ("getSelected");
	    if (array){
		    $ ("#cczz option").remove ();
		    proID = array.projectid;
		    var url = "${basePath}/find/oversightGroup?time=" + new Date ().getTime ();
		    //参数三：function(){}处理或回调函数
		    $.post (url, null, function (backData, textStatus, ajax) {
			    //数组的长度
			    var size = backData.length;
			    //迭代数组
			    for (var i = 0; i < size; i++){
				    //获取数组中的每个元素
				    var value = backData[i].ogid;
				    var name = backData[i].leader;
				    //创建option元素
				    var $option = $ ("<option value='"+value+"'>" + value + "</option>");
				    //将option元素添加到区域下拉框中
				    $ ("#cczz").append ($option);
			    }
		    });
		    $ ('#dlgzz').dialog ('open').dialog ('center').dialog ('setTitle', '请选择监督组组长');
		    
	    } else{
		    $.messager.show ({
		        title : '操作提示',
		        msg : '请先选择选择一项工程',
		        timeout : 4000,
		        showType : 'slide'
		    });
	    }
    }

    //保存组成的监督组
    function zuchengjdzSave () {
	    var groupID = $ ('#cczz').val ();
	    $.ajax ({
	        url : "${basePath}/zjz/fpJDZ",
	        type : "POST",
	        traditional : true,
	        data : {
	            proID : proID,
	            groupID : groupID
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
</script>
</html>
