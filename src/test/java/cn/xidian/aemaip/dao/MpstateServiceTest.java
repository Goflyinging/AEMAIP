package cn.xidian.aemaip.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Mpstate;
import cn.xidian.aemaip.service.MpstateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class MpstateServiceTest {
    
    @Autowired
    MpstateMapper mm;
    
    @Resource
    MpstateService ms;
    
    @Test
    public void testSelect() {
        Mpstate m = new Mpstate();
        // m.setSid(3012);
        m.setMsg("审核通过");
        List<Mpstate> r = ms.select(m);
        for (Mpstate t : r) {
            System.out.println(t.getMsg());
            System.out.println(t.getSid());
        }
    }
    
}
