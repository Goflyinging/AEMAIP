package cn.xidian.aemaip.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Supervisiontype;
import cn.xidian.aemaip.service.SupervisiontypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class SupervisiontypeServiceTest {
    @Autowired
    SupervisiontypeMapper stm;
    
    @Resource
    SupervisiontypeService sts;
    
    @Test
    public void testSelect() {
        Supervisiontype st = new Supervisiontype();
        st.setStid(13);
        st.setStname("飞行检查");
        List<Supervisiontype> j = stm.select(st);
        for (Supervisiontype t : j) {
            System.out.println(t.getStid());
            System.out.println(t.getStname());
        }
    }
}
