package cn.xidian.aemaip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xidian.aemaip.controller.base.BaseController;
import cn.xidian.aemaip.entity.MonitoringPrograms;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Project;
import cn.xidian.aemaip.entity.Supervisionreport;

/***
 * 
 * Created on 2016年8月27日<br>
 * Title: [aemaip]_[工程处理入口]<br>
 * Description: [描述该类概要功能介绍]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软件学院<br>
 * 
 * @author 路星星
 * @version 1.0
 */
@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController {
	/***
	 * 
	 * Description:[工程初始列表 待审核 审核失败 100 101]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param page
	 *            查询分页参数
	 * @return map集合
	 */
	@RequestMapping("/startList")
	@ResponseBody
	public Object startList(Page<Project> page) {
		page.setParamEntity(new Project());
		page.getParamEntity().setPrjsid(100);
		page = projectService.select1(page);
		return page.getPageMap();
	}

	/***
	 * 
	 * Description:[项目工程待审核 100 更改状态101或102]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月2日
	 * @param page
	 * @return
	 */
	@RequestMapping("/checkList")
	@ResponseBody
	public Object checkList(Page<Project> page) {
		page.setParamEntity(new Project());
		page.getParamEntity().setPrjsid(100);
		page = projectService.select(page);
		return page.getPageMap();
	}

	/***
	 * 
	 * Description:[工程项目分配监督组 102->103]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月2日
	 * @param page
	 * @return
	 */
	@RequestMapping("/groupProList")
	@ResponseBody
	public Object groupProList(Page<Project> page) {
		page.setParamEntity(new Project());
		page.getParamEntity().setPrjsid(102);
		page = projectService.select(page);
		return page.getPageMap();
	}

	/***
	 * 
	 * Description:[在监状态的项目工程建立监督方案列表 103在监]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月3日
	 * @param page
	 * @return
	 */
	@RequestMapping("/programList")
	@ResponseBody
	public Object programList(Page<Project> page) {
		page.setParamEntity(new Project());
		page.getParamEntity().setPrjsid(103);
		page = projectService.select(page);
		return page.getPageMap();
	}

	/***
	 * 
	 * Description:[在监状态的项目工程申请竣工 103在监]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月3日
	 * @param page
	 * @return
	 */
	@RequestMapping("/applyCompletionList")
	@ResponseBody
	public Object applyCompletionList(Page<Project> page) {
		page.setParamEntity(new Project());
		page.getParamEntity().setPrjsid(103);
		page = projectService.select3(page);
		return page.getPageMap();
	}

	/***
	 * 
	 * Description:[工程项目 竣工审核 104(申请竣工)-105(通过)、106(未通过)]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月2日
	 * @param page
	 * @return
	 */
	@RequestMapping("/endProList")
	@ResponseBody
	public Object endProList(Page<Project> page) {
		page.setParamEntity(new Project());
		page.getParamEntity().setPrjsid(104);
		page = projectService.select(page);
		return page.getPageMap();
	}

	/***
	 * 
	 * Description:[新增项目]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param project
	 *            工程实体
	 * @return 是否新增成功 成功true
	 */
	@RequestMapping("/addPro")
	@ResponseBody
	public Object addPro(Project project) {
		try {
			projectService.newProject(project);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Description:[更新项目]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月2日
	 * @param project
	 * @return
	 */

	@RequestMapping("/updatePro")
	@ResponseBody
	public Object updatePro(Project project) {
		try {
			projectService.updateProject(project);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Description:[审核项目]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月2日
	 * @param projectid
	 * @return
	 */
	@RequestMapping("/examineProject")
	@ResponseBody
	public Object examineProject(Project project, int value) {
		project.setPrjsid(100);
		try {
			projectService.examineProject(project, value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/***
	 * 
	 * Description:[添加监督方案]<br>
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @param monitoringPrograms
	 * @return
	 */
	@RequestMapping("/addProgram")
	@ResponseBody
	public Object addProgram(MonitoringPrograms monitoringPrograms) {
		try {
			monitoringProgramsService.insert(monitoringPrograms);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@RequestMapping("/updateProgram")
	@ResponseBody
	public Object updateProgram(MonitoringPrograms monitoringPrograms) {
		try {
			monitoringProgramsService.updateByID(monitoringPrograms);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	

	/***
	 * 
	 * Description:[申请竣工 项目状态 103-104]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月3日
	 * @param id
	 * @return
	 */
	@RequestMapping("/applyCompletionProject")
	@ResponseBody
	public Object applyCompletionProject(int id) {
		int i = 0;
		i = projectService.aplicationCompletion(id);
		if (i == 1) {
			return true;
		}
		return false;
	}

	/***
	 * 
	 * Description:[审核竣工申请]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月3日
	 * @param id
	 *            项目id
	 * @param value
	 *            审核结果
	 * @return 操作是否成功 成功true
	 */
	@RequestMapping("/endApply")
	@ResponseBody
	public Object endApply(int id, int value) {
		int i = 0;
		i = projectService.examineCompletion(id, value);
		if (i == 1) {
			return true;
		}
		return false;
	}

	/***
	 * 
	 * Description:[竣工申请通过后填写监督报告]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月3日
	 * @param id
	 * @return
	 */
	@RequestMapping("/addSupervisionReport")
	@ResponseBody
	public Object addSupervisionReport(Supervisionreport supervisionreport) {
		try {
			supervisionreportService.writeSupervisionReport(supervisionreport);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
