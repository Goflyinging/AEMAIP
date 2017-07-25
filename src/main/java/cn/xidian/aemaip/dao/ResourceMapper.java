package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Resource;

public interface ResourceMapper {
    /**
     * Description:[插入新权限]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param entity
     * @return
     */
    public int insert(Resource entity);
    
    /**
     * Description:[根据主键查找权限]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param resourceid
     * @return
     */
    public Resource selectById(int resourceid);
    
    /**
     * Description:[根据地址查找权限]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param adress
     * @return
     */
    public Resource selectByaddress(String adress);
    
    /**
     * Description:[查询子权限列表]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月31日
     * @param Res_resourceid
     * @return
     */
    public List<Resource> selectByRes_resourceid(int Res_resourceid);
    
    public List<Resource> select(Page<Resource> page);
    
    public int selectCount(Page<Resource> page);
    
    public int updateByID(Resource r);
    
    public int delete(Resource r);
    
    
    public List<Resource> selectAll();
}
