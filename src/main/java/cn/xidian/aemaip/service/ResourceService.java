package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Resource;;

public interface ResourceService {
    /**
     * Description:[插入新附件]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param resource
     * @return
     */
    public int insert(Resource resource);
    
    /**
     * Description:[查询子权限列表]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param Res_resourceid
     * @return
     */
    public List<Resource> findSonResource(int Res_resourceid);
    
    //
    /**
     * Description:[分页查询角色]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月3日
     * @param page
     * @return
     */
    public Page<Resource> select(Page<Resource> page);
    
    /**
     * Description:[根据id更新]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月3日
     * @param c
     * @return
     * @throws Exception
     */
    public int updateByID(Resource r) throws Exception;
    
    /**
     * Description:[多值删除]<br>
     * 处理逻辑：[所有满足传入对象赋值的都会被删除]<br>
     * 适用场景：[不要传入无赋值对象，会删除整张表内容]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月3日
     * @param c
     * @return
     * @throws Exception
     */
    public int delete(Resource r) throws Exception;
    
    /**
     * Description:[查询所有资源的树状结构]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月4日
     * @return
     */
    public List<Resource> selectAll();
    
}
