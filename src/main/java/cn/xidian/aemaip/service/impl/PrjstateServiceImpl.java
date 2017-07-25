package cn.xidian.aemaip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.PrjstateMapper;
import cn.xidian.aemaip.entity.Prjstate;
import cn.xidian.aemaip.service.PrjstataService;

@Service
public class PrjstateServiceImpl implements PrjstataService {
    @Autowired
    PrjstateMapper pm;
    
    public int insert(Prjstate entity) throws Exception {
        if (pm.selectByMsg(entity.getMsg()) == null)
            return pm.insert(entity);
        return -1;
    }
    
    public List<Prjstate> selectAll() {
        
        return pm.selectAll();
    }
    
    public Prjstate selectById(int prjsid) {
        
        return pm.selectById(prjsid);
    }
    
    public Prjstate selectByMsg(String msg) {
        
        return pm.selectByMsg(msg);
    }
    
}
