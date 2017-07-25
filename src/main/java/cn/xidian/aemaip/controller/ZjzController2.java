package cn.xidian.aemaip.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xidian.aemaip.content.Content;
import cn.xidian.aemaip.controller.base.BaseController;
import cn.xidian.aemaip.entity.Company;
import cn.xidian.aemaip.entity.OversightGroup;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Qsspi;
import cn.xidian.aemaip.service.CompanyService;
import cn.xidian.aemaip.service.OversightGroupService;
import cn.xidian.aemaip.service.ProjectService;
import cn.xidian.aemaip.service.QsspiService;
import cn.xidian.aemaip.service.UsersService;

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
@RequestMapping("/zjz")
public class ZjzController2 extends BaseController {

	/***
	 * Description:[系统管理员验证成功后转发的页面]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年8月27日
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}")
	public String index(@PathVariable int id, HttpServletRequest request) {
		List<Integer> list = usersService.findResourceByAccount(id);
		request.getSession().setAttribute(Content.PRIVILEGES, list);
		;
		return "common/main";
	}

	/***
	 * 
	 * Description:[监督站成员列表]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param page
	 *            查询分页参数
	 * @return map集合
	 */
	@RequestMapping("/qsspiList")
	@ResponseBody
	public Object qsspiList(Page<Qsspi> page) {
		page.setParamEntity(new Qsspi());
		page = qsspiService.get(page);
		return page.getPageMap();
	}

	/***
	 * 
	 * Description:[添加监督站成员]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param qsspi
	 *            监督站成员实体
	 * @return 是否成功 成功true
	 */
	@RequestMapping("/addQsspi")
	@ResponseBody
	public Object addQsspi(Qsspi qsspi) {
		try {
			qsspiService.insert(qsspi);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Description:[更新质监站成员]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param qsspi
	 *            监督站成员实体
	 * @return 是否成功 成功true
	 */
	@RequestMapping("/updateQsspi")
	@ResponseBody
	public Object updateQsspi(Qsspi qsspi) {
		try {
			qsspiService.updateByID(qsspi);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Description:[修改质监站人员密码]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月2日
	 * @param accountID
	 * @param password
	 * @return
	 */
	@RequestMapping("/changePass")
	@ResponseBody
	public Object changePass(int accountID, String password) {
		try {
			usersService.changePwdByID(accountID, password);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Description:[查询监督组列表]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param page
	 *            需要查询的信息
	 * @return map集合 rows total
	 */
	@RequestMapping("/oversightGroupList")
	@ResponseBody
	public Object oversightGroupList(Page<OversightGroup> page) {
		page.setParamEntity(new OversightGroup());
		page = oversightGroupService.select(page);
		return page.getPageMap();
	}

	/***
	 * 
	 * Description:[组建监督组]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param ids
	 *            监督组成员id
	 * @param id
	 *            组长id
	 * @return 是否成功 成功true
	 */
	@RequestMapping("/zuJDZ")
	@ResponseBody
	public Object zuJDZ(int[] ids, int id) {
		try {
			oversightGroupService.addGroup(id, ids);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Description:[为项目分配监督组]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param proID
	 *            项目id
	 * @param groupID
	 *            监督组id
	 * @return 是否成功 成功true
	 */
	@RequestMapping("/fpJDZ")
	@ResponseBody
	public Object fpJDZ(int proID, int groupID) {
		projectService.distributionProjectGroup(proID, groupID);
		return true;
	}

}
