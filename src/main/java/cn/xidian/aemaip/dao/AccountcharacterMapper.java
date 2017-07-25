package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Accountcharacter;
import cn.xidian.aemaip.entity.Page;

public interface AccountcharacterMapper {
    
    public List<Accountcharacter> selectByAccount(int account);
    
    public Accountcharacter selectByAccountAndCid(int account, int cid);
    
    public int insert(Accountcharacter entity);
    
    //
    public List<Accountcharacter> select(Page<Accountcharacter> page);
    
    public int selectCount(Page<Accountcharacter> page);
    
    public int updateByID(Accountcharacter ac);
    
    public int delete(Accountcharacter ac);
}
