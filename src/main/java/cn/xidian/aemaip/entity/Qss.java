package cn.xidian.aemaip.entity;

// 质监站
public class Qss {
    private Integer qssid;// 质监站编号
    
    private Integer adressid;// 地址编号
    
    private String name;// 名称
    
    public Integer getQssid() {
        return qssid;
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
}
