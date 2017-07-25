package cn.xidian.aemaip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.QsspiMapper;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Qsspi;
import cn.xidian.aemaip.service.QsspiService;
import cn.xidian.aemaip.service.UsersService;

@Service
public class QsspiServiceImpl implements QsspiService {
    
    @Autowired
    QsspiMapper qsspim;
    
    @Resource
    UsersService us;
    
    public Qsspi getQpiByID(int id) {
        return qsspim.selectQpiById(id);
    }
    
    public List<Qsspi> getQpiByMsg(String msg) {
        return qsspim.selectQpiByMsg(msg);
    }
    
    public List<Qsspi> selectQpiByQss(int qss) {
        return qsspim.selectQpiByQss(qss);
    }
    
    public int updateMsgByID(int id, String msg) throws Exception {
        return qsspim.updateMsgByID(id, msg);
    }
    
    public int insert(Qsspi qpi) throws Exception {
        int a = us.register(qpi.getUsername());
        qpi.setAccount(a);
        us.changePwdByID(a, qpi.getPwd());
        us.enableByID(a);
        qsspim.insert(qpi);
        return qsspim.selectLast();
    }
    
    public Page<Qsspi> get(Page<Qsspi> page) {
        page.setTotalRecord(qsspim.selectCount(page));
        page.setList(qsspim.select(page));
        return page;
    }
    
    public int updateByID(Qsspi qpi) throws Exception {
        return qsspim.updateByID(qpi);
    }
    
}
