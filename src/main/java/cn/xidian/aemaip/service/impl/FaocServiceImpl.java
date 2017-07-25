package cn.xidian.aemaip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.FaocMapper;
import cn.xidian.aemaip.entity.Faoc;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.service.FaocService;

@Service
public class FaocServiceImpl implements FaocService {
    
    @Autowired
    FaocMapper fm;
    
    public Page<Faoc> selectPage(Page<Faoc> page) {
        page.setTotalRecord(fm.selectCount(page));
        page.setList(fm.select(page));
        return page;
    }
    
    public int updateByID(Faoc f) throws Exception {
        return fm.updateByID(f);
    }
    
    public int insert(Faoc f) throws Exception {
        return fm.insert(f);
    }
    
}
