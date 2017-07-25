package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.Prjstate;

public interface PrjstataService {
    public int insert(Prjstate entity) throws Exception;
    
    public List<Prjstate> selectAll();
    
    public Prjstate selectById(int prjsid);
    
    public Prjstate selectByMsg(String msg);
}
