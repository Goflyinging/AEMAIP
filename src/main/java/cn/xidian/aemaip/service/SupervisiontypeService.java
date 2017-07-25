package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.Supervisiontype;

public interface SupervisiontypeService {
    
    /**
     * Description:[多值查询监督类型表]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月31日
     * @param st
     * @return
     */
    public List<Supervisiontype> select(Supervisiontype st);
}
