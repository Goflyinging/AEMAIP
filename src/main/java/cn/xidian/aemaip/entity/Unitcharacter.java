package cn.xidian.aemaip.entity;
//单位角色
public class Unitcharacter {
    private Integer ucid;//ucid

    private Integer id;//项目单位编号

    private Integer upiid;//个人信息编号

    private String cname;//角色名称

    private String msg;//描述

    public Integer getUcid() {
        return ucid;
    }

    public void setUcid(Integer ucid) {
        this.ucid = ucid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUpiid() {
        return upiid;
    }

    public void setUpiid(Integer upiid) {
        this.upiid = upiid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}