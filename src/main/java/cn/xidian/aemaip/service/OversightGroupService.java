package cn.xidian.aemaip.service;

import cn.xidian.aemaip.entity.OversightGroup;
import cn.xidian.aemaip.entity.Page;

public interface OversightGroupService {
    
    /**
     * Description:[查询方法，]<br>
     * 处理逻辑：[根据page中多值查询对象的赋值情况进行查询 将需要的约束进行赋值，其他留空]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月30日
     * @param page
     * @return
     */
    public Page<OversightGroup> select(Page<OversightGroup> page);
    
    /**
     * Description:[更新]<br>
     * 处理逻辑：[根据传输的对象进行更新，根据主键]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月30日
     * @param og
     * @return
     * @throws Exception
     */
    public int updateByID(OversightGroup og) throws Exception;
    
    /**
     * Description:[添加]<br>
     * 处理逻辑：[添加传输的对象到数据库，忽略ogid]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月30日
     * @param og
     * @return
     * @throws Exception
     */
    public int add(OversightGroup og) throws Exception;
    
    /**
     * Description:[添加监督组 ]<br>
     * 处理逻辑：[组长-组员列表]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月2日
     * @param leader
     * @param member
     * @return
     * @throws Exception
     */
    public int addGroup(int leader, int member[]) throws Exception;
}
