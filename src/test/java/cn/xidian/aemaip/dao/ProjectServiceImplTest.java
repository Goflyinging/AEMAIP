package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Company;
import cn.xidian.aemaip.entity.Faoc;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Project;
import cn.xidian.aemaip.entity.Supervisionreport;
import cn.xidian.aemaip.service.ProjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class ProjectServiceImplTest {
    @Resource
    ProjectService ps;
    
    @Autowired
    ProjectMapper pm;
    
    @Test
    public void testNewProject() throws Exception {
        Project test = new Project();
        test.setName("测试三");
        assertEquals(1, ps.newProject(test));
    }
    
    @Test
    public void testCompleteProject() throws Exception {
        assertEquals(0, ps.completeProject(8, 0));
    }
    
    @Test
    public void testExamineProject() {
        Project entity = pm.selectById(1);
        entity.setRegao("申报资料不全");
        assertEquals(1, ps.examineProject(entity, 0));
    }
    
    @Test
    public void testEndproject() {
        assertEquals(0, ps.endProject(10));
    }
    
    @Test
    public void testDistributionProjectGroup() {
        assertEquals(1, ps.distributionProjectGroup(1, 8));
    }
    
    @Test
    public void testSelectProjectList() {
        Project p = new Project();
        p.setPrjsid(109);
        Page<Project> page = new Page<Project>();
        page.setParamEntity(p);
        page.setPage(1);
        page.setStart(0);
        page.setRows(10);
        List<Project> test = ps.select(page).getList();
        Iterator<Project> l2 = test.iterator();
        while (l2.hasNext()) {
            Project i = l2.next();
            System.out.println(i.getName());
            
        }
        
    }
    
    @Test
    public void testSelectProjectList1() {
        Project p = new Project();
        Page<Project> page = new Page<Project>();
        page.setParamEntity(p);
        page.setPage(1);
        page.setStart(0);
        page.setRows(10);
        List<Project> test = ps.select1(page).getList();
        Iterator<Project> l2 = test.iterator();
        while (l2.hasNext()) {
            Project i = l2.next();
            System.out.println(i.getName());
            
        }
        
    }
    
    @Test
    public void testSelectProjectList3() {
        Project p = new Project();
        Page<Project> page = new Page<Project>();
        page.setParamEntity(p);
        page.setPage(1);
        page.setStart(0);
        page.setRows(2);
        List<Project> test = ps.select3(page).getList();
        Iterator<Project> l2 = test.iterator();
        while (l2.hasNext()) {
            Project i = l2.next();
            System.out.println(i.getName());
            
        }
        
    }
    
    @Test
    public void testSelectByCompany() {
        Company com = new Company();
        com.setCompanyid(26);
        Page<Company> page = new Page<Company>();
        page.setPage(1);
        page.setRows(10);
        page.setParamEntity(com);
        Page<Project> page2 = ps.selectByCompany(page);
        List<Project> list = page2.getList();
        Iterator<Project> l2 = list.iterator();
        while (l2.hasNext()) {
            Project i = l2.next();
            System.out.println(i.getName());
            
        }
    }
    
    @Test
    public void testSelectByProject() {
        Project poj = new Project();
        poj.setProjectid(5);
        Page<Project> page = new Page<Project>();
        page.setPage(1);
        page.setRows(10);
        page.setParamEntity(poj);
        Page<Company> page2 = ps.selectByProject(page);
        List<Company> list = page2.getList();
        Iterator<Company> l2 = list.iterator();
        while (l2.hasNext()) {
            Company i = l2.next();
            System.out.println(i.getCompanyname());
            
        }
        
    }
    
    @Test
    public void testUpdateProject() {
        Project poj = new Project();
        poj.setName("建筑工程");
        poj.setProjectid(8);
        assertEquals(1, ps.updateProject(poj));
    }
    
    @Test
    public void testFindProjectSupervisionreport() {
        Project entity = new Project();
        entity.setProjectid(6);
        Page<Project> project = new Page<Project>();
        project.setPage(1);
        project.setRows(10);
        project.setParamEntity(entity);
        List<Supervisionreport> l = ps.findProjectSupervisionreport(project)
                                      .getList();
        Iterator<Supervisionreport> l2 = l.iterator();
        while (l2.hasNext()) {
            Supervisionreport l3 = l2.next();
            System.out.println(l3.getSreportid());
        }
    }
    
    @Test
    public void testAplicationCompletion() throws Exception {
        String aa = "2016-09-03";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = df.parse(aa);
        java.sql.Date e = new java.sql.Date(d.getTime());
        
        Faoc entity = new Faoc();
        entity.setFaocdate(e);
        ps.aplicationCompletion(6);
    }
    
    @Test
    public void testExamineCompletion() {
        Faoc entity = new Faoc();
        entity.setFaocid(6);
        entity.setProjectid(6);
        entity.setApplicationresult("通过");
        ps.examineCompletion(6, 0);
        
    }
}
