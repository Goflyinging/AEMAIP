package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Projectcompany;

public interface ProjectcompanyMapper {
    public int insert(Projectcompany entity);
    
    public List<Projectcompany> select(Page<Projectcompany> page);
    
    public int selectCount(Page<Projectcompany> page);
}
