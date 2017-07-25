package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Companytype;

public interface CompanytypeMapper {
    
    public Companytype selectTypeById(int id);
    
    public List<Companytype> selectAllType();
    
}
