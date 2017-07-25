package cn.xidian.aemaip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.ResourceMapper;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Resource;
import cn.xidian.aemaip.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    ResourceMapper rm;
    
    public List<Resource> findSonResource(int Res_resourceid) {
        List<Resource> fsr = rm.selectByRes_resourceid(Res_resourceid);
        return fsr;
    }
    
    public int insert(Resource resource) {
        
        return rm.insert(resource);
    }
    
    public Page<Resource> select(Page<Resource> page) {
        page.setTotalRecord(rm.selectCount(page));
        page.setList(rm.select(page));
        return page;
    }
    
    public int updateByID(Resource r) throws Exception {
        return rm.updateByID(r);
    }
    
    public int delete(Resource r) throws Exception {
        if (r.getResResourceid() == null && r.getAdress() == null
            && r.getNumber() == null
            && r.getResourcename() == null
            && r.getResourceid() == null)
            return 0;
        return rm.delete(r);
    }
    
    public List<Resource> selectAll() {
        // TODO Auto-generated method stub
        return rm.selectAll();
    }
    
}
