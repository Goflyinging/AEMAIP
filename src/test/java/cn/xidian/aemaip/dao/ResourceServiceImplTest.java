package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.service.ResourceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class ResourceServiceImplTest {
    @Resource
    ResourceService rs;
    
    @Test
    public void TestInsert() {
        cn.xidian.aemaip.entity.Resource res =
                                             new cn.xidian.aemaip.entity.Resource();
        res.setResourcename("日志管理");
        res.setResResourceid(1);
        assertEquals(1, rs.insert(res));
    }
    
    @Test
    public void testFindSonResource() {
        List<cn.xidian.aemaip.entity.Resource> test = rs.findSonResource(1);
        Iterator<cn.xidian.aemaip.entity.Resource> l2 = test.iterator();
        while (l2.hasNext()) {
            cn.xidian.aemaip.entity.Resource i = l2.next();
            System.out.println(i.getResourcename());
        }
    }
    
    @Test
    public void testSelectAll() {
        System.out.println("ok");
        List<cn.xidian.aemaip.entity.Resource> list = rs.selectAll();
        System.out.println(list);
        for (cn.xidian.aemaip.entity.Resource r : list) {
            System.out.println(r.getResourceid() + "?");
            if (r.getChildren() != null)
                for (cn.xidian.aemaip.entity.Resource r1 : r.getChildren()) {
                    System.out.println(r1.getResourceid() + "??");
                    if (r1.getChildren() != null)
                        for (cn.xidian.aemaip.entity.Resource r2 : r1.getChildren()) {
                            System.out.println(r2.getResourceid() + "???");
                        }
                }
        }
    }
}
