package cn.xidian.aemaip.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.CompanyMapper;
import cn.xidian.aemaip.dao.FaocMapper;
import cn.xidian.aemaip.dao.ProjectMapper;
import cn.xidian.aemaip.dao.ProjectcompanyMapper;
import cn.xidian.aemaip.dao.SupervisionreportMapper;
import cn.xidian.aemaip.entity.Company;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Project;
import cn.xidian.aemaip.entity.Projectcompany;
import cn.xidian.aemaip.entity.Supervisionreport;
import cn.xidian.aemaip.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper pm;
    
    @Autowired
    CompanyMapper cm;
    
    @Autowired
    ProjectcompanyMapper pcm;
    
    @Autowired
    SupervisionreportMapper srm;
    
    @Autowired
    FaocMapper fm;
    
    public int newProject(Project entity) throws Exception {
        
        return pm.insert(entity);
    }
    
    public int examineProject(Project project, int value) {
        if (value == 0) {
            
            if (project.getPrjsid() == 100)
                project.setPrjsid(102);
            if (project.getPrjsid() == 101)
                project.setPrjsid(102);
            return pm.update(project);
            
        }
        else {
            project.setPrjsid(101);
            return pm.update(project);
        }
        
    }
    
    public int endProject(int projectid) {
        if (pm.selectById(projectid).getPrjsid() == 108) {
            pm.updateEndTime(projectid);
            pm.updatePrjsidById(projectid, 109);
        }
        return 0;
    }
    
    public Page<Project> select(Page<Project> page) {
        Project pj = new Project();
        pj.setPrjsid(page.getParamEntity().getPrjsid());
        page.setParamEntity(pj);
        
        page.setTotalRecord(pm.selectCount(page));
        page.setList(pm.select(page));
        return page;
    }
    
    public Page<Project> select1(Page<Project> page) {
        Project pj = new Project();
        pj.setPrjsid(page.getParamEntity().getPrjsid());
        page.setParamEntity(pj);
        
        page.setTotalRecord(pm.selectCount1(page));
        page.setList(pm.select1(page));
        return page;
    }
    
    public Page<Project> select3(Page<Project> page) {
        Project pj = new Project();
        Project pj2 = new Project();
        pj = page.getParamEntity();
        pj2 = page.getParamEntity();
        pj.setPrjsid(103);
        page.setParamEntity(pj);
        List<Project> l1 = pm.select(page);
        int count = pm.selectCount(page);
        pj2.setPrjsid(106);
        page.setParamEntity(pj2);
        int count2 = pm.selectCount(page);
        List<Project> l2 = pm.select(page);
        Iterator<Project> list = l1.iterator();
        while (list.hasNext()) {
            Project pro = list.next();
            l2.add(pro);
        }
        page.setTotalRecord(count + count2);
        page.setList(l2);
        return page;
    }
    
    public int completeProject(int projectid, int value) throws Exception {
        if (value == 0) {
            if (pm.selectById(projectid).getPrjsid() == 104)
                pm.updatePrjsidById(projectid, 105);
            if (pm.selectById(projectid).getPrjsid() == 106)
                pm.updatePrjsidById(projectid, 105);
        }
        else
            pm.updatePrjsidById(projectid, 106);
        return 0;
    }
    
    public Page<Project> selectByCompany(Page<Company> company) {
        Projectcompany pc = new Projectcompany();
        pc.setCompanyid(company.getParamEntity().getCompanyid());
        Page<Projectcompany> page = new Page<Projectcompany>();
        page.setParamEntity(pc);
        page.setPage(company.getPage());
        page.setRows(company.getRows());
        List<Projectcompany> list1 = pcm.select(page);
        Iterator<Projectcompany> l1 = list1.iterator();
        List<Project> list2 = new ArrayList<Project>();
        while (l1.hasNext()) {
            Projectcompany prcom = l1.next();
            
            list2.add(pm.selectById(prcom.getProjectid()));
        }
        Page<Project> page2 = new Page<Project>();
        page2.setPage(company.getPage());
        page2.setRows(company.getRows());
        page2.setTotalRecord(pcm.selectCount(page));
        page2.setList(list2);
        return page2;
    }
    
    public Page<Company> selectByProject(Page<Project> project) {
        Projectcompany pc = new Projectcompany();
        pc.setProjectid(project.getParamEntity().getProjectid());
        Page<Projectcompany> page = new Page<Projectcompany>();
        page.setParamEntity(pc);
        page.setPage(project.getPage());
        page.setRows(project.getRows());
        List<Projectcompany> list1 = pcm.select(page);
        Iterator<Projectcompany> l1 = list1.iterator();
        List<Company> list2 = new ArrayList<Company>();
        while (l1.hasNext()) {
            Projectcompany prcom = l1.next();
            
            list2.add(cm.selectByID(prcom.getCompanyid()));
        }
        Page<Company> page2 = new Page<Company>();
        page2.setPage(project.getPage());
        page2.setRows(project.getRows());
        page2.setTotalRecord(pcm.selectCount(page));
        page2.setList(list2);
        return page2;
    }
    
    public int distributionProjectGroup(int projectid, int ogid) {
        pm.updatePrjsidById(projectid, 103);
        return pm.updateogid(projectid, ogid);
    }
    
    public int newProjectCompany(int projectid, int companyid) {
        Projectcompany entity = new Projectcompany();
        entity.setCompanyid(companyid);
        entity.setProjectid(projectid);
        return pcm.insert(entity);
    }
    
    public int examineSurpervisionReport(int projectid,
                                         Supervisionreport entity,
                                         int result) {
        if (result == 1) {
            Page<Supervisionreport> page = new Page<Supervisionreport>();
            page.setPage(1);
            page.setParamEntity(entity);
            page.setRows(1);
            List<Supervisionreport> l = srm.select(page);
            Supervisionreport k = l.get(1);
            k.setState(405);
            srm.updateByID(k);
        }
        else {
            Page<Supervisionreport> page = new Page<Supervisionreport>();
            page.setPage(1);
            page.setParamEntity(entity);
            page.setRows(1);
            List<Supervisionreport> l = srm.select(page);
            Supervisionreport k = l.get(1);
            k.setState(404);
            pm.updatePrjsidById(projectid, 108);
        }
        return 0;
    }
    
    public int updateProject(Project project) {
        project.setPrjsid(100);
        return pm.update(project);
    }
    
    public Page<Supervisionreport> findProjectSupervisionreport(Page<Project> project) {
        Page<Supervisionreport> page = new Page<Supervisionreport>();
        Supervisionreport entity = new Supervisionreport();
        entity.setProjectid(project.getParamEntity().getProjectid());
        page.setParamEntity(entity);
        page.setPage(project.getPage());
        page.setRows(project.getRows());
        page.setTotalRecord(srm.selectCount1(page));
        page.setList(srm.select1(page));
        return page;
    }
    
    // public int aplicationCompletion(int projectid, Faoc entity) {
    // entity.setProjectid(projectid);
    // fm.insert(entity);
    // return pm.updatePrjsidById(projectid, 104);
    // }
    //
    // public int examineCompletion(Faoc entity, int value) {
    // if (value == 0) {
    // fm.updateByID(entity);
    // int projectid = entity.getProjectid();
    // return pm.updatePrjsidById(projectid, 107);
    // }
    // else {
    // fm.updateByID(entity);
    // int projectid = entity.getProjectid();
    // return pm.updatePrjsidById(projectid, 106);
    // }
    // }
    
    public int aplicationCompletion(int projectid) {
        // TODO Auto-generated method stub
        return pm.updatePrjsidById(projectid, 104);
    }
    
    public int examineCompletion(int projectid, int value) {
        if (value == 0)
            return pm.updatePrjsidById(projectid, 107);
        else
            return pm.updatePrjsidById(projectid, 106);
        
    }
    
}
