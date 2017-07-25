package cn.xidian.aemaip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xidian.aemaip.controller.base.BaseController;
import cn.xidian.aemaip.entity.MonitoringPrograms;
import cn.xidian.aemaip.entity.OversightGroup;
import cn.xidian.aemaip.entity.Page;

/***
 * 
 * Created on 2016年8月27日<br>
 * Title:       [aemaip]_[监督管理]<br>
 * Description: [监督处理入口]<br>
 * Copyright:   Copyright (c) 2016<br>
 * Company:     西安电子科技大学<br>
 * Department:  软件学院<br>
 * @author         路星星 
 * @version        1.0
 */
@Controller
@RequestMapping("/supervision")
public class SupervisionController extends BaseController {
	
	/***
	 * 
	 * Description:[监督方案列表]<br>
	 * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
	 * 适用场景：[描述方法使用的业务场景，可选]<br>
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param page
	 * @return
	 */
	@RequestMapping("/monitoringList")
	@ResponseBody
	public Object monitoringList(Page<MonitoringPrograms> page) {
		page.setParamEntity(new MonitoringPrograms());
		page = monitoringProgramsService.selectPage(page);
		return page.getPageMap();
	}
    
}
