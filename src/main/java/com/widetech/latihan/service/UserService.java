package com.widetech.latihan.service;

import java.util.List;

import com.widetech.latihan.dao.UserDao;
import com.widetech.latihan.model.User;

public interface UserService {

	// Create of CRUD
	void addUser(User user);

	// Read of CRUD
	List<User> getAllUsers();

	// Read of CRUD
	User getUserById(int userid);

	// Update of CRUD
	void updateUser(User user);

	// Delete of CRUD
	void deleteUser(int userid);

	UserDao getUserDao();

}