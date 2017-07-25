package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Unitcharacter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class UnitcharacterMapperTest {
    @Autowired
    UnitcharacterMapper ucm;
    
    @Test
    public void testSelect() {
        Unitcharacter entity = new Unitcharacter();
        entity.setUpiid(2);
        Page<Unitcharacter> page = new Page<Unitcharacter>();
        page.setParamEntity(entity);
        page.setPage(1);
        page.setRows(10);
        page.setTotalRecord(ucm.selectCount(page));
        page.setList(ucm.select(page));
        List<Unitcharacter> list = page.getList();
        Iterator<Unitcharacter> l2 = list.iterator();
        while (l2.hasNext()) {
            Unitcharacter i = l2.next();
            System.out.println(i.getCname());
        }
    }
    
    @Test
    public void testSelectCount() {
        Unitcharacter entity = new Unitcharacter();
        entity.setUpiid(2);
        Page<Unitcharacter> page = new Page<Unitcharacter>();
        page.setParamEntity(entity);
        assertEquals(1, ucm.selectCount(page));
    }
    
    @Test
    public void testInsert() {
        Unitcharacter entity = new Unitcharacter();
        entity.setId(1);
        entity.setUpiid(2);
        entity.setCname("Matter");
        assertEquals(1, ucm.insert(entity));
    }
    
    @Test
    public void testUpdateById() {
        Unitcharacter entity = new Unitcharacter();
        entity.setUcid(1);
        entity.setId(1);
        entity.setUpiid(3);
        entity.setCname("Matter");
        assertEquals(1, ucm.updateById(entity));
    }
}
