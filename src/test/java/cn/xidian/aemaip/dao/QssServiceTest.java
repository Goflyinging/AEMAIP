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

import cn.xidian.aemaip.entity.Qss;
import cn.xidian.aemaip.service.QssService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class QssServiceTest {
    @Autowired
    QssMapper qssm;
    
    @Resource
    QssService qsss;
    
    @Test
    public void testGetByID() {
        String s = qsss.getByID(2).getName();
        assertEquals("B站", s);
    }
    
    @Test
    public void testGetByAd() {
        List<Qss> l = qsss.getByAddress(1004);
        Iterator<Qss> j = l.iterator();
        Qss k = j.next();
        
        String s = k.getName();
        assertEquals("B站", s);
    }
}
