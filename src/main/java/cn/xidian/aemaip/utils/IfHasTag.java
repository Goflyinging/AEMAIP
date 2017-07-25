package cn.xidian.aemaip.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/***
 * Created on 2016年8月27日<br>
 * Title: [aemaip]_[jstl标签]<br>
 * Description: [判断用户是否有权限加载东西]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软件学院<br>
 * 
 * @author 路星星
 * @version 1.0
 */
public class IfHasTag extends SimpleTagSupport {
    private int id;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        HttpSession session =
                            (HttpSession) ((PageContext) this.getJspContext()).getSession();
        if (session == null)
            return;
        List<Integer> list = (List<Integer>) session.getAttribute("privileges");
        if (list == null)
            return;
        for (Integer i : list) {
            if (i == id) {
                this.getJspBody().invoke(null);
                break;
            }
        }
    }
}
