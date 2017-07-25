package cn.xidian.aemaip.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

import cn.xidian.aemaip.content.Content;
import cn.xidian.aemaip.entity.Companytype;
import cn.xidian.aemaip.entity.Prjstate;
import cn.xidian.aemaip.service.CompanyaddressService;
import cn.xidian.aemaip.service.CompanytypeService;
import cn.xidian.aemaip.service.PrjstataService;
import cn.xidian.aemaip.service.ResourceService;

/***
 * Created on 2016年8月22日<br>
 * Title: [AEMAIP]_[系统参数加载]<br>
 * Description: [在系统参数启动后加载一些常用的参数]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软件学院<br>
 * 
 * @author 路星星
 * @version 1.0
 */
@Component("beanConfig")
public class BeanConfig implements ApplicationListener<ApplicationEvent> {
	// List<String> list = new ArrayList<String>();
	@Resource
	ServletContext application;

	@Resource
	CompanytypeService companytypeService;

	@Resource
	CompanyaddressService companyaddressService;

	@Resource
	ResourceService resourceService;
	@Resource
	PrjstataService prjstataService;

	/***
	 * Title: onApplicationEvent Description:Spring容器application事件
	 * 
	 * @param event
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ApplicationContextEvent) {

			if (((ApplicationContextEvent) event).getApplicationContext().getParent() == null) {// rootapplicationcontext

				// 系统参数加载
				Map<String, Object> sysParamMap = new HashMap<String, Object>();
				// 单位类型
				HashMap<Integer, String> companyTypeMap = new HashMap<Integer, String>();

				List<Companytype> list = companytypeService.selectAllType();
				for (Companytype c : list) {
					companyTypeMap.put(c.getCompanytypeid(), c.getDesperation());
				}
				sysParamMap.put(Content.COMPANY_TYPE, companyTypeMap);
				// 单位类型end
				
				//工程状态
				HashMap<Integer, String> stateTypeMap = new HashMap<Integer, String>();
				List<Prjstate> liststate = prjstataService.selectAll();
				for (Prjstate c : liststate) {
					stateTypeMap.put(c.getPrjsid(),c.getMsg());
				}
				sysParamMap.put(Content.PRJSTATE_TYPE, stateTypeMap);
				//工程状态end
				
				
				// 性别sex
				HashMap<Integer, String> sexTypeMap = new HashMap<Integer, String>();
				sexTypeMap.put(0, "男");
				sexTypeMap.put(1, "女");
				sysParamMap.put(Content.SEX_TYPE, sexTypeMap);
				// 性别end
				// 权限 resource
				List<cn.xidian.aemaip.entity.Resource> resource = resourceService.selectAll();
				sysParamMap.put(Content.RESOURCES, resource);
				// 权限 resource end

				application.setAttribute(Content.SYS_PARAM, sysParamMap);
				System.out.println("Spring初始化完毕");

			}
		}

	}
}
