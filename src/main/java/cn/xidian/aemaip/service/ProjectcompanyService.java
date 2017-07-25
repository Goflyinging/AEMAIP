package cn.xidian.aemaip.service;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Projectcompany;

public interface ProjectcompanyService {
    public int insert(Projectcompany entity);
    
    public Page<Projectcompany> select(Page<Projectcompany> page);
    
}
