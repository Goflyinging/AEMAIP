package cn.xidian.aemaip.controller.base;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;

import cn.xidian.aemaip.service.CharactersService;
import cn.xidian.aemaip.service.CompanyService;
import cn.xidian.aemaip.service.CompanyaddressService;
import cn.xidian.aemaip.service.MonitoringProgramsService;
import cn.xidian.aemaip.service.OversightGroupService;
import cn.xidian.aemaip.service.ProjectService;
import cn.xidian.aemaip.service.QsspiService;
import cn.xidian.aemaip.service.ResourceService;
import cn.xidian.aemaip.service.SupervisionreportService;
import cn.xidian.aemaip.service.UnitpiService;
import cn.xidian.aemaip.service.UsersService;
import cn.xidian.aemaip.service.verify.VerifyService;

/***
 * Created on 2016年8月24日<br>
 * Title: [aemaip]_[控制层的父类]<br>
 * Description: [存放一些公共属性和方法]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软件学院<br>
 * 
 * @author 路星星
 * @version 1.0
 */
@Controller
public class BaseController {

	@Resource
	protected ServletContext application;

	@Resource
	protected CompanyaddressService companyaddressService;

	@Resource
	protected CompanyService companyService;

	@Resource
	protected UsersService usersService;
	@Resource
	protected VerifyService verifyService;
	@Resource
	protected ProjectService projectService;

	@Resource
	protected UnitpiService unitpiService;

	@Resource
	protected OversightGroupService oversightGroupService;

	@Resource
	protected MonitoringProgramsService monitoringProgramsService;

	@Resource
	protected ResourceService resourceService;

	@Resource
	protected QsspiService qsspiService;
	
	@Resource
	protected SupervisionreportService supervisionreportService;
	

	@Resource
	protected CharactersService charactersService;
}
