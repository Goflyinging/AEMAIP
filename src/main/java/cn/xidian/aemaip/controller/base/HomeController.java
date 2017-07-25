package cn.xidian.aemaip.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * Created on 2016年8月24日<br>
 * Title: [aemaip]_[控制层的父类]<br>
 * Description: [存放一些公共属性和方法]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软件学院<br>
 * 
 * @author 路星星
 * @version 1.0
 */
@Controller
public class HomeController {

	@RequestMapping("/exit")
	public String exit(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("privileges");
		return "redirect:/";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "common/index";
	}
}
