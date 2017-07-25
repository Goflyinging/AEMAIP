package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Supervisionreport;
import cn.xidian.aemaip.service.SupervisionreportService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class SupervisionreportServiceTest {
    @Autowired
    SupervisionreportMapper srm;
    
    @Resource
    SupervisionreportService srs;
    
    @Test
    public void testSelect() {
        Page<Supervisionreport> page = new Page<Supervisionreport>();
        page.setPage(1);
        page.setRows(10);
        Supervisionreport sr = new Supervisionreport();
        sr.setState(401);
        
        page.setParamEntity(sr);
        srs.select(page);
        List<Supervisionreport> l;
        l = (List<Supervisionreport>) ((Map) page.getPageMap()).get("rows");
        for (Supervisionreport s : l) {
            System.out.println("" + s.getSreportid()
                               + s.getProjectid()
                               + s.getState()
                               + s.getBegintime()
                               + s.getEndtime()
                               + s.getReport()
                               + s.getResult()
                               + s.getCheckresult()
                               + s.getWritettime());
        }
    }
    
    @Test
    public void testUpdateByID() throws Exception {
        Supervisionreport sr = new Supervisionreport();
        sr.setSreportid(2);
        sr.setResult("sd42");
        sr.setState(401);
        sr.setReport("rr2");
        sr.setCheckresult("cjk2");
        srs.updateByID(sr);
    }
    
    @Test
    public void testInsert() throws Exception {
        Supervisionreport sr = new Supervisionreport();
        sr.setSreportid(6);
        sr.setResult("sd4");
        sr.setState(401);
        sr.setReport("rr");
        sr.setCheckresult("cjk");
        srs.insert(sr);
    }
    
    @Test
    public void writeSupervisionReport() {
        Supervisionreport entity = new Supervisionreport();
        entity.setReport("监督完成，工程顺利完成");
        entity.setResult("监督完成");
        entity.setProjectid(7);
        assertEquals(1, srs.writeSupervisionReport(entity));
    }
    
    @Test
    public void changeSupervisionReport() {
        Supervisionreport entity = new Supervisionreport();
        entity.setReport("监督完成，工程顺利完成");
        entity.setResult("监督完成");
        entity.setProjectid(1);
        entity.setSreportid(6);
        assertEquals(1, srs.changeSupervisionReport(entity));
    }
    
    @Test
    public void delectSupervisionReport() {
        Supervisionreport entity = new Supervisionreport();
        entity.setSreportid(6);
        assertEquals(1, srs.delectSupervisionReport(entity));
    }
    
    @Test
    public void submitSupervisionReport() {
        Supervisionreport entity = new Supervisionreport();
        entity.setSreportid(6);
        assertEquals(1, srs.submitSupervisionReport(entity));
        
    }
}
