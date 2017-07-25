package cn.xidian.aemaip.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xidian.aemaip.content.Content;
import cn.xidian.aemaip.controller.base.BaseController;
import cn.xidian.aemaip.entity.Companyaddress;
import cn.xidian.aemaip.entity.Users;

/***
 * Created on 2016年8月22日<br>
 * Title: [AEMAIP]_[登录和注册模块]<br>
 * Description: [管理各种登录]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软件学院<br>
 * 
 * @author 路星星
 * @version 1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
    /***
     * Description:[在主页中转发到对应的JSP登录页面]<br>
     * 
     * @author:路星星
     * @update: 2016年8月22日
     * @param file
     * @return 对应JSP页面路径
     */
    @RequestMapping("/{file}")
    public String goURL(Model model, @PathVariable String file) {
        if (file.equals("register")) {
            int pid = Content.ADDRESSID_SICHUAN_ID; // 地址最高层主键
            List<Companyaddress> list = companyaddressService.selectByPID(pid);
            model.addAttribute("citys", list);
        }
        return "login/" + file;
    }
    
    /***
     * 
     * Description:[确认登录信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * @author:路星星
     * @update: 2016年9月5日
     * @param users
     * @param request
     * @return
     */
    @RequestMapping("/confirmSys")
    public String sysLogin(Users users, HttpServletRequest request) {
        users = usersService.login(users.getUsername(), users.getPasswd());
        if (users == null) {
        	request.setAttribute("error", "用户名或密码错误!");
            return "login/sysLogin";
        }
        HttpSession session = request.getSession();
        session.setAttribute(Content.USER, users);
        List<Integer> list = usersService.findResourceByAccount(users.getAccount());
		request.getSession().setAttribute(Content.PRIVILEGES, list);
        return "redirect:/index";
    }
    
    @RequestMapping("/confirmZrdw")
    public String companyLogin(Users users, HttpServletRequest request) {
        users = usersService.login(users.getUsername(), users.getPasswd());
        if (users == null) {
        	request.setAttribute("error", "用户名或密码错误!");
        	return "login/zrdwLogin";
        }
        HttpSession session = request.getSession();
        session.setAttribute(Content.USER, users);
        List<Integer> list = usersService.findResourceByAccount(users.getAccount());
		request.getSession().setAttribute(Content.PRIVILEGES, list);
        return "redirect:/index";
    }
    
    @RequestMapping("/confirmZjz")
    public String ZjzLogin(Users users, HttpServletRequest request) {
        users = usersService.login(users.getUsername(), users.getPasswd());
        if (users == null) {
        	request.setAttribute("error", "用户名或密码错误!");
        	return "login/zjzLogin";
        }
        HttpSession session = request.getSession();
        session.setAttribute(Content.USER, users);
        List<Integer> list = usersService.findResourceByAccount(users.getAccount());
		request.getSession().setAttribute(Content.PRIVILEGES, list);
        return "redirect:/index";
    }
    
}
