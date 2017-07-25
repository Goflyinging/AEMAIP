package out.pass;

/**
 * Created on 2016年9月1日<br>
 * Title: [建筑工程多主体交互平台]_[账户状态表]<br>
 * Description: [已经使用 ，无需额外添加，跳过]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软院10组<br>
 * 
 * @author 余思佳
 * @version 1.0
 */
public class State {
    private Integer stateid;// 状态编号
    
    private String stateinformation;// 状态信息
    
    public Integer getStateid() {
        return stateid;
    }
    
    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }
    
    public String getStateinformation() {
        return stateinformation;
    }
    
    public void setStateinformation(String stateinformation) {
        this.stateinformation = stateinformation;
    }
}
