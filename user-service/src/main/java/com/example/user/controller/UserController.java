package com.example.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import com.example.user.vo.ResponseTemplateVo;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
	
	private static Logger log=LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("inside UserControler");
		return userService.saveUser(user);
	}
	@GetMapping("/{id}")
	public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("inside getUserWithDepartment");
		return userService.getUserWithDepartment(userId);
	}
}
