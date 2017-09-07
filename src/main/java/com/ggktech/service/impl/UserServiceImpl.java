package com.ggktech.service.impl;

import org.springframework.stereotype.Component;

import com.ggktech.response.dto.User;
import com.ggktech.service.UserService;

@Component
public class UserServiceImpl implements UserService{

	public User getUserDetails() {
		User user = new User();
		user.setId(1);
		user.setName("John");
		return user;
	}

}
