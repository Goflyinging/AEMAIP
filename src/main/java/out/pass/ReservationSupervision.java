package out.pass;
//预约监督单
import java.util.Date;

public class ReservationSupervision {
    private Integer rsid;//预约单编号

    private Integer projectid;//项目编号

    private Integer upiid;//预约人编号

    private Integer state;//状态编号

    private Date fdate;//预约时间

    private Date ldate;//实际监督时间

    private String description;//说明

    public Integer getRsid() {
        return rsid;
    }

    public void setRsid(Integer rsid) {
        this.rsid = rsid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getUpiid() {
        return upiid;
    }

    public void setUpiid(Integer upiid) {
        this.upiid = upiid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public Date getLdate() {
        return ldate;
    }

    public void setLdate(Date ldate) {
        this.ldate = ldate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}