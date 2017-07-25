package cn.xidian.aemaip.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Docstate;
import cn.xidian.aemaip.service.DocstateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class DocstateServiceTest {
    
    @Autowired
    DocstateMapper dm;
    
    @Resource
    DocstateService ds;
    
    @Test
    public void testSelect() {
        Docstate m = new Docstate();
        // m.setSid(3012);
        m.setMsg("审核通过");
        List<Docstate> r = ds.select(m);
        for (Docstate t : r) {
            System.out.println(t.getMsg());
            System.out.println(t.getState());
        }
    }
}
