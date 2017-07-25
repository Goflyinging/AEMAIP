package cn.xidian.aemaip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.DocstateMapper;
import cn.xidian.aemaip.entity.Docstate;
import cn.xidian.aemaip.service.DocstateService;

@Service
public class DocstateServiceImpl implements DocstateService {
    
    @Autowired
    DocstateMapper dm;
    
    public List<Docstate> select(Docstate ds) {
        return dm.select(ds);
    }
    
}
