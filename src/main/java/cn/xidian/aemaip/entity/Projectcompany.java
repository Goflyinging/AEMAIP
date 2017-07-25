package cn.xidian.aemaip.entity;
//项目单位表
public class Projectcompany {
    private Integer id;//项目单位编号

    private Integer projectid;//项目编号

    private Integer companyid;//单位编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }
}