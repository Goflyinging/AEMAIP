package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Prjstate;
import cn.xidian.aemaip.service.PrjstataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class PrjstataServiceImplTest {
    @Resource
    PrjstataService ps;
    
    @Test
    public void testInsert() throws Exception {
        Prjstate test = new Prjstate();
        test.setMsg("测试2");
        assertEquals(1, ps.insert(test));
    }
    
    @Test
    public void selectAll() {
        List<Prjstate> test = ps.selectAll();
        Iterator<Prjstate> l2 = test.iterator();
        while (l2.hasNext()) {
            Prjstate i = l2.next();
            System.out.println(i.getMsg());
        }
    }
    
    @Test
    public void selectById() {
        assertEquals("注册审核中", ps.selectById(100).getMsg());
    }
    
    @Test
    public void selectByMsg() {
        assertEquals(100, (int) ps.selectByMsg("注册审核中").getPrjsid());
    }
}
