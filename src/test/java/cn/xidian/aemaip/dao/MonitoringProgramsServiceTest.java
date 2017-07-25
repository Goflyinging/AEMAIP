package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.MonitoringPrograms;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.service.MonitoringProgramsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class MonitoringProgramsServiceTest {
    @Autowired
    MonitoringProgramsMapper mpm;
    
    @Resource
    MonitoringProgramsService mps;
    
    @Test
    public void testInsert() throws Exception {
        MonitoringPrograms m = new MonitoringPrograms();
        m.setSid(1);
        m.setProjectid(6);
        m.setMpmsg("xxx");
        mps.insert(m);
    }
    
    @Test
    public void testSelect() {
        MonitoringPrograms m = new MonitoringPrograms();
        // m.setSid(1);
        m.setProjectid(6);
        // m.setMpmsg("xxx");
        List<MonitoringPrograms> r = mps.select(m);
        for (MonitoringPrograms t : r) {
            System.out.println(t.getMpid());
        }
    }
    
    @Test
    public void testSelectPage() {
        MonitoringPrograms m = new MonitoringPrograms();
        m.setSid(1);
        m.setProjectid(6);
        m.setMpmsg("xxx");
        Page<MonitoringPrograms> p = new Page<MonitoringPrograms>();
        p.setParamEntity(m);
        p.setPage(1);
        p.setRows(10);
        mps.selectPage(p);
        for (MonitoringPrograms q1 : (List<MonitoringPrograms>) p.getPageMap()
                                                                 .get("rows")) {
            int upiid = q1.getMpid();
            System.out.println(upiid);
            assertEquals("xxx", q1.getMpmsg());
        }
    }
    
    @Test
    public void testUpdateByID() throws Exception {
        MonitoringPrograms m = new MonitoringPrograms();
        m.setMpid(3);
        m.setSid(1);
        m.setProjectid(6);
        m.setMpmsg("xxjx");
        m.setMpsSid(301);
        mps.updateByID(m);
    }
}
