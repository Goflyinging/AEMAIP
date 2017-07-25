package cn.xidian.aemaip.content;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 * Created on 2016年8月23日<br>
 * Title: [AEMAIP]_[命名常数]<br>
 * Description: [描述该类概要功能介绍]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软件学院<br>
 * 
 * @author 路星星
 * @version 1.0
 */
public class Content {
    /* 存放sessionID和userID 用来判断是否多个用户登录 */
    public static Map<Integer, String> USER_SESS_ID =
                                                    new ConcurrentHashMap<Integer, String>();// 保存sessionID和username的映射
    /* 系统加载后参数变量设置 */
    /* 系统参数 */
    
    public static String SYS_PARAM = "sys_param";
    /* 公司类型 */
    public static String COMPANY_TYPE = "company_type";
    public static String PRJSTATE_TYPE = "prjState_type";
    /*sex类型*/
    public static String SEX_TYPE = "sex_type";
    /*resources*/
    public static String RESOURCES = "resources";
    
    /* 四川省编号 最高层 */
    public static int ADDRESSID_SICHUAN_ID = 1024;
    
    /* session 中存放的用户 */
    public static String USER = "user";
    
    /* session中 存放用户权限ID集合 */
    public static String PRIVILEGES = "privileges";
    
}
