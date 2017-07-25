package out.pass;
//监督通知
import java.util.Date;

public class Supervisionnotice {
    private Integer snid;//监督通知编号

    private Integer projectid;//项目编号

    private Integer rsid;//预约单编号

    private Integer qsspiid;//编写人编号

    private Integer state;//状态编号

    private Date date;//监督时间

    private String snnotice;//监督通知内容

    public Integer getSnid() {
        return snid;
    }

    public void setSnid(Integer snid) {
        this.snid = snid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getRsid() {
        return rsid;
    }

    public void setRsid(Integer rsid) {
        this.rsid = rsid;
    }

    public Integer getQsspiid() {
        return qsspiid;
    }

    public void setQsspiid(Integer qsspiid) {
        this.qsspiid = qsspiid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSnnotice() {
        return snnotice;
    }

    public void setSnnotice(String snnotice) {
        this.snnotice = snnotice;
    }
}