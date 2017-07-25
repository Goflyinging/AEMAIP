package cn.xidian.aemaip.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Qsspi;
import cn.xidian.aemaip.entity.Supervisors;
import cn.xidian.aemaip.service.SupervisorsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class SupervisorsServiceTest {
    
    @Autowired
    SupervisorsMapper sm;
    
    @Resource
    SupervisorsService ss;
    
    @Test
    public void testInsert() throws Exception {
        Supervisors s = new Supervisors();
        s.setOgid(1);
        // s.setPinfoid(2);
        s.setSid(23);
        ss.insert(s);
    }
    
    @Test
    public void testSelect() {
        Page<Supervisors> p = new Page<Supervisors>();
        Supervisors s = new Supervisors();
        // s.setSid(1);
        // s.setOgid(1);
        s.setPinfoid(2);
        p.setParamEntity(s);
        p.setPage(1);
        p.setRows(10);
        ss.select(p);
        // p = sm.get(p);
        // assertEquals(1, qsss.selectCount(p));
        for (Supervisors q1 : (List<Supervisors>) p.getPageMap().get("rows")) {
            System.out.println(q1.getSid());
            System.out.println(q1.getOgid());
            System.out.println(q1.getPinfoid());
            
        }
    }
    
    @Test
    public void testUpdateByID() throws Exception {
        Qsspi q = new Qsspi();
        q.setQsspiid(12);
        q.setName("txtx");
        // qsss.updateByID(q);
    }
    
}
