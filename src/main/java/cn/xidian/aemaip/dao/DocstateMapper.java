package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Docstate;

public interface DocstateMapper {
    
    public List<Docstate> select(Docstate ds);
}
