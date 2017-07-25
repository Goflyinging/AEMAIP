package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Company;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.service.CompanyService;
import cn.xidian.aemaip.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class CompanyServiceTest {
    @Autowired
    CompanyMapper cm;
    
    @Resource
    CompanyService cs;
    
    @Resource
    UsersService us;
    
    @Test
    public void testInsert() throws Exception {
        Company c = new Company();
        c.setCompanytypeid(22);
        c.setAdressid(1004);
        c.setCompanyname("WTFHHH");
        c.setCompanyphone("10086");
        c.setEmail("10086@11.cn");
        int id = us.register("wtfhhhhhhh");
        c.setAccount(id);
        cs.insert(c);
        int a = cs.selectByCompanyname("WTFHHH").getAccount();
        assertEquals(id, a);
    }
    
    @Test
    public void testSelectByID() throws Exception {
        assertEquals("哈哈", cs.selectByID(1).getCompanyname());
    }
    
    @Test
    public void testUpdateTypeByID() throws Exception {
        cs.updateTypeByID(1, 21);
        int t = cs.selectByID(1).getCompanytypeid();
        assertEquals(21, t);
    }
    
    @Test
    public void testSelectByCompanyname() throws Exception {
        int id = cs.selectByCompanyname("哈哈").getCompanyid();
        assertEquals(1, id);
    }
    
    @Test
    public void testUpdateAdressByID() throws Exception {
        cs.updateAdressByID(1, 1005);
        int a = cs.selectByID(1).getAdressid();
        assertEquals(1005, a);
    }
    
    @Test
    public void testUpdateUpiidByID() throws Exception {
        /// 未完成
        /**
         * upi未完成
         */
    }
    
    @Test
    public void testUpdatePhoneByID() throws Exception {
        cs.updatePhoneByID(1, "13800000000");
        String p = cs.selectByID(1).getCompanyphone();
        assertEquals("13800000000", p);
    }
    
    @Test
    public void testUpdateStateByID() throws Exception {
        cs.updateStateByID(1, 1);
        int i = cs.selectByID(1).getCompanystate();
        assertEquals(1, i);
    }
    
    @Test
    public void testUpdateEmailByID() throws Exception {
        String email = "98979@jjj.jjj";
        cs.updateEmailByID(1, email);
        assertEquals(email, cs.selectByID(1).getEmail());
    }
    
    @Test
    public void testGetUnapproved() {
        Page<Company> p = new Page<Company>();
        p.setTotalRecord(cm.selectUnapproved());
        p.setPage(1);
        p.setRows(7);
        p = cs.getUnapproved(p);
        System.out.println(p.toString());
        Object q = p.getPageMap().get("rows");
        List<Company> list = (List<Company>) q;
        Iterator<Company> li = list.iterator();
        Company c;
        while (li.hasNext()) {
            c = li.next();
            System.out.println("" + c.getCompanyid()
                               + c.getCompanytypeid()
                               + c.getAdressid()
                               + c.getAccount()
                               + c.getCompanyname()
                               + c.getCompanyphone()
                               + c.getCompanyjiontime()
                               + c.getCompanytypeid()
                               + c.getEmail()
                               + c.getType());
        }
        // assertEquals();
        
    }
    
}
