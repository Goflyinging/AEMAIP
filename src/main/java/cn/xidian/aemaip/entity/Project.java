package cn.xidian.aemaip.entity;

// 项目表
import java.util.Date;

public class Project {
    private Integer projectid;// 项目编号
    
    private Integer ogid;// 监督组编号
    
    private Integer qssid;// 质监站编号
    
    private Integer prjsid;// 项目状态编号
    
    private String name;// 项目名称
    
    private Date begintime;// 项目开始时间
    
    private Date endtime;// 项目结束时间
    
    private String regao;// 注册审核意见
    
    private String msg;// 描述
    
    private Integer mpid;
    
    public Integer getMpid() {
        return mpid;
    }
    
    public void setMpid(Integer mpid) {
        this.mpid = mpid;
    }
    
    public Integer getProjectid() {
        return projectid;
    }
    
    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }
    
    public Integer getOgid() {
        return ogid;
    }
    
    public void setOgid(Integer ogid) {
        this.ogid = ogid;
    }
    
    public Integer getQssid() {
        return qssid;
    }
    
    public void setQssid(Integer qssid) {
        this.qssid = qssid;
    }
    
    public Integer getPrjsid() {
        return prjsid;
    }
    
    public void setPrjsid(Integer prjsid) {
        this.prjsid = prjsid;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getBegintime() {
        return begintime;
    }
    
    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }
    
    public Date getEndtime() {
        return endtime;
    }
    
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
    
    public String getRegao() {
        return regao;
    }
    
    public void setRegao(String regao) {
        this.regao = regao;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
