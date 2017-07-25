package cn.xidian.aemaip.service;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Supervisionrecord;

public interface SupervisionrecordService {
    
    /**
     * Description:[分页多值查询]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月1日
     * @param page
     * @return
     */
    public Page<Supervisionrecord> select(Page<Supervisionrecord> page);
    
    /**
     * Description:[多值更新]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月1日
     * @param sr
     * @return
     */
    public int updateByID(Supervisionrecord sr);
    
    /**
     * Description:[添加 ]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月1日
     * @param sr
     * @return
     */
    public int insert(Supervisionrecord sr);
}
