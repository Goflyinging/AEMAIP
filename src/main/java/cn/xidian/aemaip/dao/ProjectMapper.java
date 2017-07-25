package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Project;

public interface ProjectMapper {
    /**
     * Description:[插入新项目]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param entity
     * @return
     */
    public int insert(Project entity);
    
    /**
     * Description:[查询记录数]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param page
     * @return
     */
    public Integer selectCount(Page<Project> page);
    
    /**
     * Description:[查询项目列表]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param page
     * @return
     */
    public List<Project> select(Page<Project> page);
    
    /**
     * Description:[查询审核未通过记录数]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param page
     * @return
     */
    public Integer selectCount1(Page<Project> page);
    
    /**
     * Description:[查询审核未通过项目列表]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param page
     * @return
     */
    public List<Project> select1(Page<Project> page);
    
    /**
     * Description:[更新项目状态]<br>
     * 处理逻辑：[]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param projectid
     * @param prjsid
     * @return
     */
    public int updatePrjsidById(int projectid, int prjsid);
    
    /**
     * Description:[填写结束时间]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param projectid
     * @return
     */
    public int updateEndTime(int projectid);
    
    /**
     * Description:[更新项目注册审核意见]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param projectid
     * @param msg
     * @return
     */
    public int updateMsg(int projectid, String msg);
    
    /**
     * Description:[根据主键寻找项目]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param projectid
     * @return
     */
    public Project selectById(int projectid);
    
    /**
     * Description:[更新项目描述信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param projectid
     * @param Rego
     * @return
     */
    public int updateRegao(int projectid, String Rego);
    
    /**
     * Description:[为项目更新监督组]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月1日
     * @param projectid
     * @param ogid
     * @return
     */
    public int updateogid(int projectid, int ogid);
    
    /**
     * Description:[修改项目信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月2日
     * @param entity
     * @return
     */
    public int update(Project entity);
}
