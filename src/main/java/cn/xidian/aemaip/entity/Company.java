package cn.xidian.aemaip.entity;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

// 单位信息
public class Company {
    
    private Integer companyid;// 单位编号
    
    private String type;
    
    @Length(min = 5, max = 15)
    @NotNull(message = "公司名不能为空")
    @Pattern(regexp = "^[\u4e00-\u9fa5]+$", message = "公司名格式错误")
    private String companyname;// 单位名称
    
    @NotNull(message = "{单位类型不能为空}")
    private Integer companytypeid;// 单位类型编号
    
    @NotNull(message = "地址编号不能为空")
    @Min(value = 1, message = "{请选择地址}")
    private Integer adressid;// 地址编号
    
    private Integer account;// 账号
    
    private Integer upiid;// 负责人信息编号
    
    @Pattern(regexp = "^[0-9]{7,11}$", message = "电话格式不正确")
    private String companyphone;// 单位电话
    
    @Email(message = "邮箱格式不对")
    @NotEmpty(message = "邮箱不能为空")
    private String email;// 单位邮箱
    
    private Date companyjiontime;// 单位注册时间
    
    private Integer companystate;
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Integer getCompanyid() {
        return companyid;
    }
    
    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }
    
    public Integer getCompanytypeid() {
        return companytypeid;
    }
    
    public void setCompanytypeid(Integer companytypeid) {
        this.companytypeid = companytypeid;
    }
    
    public Integer getAdressid() {
        return adressid;
    }
    
    public void setAdressid(Integer adressid) {
        this.adressid = adressid;
    }
    
    public Integer getAccount() {
        return account;
    }
    
    public void setAccount(Integer account) {
        this.account = account;
    }
    
    public Integer getUpiid() {
        return upiid;
    }
    
    public void setUpiid(Integer upiid) {
        this.upiid = upiid;
    }
    
    public String getCompanyname() {
        return companyname;
    }
    
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
    
    public String getCompanyphone() {
        return companyphone;
    }
    
    public void setCompanyphone(String companyphone) {
        this.companyphone = companyphone;
    }
    
    public Date getCompanyjiontime() {
        return companyjiontime;
    }
    
    public void setCompanyjiontime(Date companyjiontime) {
        this.companyjiontime = companyjiontime;
    }
    
    public Integer getCompanystate() {
        return companystate;
    }
    
    public void setCompanystate(Integer companystate) {
        this.companystate = companystate;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    public String getTest() {
        
        return "hhh";
    }
}
