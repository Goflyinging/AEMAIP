package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Character_Resource;
import cn.xidian.aemaip.entity.Page;

public interface Character_ResourceMapper {
    
    public int insert(Character_Resource entity);
    
    public List<Character_Resource> selectByCid(int cid);
    
    //
    public List<Character_Resource> select(Page<Character_Resource> page);
    
    public int selectCount(Page<Character_Resource> page);
    
    public int updateByID(Character_Resource cr);
    
    public int delete(Character_Resource cr);
}
