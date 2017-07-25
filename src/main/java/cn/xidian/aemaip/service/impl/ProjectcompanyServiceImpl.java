package cn.xidian.aemaip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.ProjectcompanyMapper;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Projectcompany;
import cn.xidian.aemaip.service.ProjectcompanyService;

@Service
public class ProjectcompanyServiceImpl implements ProjectcompanyService {
    @Autowired
    ProjectcompanyMapper pcm;
    
    public int insert(Projectcompany entity) {
        
        return pcm.insert(entity);
    }
    
    public Page<Projectcompany> select(Page<Projectcompany> page) {
        page.setTotalRecord(pcm.selectCount(page));
        page.setList(pcm.select(page));
        return page;
    }
    
}
