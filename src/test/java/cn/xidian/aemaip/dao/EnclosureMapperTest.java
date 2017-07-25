package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Enclosure;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class EnclosureMapperTest {
    @Autowired
    EnclosureMapper em;
    
    @Test
    public void testInsert() {
        Enclosure test = new Enclosure();
        test.setFilename("测试");
        test.setAdress("/105");
        test.setMsg("测试");
        assertEquals(1, em.insert(test));
    }
    
    @Test
    public void testSelectById() {
        Enclosure test = em.selectById(1);
        assertEquals("测试", test.getFilename());
    }
    
    @Test
    public void testSelectByAddress() {
        Enclosure test = em.selectByAddress("/105");
        assertEquals(1, (int) test.getFileid());
    }
}
