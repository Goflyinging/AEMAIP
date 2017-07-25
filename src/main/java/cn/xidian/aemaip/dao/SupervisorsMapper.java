package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Supervisors;

public interface SupervisorsMapper {
    
    public List<Supervisors> select(Page<Supervisors> page);
    
    public int selectCount(Page<Supervisors> page);
    
    public int updateByID(Supervisors s);
    
    public int insert(Supervisors s);
}
