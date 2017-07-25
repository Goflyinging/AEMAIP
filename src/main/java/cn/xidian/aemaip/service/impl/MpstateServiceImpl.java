package cn.xidian.aemaip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.MpstateMapper;
import cn.xidian.aemaip.entity.Mpstate;
import cn.xidian.aemaip.service.MpstateService;

@Service
public class MpstateServiceImpl implements MpstateService {
    
    @Autowired
    MpstateMapper mm;
    
    public List<Mpstate> select(Mpstate mp) {
        return mm.select(mp);
    }
    
}
