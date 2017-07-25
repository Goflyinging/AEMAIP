<%@ page language="java" pageEncoding="utf-8"%>
<div data-options="region:'west'" title="功能菜单"
	style="overflow: hidden; width: 190px; background: #f0f9fd;" id="west">
	<div id="nav" class="easyui-accordion" fit="true" style="background: #f0f9fd; overflow: hidden;"
		border="false">


		<div title="基础信息管理(sys)" style="background: #f0f9fd; overflow: hidden;">
			<ul class="menuson">
				<li>
					<cite></cite>
					<a href="${basePath}/find/company/noVerifyList">审核注册单位资料</a>
					<i></i>
				</li>
			</ul>
		</div>
		<div title="组织结构管理(sys)" style="background: #f0f9fd; overflow: hidden;">
			<ul class="menuson">
				<li>
					<cite></cite>
					<a href="${basePath}/find/company/noVerifyList">审核注册单位资料</a>
					<i></i>
				</li>
			</ul>
		</div>
		
		<div title="系统管理(sys)" style="background: #f0f9fd; overflow: hidden;">
			<ul class="menuson">
				<li>
					<cite></cite>
					<a href="${basePath}/find/system/usersList">用户管理</a>
					<i></i>
				</li>
				<li>
					<cite></cite>
					<a href="${basePath}/find/system/roleList">角色管理</a>
					<i></i>
				</li>
				<li>
					<cite></cite>
					<a href="${basePath}/find/system/resourceList">资源管理</a>
					<i></i>
				</li>
			</ul>
		</div>

		<div title="项目管理(zjz)" style="overflow: hidden; background: #f0f9fd;">
			<ul class="menuson">
				<li class="active">
					<cite></cite>
					<a href="${basePath}/find/zjz/checkList">项目审核</a>
					<i></i>
				</li>
				<li>
					<cite></cite>
					<a href="${basePath}/find/zjz/groupProList">分配监督组</a>
					<i></i>
				</li>
				<li>
					<cite></cite>
					<a href="${basePath}/find/zjz/endProList">竣工审核</a>
					<i></i>
				</li>
			</ul>
		</div>

		<div title="监督管理(zjz)" style="overflow: hidden; background: #f0f9fd;">
			<ul class="menuson">
				<li class="active">
					<cite></cite>
					<a href="${basePath}/find/zjz/qsspiList">人员管理</a>
					<i></i>
				</li>
				<li>
					<cite></cite>
					<a href="${basePath}/find/zjz/oversightGroupList">监督组管理</a>
					<i></i>
				</li>
			</ul>
		</div>
		<div title="日常监督(zjz)" style="overflow: hidden; background: #f0f9fd;">
			<ul class="menuson">
				<li class="active">
					<cite></cite>
					<a href="${basePath}/find/zjz/ProMonitorList">监督方案管理</a>
					<i></i>
				</li>
				<li>
					<cite></cite>
					<a href="${basePath}/find/zjz/addSupervisionReport">监督报告</a>
					<i></i>
				</li>
			</ul>
		</div>

		<div title="员工管理(dwzt)" style="background: #f0f9fd; overflow: hidden;">
			<ul class="menuson">
				<li>
					<cite></cite>
					<a href="${basePath}/find/company/unitpiList">人员管理</a>
					<i></i>
				</li>
			</ul>
		</div>
		<div title="工程管理(dwzt)" style="background: #f0f9fd; overflow: hidden;">
			<ul class="menuson">
				<li>
					<cite></cite>
					<a href="${basePath}/find/company/startProList">新增项目</a>
					<i></i>
				</li>
				<li>
					<cite></cite>
					<a href="${basePath}/find/company/applyCompletionList">提交竣工</a>
					<i></i>
				</li>
			</ul>
		</div>
	</div>
</div>
