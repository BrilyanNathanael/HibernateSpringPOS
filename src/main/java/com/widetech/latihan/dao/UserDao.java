package com.widetech.latihan.dao;

import java.util.List;

import com.widetech.latihan.model.User;

public interface UserDao {

	//Create of CRUD
	void addUser(User user);

	//Read of CRUD
	List<User> getAllUsers();

	//Read of CRUD
	User getUserById(int userid);

	//Update of CRUD
	void updateUser(User user);

	//Delete of CRUD
	void deleteUser(int userid);

}