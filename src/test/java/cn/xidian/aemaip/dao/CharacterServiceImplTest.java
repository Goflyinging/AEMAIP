package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Characters;
import cn.xidian.aemaip.service.CharactersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class CharacterServiceImplTest {
    @Resource
    CharactersService cs;
    
    @Test
    public void insert() throws Exception {
        assertEquals(1, cs.insert("二级管理员"));
    }
    
    @Test
    public void selectAll() throws Exception {
        List<Characters> tsa = cs.selectAll();
        Iterator<Characters> l2 = tsa.iterator();
        while (l2.hasNext()) {
            Characters i = l2.next();
            System.out.println(i.getCid());
            System.out.println(i.getMdg());
        }
    }
    
    //
    @Test
    public void testSetResource() throws Exception {
        int cid = 3;
        int[] rid = { 1, 3, 4, 6, 7 };
        cs.setResource(cid, rid);
    }
    
    @Test
    public void testGetResource() {
        List<Integer> resourceID = cs.getResourceID(3);
        for (int i : resourceID) {
            System.out.println(i);
        }
    }
    
    @Test
    public void testDelete() throws Exception {
        Characters c = new Characters();
        c.setCid(6);
        cs.delete(c);
    }
    
    @Test
    public void updateResource() throws Exception {
        Characters c = new Characters();
        int[] rid = { 1, 3, 4, 6, 8 };
        c.setCid(3);
        c.setMdg("监督组长");
        cs.updateResource(c, rid);
        
    }
    
    @Test
    public void testNewCharacters() throws Exception {
        
        int[] rid = { 1, 3, 4, 6, 8 };
        cs.newCharacters("监都站长", rid);
    }
}
