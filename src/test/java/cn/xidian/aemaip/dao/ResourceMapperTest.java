package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Resource;
import cn.xidian.aemaip.service.ResourceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class ResourceMapperTest {
    @Autowired
    ResourceMapper rm;
    
    @javax.annotation.Resource
    ResourceService rs;
    
    @Test
    public void testInsert() {
        Resource entity = new Resource();
        entity.setAdress("c:/");
        entity.setResourcename("审核");
        entity.setResResourceid(1);
        assertEquals(1, rm.insert(entity));
    }
    
    @Test
    public void testSelectById() {
        Resource test = rm.selectById(2);
        assertEquals("审核", test.getResourcename());
    }
    
    @Test
    public void testSelectByaddress() {
        Resource test = rm.selectByaddress("c:/");
        assertEquals("审核", test.getResourcename());
    }
    
    @Test
    public void testSelectByRes_resourceid() {
        List<Resource> test = rm.selectByRes_resourceid(1);
        Iterator<Resource> l2 = test.iterator();
        while (l2.hasNext()) {
            Resource i = l2.next();
            System.out.println(i.getResourcename());
            
        }
    }
    
    // tt
    
    @Test
    public void testDelete() throws Exception {
        Resource r = new Resource();
        r.setResResourceid(16);
        rs.delete(r);
    }
    
    @Test
    public void testUpdate() throws Exception {
        Resource r = new Resource();
        r.setResourceid(16);
        r.setResResourceid(13);
        r.setResourcename("jjk");
        r.setAdress("pp");
        r.setNumber(110);
        rs.updateByID(r);
    }
    
    @Test
    public void testSelect() {
        Resource r = new Resource();
        
        // r.setResourceid(16);
        // r.setResResourceid(13);
        // r.setResourcename("jjk");
        // r.setAdress("pp");
        r.setNumber(110);
        
        Page<Resource> page = new Page<Resource>();
        page.setPage(1);
        page.setRows(10);
        page.setParamEntity(r);
        page = rs.select(page);
        Map<String, Object> pageMap = page.getPageMap();
        List<Resource> object = (List<Resource>) pageMap.get("rows");
        for (Resource i : object) {
            System.out.println(i.getResourcename());
        }
        
    }
    @Test
    public void testSelectAll() {
    System.out.println("ok");	
    List<Resource>  list =	rm.selectAll();
    System.out.println(list);
    	for(Resource r:list){
    		System.out.println(r.getResourceid()+"?");
    		if(r.getChildren()!=null)
    		for(Resource r1:r.getChildren()){
    			System.out.println(r1.getResourceid()+"??");	
    			if(r1.getChildren()!=null)
    			for(Resource r2:r1.getChildren()){
        			System.out.println(r2.getResourceid()+"???");	
        		}
    		}
    	}
    }
    
}
