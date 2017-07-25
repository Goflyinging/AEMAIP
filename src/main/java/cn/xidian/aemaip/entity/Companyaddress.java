package cn.xidian.aemaip.entity;

// 地址表
public class Companyaddress {
    private Integer addressid;// 地址编号
    
    private Integer pid;// 父节点
    
    private String name;// 名称
    
    public Integer getAddressid() {
        return addressid;
    }
    
    public void setAddressid(Integer adressid) {
        this.addressid = adressid;
    }
    
    public Integer getPid() {
        return pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
