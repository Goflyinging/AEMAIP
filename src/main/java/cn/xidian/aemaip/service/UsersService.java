package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.Accountcharacter;
import cn.xidian.aemaip.entity.Characters;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Users;

public interface UsersService {
    
    /**
     * Description:[登陆]<br>
     * 处理逻辑：[]<br>
     * 适用场景：[用户登录]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月25日
     * @param username
     * @param passwd
     * @return
     */
    public Users login(String username, String passwd);
    
    /**
     * Description:[注册]<br>
     * 处理逻辑：[注册成功返回此用户的id]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月25日
     * @param username
     * @return
     */
    public int register(String username) throws Exception;
    
    /**
     * Description:[禁用用户]<br>
     * 处理逻辑：[传入用户id，用户状态被修改]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月25日
     * @param account
     * @return
     */
    public int disableByID(int account) throws Exception;
    
    /**
     * Description:[启用用户]<br>
     * 处理逻辑：[传入用户id，用户状态被修改]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月25日
     * @param account
     * @return
     */
    public int enableByID(int account) throws Exception;
    
    /**
     * Description:[审核账号]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param account
     * @return
     * @throws Exception
     */
    public int verifyByID(int account) throws Exception;
    
    /**
     * Description:[修改密码]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月25日
     * @param id
     * @param pwd
     * @return
     * @throws Exception
     */
    public int changePwdByID(int id, String pwd) throws Exception;
    
    /**
     * Description:[根据用户名判断是否存在用户]<br>
     * 处理逻辑：[返回对象为空代表不存在]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月25日
     * @param username
     * @return
     */
    public Users exitsUser(String username);
    
    /**
     * Description:[根据账户id获取账号信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param id
     * @return
     */
    public Users getByID(int id);
    
    /**
     * Description:[查询用户的所有角色]<br>
     * 处理逻辑：[返回该用户所有角色信息]<br>
     * 适用场景：[查询用户角色]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月26日
     * @param account
     * @return
     * @throws Exception
     */
    public List<Characters> findCharactersByAccount(int account);
    
    /**
     * Description:[为用户分配角色]<br>
     * 适用场景：[为用户分配角色]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月26日
     * @param account
     * @param cid
     * @return
     * @throws Exception
     */
    public int insertAccountCharacter(int account, int cid) throws Exception;
    
    /**
     * Description:[查询用户所有资源]<br>
     * 适用场景：[用户登录成功后查询可用资源]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月27日
     * @param account
     * @return
     * @throws Exception
     */
    public List<Integer> findResourceByAccount(int account);
    
    /**
     * Description:[多值分页查询]<br>
     * 处理逻辑：[注意密码采用MD5,密码无需转MD5]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月3日
     * @param page
     * @return
     */
    public Page<Users> select(Page<Users> page);
    
    /**
     * Description:[多值更新]<br>
     * 处理逻辑：[密码无需转MD5]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月3日
     * @param u
     * @return
     * @throws Exception
     */
    public int updateByID(Users u) throws Exception;
    
    /**
     * Description:[获取资源id列表]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月3日
     * @param account
     * @return
     */
    public List<Integer> getUserResource(int account);
    
    /**
     * Description:[获取用户角色分页]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月4日
     * @param page
     * @return
     */
    public Page<Accountcharacter> getAccountcharacter(Page<Accountcharacter> page);
    
    /**
     * Description:[更新用户角色]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年9月4日
     * @param account
     * @param cid
     * @return
     * @throws Exception
     */
    public int setUserCharacter(int account, int[] cid) throws Exception;
    
    /**
     * Description:[添加用户]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月5日
     * @param user
     * @return
     */
    public int insertUser(Users users) throws Exception;
}
