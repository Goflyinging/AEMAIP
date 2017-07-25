package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Faoc;
import cn.xidian.aemaip.entity.Page;

public interface FaocMapper {
    
    public List<Faoc> select(Page<Faoc> page);
    
    public int selectCount(Page<Faoc> page);
    
    public int updateByID(Faoc f);
    
    public int insert(Faoc f);
}
