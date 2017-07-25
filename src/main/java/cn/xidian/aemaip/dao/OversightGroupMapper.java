package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.OversightGroup;
import cn.xidian.aemaip.entity.Page;

public interface OversightGroupMapper {
    
    public List<OversightGroup> select(Page<OversightGroup> page);
    
    public int selectCount(Page<OversightGroup> page);
    
    public int updateByID(OversightGroup og);
    
    public int insert(OversightGroup og);
    
    public int selectLast();
}
