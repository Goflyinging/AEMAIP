package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Prjstate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class PrjstateMapperTest {
    @Autowired
    PrjstateMapper pm;
    
    @Test
    public void testInsert() {
        Prjstate test = new Prjstate();
        test.setPrjsid(98);
        test.setMsg("测试");
        assertEquals(1, pm.insert(test));
    }
    
    @Test
    public void testSelectById() {
        Prjstate test = pm.selectById(99);
        assertEquals("测试", test.getMsg());
    }
    
    @Test
    public void testSelectByMsg() {
        Prjstate test = pm.selectByMsg("竣工");
        assertEquals(108, (int) test.getPrjsid());
    }
    
    @Test
    public void testSelectAll() {
        List<Prjstate> test = pm.selectAll();
        Iterator<Prjstate> l2 = test.iterator();
        while (l2.hasNext()) {
            Prjstate i = l2.next();
            System.out.println(i.getMsg());
        }
    }
}
