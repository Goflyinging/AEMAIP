package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Unitcharacter;

public interface UnitcharacterMapper {
    public List<Unitcharacter> select(Page<Unitcharacter> page);
    
    public int selectCount(Page<Unitcharacter> page);
    
    public int insert(Unitcharacter entity);
    
    public int updateById(Unitcharacter entity);
}
