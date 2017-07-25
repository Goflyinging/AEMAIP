package cn.xidian.aemaip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.UnitpiMapper;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Unitpi;
import cn.xidian.aemaip.service.UnitpiService;

@Service
public class UnitpiServiceImpl implements UnitpiService {
    
    @Autowired
    UnitpiMapper upim;
    
    public Unitpi getPIById(int id) {
        return upim.selectPIById(id);
    }
    
    public List<Unitpi> getPIByCompany(int cid) {
        return upim.selectPIByCompany(cid);
    }
    
    public List<Unitpi> getPIByMsg(String msg) {
        return upim.selectPIByMsg(msg);
    }
    
    public int addPI(Unitpi pi) throws Exception {
        return upim.insert(pi);
    }
    
    public int updateMsgByID(int id, String msg) throws Exception {
        return upim.updateMsgByID(id, msg);
    }
    
    public Page<Unitpi> select(Page<Unitpi> page) {
        page.setTotalRecord(upim.selectCount(page));
        page.setList(upim.select(page));
        return page;
    }
    
    public int updateByID(Unitpi upi) throws Exception {
        return upim.updateByID(upi);
    }
    
}
