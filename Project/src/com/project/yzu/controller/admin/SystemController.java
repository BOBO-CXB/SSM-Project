package com.project.yzu.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.util.StringUtil;
import com.project.yzu.entity.admin.User;
import com.project.yzu.service.admin.UserService;

@Controller
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping(value = "/index",method = RequestMethod.GET)
//	public String index() {
//		return "system/index";
//	}
	@RequestMapping(value = "/index",method = RequestMethod.GET)
 	public ModelAndView index(ModelAndView model) {
  		 model.setViewName("system/index");
 		 return model;
 	 }
	
	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
 	public ModelAndView welcome(ModelAndView model) {
  		 model.setViewName("system/welcome");
 		 return model;
 	 }
 	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model) {
		model.setViewName("system/login");
		return model;
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> loginAct(User user,HttpServletRequest request){
		Map<String, String> ret = new HashMap<String,String>();
		if(user == null) {
			ret.put("type", "error");
			ret.put("msg", "����д�û���Ϣ��");
			return ret;
		}
	
		if(StringUtil.isEmpty(user.getUsername())) {
			ret.put("type", "error");
			ret.put("msg", "����д�û�����");
			return ret;
		}
		
		if(StringUtil.isEmpty(user.getPassword())) {
			ret.put("type", "error");
			ret.put("msg", "����д���룡");
			return ret;
		}
		
		User findByUsername = userService.findByUsername(user.getUsername());
		if(findByUsername == null) {
			ret.put("type", "error");
			ret.put("msg", "���û��������ڣ�");
			return ret;
			
		}
		if(!user.getPassword().equals(findByUsername.getPassword())) {
			ret.put("type", "error");
			ret.put("msg", "�������");
			return ret;
		}
		request.getSession().setAttribute("admin", findByUsername);
		ret.put("type", "success");
		ret.put("msg", "��¼�ɹ���");
		return ret;
 }

}
