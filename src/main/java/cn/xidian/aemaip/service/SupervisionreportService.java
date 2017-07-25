package cn.xidian.aemaip.service;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Supervisionreport;

public interface SupervisionreportService {
    
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
    public Page<Supervisionreport> select(Page<Supervisionreport> page);
    
    /**
     * Description:[更新]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月1日
     * @param sr
     * @return
     * @throws Exception
     */
    public int updateByID(Supervisionreport sr) throws Exception;
    
    /**
     * Description:[添加]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月1日
     * @param sr
     * @return
     * @throws Exception
     */
    public int insert(Supervisionreport sr) throws Exception;
    
    /**
     * Description:[填写监督报告]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月1日
     * @param projectid
     * @param entity
     * @return
     */
    public int writeSupervisionReport(Supervisionreport entity);
    
    /**
     * Description:[更改监督报告]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月1日
     * @param projectid
     * @param entity
     * @return
     */
    public int changeSupervisionReport(Supervisionreport entity);
    
    /**
     * Description:[删除监督报告]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月1日
     * @param projectid
     * @param entity
     * @return
     */
    public int delectSupervisionReport(Supervisionreport entity);
    
    /**
     * Description:[提交监督报告]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月1日
     * @param projectid
     * @param entity
     * @return
     */
    public int submitSupervisionReport(Supervisionreport entity);
}
