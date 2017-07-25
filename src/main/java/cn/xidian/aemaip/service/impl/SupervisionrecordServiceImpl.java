package cn.xidian.aemaip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.SupervisionrecordMapper;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Supervisionrecord;
import cn.xidian.aemaip.service.SupervisionrecordService;

@Service
public class SupervisionrecordServiceImpl implements SupervisionrecordService {
    
    @Autowired
    SupervisionrecordMapper srm;
    
    public Page<Supervisionrecord> select(Page<Supervisionrecord> page) {
        page.setTotalRecord(srm.selectCount(page));
        page.setList(srm.select(page));
        return page;
    }
    
    public int updateByID(Supervisionrecord sr) {
        return srm.updateByID(sr);
    }
    
    public int insert(Supervisionrecord sr) {
        return srm.insert(sr);
    }
    
}
