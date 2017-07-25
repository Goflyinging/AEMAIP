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
import cn.xidian.aemaip.entity.Qsspi;
import cn.xidian.aemaip.service.QsspiService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class QsspiServiceTest {
    
    @Autowired
    QsspiMapper qsspim;
    
    @Resource
    QsspiService qsss;
    
    @Test
    public void testInsert() throws Exception {
        Qsspi l = new Qsspi();
        l.setMsg("hh 233");
        l.setName("bbk");
        l.setSex((short) 1);
        l.setTel("100861111");
        l.setUsername("hhhhtxt444");
        l.setPwd("admin");
        qsss.insert(l);
    }
    
    @Test
    public void testUpdateMsgByID() throws Exception {
        qsss.updateMsgByID((int) 7, "tt");
        assertEquals("tt", qsss.getQpiByID(7).getMsg());
    }
    
    @Test
    public void testSelectQpiByQss() {
        List<Qsspi> ql = qsss.selectQpiByQss(1);
        Iterator<Qsspi> qi = ql.iterator();
        while (qi.hasNext()) {
            Qsspi q = qi.next();
            System.out.println(q.getMsg());
            int qssid = q.getQssid();
            assertEquals(1, qssid);
        }
    }
    
    @Test
    public void testGetQpiByMsg() {
        List<Qsspi> ql = qsss.getQpiByMsg("hh");
        Iterator<Qsspi> qi = ql.iterator();
        while (qi.hasNext()) {
            Qsspi q = qi.next();
            System.out.println(q.getTel());
            int qssid = q.getQssid();
            assertEquals(1, qssid);
        }
    }
    
    @Test
    public void testGetQpiByID() {
        Qsspi q = qsss.getQpiByID(7);
        assertEquals("tt", q.getMsg());
    }
    
    @Test
    public void testSelect() {
        Page<Qsspi> p = new Page<Qsspi>();
        Qsspi q = new Qsspi();
        q.setMsg("hh");
        p.setParamEntity(q);
        p.setPage(1);
        p.setRows(10);
        p = qsss.get(p);
        // assertEquals(1, qsss.selectCount(p));
        for (Qsspi q1 : (List<Qsspi>) p.getPageMap().get("rows")) {
            System.out.println(q1.getName());
        }
    }
    
    @Test
    public void testUpdateByID() throws Exception {
        Qsspi q = new Qsspi();
        q.setQsspiid(12);
        q.setName("txtx");
        qsss.updateByID(q);
    }
}
