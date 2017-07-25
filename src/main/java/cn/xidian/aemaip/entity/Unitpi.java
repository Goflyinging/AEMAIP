package cn.xidian.aemaip.entity;

// 单位人员信息表
public class Unitpi {
    private Integer upiid;// 个人信息编号
    
    private Integer companyid;// 单位编号
    
    private Integer adressid;// 地址编号
    
    private String name;// 姓名
    
    private String phone;// 电话
    
    private Short sex;// 性别
    
    private String msg;// 描述
    
    public Integer getUpiid() {
        return upiid;
    }
    
    public void setUpiid(Integer upiid) {
        this.upiid = upiid;
    }
    
    public Integer getCompanyid() {
        return companyid;
    }
    
    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }
    
    public Integer getAdressid() {
        return adressid;
    }
    
    public void setAdressid(Integer adressid) {
        this.adressid = adressid;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Short getSex() {
        return sex;
    }
    
    public void setSex(Short sex) {
        this.sex = sex;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
