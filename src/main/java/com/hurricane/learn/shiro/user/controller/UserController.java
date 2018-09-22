package com.hurricane.learn.shiro.user.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("index")
	public String index() {
		return "user/index";
	}
	
	@RequiresPermissions("user:admin")
	@RequestMapping("admin")
	public String admin() {
		return "user/admin";
	}
}
