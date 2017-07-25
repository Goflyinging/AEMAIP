package cn.xidian.aemaip.dao;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xidian.aemaip.entity.Accountcharacter;
import cn.xidian.aemaip.entity.Characters;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Users;
import cn.xidian.aemaip.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext.xml" })
public class UserServiceImplTest {
    @Autowired
    UsersMapper um;
    
    @Resource
    UsersService us;
    
    @Test
    public void testIU() throws Exception {
        Users u = new Users();
        u.setUsername("xxyy");
        u.setPasswd("admin");
        us.insertUser(u);
        
    }
    
    @Test
    public void testLogin() throws Exception {
        Users u = us.login("xtc", "Hj@$p9w*d,_=");
        assertEquals("xtc", u.getUsername());
    }
    
    @Test
    public void testRegister() throws Exception {
        String username = "xtcccc";
        int a = us.register(username);
        assertEquals(username, um.selectUserById(a).getUsername());
    }
    
    @Test
    public void testDisableByID() throws Exception {
        assertEquals(0, us.disableByID(3));
    }
    
    @Test
    public void testEnableByID() throws Exception {
        assertEquals(0, us.enableByID(3));
    }
    
    @Test
    public void testChangePwdByID() throws Exception {
        assertEquals(1, us.changePwdByID(3, "pwd"));
        System.out.println(DigestUtils.md5Hex("Hj@$p9w*d,_="));
        
    }
    
    @Test
    public void testExitsUser() {
        int id = us.exitsUser("xtc").getAccount();
        assertEquals(3, id);
    }
    
    @Test
    public void testGetByID() {
        int id = 4;
        Users u = us.getByID(id);
        assertEquals(4, (int) u.getAccount());
        assertEquals(201, (int) u.getStateid());
        assertEquals("xtcccc", u.getUsername());
    }
    
    @Test
    public void findCharactersByAccount() throws Exception {
        List<Characters> ts = us.findCharactersByAccount(6);
        Iterator<Characters> l2 = ts.iterator();
        while (l2.hasNext()) {
            Characters i = l2.next();
            System.out.println(i.getCid());
            System.out.println(i.getMdg());
        }
    }
    
    @Test
    public void insertAccountCharacter() throws Exception {
        assertEquals(0, us.insertAccountCharacter(7, 2));
    }
    
    @Test
    public void testFindResourceByAccount() throws Exception {
        List<Integer> ts = us.findResourceByAccount(6);
        Iterator<Integer> l2 = ts.iterator();
        while (l2.hasNext()) {
            Integer i = l2.next();
            System.out.println(i);
            
        }
    }
    
    //
    @Test
    public void testSelect() {
        Users u = new Users();
        // u.setAccount(3);
        // u.setStateid(202);
        // u.setUsername("yyc");
        u.setPasswd("admin");
        
        Page<Users> page = new Page<Users>();
        page.setPage(1);
        page.setRows(10);
        page.setParamEntity(u);
        us.select(page);
        
        Map<String, Object> pageMap = page.getPageMap();
        List<Users> list = (List<Users>) pageMap.get("rows");
        for (Users l : list) {
            System.out.println(l.getPasswd() + "\n"
                               + l.getUsername()
                               + l.getStateid()
                               + l.getAccount());
        }
    }
    
    @Test
    public void testUpdateByID() throws Exception {
        Users u = new Users();
        u.setAccount(26);
        u.setStateid(202);
        u.setUsername("hhhhtxt444110");
        u.setPasswd("admin");
        
        us.updateByID(u);
        
    }
    
    @Test
    public void testGetUserResource() {
        List<Integer> userResource = um.getUserResource(7);
        for (int i : userResource) {
            System.out.println(i);
        }
    }
    
    @Test
    public void testGetAccountcharacter() {
        Accountcharacter ac = new Accountcharacter();
        // ac.setAccount(7);
        // ac.setAcid(1);
        ac.setCid(2);
        
        Page<Accountcharacter> page = new Page<Accountcharacter>();
        page.setPage(1);
        page.setRows(10);
        page.setParamEntity(ac);
        us.getAccountcharacter(page);
        Map<String, Object> pageMap = page.getPageMap();
        List<Accountcharacter> l = (List<Accountcharacter>) pageMap.get("rows");
        
        for (Accountcharacter a : l) {
            System.out.println(a.getAcid());
            System.out.println(a.getAccount());
            System.out.println(a.getCid());
        }
        
    }
    
    @Test
    public void testSetUserCharacter() throws Exception {
        int[] cid = { 2, 3, 4 };
        int account = 3;
        us.setUserCharacter(account, cid);
        
    }
}
