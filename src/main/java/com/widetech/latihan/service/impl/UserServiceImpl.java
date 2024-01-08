package com.widetech.latihan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.widetech.latihan.dao.UserDao;
import com.widetech.latihan.model.User;
import com.widetech.latihan.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	
	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);
	}


	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	
	@Transactional
	public User getUserById(int userid) {
		return userDao.getUserById(userid);
	}

	
	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	
	@Transactional
	public void deleteUser(int userid) {
		userDao.deleteUser(userid);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}