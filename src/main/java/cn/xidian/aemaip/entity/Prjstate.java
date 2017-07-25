package cn.xidian.aemaip.entity;
//项目状态表
public class Prjstate {
    private Integer prjsid;//项目状态编号

    private String msg;//描述

    public Integer getPrjsid() {
        return prjsid;
    }

    public void setPrjsid(Integer prjsid) {
        this.prjsid = prjsid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}