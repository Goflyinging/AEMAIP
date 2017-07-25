package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Company;
import cn.xidian.aemaip.entity.Page;

public interface CompanyMapper {
    
    public Company selectByID(int companyid);
    
    public Company selectByCompanyname(String companyname);
    
    public int insert(Company company);
    
    public int updateTypeByID(int companyid, int companytypeid);
    
    public int updateAdressByID(int companyid, int adressid);
    
    public int updateUpiidByID(int companyid, int upiid);
    
    public int updatePhoneByID(int companyid, String companyphone);
    
    public int updateStateByID(int companyid, int companystate);
    
    public int updateEmailByID(int companyid, String email);
    
    public int selectUnapproved();
    
    public List<Company> selectUnapprovedPage(Page<Company> page);
    
}
