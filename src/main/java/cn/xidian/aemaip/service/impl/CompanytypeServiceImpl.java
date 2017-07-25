package cn.xidian.aemaip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.CompanytypeMapper;
import cn.xidian.aemaip.entity.Companytype;
import cn.xidian.aemaip.service.CompanytypeService;

@Service
public class CompanytypeServiceImpl implements CompanytypeService {
    @Autowired
    CompanytypeMapper ctm;
    
    public Companytype selectTypeById(int id) {
        return ctm.selectTypeById(id);
    }
    
    public List<Companytype> selectAllType() {
        return ctm.selectAllType();
    }
    
}
