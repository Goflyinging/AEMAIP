package cn.xidian.aemaip.service;

import java.util.List;

import cn.xidian.aemaip.entity.Companyaddress;

public interface CompanyaddressService {
    int insert(Companyaddress entity) throws Exception;
    
    Companyaddress selectByID(int id);
    
    List<Companyaddress> selectByPID(int pid);
    
    String getAddressByID(int id);
}
