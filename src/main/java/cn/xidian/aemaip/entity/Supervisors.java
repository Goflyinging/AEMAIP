package cn.xidian.aemaip.entity;

// 监督员表
public class Supervisors {
    private Integer sid;// 监督员编号
    
    private Integer ogid;// 监督组编号
    
    private Integer pinfoid;// 质监站人员编号
    
    public Integer getSid() {
        return sid;
    }
    
    public void setSid(Integer sid) {
        this.sid = sid;
    }
    
    public Integer getOgid() {
        return ogid;
    }
    
    public void setOgid(Integer ogid) {
        this.ogid = ogid;
    }
    
    public Integer getPinfoid() {
        return pinfoid;
    }
    
    public void setPinfoid(Integer pinfoid) {
        this.pinfoid = pinfoid;
    }
    
}
