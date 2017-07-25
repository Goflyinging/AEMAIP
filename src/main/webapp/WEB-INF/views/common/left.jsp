<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://lx.aemaip.cn" prefix="l"%>
<div data-options="region:'west'" title="功能菜单"
	style="overflow: hidden; width: 190px; background: #f0f9fd;" id="west">
	<div id="nav" class="easyui-accordion" fit="true" style="background: #f0f9fd; overflow: hidden;"
		border="false">
		<%--显示一级菜单 --%>
		<c:forEach items="${applicationScope.sys_param.resources}" var="resource">
			<l:ifhas id="${resource.resourceid}">
				<div title="${resource.resourcename}" style="background: #f0f9fd; overflow: hidden;">
					<ul class="menuson">
						<c:forEach items="${resource.children}" var="resource2">
							<l:ifhas id="${resource2.resourceid}">
								<li>
									<cite></cite>
									<a href="${basePath}${resource2.adress}">${resource2.resourcename}</a>
									<i></i>
								</li>
							</l:ifhas>
						</c:forEach>
					</ul>
				</div>
			</l:ifhas>
		</c:forEach>
	</div>
</div>
