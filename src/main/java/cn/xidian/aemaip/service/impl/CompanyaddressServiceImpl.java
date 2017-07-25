package cn.xidian.aemaip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.CompanyaddressMapper;
import cn.xidian.aemaip.entity.Companyaddress;
import cn.xidian.aemaip.service.CompanyaddressService;

@Service
public class CompanyaddressServiceImpl implements CompanyaddressService {
    @Autowired
    CompanyaddressMapper companyaddressMapper;
    
    public int insert(Companyaddress entity) throws Exception {
        return companyaddressMapper.insert(entity);
    }
    
    public Companyaddress selectByID(int id) {
        return companyaddressMapper.selectByID(id);
    }
    
    public List<Companyaddress> selectByPID(int pid)  {
        return companyaddressMapper.selectByPID(pid);
    }
    
    public String getAddressByID(int id)  {
        String ad = "";
        if (id != 0) {
            Companyaddress ca = companyaddressMapper.selectByID(id);
            if (ca != null)
                ad = getAddressByID(ca.getPid() == null ? 0 : ca.getPid())
                     + ca.getName();
        }
        return ad;
    }
    
}
