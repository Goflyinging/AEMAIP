package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Users;

public interface UsersMapper {
    
    public int insert(Users users);
    
    public int updateStateByID(int account, int stateid);
    
    public int updatePwdByID(int account, String passwd);
    
    public Users selectUserById(int account);
    
    public Users selectUserByUsername(String username);
    
    public Users selectUserByUsernameAndPasswd(String username, String passwd);
    
    public List<Users> select(Page<Users> page);
    
    public int selectCount(Page<Users> page);
    
    public int updateByID(Users u);
    
    public List<Integer> getUserResource(int account);
    
}
