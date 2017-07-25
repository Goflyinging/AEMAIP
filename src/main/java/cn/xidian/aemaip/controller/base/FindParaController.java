package cn.xidian.aemaip.controller.base;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xidian.aemaip.content.Content;
import cn.xidian.aemaip.entity.Characters;
import cn.xidian.aemaip.entity.Company;
import cn.xidian.aemaip.entity.Companyaddress;
import cn.xidian.aemaip.entity.MonitoringPrograms;
import cn.xidian.aemaip.entity.OversightGroup;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Project;
import cn.xidian.aemaip.entity.Resource;

/***
 * Created on 2016年8月24日<br>
 * Title: [aemip]_[ajax异步查询数据]<br>
 * Description: [描述该类概要功能介绍]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软件学院<br>
 * 
 * @author 路星星
 * @version 1.0
 */
@Controller
@RequestMapping("/find")
public class FindParaController extends BaseController {
	/***
	 * Description:[通过选择的城市查询地区信息]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年8月24日
	 * @param pid
	 *            父地址 代表值
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/area")
	@ResponseBody
	public Object findArea(int city) {
		List<Companyaddress> list = companyaddressService.selectByPID(city);
		return list;
	}

	/***
	 * 
	 * Description:[注册是查找公司名称是否已经存在]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年8月29日
	 * @param companyname
	 * @return
	 */
	@RequestMapping("/Iscompanyname")
	@ResponseBody
	public boolean findCompanyname(String companyname) {
		try {
			Company company = companyService.selectByCompanyname(companyname);
			if (company != null)
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Description:[注册是查找用户名是否已经存在]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年8月29日
	 * @param username
	 * @return
	 */
	@RequestMapping("/Isusername")
	@ResponseBody
	public boolean findusername(String username) {
		if (usersService.exitsUser(username) != null) {
			return false;
		}
		return true;
	}

	/****
	 * 
	 * Description:[查找个列表的位置]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年8月29日
	 * @param file
	 * @param page
	 * @return 列表所在的对应文件
	 */
	@RequestMapping("/{file}/{page}")
	public String findlist(@PathVariable String file, @PathVariable String page) {
		return file + "/" + page;
	}

	/***
	 * 
	 * Description:[查找质监站监督组]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param page
	 * @return
	 */
	@RequestMapping("/oversightGroup")
	@ResponseBody
	public Object oversightGroup() {
		Page<OversightGroup> page = new Page<OversightGroup>();
		page.setPage(1);
		page.setRows(50);
		page.setParamEntity(new OversightGroup());
		page = oversightGroupService.select(page);
		return page.getPageMap().get("rows");
	}

	/**
	 * 
	 * Description:[查询工程]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @return
	 */
	@RequestMapping("/project")
	@ResponseBody
	public Object project() {
		Page<Project> page = new Page<Project>();
		page.setPage(1);
		page.setRows(50);
		Project project = new Project();
		project.setPrjsid(107);
		page.setParamEntity(project);
		page = projectService.select(page);
		return page.getPageMap().get("rows");
	}

	/***
	 * 
	 * Description:[查询工程的监督方案]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @param mp
	 * @return
	 */
	@RequestMapping("/projectProgram")
	@ResponseBody
	public Object projectProgram(MonitoringPrograms mp) {
		List<MonitoringPrograms> list = monitoringProgramsService.select(mp);
		return list.get(0);
	}

	/**
	 * 
	 * Description:[查询所有角色]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @return
	 */
	@RequestMapping("/roles")
	@ResponseBody
	public Object roles() {
		List<Characters> rolesList = null;
		try {
			rolesList = charactersService.selectAll();
		} catch (Exception e) {

		}
		return rolesList;
	}

	/***
	 * 
	 * Description:[资源树]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月6日
	 * @return
	 */
	@RequestMapping("/tree")
	@ResponseBody
	public Object tree() {
		Map sysparam = (Map) application.getAttribute(Content.SYS_PARAM);
		List<cn.xidian.aemaip.entity.Resource> resource = (List<Resource>) sysparam.get(Content.RESOURCES);
		return resource;
	}

}
