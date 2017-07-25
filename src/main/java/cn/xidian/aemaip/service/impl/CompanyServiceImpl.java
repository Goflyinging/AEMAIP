package cn.xidian.aemaip.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xidian.aemaip.dao.CompanyMapper;
import cn.xidian.aemaip.entity.Company;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.service.CompanyService;
import cn.xidian.aemaip.service.UsersService;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyMapper cm;
    
    @Resource
    UsersService us;
    
    // @Resource
    // ServletContext application;
    
    public int insert(Company company) throws Exception {
        company.setCompanystate(0);
        /**
         * 0代表审核中
         */
        return cm.insert(company);
    }
    
    public Company selectByID(int companyid) throws Exception {
        return cm.selectByID(companyid);
    }
    
    public Company selectByCompanyname(String companyname) throws Exception {
        return cm.selectByCompanyname(companyname);
    }
    
    public int updateTypeByID(int companyid,
                              int companytypeid) throws Exception {
        cm.updateTypeByID(companyid, companytypeid);
        return 0;
    }
    
    public int updateAdressByID(int companyid, int adressid) throws Exception {
        cm.updateAdressByID(companyid, adressid);
        return 0;
    }
    
    public int updateUpiidByID(int companyid, int upiid) throws Exception {
        cm.updateUpiidByID(companyid, upiid);
        return 0;
    }
    
    public int updatePhoneByID(int companyid,
                               String companyphone) throws Exception {
        cm.updatePhoneByID(companyid, companyphone);
        return 0;
    }
    
    public int updateStateByID(int companyid,
                               int companystate) throws Exception {
        cm.updateStateByID(companyid, companystate);
        return 0;
    }
    
    public int updateEmailByID(int companyid, String email) throws Exception {
        cm.updateEmailByID(companyid, email);
        return 0;
    }
    
    public Page<Company> getUnapproved(Page<Company> page) {
        page.setTotalRecord(cm.selectUnapproved());
        page.setList(cm.selectUnapprovedPage(page));
        return page;
        
    }
    
}
