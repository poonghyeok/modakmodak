package com.modak.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.modak.user.service.UserService;

@Controller
@RequestMapping("/login")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/test")
	public String test(Model m) {
			int testCnt = userService.getCount();
			m.addAttribute("testCnt","count"+testCnt);
			System.out.print("userLoginController..! /loging/test mapping test..!");
			System.out.print(testCnt);
		
		return "/user/userLogin/userLoginForm";
	}
	
	
}
