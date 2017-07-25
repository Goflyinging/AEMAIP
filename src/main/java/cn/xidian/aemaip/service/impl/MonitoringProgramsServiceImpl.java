package cn.xidian.aemaip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.MonitoringProgramsMapper;
import cn.xidian.aemaip.entity.MonitoringPrograms;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.service.MonitoringProgramsService;

@Service
public class MonitoringProgramsServiceImpl implements
                                           MonitoringProgramsService {
    
    @Autowired
    MonitoringProgramsMapper mpm;
    
    public List<MonitoringPrograms> select(MonitoringPrograms mp) {
        return mpm.select(mp);
    }
    
    public Page<MonitoringPrograms> selectPage(Page<MonitoringPrograms> page) {
        page.setTotalRecord(mpm.selectCount(page));
        page.setList(mpm.selectPage(page));
        return page;
    }
    
    public int updateByID(MonitoringPrograms mp) throws Exception {
        return mpm.updateByID(mp);
    }
    
    public int insert(MonitoringPrograms mp) throws Exception {
        return mpm.insert(mp);
    }
    
}
