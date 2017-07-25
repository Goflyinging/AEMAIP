package cn.xidian.aemaip.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
/***
 * 
 * Created on 2016年8月26日<br>
 * Title:       [aemaip]_[校验工具]<br>
 * Description: [提供表单校验工具]<br>
 * Copyright:   Copyright (c) 2016<br>
 * Company:     西安电子科技大学<br>
 * Department:  软件学院<br>
 * @author         路星星 
 * @version        1.0
 */
public class validator {
    /***
     * 
     * Description:[验证用户帐号是否合法]<br>
     * @author:路星星
     * @update: 2016年8月26日
     * @param username
     * @return true/false
     */
    public boolean validatorUsername(String username) {
        Pattern pattern = Pattern.compile("[\\w]{5,16}",
                                          Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    
}
