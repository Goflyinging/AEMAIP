package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Companyaddress;
import cn.xidian.aemaip.service.CompanyaddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class CompanyaddressMapperTest {
    @Autowired
    CompanyaddressMapper cam;
    
    @Resource
    CompanyaddressService companyaddressService;
    
    @Test
    public void testInsert() {
        Companyaddress ca = new Companyaddress();
        ca.setPid(1024);
        ca.setName("乐山市");
        assertEquals(1, cam.insert(ca));
    }
    
    @Test
    public void testSelectByPID() throws Exception {
        int pid = 1024;
        List<Companyaddress> l = new ArrayList<Companyaddress>();
        l.add(companyaddressService.selectByID(1));
        l.add(companyaddressService.selectByID(2));
        l.add(companyaddressService.selectByID(3));
        
        List<Companyaddress> l2 = companyaddressService.selectByPID(pid);
        Iterator<Companyaddress> ll = l2.iterator();
        while (ll.hasNext()) {
            Companyaddress jj = ll.next();
            System.out.println(jj.getName());
            System.out.println(jj.getAddressid());
            System.out.println(jj.getPid());
        }
    }
    
    @Test
    public void testGetAddressByID() {
        int id = 17;
        try {
            assertEquals("四川省成都市青羊区", companyaddressService.getAddressByID(id));
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
