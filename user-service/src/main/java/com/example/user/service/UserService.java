package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.vo.ResponseTemplateVo;

public interface UserService {

	User saveUser(User user);

	ResponseTemplateVo getUserWithDepartment(Long userId);

}
