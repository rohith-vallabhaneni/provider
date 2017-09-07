package com.ggktech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggktech.response.dto.User;
import com.ggktech.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public User userDetails(){
		return userService.getUserDetails();
	}
}
