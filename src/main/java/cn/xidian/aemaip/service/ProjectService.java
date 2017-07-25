package cn.xidian.aemaip.service;

import cn.xidian.aemaip.entity.Company;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Project;
import cn.xidian.aemaip.entity.Supervisionreport;

public interface ProjectService {
    /**
     * Description:[新建项目]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param entity
     * @return
     * @throws Exception
     */
    public int newProject(Project entity) throws Exception;
    
    /**
     * Description:[项目竣工申请审核]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param projectid
     * @return
     * @throws Exception
     */
    public int completeProject(int projectid, int value) throws Exception;
    
    /**
     * Description:[审核项目]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param projectid
     * @return
     */
    public int examineProject(Project project, int value);
    
    /**
     * Description:[分配监督组]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月1日
     * @param projectid
     * @param ogid
     * @return
     */
    public int distributionProjectGroup(int projectid, int ogid);
    
    // /**
    // * Description:[申请竣工]<br>
    // * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
    // * 适用场景：[描述方法使用的业务场景，可选]<br>
    // *
    // * @author:谢天赐
    // * @update: 2016年9月3日
    // * @param projectid
    // * @return
    // */
    // public int aplicationCompletion(int projectid, Faoc entity);
    //
    // /**
    // * Description:[审核竣工]<br>
    // * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
    // * 适用场景：[描述方法使用的业务场景，可选]<br>
    // *
    // * @author:谢天赐
    // * @update: 2016年9月3日
    // * @param entity
    // * @return
    // */
    // public int examineCompletion(Faoc entity, int value);
    /**
     * Description:[申请竣工]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月3日
     * @param projectid
     * @return
     */
    public int aplicationCompletion(int projectid);
    
    /**
     * Description:[审核竣工]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月3日
     * @param entity
     * @return
     */
    public int examineCompletion(int projectid, int value);
    
    /**
     * Description:[审核监督报告]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月2日
     * @param projecctid
     * @param entity
     * @return
     */
    public int examineSurpervisionReport(int projectid,
                                         Supervisionreport entity,
                                         int result);
    
    /**
     * Description:[结束项目]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param projectid
     * @return
     */
    public int endProject(int projectid);
    
    /**
     * Description:[查询项目列表]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param page
     * @return
     */
    public Page<Project> select(Page<Project> page);
    
    /**
     * Description:[查询未审核项目]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月30日
     * @param page
     * @return
     */
    public Page<Project> select1(Page<Project> page);
    
    /**
     * Description:[查询等待竣工项目列表]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月3日
     * @param page
     * @return
     */
    public Page<Project> select3(Page<Project> page);
    
    /**
     * Description:[查询公司项目]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月31日
     * @param account
     * @param prjsid
     * @return
     */
    
    public Page<Project> selectByCompany(Page<Company> company);
    
    /**
     * Description:[查询项目公司]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年8月31日
     * @param projectid
     * @return
     */
    public Page<Company> selectByProject(Page<Project> project);
    
    /**
     * Description:[为项目添加公司/为公司添加项目]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月1日
     * @param projectid
     * @param companyid
     */
    public int newProjectCompany(int projectid, int companyid);
    
    /**
     * Description:[更改项目信息]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     * 
     * @author:谢天赐
     * @update: 2016年9月2日
     * @param project
     * @return
     */
    public int updateProject(Project project);
    
    /**
     * Description:[得到监督报告列表]<br>
     * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
     * 适用场景：[描述方法使用的业务场景，可选]<br>
     *
     * @author:谢天赐
     * @update: 2016年9月2日
     * @param projectid
     * @return
     */
    public Page<Supervisionreport> findProjectSupervisionreport(Page<Project> project);
    
}
