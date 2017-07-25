package cn.xidian.aemaip.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.OversightGroupMapper;
import cn.xidian.aemaip.entity.OversightGroup;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Qsspi;
import cn.xidian.aemaip.entity.Supervisors;
import cn.xidian.aemaip.service.OversightGroupService;
import cn.xidian.aemaip.service.QsspiService;
import cn.xidian.aemaip.service.SupervisorsService;
import cn.xidian.aemaip.service.UsersService;

@Service
public class OversightGroupServiceImpl implements OversightGroupService {
    
    @Autowired
    OversightGroupMapper ogm;
    
    @Resource
    QsspiService qs;
    
    @Resource
    SupervisorsService ss;
    
    @Resource
    UsersService us;
    
    public Page<OversightGroup> select(Page<OversightGroup> page) {
        page.setTotalRecord(ogm.selectCount(page));
        page.setList(ogm.select(page));
        return page;
    }
    
    public int updateByID(OversightGroup og) throws Exception {
        return ogm.updateByID(og);
    }
    
    public int add(OversightGroup og) throws Exception {
        ogm.insert(og);
        return ogm.selectLast();
    }
    
    public int addGroup(int leader, int[] member) throws Exception {
        OversightGroup og = new OversightGroup();
        og.setLeader(leader);
        og.setQss(qs.getQpiByID(leader).getQssid());
        int g = add(og);
        
        for (int i : member) {
            Supervisors s = new Supervisors();
            s.setOgid(g);
            s.setPinfoid(i);
            ss.insert(s);
        }
        
        Qsspi q = qs.getQpiByID(leader);
        int a = q.getAccount();
        int[] cid = { 3 };
        us.setUserCharacter(a, cid);
        
        return g;
    }
    
}
