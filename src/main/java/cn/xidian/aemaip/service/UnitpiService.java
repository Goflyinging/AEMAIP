package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Unitpi;

public interface UnitpiService {
    
    /**
     * Description:[根据人员信息id查找人员信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param id
     * @return
     */
    public Unitpi getPIById(int id);
    
    /**
     * Description:[根据公司查找所有人员信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param cid
     * @return
     */
    public List<Unitpi> getPIByCompany(int cid);
    
    /**
     * Description:[根据msg查找所有人员信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param msg
     * @return
     */
    public List<Unitpi> getPIByMsg(String msg);
    
    /**
     * Description:[添加人员信息]<br>
     * 处理逻辑：[输入为人员信息对象]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param pi
     * @return
     * @throws Exception
     */
    public int addPI(Unitpi pi) throws Exception;
    
    /**
     * Description:[根据id更新msg]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param id
     * @param msg
     * @return
     * @throws Exception
     */
    public int updateMsgByID(int id, String msg) throws Exception;
    
    /**
     * Description:[查询,]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月30日
     * @param page
     * @return
     */
    public Page<Unitpi> select(Page<Unitpi> page);
    
    /**
     * Description:[更新]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月30日
     * @param upi
     * @return
     * @throws Exception
     */
    public int updateByID(Unitpi upi) throws Exception;
}
