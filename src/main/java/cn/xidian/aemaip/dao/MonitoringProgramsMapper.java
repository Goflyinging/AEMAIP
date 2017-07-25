package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.MonitoringPrograms;
import cn.xidian.aemaip.entity.Page;

public interface MonitoringProgramsMapper {
    
    public List<MonitoringPrograms> select(MonitoringPrograms mp);
    
    public List<MonitoringPrograms> selectPage(Page<MonitoringPrograms> page);
    
    public int selectCount(Page<MonitoringPrograms> page);
    
    public int updateByID(MonitoringPrograms mp);
    
    public int insert(MonitoringPrograms mp);
    
}
