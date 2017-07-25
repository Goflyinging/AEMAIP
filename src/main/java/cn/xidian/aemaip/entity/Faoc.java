package cn.xidian.aemaip.entity;

// 竣工验收表
import java.util.Date;

public class Faoc {
    private Integer faocid;// 竣工验收编号
    
    private Integer projectid;// 项目编号
    
    private Date faocdate;// 竣工验收申请时间
    
    private String applicationadvice;// 审核意见
    
    private String applicationresult;// 审核结果
    
    public Integer getFaocid() {
        return faocid;
    }
    
    public void setFaocid(Integer faocid) {
        this.faocid = faocid;
    }
    
    public Integer getProjectid() {
        return projectid;
    }
    
    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }
    
    public Date getFaocdate() {
        return faocdate;
    }
    
    public void setFaocdate(Date faocdate) {
        this.faocdate = faocdate;
    }
    
    public String getApplicationadvice() {
        return applicationadvice;
    }
    
    public void setApplicationadvice(String applicationadvice) {
        this.applicationadvice = applicationadvice;
    }
    
    public String getApplicationresult() {
        return applicationresult;
    }
    
    public void setApplicationresult(String applicationresult) {
        this.applicationresult = applicationresult;
    }
    
}
