package cn.xidian.aemaip.entity;

// 质监站人员表
public class Qsspi {
    private Integer qsspiid;// 质监站人员编号
    
    private String name;// 姓名
    
    private Short sex;// 性别
    
    private String tel;// 电话
    
    private String msg;// 描述
    
    private Integer account;// 账号
    
    private Integer qssid;// 质监站编号
    
    private String username;
    
    private String pwd;
    
    public String getPwd() {
        return pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setQsspiid(Integer qsspiid) {
        this.qsspiid = qsspiid;
    }
    
    public Integer getQsspiid() {
        return qsspiid;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Short getSex() {
        return sex;
    }
    
    public void setSex(Short sex) {
        this.sex = sex;
    }
    
    public String getTel() {
        return tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public Integer getAccount() {
        return account;
    }
    
    public void setAccount(Integer account) {
        this.account = account;
    }
    
    public Integer getQssid() {
        return qssid;
    }
    
    public void setQssid(Integer qssid) {
        this.qssid = qssid;
    }
}
