package com.springthymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springthymeleaf.dao.UserDao;
import com.springthymeleaf.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void saveUser(User user) {
		userDao.saveUser(user);
	}
}
