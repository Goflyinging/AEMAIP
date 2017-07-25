package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Prjstate;

public interface PrjstateMapper {
    public int insert(Prjstate entity);
    
    public Prjstate selectById(int prjsid);
    
    public Prjstate selectByMsg(String msg);
    
    public List<Prjstate> selectAll();
}
