package cn.xidian.aemaip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.SpstaffMapper;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Spstaff;
import cn.xidian.aemaip.service.SpstaffService;

@Service
public class SpstaffServiceImpl implements SpstaffService {
    
    @Autowired
    SpstaffMapper sfm;
    
    public Page<Spstaff> select(Page<Spstaff> page) {
        page.setTotalRecord(sfm.selectCount(page));
        page.setList(sfm.select(page));
        return page;
    }
    
    public int updateByID(Spstaff sf) throws Exception {
        return sfm.updateByID(sf);
    }
    
    public int insert(Spstaff sf) throws Exception {
        return sfm.insert(sf);
    }
    
}
