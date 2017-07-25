package cn.xidian.aemaip.entity;

// 监督组
public class OversightGroup {
    private Integer ogid;// 监督组编号
    
    private Integer leader;// 质监组长编号
    
    private String leadername;
    
    private Integer qss;// 质监站编号
    
    public Integer getOgid() {
        return ogid;
    }
    
    public void setOgid(Integer ogid) {
        this.ogid = ogid;
    }
    
    public Integer getLeader() {
        return leader;
    }
    
    public void setLeader(Integer leader) {
        this.leader = leader;
    }
    
    public Integer getQss() {
        return qss;
    }
    
    public void setQss(Integer qss) {
        this.qss = qss;
    }
    
    public String getLeadername() {
        return leadername;
    }
    
    public void setLeadername(String leadername) {
        this.leadername = leadername;
    }
}
