package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.Docstate;

public interface DocstateService {
    /**
     * Description:[多值查询文档状态表]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月31日
     * @param mp
     * @return
     */
    public List<Docstate> select(Docstate ds);
}
