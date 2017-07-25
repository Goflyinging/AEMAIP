package cn.xidian.aemaip.service;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Supervisors;

public interface SupervisorsService {
    
    /**
     * Description:[分页查询]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月30日
     * @param page
     * @return
     */
    public Page<Supervisors> select(Page<Supervisors> page);
    
    /**
     * Description:[根据id更新]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月30日
     * @param s
     * @return
     * @throws Exception
     */
    public int updateByID(Supervisors s) throws Exception;
    
    /**
     * Description:[添加]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月30日
     * @param s
     * @return
     * @throws Exception
     */
    public int insert(Supervisors s) throws Exception;
}
