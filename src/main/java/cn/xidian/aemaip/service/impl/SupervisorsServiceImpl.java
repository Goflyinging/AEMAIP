package cn.xidian.aemaip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.SupervisorsMapper;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Supervisors;
import cn.xidian.aemaip.service.SupervisorsService;

@Service
public class SupervisorsServiceImpl implements SupervisorsService {
    
    @Autowired
    SupervisorsMapper sm;
    
    public Page<Supervisors> select(Page<Supervisors> page) {
        page.setTotalRecord(sm.selectCount(page));
        page.setList(sm.select(page));
        return page;
    }
    
    public int updateByID(Supervisors s) throws Exception {
        return sm.updateByID(s);
    }
    
    public int insert(Supervisors s) throws Exception {
        return sm.insert(s);
    }
    
}
