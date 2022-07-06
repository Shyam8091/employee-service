package com.example.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.dao.UserDao;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import com.example.user.vo.Department;
import com.example.user.vo.ResponseTemplateVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RestTemplate restTemplate;

	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		log.info("Inside Save user Service");
		return userDao.save(user);
	}

	@Override
	public ResponseTemplateVo getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment Service implementation");
		ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
		User user = userDao.findByUserId(userId);

		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
				Department.class);
		responseTemplateVo.setUser(user);
		responseTemplateVo.setDepartment(department);
		return responseTemplateVo;

	}

}
