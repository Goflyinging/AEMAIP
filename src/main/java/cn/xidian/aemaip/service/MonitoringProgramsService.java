package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.MonitoringPrograms;
import cn.xidian.aemaip.entity.Page;

public interface MonitoringProgramsService {
    
    /**
     * Description:[选择]<br>
     * 处理逻辑：[主要使用select方法，根据传入的参数选择，空对象为全选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月31日
     * @param mp
     * @return
     */
    public List<MonitoringPrograms> select(MonitoringPrograms mp);
    
    /**
     * Description:[分页选择]<br>
     * 处理逻辑：[备用]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月31日
     * @param page
     * @return
     */
    public Page<MonitoringPrograms> selectPage(Page<MonitoringPrograms> page);
    
    /**
     * Description:[根据id更新]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月31日
     * @param mp
     * @return
     * @throws Exception
     */
    public int updateByID(MonitoringPrograms mp) throws Exception;
    
    /**
     * Description:[添加]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月31日
     * @param mp
     * @return
     * @throws Exception
     */
    public int insert(MonitoringPrograms mp) throws Exception;
}
