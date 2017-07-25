package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Companyaddress;

public interface CompanyaddressMapper {
    /***
     * Description:[添加实体对象到表中]<br>
     * 
     * @author:路星星
     * @update: 2016年8月21日
     * @param entity
     * @return 影响的行数
     */
    int insert(Companyaddress entity);
    
    /***
     * Description:[通过id查询实体信息]<br>
     * 
     * @author:路星星
     * @update: 2016年8月21日
     * @param id
     * @return 实体信息
     */
    Companyaddress selectByID(int id);
    
    /**
     * Description:根据pid选择结果<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月24日
     * @param pid
     * @return
     */
    List<Companyaddress> selectByPID(int pid);
}
