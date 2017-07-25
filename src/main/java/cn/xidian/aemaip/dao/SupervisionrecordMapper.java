package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Supervisionrecord;

public interface SupervisionrecordMapper {
    
    public List<Supervisionrecord> select(Page<Supervisionrecord> page);
    
    public int selectCount(Page<Supervisionrecord> page);
    
    public int updateByID(Supervisionrecord sr);
    
    public int insert(Supervisionrecord sr);
}
