<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf"%>
<html>
<head>
<title></title>
</head>
<body>
	<div class="easyui-panel" style="padding: 5px; margin-left: 200px; width: 600px">
		<ul id="tt" class="easyui-tree"
			data-options="
				url: '${basePath}/find/tree',
				animate: true,
				method: 'get',
				lines:true,
				checkbox:true,
				formatter:function(node){
						var s = node.id;
					return s; 
			}">
		</ul>
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">显示节点</a>
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
	function append () {
	    var t = $ ('#tt');
	    var node = t.tree ('getSelected');
	    t.tree ('append', {
	        parent : (node ? node.target : null),
	        data : [
	                {
		                text : 'new item1'
	                }, {
		                text : 'new item2'
	                }
	        ]
	    });
    }
    function removeit () {
	    var node = $ ('#tt').tree ('getSelected');
	    $ ('#tt').tree ('remove', node.target);
    }
    function collapse () {
	    var node = $ ('#tt').tree ('getSelected');
	    $ ('#tt').tree ('collapse', node.target);
    }
    function expand () {
	    var node = $ ('#tt').tree ('getSelected');
	    $ ('#tt').tree ('expand', node.target);
    }

    $ ("#btn").click (function () {
	    var nodes = $ ('#tt').tree ('getChecked');
	    for (var i = 0; i < nodes.length; i++){
		    alert (nodes[i].id);
	    }
	    
    });
</script>
</html>
