package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.Qss;

public interface QssService {
    /**
     * Description:[根据质监站id获取质监站信息]<br>
     * 处理逻辑：[返回为空说明不存在]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月27日
     * @param id
     * @return
     */
    public Qss getByID(int id);
    
    /**
     * Description:[根据地质选择质监站]<br>
     * 处理逻辑：[返回为空说明不存在]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月27日
     * @param adid
     * @return
     */
    public List<Qss> getByAddress(int adid);
}
