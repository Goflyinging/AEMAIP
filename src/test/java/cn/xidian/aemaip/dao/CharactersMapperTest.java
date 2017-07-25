package cn.xidian.aemaip.dao;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Characters;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class CharactersMapperTest {
    @Autowired
    CharactersMapper cmt;
	@Test
     public void testInsert() {
		 assertEquals(1, cmt.insert("主管"));
	}
    @Test
    public void testSelectByMsg() {

    	assertEquals(1,(int)cmt.selectByMdg("主管").getCid());
	}
    @Test
    public void testSelectAll() {
    	List<Characters> tsa=cmt.selectAll();
    	  Iterator<Characters> l2 = tsa.iterator();
    	  while(l2.hasNext())
    	  {
    		  Characters i=l2.next();
    		  System.out.println(i.getCid());
    		  System.out.println(i.getMdg());
    	  }
	}
    @Test
    public void testSelectById() {
    	assertEquals("职员",cmt.selectById(2).getMdg());
	}
}
