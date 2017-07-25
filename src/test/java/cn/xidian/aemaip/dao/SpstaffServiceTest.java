package cn.xidian.aemaip.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Spstaff;
import cn.xidian.aemaip.service.SpstaffService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class SpstaffServiceTest {
    @Autowired
    SpstaffMapper sfm;
    
    @Resource
    SpstaffService sfs;
    
    @Test
    public void testInsert() throws Exception {
        Spstaff sf = new Spstaff();
        sf.setSpsid(2);
        sf.setQsspiid(3);
        sf.setSrid(3);
        sfs.insert(sf);
    }
    
    @Test
    public void testSelect() {
        Spstaff sf = new Spstaff();
        sf.setSpsid(2);
        sf.setQsspiid(3);
        sf.setSrid(1);
        
        Page<Spstaff> p = new Page<Spstaff>();
        p.setParamEntity(sf);
        p.setPage(1);
        p.setRows(10);
        
        sfs.select(p);
        for (Spstaff q : (List<Spstaff>) p.getPageMap().get("rows")) {
            System.out.println("" + q.getSpsid()
                               + q.getQsspiid()
                               + q.getSrid());
        }
    }
    
    @Test
    public void testUpdateByID() throws Exception {
        Spstaff sf = new Spstaff();
        sf.setSpsid(2);
        sf.setQsspiid(8);
        sf.setSrid(3);
        
        sfs.updateByID(sf);
    }
}
