package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Projectcompany;
import cn.xidian.aemaip.service.ProjectcompanyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class ProjectcompanyServiceImplTest {
    @Resource
    ProjectcompanyService pcs;
    
    @Test
    public void testInsert() {
        Projectcompany entity = new Projectcompany();
        entity.setCompanyid(26);
        entity.setProjectid(5);
        assertEquals(1, pcs.insert(entity));
    }
    
    @Test
    public void testSelect() {
        Projectcompany entity = new Projectcompany();
        Page<Projectcompany> page = new Page<Projectcompany>();
        // entity.setCompanyid(26);
        entity.setProjectid(5);
        page.setPage(1);
        page.setRows(10);
        page.setParamEntity(entity);
        page = pcs.select(page);
        List<Projectcompany> test = page.getList();
        Iterator<Projectcompany> l2 = test.iterator();
        while (l2.hasNext()) {
            Projectcompany pc = l2.next();
            System.out.println(pc.getProjectid());
        }
    }
    
}
