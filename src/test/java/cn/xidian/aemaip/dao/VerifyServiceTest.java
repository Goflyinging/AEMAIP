package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.service.CompanyService;
import cn.xidian.aemaip.service.UsersService;
import cn.xidian.aemaip.service.verify.VerifyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class VerifyServiceTest {
    @Resource
    VerifyService vs;
    
    @Resource
    CompanyService cs;
    
    @Resource
    UsersService us;
    
    @Test
    public void testVerifyCompany() throws Exception {
        int id = 18;
        vs.verifyCompany(id);
        int s = cs.selectByID(id).getCompanystate();
        int a = cs.selectByID(id).getAccount();
        assertEquals(1, s);
        assertEquals(202, (int) us.getByID(a).getStateid());
    }
}
