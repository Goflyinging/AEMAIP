package cn.xidian.aemaip.service.base;

import java.util.List;

/***
 * Created on 2016年8月21日<br>
 * Title: [AEMAIP]_[Service]<br>
 * Description: [所有Service接口的父类，封装了一些常用的操作方法]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软件学院<br>
 * 
 * @author 路星星
 * @version 1.0
 */
public interface BaseService<T> {
    /***
     * Description:[添加实体对象到表中]<br>
     * 
     * @author:路星星
     * @update: 2016年8月21日
     * @param entity
     * @return 影响的行数
     */
    int insert(T entity) throws Exception;
    
    /***
     * Description:[通过id查询实体信息]<br>
     * 
     * @author:路星星
     * @update: 2016年8月21日
     * @param entity
     * @return 实体信息
     */
    T selectByID(T entity);
    
    /***
     * Description:[通过ID删除实体在表中的记录]<br>
     * 
     * @author:路星星
     * @update: 2016年8月21日
     * @param entity
     * @return 影响的行数
     */
    int deleteByID(T entity) throws Exception;
    
    /***
     * Description:[通过ID更新实体信息]<br>
     * 
     * @author:路星星
     * @update: 2016年8月21日
     * @param entity
     * @return
     */
    int updateByID(T entity);
    
    /***
     * Description:[通过实体信息查询所有相关的实体]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:路星星
     * @update: 2016年8月21日
     * @param entity
     * @return 实体集合
     */
    List<T> selectByInfo(T entity);
    
}
