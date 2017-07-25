package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Spstaff;

public interface SpstaffMapper {
    
    public List<Spstaff> select(Page<Spstaff> page);
    
    public int selectCount(Page<Spstaff> page);
    
    public int updateByID(Spstaff sf);
    
    public int insert(Spstaff sf);
}
