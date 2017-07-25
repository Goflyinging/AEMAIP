package cn.xidian.aemaip.entity;
//角色资源表
public class Character_Resource {
    private Integer id;//ID

    private Integer resourceid;//资源编号

    private Integer cid;//角色编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}