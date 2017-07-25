package cn.xidian.aemaip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.ProjectMapper;
import cn.xidian.aemaip.dao.SupervisionreportMapper;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Supervisionreport;
import cn.xidian.aemaip.service.SupervisionreportService;

@Service
public class SupervisionreportServiceImpl implements SupervisionreportService {
    
    @Autowired
    SupervisionreportMapper srm;
    
    @Autowired
    ProjectMapper pm;
    
    public Page<Supervisionreport> select(Page<Supervisionreport> page) {
        page.setTotalRecord(srm.selectCount(page));
        page.setList(srm.select(page));
        return page;
    }
    
    public int updateByID(Supervisionreport sr) throws Exception {
        return srm.updateByID(sr);
    }
    
    public int insert(Supervisionreport sr) throws Exception {
        return srm.insert(sr);
    }
    
    public int writeSupervisionReport(Supervisionreport entity) {
        entity.setState(402);
        pm.updatePrjsidById(entity.getProjectid(), 108);
        return srm.insert(entity);
    }
    
    public int changeSupervisionReport(Supervisionreport entity) {
        
        return srm.updateByID(entity);
        
    }
    
    public int delectSupervisionReport(Supervisionreport entity) {
        Page<Supervisionreport> page = new Page<Supervisionreport>();
        page.setParamEntity(entity);
        page.setPage(1);
        page.setRows(1);
        List<Supervisionreport> l = srm.select(page);
        Supervisionreport k = l.get(0);
        if (k.getState() < 402) {
            k.setState(406);
            return srm.updateByID(k);
        }
        
        return 0;
    }
    
    public int submitSupervisionReport(Supervisionreport entity) {
        Page<Supervisionreport> page = new Page<Supervisionreport>();
        page.setParamEntity(entity);
        page.setPage(1);
        page.setRows(1);
        List<Supervisionreport> l = srm.select(page);
        Supervisionreport k = l.get(0);
        k.setState(401);
        return srm.updateByID(k);
        
    }
    
}
