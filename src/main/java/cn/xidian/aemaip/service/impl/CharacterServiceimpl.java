package cn.xidian.aemaip.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.Character_ResourceMapper;
import cn.xidian.aemaip.dao.CharactersMapper;
import cn.xidian.aemaip.entity.Character_Resource;
import cn.xidian.aemaip.entity.Characters;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.service.CharactersService;

@Service
public class CharacterServiceimpl implements CharactersService {
    @Autowired
    CharactersMapper cm;
    
    @Autowired
    Character_ResourceMapper crm;
    
    public int insert(String msg) throws Exception {
        
        return cm.insert(msg);
    }
    
    public List<Characters> selectAll() throws Exception {
        
        return cm.selectAll();
    }
    
    public Page<Characters> select(Page<Characters> page) {
        page.setTotalRecord(cm.selectCount(page));
        page.setList(cm.select(page));
        return page;
    }
    
    public int updateByID(Characters c) throws Exception {
        return cm.updateByID(c);
    }
    
    public int delete(Characters c) throws Exception {
        if (c.getCid() == null && c.getMdg() == null)
            return 0;
        return cm.delete(c);
    }
    
    public int setResource(int cid, int[] rid) throws Exception {
        for (int i : rid) {
            Character_Resource cr = new Character_Resource();
            cr.setCid(cid);
            cr.setResourceid(i);
            crm.insert(cr);
        }
        return 0;
    }
    
    public List<Integer> getResourceID(int cid) {
        List<Integer> rl = new ArrayList<Integer>();
        List<Character_Resource> crl = crm.selectByCid(cid);
        for (Character_Resource cr : crl) {
            rl.add(cr.getResourceid());
        }
        return rl;
    }
    
    public int updateResource(Characters entity, int[] rid) throws Exception {
        Character_Resource cr = new Character_Resource();
        cr.setCid(entity.getCid());
        crm.delete(cr);
        setResource(entity.getCid(), rid);
        return cm.updateByID(entity);
        
    }
    
    public int newCharacters(String mdg, int[] rid) throws Exception {
        cm.insert(mdg);
        Characters cha = cm.selectByMdg(mdg);
        setResource(cha.getCid(), rid);
        return 1;
    }
    
}
