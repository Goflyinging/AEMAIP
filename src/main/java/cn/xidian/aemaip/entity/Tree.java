package cn.xidian.aemaip.entity;

import java.util.List;

public class Tree {
    
    private Integer id;

    private String text;
    private List<Tree> children;
    

    public Tree(){}
    
    public Tree(Integer id, String text, List<Tree> children) {
		super();
		this.id = id;
		this.text = text;
		this.children = children;
	}

	public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
