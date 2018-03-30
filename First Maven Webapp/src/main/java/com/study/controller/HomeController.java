package com.study.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.model.UserT;
import com.study.service.IUserService;

@Controller
public class HomeController {

	@RequestMapping("index")
	public String index() {
		System.out.println(userService != null);
		UserT user = userService.getUserById(1);
		System.out.println(user);
		return "index";
	}
	
	@RequestMapping("/user/toAdd")
	public String toAdd() {
		
		return "user_add";
	}

	@RequestMapping("/user/add")
	public String saveUser(UserT user,HttpServletRequest req) {
		userService.saveUser(user);
		
		List<UserT> list = userService.getAllUser();
		req.getSession().setAttribute("users", list);
		
		return "redirect:/user/list";
	}
	@RequestMapping("/user/list")
	public String listUser(HttpServletRequest req,ServletResponse resp){
		List<UserT> list = userService.getAllUser();
		req.getSession().setAttribute("users", list);
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		//int age = Integer.parseInt(req.getParameter("age"));
		if (tel == null) {
			System.out.println("listUser电话:tel is Null");
		}else if (name == null) {
			System.out.println("listUser姓名:name is Null");
		}else {
			System.out.println("listUser姓名---"+name+"listUser电话----"+tel);
		}
		return "user_list";
	}
	
	@RequestMapping("test")
	public String test(HttpServletRequest req,ServletResponse resp){
		
		return "test";
	}
	/*url提交参数和获取参数*/
	/*使用@RequestMapping URI template样式映射时，即 someUrl/{paramId}, 
	这时的paramId可通过@Pathvariable注解绑定它传过来的值到方法的参数上。
	访问该方法的url格式为：index/mahoking。@PathVariable是用来获得请求url中的动态参数的，十分方便。
	mahoking即是username的动态值。*/
	@RequestMapping("test2/{uname}")
	public String test2(@PathVariable("uname") String uname,HttpServletRequest req,ServletResponse resp){
		
		System.out.println("---------------"+uname);
		return "test";
	}
	
	/*访问该方法的url格式为：param?name=hoking(Get方式)。该方式是很普通的提交方式。
	用注解@RequestParam绑定请求参数a到变量a当请求参数a不存在时会有异常发生,可以通过设置属性required=false解决*/
	@RequestMapping("test3")
	public String test3(@RequestParam(value="uname3",required=false) String uname3,HttpServletRequest req,ServletResponse resp){
		
		System.out.println("---------------"+uname3);
		return "test";
	}
	
	/*获取请求参数Get,Post*/
	@RequestMapping("test4")
	public void test4(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		//int age = Integer.parseInt(req.getParameter("age"));
		if (tel == null) {
			System.out.println("电话:tel is Null");
		}else if (name == null) {
			System.out.println("姓名:name is Null");
		}else {
			System.out.println("姓名---"+name+"电话----"+tel);
		}
		//1.重定向,改变地址栏url,重新创建requset，浏览器处理
		//resp.sendRedirect("http://www.baidu.com");
		//2.重定向,不改变地址栏url,保留requset,提供下个地址使用,内部处理。
		req.getRequestDispatcher("/listUser").forward(req,resp);
		//3.输出浏览器数据到浏览器
		/*resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().print("姓名:"+name+" 电话:"+tel);*/
		
	}
	@RequestMapping("to/get/json")
	public String toGetJson(){
		return "ajax_get_json";
	}
	
	//输出json
	@RequestMapping("/get/json")
	@ResponseBody
	public Map<String, String> getJson() {
        Map<String, String> map = new HashMap<String, String>();  
        map.put("success", "true中");
        map.put("success2", "true2文档");
        return map;
	}
	//自定标签JSTL页面
	@RequestMapping("/custom/tag")
	public String customTag() {
       
        return "custom_tag_test";
	}
	
	@Autowired
	IUserService userService;

}
