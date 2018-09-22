package com.hurricane.learn.shiro.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class AuthController {
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		Object attribute = request.getAttribute("shiroLoginFailure");
		System.out.println(attribute);
		if (!StringUtils.isEmpty(attribute)) {
			if (UnknownAccountException.class.getName().equals(attribute)) {
				request.setAttribute("errorText", "用户名不存在");
			}else if (IncorrectCredentialsException.class.getName().equals(attribute)) {
				request.setAttribute("errorText", "密码错误");
			}else {
				request.setAttribute("errorText", "未知错误");
			}
		}
		return "auth/login";
	}
	
	@RequestMapping("/unauthorized")
	public String unauthorized() {
		return "auth/unauthorized";
	}
	

}
