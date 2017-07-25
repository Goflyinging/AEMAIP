package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Character_Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class Charact_ResourceMapperTest {
    @Autowired
    Character_ResourceMapper crm;
    
    @Test
    public void testInsert() {
        Character_Resource rm = new Character_Resource();
        rm.setResourceid(1);
        rm.setCid(2);
        ;
        assertEquals(1, crm.insert(rm));
    }
    
    @Test
    public void testSelectByCid() {
        List<Character_Resource> tsa = crm.selectByCid(2);
        Iterator<Character_Resource> l2 = tsa.iterator();
        while (l2.hasNext()) {
            Character_Resource i = l2.next();
            System.out.println(i.getResourceid());
            
        }
    }
}
