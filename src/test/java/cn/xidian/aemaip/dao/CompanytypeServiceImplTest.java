package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Companytype;
import cn.xidian.aemaip.service.CompanytypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class CompanytypeServiceImplTest {
    @Autowired
    CompanytypeMapper ctm;
    
    @Resource
    CompanytypeService cts;
    
    @Test
    public void testSelectTypeById() {
        assertEquals("建设单位", cts.selectTypeById(21).getDesperation());
    }
    
    @Test
    public void testSelectAllType() {
        List<Companytype> a = cts.selectAllType();
        assertEquals(6, a.size());
        for (Companytype c : a) {
            System.out.println(c.getCompanytypeid());
            System.out.println(c.getDesperation());
        }
        
    }
}
