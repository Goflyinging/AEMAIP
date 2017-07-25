package cn.xidian.aemaip.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xidian.aemaip.content.Content;
import cn.xidian.aemaip.controller.base.BaseController;
import cn.xidian.aemaip.entity.Characters;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Resource;
import cn.xidian.aemaip.entity.Users;

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
@RequestMapping("/sys")
public class SysController extends BaseController {
	/***
	 * 
	 * Description:[资源列表]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @param page
	 * @return
	 */
	@RequestMapping("/resourceList")
	@ResponseBody
	public Object resourceList(Page<Resource> page) {
		page.setParamEntity(new Resource());
		page = resourceService.select(page);
		return page.getPageMap();
	}

	/**
	 * 
	 * Description:[权限列表]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @param page
	 * @return
	 */
	@RequestMapping("/roleList")
	@ResponseBody
	public Object roleList(Page<Characters> page) {
		page.setParamEntity(new Characters());
		page = charactersService.select(page);
		return page.getPageMap();
	}

	/***
	 * 
	 * Description:[用户列表]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @param page
	 * @return
	 */
	@RequestMapping("/usersList")
	@ResponseBody
	public Object usersList(Page<Users> page) {
		page.setParamEntity(new Users());
		page = usersService.select(page);
		return page.getPageMap();
	}

	/***
	 * 
	 * Description:[添加用户]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public Object addUser(Users user) {
		try {
			usersService.insertUser(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Description:[修改用户密码]<br>
	 * 处理逻辑：[业务复杂的方法罗列出处理逻辑，可选]<br>
	 * 适用场景：[描述方法使用的业务场景，可选]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
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
	 * Description:[给用户分配角色]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @param account
	 * @param roleids
	 * @return
	 */
	@RequestMapping("/assigningroles")
	@ResponseBody
	public Object assigningroles(int account, int[] roleids) {
		try {
			usersService.setUserCharacter(account, roleids);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * Description:[添加角色]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @param mdg
	 * @param ids
	 * @return
	 */
	@RequestMapping("/addRole")
	@ResponseBody
	public Object addRole(String mdg, int[] ids) {
		try {
			charactersService.newCharacters(mdg, ids);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/****
	 * 
	 * Description:[更新角色]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月6日
	 * @param characters
	 * @param ids
	 * @return
	 */
	@RequestMapping("/updateRole")
	@ResponseBody
	public Object updateRole(Characters characters, int[] ids) {
		try {
			charactersService.updateResource(characters, ids);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Description:[获取角色可访问的所有资源]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @param id
	 * @return
	 */
	@RequestMapping("/getResources")
	@ResponseBody
	public Object getResources(int id) {
		List<Integer> list = charactersService.getResourceID(id);
		return list;
	}

	/***
	 * 
	 * Description:[添加资源]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @param resource
	 * @return
	 */
	@RequestMapping("/addResource")
	@ResponseBody
	public Object addResource(Resource resource) {
		int i = 0;
		i = resourceService.insert(resource);
		if (i == 0)
			return false;
		return true;
	}

	/***
	 * 
	 * Description:[更新资源]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月5日
	 * @param resource
	 * @return
	 */
	@RequestMapping("/updateResource")
	@ResponseBody
	public Object updateResource(Resource resource) {
		try {
			resourceService.updateByID(resource);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
