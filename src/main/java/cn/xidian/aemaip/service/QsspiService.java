package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Qsspi;

public interface QsspiService {
    
    /**
     * Description:[根据id选择人员信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月27日
     * @param id
     * @return
     */
    public Qsspi getQpiByID(int id);
    
    /**
     * Description:[根据msg选择人员信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月27日
     * @param msg
     * @return
     */
    public List<Qsspi> getQpiByMsg(String msg);
    
    /**
     * Description:[根据质监站选择人员信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月27日
     * @param qss
     * @return
     */
    public List<Qsspi> selectQpiByQss(int qss);
    
    /**
     * Description:[根据id修改人员信息msg]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月27日
     * @param id
     * @param msg
     * @return
     * @throws Exception
     */
    public int updateMsgByID(int id, String msg) throws Exception;
    
    /**
     * Description:[添加人员信息]<br>
     * 处理逻辑：[添加人员信息，返回添加的人员信息对象id 。<br>
     * 必须包括name，sex，tel，msg，account，qssid（质监站） <br>
     * 所有必须先创建账号，才能添加人员信息。 ]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月27日
     * @param qpi
     * @return
     * @throws Exception
     */
    public int insert(Qsspi qpi) throws Exception;
    
    /**
     * Description:[查询]<br>
     * 处理逻辑：[多值查询]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月30日
     * @param page
     * @return
     */
    public Page<Qsspi> get(Page<Qsspi> page);
    
    /**
     * Description:[更新]<br>
     * 处理逻辑：[多值更新]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月30日
     * @param qpi
     * @return
     */
    public int updateByID(Qsspi qpi) throws Exception;
}
