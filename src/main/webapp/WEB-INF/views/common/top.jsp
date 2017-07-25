<%@ page language="java" pageEncoding="utf-8"%>
<div data-options="region:'north'"
	style="height:50px;overflow: hidden;background: url(${basePath}/images/topbg.gif) #7f99be repeat-x center 50%;">
	<div class="topleft">
		<img
			src="${basePath}/images/logo.png" title="系统首页" />
	</div>
	<div class="user">
		<span>${sessionScope.user.username}</span><i> <a href="${basePath}/exit"
			>退出</a></i>&nbsp;
	</div>
</div>