package cn.xidian.aemaip.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.AccountcharacterMapper;
import cn.xidian.aemaip.dao.Character_ResourceMapper;
import cn.xidian.aemaip.dao.CharactersMapper;
import cn.xidian.aemaip.dao.ResourceMapper;
import cn.xidian.aemaip.dao.UsersMapper;
import cn.xidian.aemaip.entity.Accountcharacter;
import cn.xidian.aemaip.entity.Character_Resource;
import cn.xidian.aemaip.entity.Characters;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Resource;
import cn.xidian.aemaip.entity.Users;
import cn.xidian.aemaip.service.UsersService;

@Service
public class UserServiceImpl implements UsersService {
    
    @Autowired
    UsersMapper um;
    
    @Autowired
    CharactersMapper cm;
    
    @Autowired
    AccountcharacterMapper acm;
    
    @Autowired
    ResourceMapper rm;
    
    @Autowired
    Character_ResourceMapper crm;
    
    private int insert(Users users) throws Exception {
        return um.insert(users);
    }
    
    private int updateStateByID(int account, int stateid) {
        return um.updateStateByID(account, stateid);
    }
    
    private int updatePwdByID(int account, String passwd) {
        return um.updatePwdByID(account, DigestUtils.md5Hex(passwd));
    }
    
    private Users selectUserById(int account) {
        return um.selectUserById(account);
    }
    
    /**
     * Description:[验证用户名和密码]<br>
     * 处理逻辑：[返回users对象，可以获取到他的id（account）和状态]<br>
     * 适用场景：[登陆时]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月25日
     * @param username
     * @param passwd
     * @return @
     */
    private Users selectUserByUsernameAndPasswd(String username,
                                                String passwd) {
        return um.selectUserByUsernameAndPasswd(username,
                                                DigestUtils.md5Hex(passwd));
    }
    
    private Users add(String username) throws Exception {
        String pwd = Integer.toString(username.hashCode());
        Users newuser = new Users();
        newuser.setUsername(username);
        newuser.setPasswd(DigestUtils.md5Hex(pwd));
        newuser.setStateid(201);
        insert(newuser);
        return selectUserByUsernameAndPasswd(username, pwd);
    }
    
    public Users login(String username, String passwd) {
        Users u = selectUserByUsernameAndPasswd(username, passwd);
        // if (u != null && u.getStateid() != 202) {
        // u = null;
        // }
        return u;
    }
    
    public int register(String username) throws Exception {
        return add(username).getAccount();
    }
    
    public int disableByID(int account) throws Exception {
        Users u = selectUserById(account);
        if (u.getStateid() != 201)
            updateStateByID(account, 204);
        return 0;
    }
    
    public int enableByID(int account) throws Exception {
        Users u = selectUserById(account);
        if (u.getStateid() == 204)
            updateStateByID(account, 202);
        return 0;
    }
    
    public int changePwdByID(int id, String pwd) throws Exception {
        return updatePwdByID(id, pwd);
    }
    
    public Users exitsUser(String username) {
        return um.selectUserByUsername(username);
    }
    
    public Users getByID(int id) {
        return um.selectUserById(id);
    }
    
    public int verifyByID(int account) throws Exception {
        Users u = selectUserById(account);
        if (u.getStateid() == 201)
            updateStateByID(account, 202);
        return 0;
    }
    
    public List<Characters> findCharactersByAccount(int account) {
        List<Accountcharacter> lac = acm.selectByAccount(account);
        Iterator<Accountcharacter> jjj = lac.iterator();
        List<Characters> lc = new ArrayList<Characters>();
        
        while (jjj.hasNext()) {
            Accountcharacter j = jjj.next();
            
            lc.add(cm.selectById(j.getCid()));
        }
        return lc;
    }
    
    public int insertAccountCharacter(int account, int cid) throws Exception {
        Accountcharacter entity = new Accountcharacter();
        entity.setAccount(account);
        entity.setCid(cid);
        if (acm.selectByAccountAndCid(account, cid) != null)
            return -1;
        acm.insert(entity);
        return 0;
    }
    
    public List<Integer> findResourceByAccount(int account) {
        
        List<Characters> i1 = findCharactersByAccount(account);
        List<Resource> i2 = new ArrayList<Resource>();
        List<Integer> i7 = new ArrayList<Integer>();
        Iterator<Characters> l = i1.iterator();
        while (l.hasNext()) {
            Characters chars = l.next();
            List<Character_Resource> i3 = crm.selectByCid(chars.getCid());
            Iterator<Character_Resource> l3 = i3.iterator();
            while (l3.hasNext()) {
                Character_Resource charre = l3.next();
                Resource re = rm.selectById(charre.getResourceid());
                i2.add(re);
            }
        }
        for (int i = 0; i < i2.size() - 1; i++) {
            for (int j = i2.size() - 1; j > i; j--) {
                if (i2.get(j)
                      .getResourceid()
                      .equals(i2.get(i).getResourceid())) {
                    i2.remove(j);
                }
            }
        }
        Iterator<Resource> l2 = i2.iterator();
        while (l2.hasNext()) {
            Resource res = l2.next();
            i7.add(res.getResourceid());
            
        }
        return i7;
    }
    
    public Page<Users> select(Page<Users> page) {
        Users u = page.getParamEntity();
        String pwd = u.getPasswd();
        if (pwd != null) {
            u.setPasswd(DigestUtils.md5Hex(pwd));
            page.setParamEntity(u);
        }
        page.setTotalRecord(um.selectCount(page));
        page.setList(um.select(page));
        return page;
    }
    
    public int updateByID(Users u) throws Exception {
        String pwd = u.getPasswd();
        if (pwd != null)
            u.setPasswd(DigestUtils.md5Hex(pwd));
        return um.updateByID(u);
    }
    
    public List<Integer> getUserResource(int account) {
        return um.getUserResource(account);
    }
    
    public Page<Accountcharacter> getAccountcharacter(Page<Accountcharacter> page) {
        page.setTotalRecord(acm.selectCount(page));
        page.setList(acm.select(page));
        return page;
    }
    
    public int setUserCharacter(int account, int[] cid) throws Exception {
        Accountcharacter ac = new Accountcharacter();
        ac.setAccount(account);
        acm.delete(ac);
        for (int i : cid) {
            Accountcharacter a = new Accountcharacter();
            a.setAccount(account);
            a.setCid(i);
            acm.insert(a);
        }
        return 0;
    }
    
    public int insertUser(Users users) throws Exception {
        users.setPasswd(DigestUtils.md5Hex(users.getPasswd()));
        return insert(users);
    }
}
