package cn.xidian.aemaip.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Supervisionrecord;
import cn.xidian.aemaip.service.SupervisionrecordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class SupervisionrecordServiceTest {
    @Autowired
    SupervisionrecordMapper srm;
    
    @Resource
    SupervisionrecordService srs;
    
    @Test
    public void testSelect() {
        Page<Supervisionrecord> page = new Page<Supervisionrecord>();
        page.setPage(1);
        page.setRows(10);
        
        Supervisionrecord sr = new Supervisionrecord();
        sr.setSrid(1);
        sr.setProjectid(6);
        sr.setQsspiid(12);
        sr.setStid(11);
        sr.setState(400);
        sr.setStateid(-1);
        sr.setSupervisiontime(new Date(116, 8, 1, 9, 3, 30));
        sr.setSupervisionrecord("sfddsf34252434235");
        
        Date supervisiontime = new Date(116, 8, 1, 9, 3, 30);
        System.out.println(supervisiontime);
        
        page.setParamEntity(sr);
        srs.select(page);
        List<Supervisionrecord> l;
        l = (List<Supervisionrecord>) ((Map) page.getPageMap()).get("rows");
        for (Supervisionrecord s : l) {
            System.out.println("" + s.getSrid()
                               + s.getProjectid()
                               + s.getQsspiid()
                               + s.getStid()
                               + s.getState()
                               + s.getStateid()
                               + s.getSupervisionrecord()
                               + s.getSupervisiontime());
        }
        
    }
    
    @Test
    public void testUpdateByID() {
        Supervisionrecord sr = new Supervisionrecord();
        sr.setSrid(4);
        sr.setProjectid(6);
        sr.setQsspiid(12);
        sr.setStid(11);
        sr.setState(400);
        sr.setStateid(10);
        // sr.setSupervisiontime(new Date(116, 8, 1, 9, 3, 30));
        sr.setSupervisionrecord("cp");
        srs.updateByID(sr);
    }
    
    @Test
    public void testInsert() {
        Supervisionrecord sr = new Supervisionrecord();
        sr.setSrid(1);
        sr.setProjectid(6);
        sr.setQsspiid(12);
        sr.setStid(11);
        sr.setState(400);
        sr.setStateid(-1);
        sr.setSupervisiontime(new Date(116, 8, 1, 9, 3, 30));
        sr.setSupervisionrecord("t2");
        srs.insert(sr);
    }
}
