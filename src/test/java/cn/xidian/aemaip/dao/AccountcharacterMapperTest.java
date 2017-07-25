package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Accountcharacter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class AccountcharacterMapperTest {
    @Autowired
    AccountcharacterMapper atmt;
    
    @Test
    public void selectByAccount() {
        List<Accountcharacter> tsa = atmt.selectByAccount(5);
        Iterator<Accountcharacter> l2 = tsa.iterator();
        while (l2.hasNext()) {
            Accountcharacter i = l2.next();
            System.out.println(i.getCid());
            System.out.println(i.getAccount());
        }
    }
    
    @Test
    public void testInsert() {
        Accountcharacter test = new Accountcharacter();
        test.setAccount(5);
        test.setCid(2);
        assertEquals(1, atmt.insert(test));
    }
    
    @Test
    public void testSelectByAccountAndCid() {
        Accountcharacter test = atmt.selectByAccountAndCid(5, 2);
        assertEquals(1, (int) test.getAcid());
    }
    
}
