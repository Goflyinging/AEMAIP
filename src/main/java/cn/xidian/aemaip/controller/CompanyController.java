package cn.xidian.aemaip.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xidian.aemaip.content.Content;
import cn.xidian.aemaip.controller.base.BaseController;
import cn.xidian.aemaip.entity.Company;
import cn.xidian.aemaip.entity.Page;
import cn.xidian.aemaip.entity.Unitpi;

/***
 * Created on 2016年8月25日<br>
 * Title: [aemaip]_[各责任主体]<br>
 * Description: [处理有关各责任主体的请求]<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 西安电子科技大学<br>
 * Department: 软件学院<br>
 * 
 * @author 路星星
 * @version 1.0
 */
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {

	/***
	 * Description:[各责任主体注册]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年8月24日
	 * @param model
	 * @param company
	 * @param result
	 * @return
	 */
	@RequestMapping("/register")
	public String register(@Valid @ModelAttribute("company") Company company, HttpServletRequest request,
			BindingResult result, String username) {
		if (result.hasErrors()) {
			request.setAttribute("formErrors", "操作异常，请正确操作！");
			return "/login/register";
		}
		try {
			int i = usersService.register(username);
			company.setAccount(i);
			companyService.insert(company);
		} catch (Exception e) {
			request.setAttribute("formErrors", "操作异常，请正确操作！");
			e.printStackTrace();
			return "/login/register";
		}
		request.setAttribute("company", company);
		return "/company/reSuccess";
	}

	/***
	 * Description:[由 /register转发过来，公司注册完成后提示用户注册完成等待审核]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年8月25日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/reSuccess")
	public String success(HttpServletRequest request, HttpServletResponse response) {
		String str = (String) request.getAttribute("companyname");// 公司名
		String username = (String) request.getAttribute("username");// 公司登录帐号
		if (str == null || str.equals("")) {
			return "redirect:login/register";
		}
		return "/company/reSuccess";
	}

	/***
	 * Description:[各公司登录]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年8月27日
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/{id}")
	public String index(@PathVariable int id, HttpServletRequest request) {
		// 查找可访问的资源集合
		List<Integer> list = usersService.findResourceByAccount(id);
		request.getSession().setAttribute(Content.PRIVILEGES, list);
		;

		return "common/main";
	}

	/***
	 * Description:[公司未审核的列表]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年8月29日
	 * @return map集合
	 */
	@RequestMapping("/noVerifyList")
	@ResponseBody
	public Object noVerifyList(Page<Company> page) {
		page = companyService.getUnapproved(page);
		return page.getPageMap();
	}

	/***
	 * Description:[审核注册公司]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年8月30日
	 * @param id
	 * @param request
	 * @return false 失败 true成功
	 */
	@RequestMapping("/verifyCompany")
	@ResponseBody
	public Object verify(int id, HttpServletRequest request) {
		try {
			verifyService.verifyCompany(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Description:[各责任主体人员管理列表]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param page
	 *            查询分页参数
	 * @return map集合
	 */
	@RequestMapping("/unitpiList")
	@ResponseBody
	public Object ubitpList(Page<Unitpi> page) {
		page.setParamEntity(new Unitpi());
		page = unitpiService.select(page);
		return page.getPageMap();
	}

	/***
	 * 
	 * Description:[添加各责任主体成员]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param unitpi
	 *            成员信息实体
	 * @return 是否成功 成功true
	 */
	@RequestMapping("/addUnitpi")
	@ResponseBody
	public Object addUnitpi(Unitpi unitpi) {
		try {
			unitpiService.addPI(unitpi);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Description:[更新各责任主体成员]<br>
	 * 
	 * @author:路星星
	 * @update: 2016年9月1日
	 * @param unitpi
	 *            各责任主体成员实体
	 * @return 是否成功 成功true
	 */
	@RequestMapping("/updateUnitpi")
	@ResponseBody
	public Object updateUnitpi(Unitpi unitpi) {
		try {
			unitpiService.updateByID(unitpi);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
