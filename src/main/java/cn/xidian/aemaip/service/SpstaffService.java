package cn.xidian.aemaip.service;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Spstaff;

public interface SpstaffService {
    
    /**
     * Description:[多值查询]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月1日
     * @param page
     * @return
     */
    public Page<Spstaff> select(Page<Spstaff> page);
    
    /**
     * Description:[更新]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月1日
     * @param sf
     * @return
     * @throws Exception
     */
    public int updateByID(Spstaff sf) throws Exception;
    
    /**
     * Description:[添加]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月1日
     * @param sf
     * @return
     * @throws Exception
     */
    public int insert(Spstaff sf) throws Exception;
}
