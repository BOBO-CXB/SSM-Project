package com.project.yzu.interceptor.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
/**
 * 后台登陆拦截器
 */
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {

	//@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	///@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	//@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();		
		Object admin = request.getSession().getAttribute("admin");
		
		if(admin == null) {
			//表示未登录或登陆失效
			System.out.println("链接"+requestURI+"进入拦截器");
			String header = request.getHeader("X-Requeted-with");
			//判断是否为AJAX请求
			if("XMLHTTPREQUEST".equals(header)) {
				Map<String, String> ret = new HashMap<String,String>();
				ret.put("type", "error");
				ret.put("msg", "登陆会话超时或还未登陆，请重新登录！");
				response.getWriter().write(JSONObject.fromObject(ret).toString());
				return false;
			}
			//普通链接跳转，直接重定向到登录页面
			response.sendRedirect(request.getServletContext().getContextPath() + "/system/login");
			return false;
		}
		return true;
	}

}
