package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.Companytype;

public interface CompanytypeService {
    /**
     * Description:[根据id确定类型]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月25日
     * @param id
     * @return
     */
    public Companytype selectTypeById(int id);
    
    /**
     * Description:[获得所有公司类型]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月25日
     * @return
     */
    public List<Companytype> selectAllType();
}
