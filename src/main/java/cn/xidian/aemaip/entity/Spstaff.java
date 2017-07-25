package cn.xidian.aemaip.entity;

// 监督人员安排表
public class Spstaff {
    private Integer spsid;// 监督人员安排编号i
    
    private Integer qsspiid;// 质监站人员编号
    
    private Integer srid;// 监督记录编号
    
    public Integer getSpsid() {
        return spsid;
    }
    
    public void setSpsid(Integer spsid) {
        this.spsid = spsid;
    }
    
    public Integer getQsspiid() {
        return qsspiid;
    }
    
    public void setQsspiid(Integer qsspiid) {
        this.qsspiid = qsspiid;
    }
    
    public Integer getSrid() {
        return srid;
    }
    
    public void setSrid(Integer srid) {
        this.srid = srid;
    }
}
