package cn.xidian.aemaip.service;

import cn.xidian.aemaip.entity.Company;
import cn.xidian.aemaip.entity.Page;

public interface CompanyService {
    /**
     * Description:[插入新用户]<br>
     * 处理逻辑：[需要先添加账户，并获取账户id，将账户id赋值之后才能添加 执行以下： c.setCompanytypeid(22);
     * c.setAdressid(1004); c.setCompanyname("WTF"); c.setCompanyphone("10086");
     * c.setEmail("10086@11.cn"); c.setAccount(3);]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param company
     * @return
     * @throws Exception
     */
    int insert(Company company) throws Exception;
    
    /**
     * Description:[根据id选择用户]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param companyid
     * @return
     * @throws Exception
     */
    public Company selectByID(int companyid) throws Exception;
    
    /**
     * Description:[根据公司名称选择用户]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param companyname
     * @return
     * @throws Exception
     */
    public Company selectByCompanyname(String companyname) throws Exception;
    
    /**
     * Description:[更新单位类型]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param companyid
     * @param companytypeid
     * @return
     * @throws Exception
     */
    public int updateTypeByID(int companyid,
                              int companytypeid) throws Exception;
    
    /**
     * Description:[根据id更新地址]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param companyid
     * @param adressid
     * @return
     * @throws Exception
     */
    public int updateAdressByID(int companyid, int adressid) throws Exception;
    
    /**
     * Description:[更新负责人信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param companyid
     * @param upiid
     * @return
     * @throws Exception
     */
    public int updateUpiidByID(int companyid, int upiid) throws Exception;
    
    /**
     * Description:[更新电话]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param companyid
     * @param companyphone
     * @return
     * @throws Exception
     */
    public int updatePhoneByID(int companyid,
                               String companyphone) throws Exception;
    
    /**
     * Description:[更新状态]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param companyid
     * @param companystate
     * @return
     * @throws Exception
     */
    public int updateStateByID(int companyid,
                               int companystate) throws Exception;
    
    /**
     * Description:[更新电子邮件]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param companyid
     * @param email
     * @return
     * @throws Exception
     */
    public int updateEmailByID(int companyid, String email) throws Exception;
    
    /**
     * Description:[获取未审核单位分页]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月29日
     * @param page
     * @return
     */
    public Page<Company> getUnapproved(Page<Company> page);
    
}
