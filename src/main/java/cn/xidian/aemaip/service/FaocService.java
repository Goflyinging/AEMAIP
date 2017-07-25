package cn.xidian.aemaip.service;

import cn.xidian.aemaip.entity.Faoc;
import cn.xidian.aemaip.entity.Page;

public interface FaocService {
    
    /**
     * Description:[分页查询验收]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月1日
     * @param page
     * @return
     */
    public Page<Faoc> selectPage(Page<Faoc> page);
    
    /**
     * Description:[多值更新]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月1日
     * @param f
     * @return
     * @throws Exception
     */
    public int updateByID(Faoc f) throws Exception;
    
    /**
     * Description:[添加]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月1日
     * @param f
     * @return
     * @throws Exception
     */
    public int insert(Faoc f) throws Exception;
}
