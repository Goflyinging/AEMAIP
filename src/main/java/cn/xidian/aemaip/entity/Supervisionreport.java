package cn.xidian.aemaip.entity;
//监督报告表
import java.util.Date;

public class Supervisionreport {
    private Integer sreportid;//监督报告编号

    private Integer projectid;//项目编号

    private Integer state;//状态编号

    private Date begintime;//监督开始时间

    private Date endtime;//监督完成时间

    private String result;//监督结果

    private String checkresult;//监督报告审查结果

    private Date writettime;//监督报告编写时间

    private String report;//监督报告内容

    public Integer getSreportid() {
        return sreportid;
    }

    public void setSreportid(Integer sreportid) {
        this.sreportid = sreportid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCheckresult() {
        return checkresult;
    }

    public void setCheckresult(String checkresult) {
        this.checkresult = checkresult;
    }

    public Date getWritettime() {
        return writettime;
    }

    public void setWritettime(Date writettime) {
        this.writettime = writettime;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}