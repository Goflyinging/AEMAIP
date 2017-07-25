package cn.xidian.aemaip.entity;

// 监督方案
public class MonitoringPrograms {
    private Integer mpid;// mpid
    
    private Integer sid;// 监督员编号
    
    private Integer mpsSid;// 监督方案状态
    
    private Integer projectid;// 项目编号
    
    private String mpmsg;// 方案内容
    
    public Integer getMpid() {
        return mpid;
    }
    
    public void setMpid(Integer mpid) {
        this.mpid = mpid;
    }
    
    public Integer getSid() {
        return sid;
    }
    
    public void setSid(Integer sid) {
        this.sid = sid;
    }
    
    public Integer getMpsSid() {
        return mpsSid;
    }
    
    public void setMpsSid(Integer mpsSid) {
        this.mpsSid = mpsSid;
    }
    
    public Integer getProjectid() {
        return projectid;
    }
    
    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }
    
    public String getMpmsg() {
        return mpmsg;
    }
    
    public void setMpmsg(String mpmsg) {
        this.mpmsg = mpmsg;
    }
}
