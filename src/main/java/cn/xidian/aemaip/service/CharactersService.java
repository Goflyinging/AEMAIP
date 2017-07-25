package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.Characters;
import cn.xidian.aemaip.entity.Page;

public interface CharactersService {
    /**
     * Description:[实现对角色的插入]<br>
     * 适用场景：[插入新的角色]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月27日
     * @param msg
     * @return
     * @throws Exception
     */
    public int insert(String msg) throws Exception;
    
    /**
     * Description:[查询所有角色列表]<br>
     * 适用场景：[用户分配角色]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月27日
     * @return
     * @throws Exception
     */
    public List<Characters> selectAll() throws Exception;
    
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
    public Page<Characters> select(Page<Characters> page);
    
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
    public int updateByID(Characters c) throws Exception;
    
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
    public int delete(Characters c) throws Exception;
    
    /**
     * Description:[更新角色的资源信息]<br>
     * 处理逻辑：[输入角色id和资源id数组]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月3日
     * @param cid
     * @param rid
     * @return
     * @throws Exception
     */
    public int setResource(int cid, int[] rid) throws Exception;
    
    /**
     * Description:[获取资源]<br>
     * 处理逻辑：[根据角色id获取资源]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月3日
     * @param cid
     * @return
     */
    public List<Integer> getResourceID(int cid);
    
    /**
     * Description:[更改角色及其信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[entity一定要有赋值，不然会删除整张表]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月5日
     * @param entity
     * @param rid
     * @return
     * @throws Exception
     */
    public int updateResource(Characters entity, int[] rid) throws Exception;
    
    /**
     * Description:[新增角色并分配权限]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月6日
     * @param mdg
     * @param rid
     * @return
     * @throws Exception
     */
    public int newCharacters(String mdg, int[] rid) throws Exception;
}
