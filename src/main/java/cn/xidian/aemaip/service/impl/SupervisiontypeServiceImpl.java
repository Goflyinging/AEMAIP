package cn.xidian.aemaip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.SupervisiontypeMapper;
import cn.xidian.aemaip.entity.Supervisiontype;
import cn.xidian.aemaip.service.SupervisiontypeService;

@Service
public class SupervisiontypeServiceImpl implements SupervisiontypeService {
    
    @Autowired
    SupervisiontypeMapper stm;
    
    public List<Supervisiontype> select(Supervisiontype st) {
        return stm.select(st);
    }
    
}
