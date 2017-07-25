package cn.xidian.aemaip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xidian.aemaip.content.Content;
import cn.xidian.aemaip.controller.base.BaseController;
import cn.xidian.aemaip.entity.Users;

/***
 * 
 * Created on 2016年8月27日<br>
 * Title:       [aemaip]_[监督管理]<br>
 * Description: [监督处理入口]<br>
 * Copyright:   Copyright (c) 2016<br>
 * Company:     西安电子科技大学<br>
 * Department:  软件学院<br>
 * @author         路星星 
 * @version        1.0
 */
@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {
    
    @RequestMapping("/add")
    @ResponseBody
    public Object sysLogin() {
        int i=0;
        i=1;
        return i;
    }
    
    @RequestMapping("/addUI")
    public String addui() {
        
        return "systerm/addArea";
    }
}
