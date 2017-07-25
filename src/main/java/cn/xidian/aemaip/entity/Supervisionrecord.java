package cn.xidian.aemaip.entity;
//监督记录
import java.util.Date;

public class Supervisionrecord {
    private Integer srid;//监督记录编号

    private Integer projectid;//项目编号

    private Integer qsspiid;//编写监督员编号

    private Integer stid;//监督类型编号

    private Integer state;//状态编号

    private Integer stateid;//监督记录状态编号

    private Date supervisiontime;//监督时间

    private String supervisionrecord;//监督记录正文

    public Integer getSrid() {
        return srid;
    }

    public void setSrid(Integer srid) {
        this.srid = srid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getQsspiid() {
        return qsspiid;
    }

    public void setQsspiid(Integer qsspiid) {
        this.qsspiid = qsspiid;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Date getSupervisiontime() {
        return supervisiontime;
    }

    public void setSupervisiontime(Date supervisiontime) {
        this.supervisiontime = supervisiontime;
    }

    public String getSupervisionrecord() {
        return supervisionrecord;
    }

    public void setSupervisionrecord(String supervisionrecord) {
        this.supervisionrecord = supervisionrecord;
    }
}