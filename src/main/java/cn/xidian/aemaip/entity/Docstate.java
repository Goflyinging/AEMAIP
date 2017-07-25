package cn.xidian.aemaip.entity;
//文档状态表
public class Docstate {
    private Integer state;//状态编号

    private String msg;//描述

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}