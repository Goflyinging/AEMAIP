package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Unitpi;

public interface UnitpiMapper {
    
    public Unitpi selectPIById(int id);
    
    public List<Unitpi> selectPIByCompany(int cid);
    
    public List<Unitpi> selectPIByMsg(String msg);
    
    public int insert(Unitpi pi);
    
    public int updateMsgByID(int id, String msg);
    
    public List<Unitpi> select(Page<Unitpi> page);
    
    public int selectCount(Page<Unitpi> page);
    
    public int updateByID(Unitpi upi);
}
