package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Qsspi;

public interface QsspiMapper {
    
    public Qsspi selectQpiById(int id);
    
    public List<Qsspi> selectQpiByQss(int qss);
    
    public List<Qsspi> selectQpiByMsg(String msg);
    
    public int updateMsgByID(int id, String msg);
    
    public int insert(Qsspi qpi);
    
    public int selectLast();
    
    public List<Qsspi> select(Page<Qsspi> page);
    
    public int selectCount(Page<Qsspi> page);
    
    public int updateByID(Qsspi qpi);
}
