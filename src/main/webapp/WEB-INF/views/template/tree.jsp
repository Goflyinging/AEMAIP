<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title></title>
</head>
<body>
	<div class="easyui-panel" style="padding: 5px;width:100px">
		<ul id="tt" class="easyui-tree"
			data-options="
				url: '${basePath}/find/tree',
				method: 'get',
				animate: true,
				onClick: function(node){
					$(this).tree('beginEdit',node.target);
				},
				onContextMenu: function(e,node){
					e.preventDefault();
					$(this).tree('select',node.target);
					$('#mm').menu('show',{
						left: e.pageX,
						top: e.pageY
					});
				}
			">
		</ul>
	</div>

	<div id="mm" class="easyui-menu" style="width: 120px;">
		<div onclick="append()" data-options="iconCls:'icon-add'">Append</div>
		<div onclick="removeit()" data-options="iconCls:'icon-remove'">Remove</div>
		<div class="menu-sep"></div>
		<div onclick="expand()">Expand</div>
		<div onclick="collapse()">Collapse</div>
	</div>
</body>


<script type="text/javascript">
	function append() {
		var t = $('#tt');
		var node = t.tree('getSelected');
		t.tree('append', {
			parent : (node ? node.target : null),
			data : [ {
				text : 'new item1'
			}, {
				text : 'new item2'
			} ]
		});
	}
	function removeit() {
		var node = $('#tt').tree('getSelected');
		$('#tt').tree('remove', node.target);
	}
	function collapse() {
		var node = $('#tt').tree('getSelected');
		$('#tt').tree('collapse', node.target);
	}
	function expand() {
		var node = $('#tt').tree('getSelected');
		$('#tt').tree('expand', node.target);
	}
</script>
</html>
