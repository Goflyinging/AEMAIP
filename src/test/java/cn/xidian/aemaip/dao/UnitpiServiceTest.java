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

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Unitpi;
import cn.xidian.aemaip.service.UnitpiService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class UnitpiServiceTest {
    @Autowired
    UnitpiMapper upim;
    
    @Resource
    UnitpiService upis;
    
    @Test
    public void testAddPI() throws Exception {
        Unitpi u = new Unitpi();
        u.setCompanyid(15);
        u.setAdressid(1005);
        u.setName("etf");
        u.setPhone("1000011");
        u.setSex((short) 0);
        u.setMsg("cx");
        upis.addPI(u);
        assertEquals(15, (int) upis.getPIById(1).getCompanyid());
    }
    
    @Test
    public void testUpdateMsgByID() throws Exception {
        upis.updateMsgByID(1, "qq");
        assertEquals("qq", (String) upis.getPIById(1).getMsg());
    }
    
    @Test
    public void testGetPIById() {
        int c = upis.getPIById(1).getCompanyid();
        assertEquals(15, c);
    }
    
    @Test
    public void testGetPIByCompany() {
        List<Unitpi> l = upis.getPIByCompany(15);
        Iterator<Unitpi> j = l.iterator();
        Unitpi k = j.next();
        assertEquals("etf", k.getName());
    }
    
    @Test
    public void testGetPIByMsg() {
        List<Unitpi> p = upis.getPIByMsg("qq");
        Iterator<Unitpi> j = p.iterator();
        Unitpi k = j.next();
        assertEquals("etf", k.getName());
        
    }
    
    @Test
    public void testSelect() {
        Page<Unitpi> p = new Page<Unitpi>();
        Unitpi q = new Unitpi();
        // '1', '15', '1005', 'etf', '1000011', '0', 'qq'
        q.setCompanyid(15);
        q.setAdressid(1005);
        q.setName("etf");
        q.setSex((short) 0);
        q.setPhone("1000011");
        q.setMsg("qq");
        p.setParamEntity(q);
        p.setPage(1);
        p.setRows(10);
        p = upis.select(p);
        // assertEquals(1, qsss.selectCount(p));
        for (Unitpi q1 : (List<Unitpi>) p.getPageMap().get("rows")) {
            int upiid = q1.getUpiid();
            System.out.println(upiid);
            assertEquals(1, upiid);
        }
    }
    
    @Test
    public void testUpdateByID() throws Exception {
        Unitpi p = new Unitpi();
        p.setUpiid(1);
        p.setMsg("qqxx");
        upis.updateByID(p);
    }
    
}
