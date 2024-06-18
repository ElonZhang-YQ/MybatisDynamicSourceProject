package com.ez.mybatisdynamicsourceproject.controller;

import com.ez.mybatisdynamicsourceproject.bean.User;
import com.ez.mybatisdynamicsourceproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/12
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/showMaster")
	public List<User> showAllMasterUser() {

		return userService.findAllMasterUser();
	}

	@RequestMapping("/showSlave")
	public List<User> showAllSlaveUser() {

		return userService.findALlSlaveUser();
	}
}
