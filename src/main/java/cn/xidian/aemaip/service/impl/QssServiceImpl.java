package cn.xidian.aemaip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.QssMapper;
import cn.xidian.aemaip.entity.Qss;
import cn.xidian.aemaip.service.QssService;

@Service
public class QssServiceImpl implements QssService {
    
    @Autowired
    QssMapper qssm;
    
    public Qss getByID(int id) {
        return qssm.selectQssById(id);
    }
    
    public List<Qss> getByAddress(int adid) {
        return qssm.selectQssByAd(adid);
    }
    
}
