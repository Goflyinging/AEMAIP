package cn.xidian.aemaip.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.xidian.aemaip.content.Content;
import cn.xidian.aemaip.entity.Users;

public class SessionListener implements HttpSessionListener {

	/** 以下是实现HttpSessionListener中的方法 **/
	public void sessionCreated(HttpSessionEvent se) {

	}

	/***
	 * Title: sessionDestroyed Description: 每次seesion销毁前看map集合中是否有账户ID与其有关联
	 * 
	 * @param se
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {

		Users user = (Users) se.getSession().getAttribute(Content.USER);
		if (user != null) {
			Content.USER_SESS_ID.remove(user.getAccount());
		}

	}

}
