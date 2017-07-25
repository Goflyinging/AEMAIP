package cn.xidian.aemaip.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.OversightGroup;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.service.OversightGroupService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class OversightGroupServiceTest {
    @Autowired
    OversightGroupMapper ogm;
    
    @Resource
    OversightGroupService ogs;
    
    @Test
    public void testSelect() {
        Page<OversightGroup> p = new Page<OversightGroup>();
        OversightGroup og = new OversightGroup();
        og.setOgid(1);
        // og.setQss(2);
        // og.setLeader(9);
        p.setParamEntity(og);
        p.setPage(1);
        p.setRows(10);
        // assertEquals(1, ogm.selectCount(p));
        
        p = ogs.select(p);
        Map<String, Object> m = p.getPageMap();
        List<OversightGroup> l = (List<OversightGroup>) m.get("rows");
        System.out.println(l == null);
        for (OversightGroup o : l) {
            System.out.println("" + o.getLeadername());
        }
    }
    
    @Test
    public void testUpdate() {
        OversightGroup og = new OversightGroup();
        og.setOgid(8);
        og.setQss(3);
        og.setLeader(11);
        ogm.updateByID(og);
    }
    
    @Test
    public void testInsert() {
        OversightGroup og = new OversightGroup();
        // og.setOgid(8);
        og.setQss(3);
        og.setLeader(10);
        ogm.insert(og);
    }
    
    @Test
    public void testAddGroup() throws Exception {
        OversightGroup og = new OversightGroup();
        int l[] = { 16, 15, 14, 13, 12, 11, 10 };
        ogs.addGroup(16, l);
    }
}
