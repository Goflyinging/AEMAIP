package cn.xidian.aemaip.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Faoc;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.service.FaocService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class FacoServiceTest {
    
    @Autowired
    FaocMapper fm;
    
    @Resource
    FaocService fs;
    
    @Test
    public void testInsert() throws Exception {
        Faoc f = new Faoc();
        // f.setFaocid(4);
        f.setProjectid(4);
        f.setFaocdate(new Date(116, 8, 2));
        f.setApplicationresult("gg233");
        f.setApplicationadvice("fk233");
        fs.insert(f);
    }
    
    @Test
    public void testSelect() {
        Faoc f = new Faoc();
        f.setFaocid(4);
        f.setProjectid(4);
        f.setFaocdate(new Date(116, 8, 1));
        f.setApplicationresult("gg");
        f.setApplicationadvice("fk");
        
        Page<Faoc> p = new Page<Faoc>();
        p.setParamEntity(f);
        p.setPage(1);
        p.setRows(10);
        fs.selectPage(p);
        for (Faoc q : (List<Faoc>) p.getPageMap().get("rows")) {
            System.out.println("" + q.getProjectid()
                               + q.getProjectid()
                               + q.getFaocdate()
                               + q.getApplicationresult()
                               + q.getApplicationadvice());
        }
    }
    
    @Test
    public void testUpdateByID() throws Exception {
        Faoc f = new Faoc();
        f.setFaocid(4);
        f.setProjectid(5);
        f.setFaocdate(new Date(116, 8, 13));
        f.setApplicationresult("ggleg");
        f.setApplicationadvice("fkpup");
        fs.updateByID(f);
    }
}
