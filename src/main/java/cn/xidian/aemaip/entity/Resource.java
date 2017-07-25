package cn.xidian.aemaip.entity;

import java.util.List;

// 资源表
public class Resource {
    private Integer resourceid;// 资源编号
    
    private Integer res_resourceid;// 资源表_资源编号
    
    private String resourcename;// 资源名称
     
    private List<Resource> children;
    
    public List<Resource> getChildren() {
		return children;
	}

	public void setChildren(List<Resource> children) {
		this.children = children;
	}

	private String adress;// 资源地址
    
    private Integer number;// 资源数量
    
    public Integer getResourceid() {
        return resourceid;
    }
    
    public Integer getId() {
        return resourceid;
    }
    
    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }
    
    public Integer getResResourceid() {
        return res_resourceid;
    }
    
    public void setResResourceid(Integer resResourceid) {
        this.res_resourceid = resResourceid;
    }
    
    public Integer getRes_resourceid() {
        return res_resourceid;
    }
    
    public void setRes_resourceid(Integer resResourceid) {
        this.res_resourceid = resResourceid;
    }
    
    public String getResourcename() {
        return resourcename;
    }
    
    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }
    
    public String getAdress() {
        return adress;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    public Integer getNumber() {
        return number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }
}
