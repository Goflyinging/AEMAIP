package cn.xidian.aemaip.interceptor;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.xidian.aemaip.content.Content;
import cn.xidian.aemaip.entity.Users;

/***
 * Created on 2016年8月25日<br>
 * Title: [ameaip]_[拦截器]<br>
 * Description: [判断用户状态和权限进行拦截]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软件学院<br>
 * 
 * @author 路星星
 * @version 1.0
 */
@Component("helloInterceptor")
public class HelloInterceptor implements HandlerInterceptor {

	@Resource
	protected ServletContext application;

	// 执行Action前先判断权限
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		// 先判断是否已经重复登录
		HttpSession session = request.getSession();
		// Users user = (Users) session.getAttribute(Content.USER);
		// if (user != null) {
		// String sessionID = Content.USER_SESS_ID.get(user.getAccount());
		// if (!session.getId().equals(sessionID)) {
		// // 跳转到另外一个页面
		// response.sendRedirect(request.getContextPath()); // 别人已经登录了
		// session.removeAttribute(Content.USER);// 移除session中的用户
		// return false;
		// }
		// }
		// 用户在线状态判断 end
		// 判断用户权限 //
		String url = request.getServletPath();
		// 查找url对应的ID
		Integer id = null;
		Map sysParam = (Map) application.getAttribute(Content.SYS_PARAM);
		List<cn.xidian.aemaip.entity.Resource> resources = (List) sysParam.get(Content.RESOURCES);
		if (resources != null) {
			outer: for (cn.xidian.aemaip.entity.Resource re : resources) {
				if (re.getChildren() != null) {
					for (cn.xidian.aemaip.entity.Resource re1 : re.getChildren()) {
						if (url.equals(re1.getAdress())) {
							id = re1.getResourceid();
							break outer;
						}
						if (re1.getChildren() != null) {
							for (cn.xidian.aemaip.entity.Resource re2 : re1.getChildren()) {
								if (url.equals(re2.getAdress())) {
									id = re2.getResourceid();
									break outer;
								}

							} // for3
						} // if
					} // for2
				} // if
			} // for1
		}
		if (id == null) {
			response.sendRedirect(request.getContextPath() + "/find/common/notFind");
			return false;
		}
		// 查看url对应的ID是否在用户权限里
		List<Integer> list = (List<Integer>) session.getAttribute("privileges");
		for (Integer i : list) {
			if (id .equals(i)) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath() + "/find/common/noPrivilege");
		return false;
	}

	// 生成视图前，可以改model和视图
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {
	}
}
