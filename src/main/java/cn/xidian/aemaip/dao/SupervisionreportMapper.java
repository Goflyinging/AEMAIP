package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Supervisionreport;

public interface SupervisionreportMapper {
    
    public List<Supervisionreport> select(Page<Supervisionreport> page);
    
    public int selectCount(Page<Supervisionreport> page);
    
    public List<Supervisionreport> select1(Page<Supervisionreport> page);
    
    public int selectCount1(Page<Supervisionreport> page);
    
    public int updateByID(Supervisionreport sr);
    
    public int insert(Supervisionreport sr);
}
