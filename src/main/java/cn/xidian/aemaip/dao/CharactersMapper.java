package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Characters;
import cn.xidian.aemaip.entity.Page;

public interface CharactersMapper {
    /**
     * Description:[插入新角色]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月27日
     * @param msg
     * @return
     */
    public int insert(String msg);
    
    /**
     * Description:[通过名字查询角色]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月27日
     * @param msg
     * @return
     */
    public Characters selectByMdg(String msg);
    
    /**
     * Description:[查询所有角色]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月27日
     * @return
     */
    public List<Characters> selectAll();
    
    /**
     * Description:[通过Id查询角色]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月27日
     * @param cid
     * @return
     */
    public Characters selectById(int cid);
    
    //
    public List<Characters> select(Page<Characters> page);
    
    public int selectCount(Page<Characters> page);
    
    public int updateByID(Characters c);
    
    public int delete(Characters c);
}
