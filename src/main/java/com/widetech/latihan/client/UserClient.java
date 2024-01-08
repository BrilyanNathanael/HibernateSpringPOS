package com.widetech.latihan.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.widetech.latihan.dao.UserDao;
import com.widetech.latihan.dao.impl.UserDaoImpl;
import com.widetech.latihan.model.User;
import com.widetech.latihan.service.impl.UserServiceImpl;

public class UserClient {

	public static void main(String[] args) {
		 UserServiceImpl userService = new UserServiceImpl();
	        UserDao userDao = new UserDaoImpl();
	        userService.setUserDao(userDao);
	        
	        User user1 = new User();
	        user1.setFirstName("Budiman");
	        user1.setLastName("Budiman");
	        try {
	            Date dob = new SimpleDateFormat("yyyy-MM-dd").parse("1995-01-01");
	            user1.setDob(dob);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
	        user1.setEmail("budiman.budiman@budiman.com");
	        User user2 = new User();
	        user2.setFirstName("Mumtaz");
	        user2.setLastName("Ahmad");
	        try {
	            Date dob = new SimpleDateFormat("yyyy-MM-dd").parse("1975-01-01");
	            user2.setDob(dob);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        user2.setEmail("mumtaz@mumtaz.com");
	        
	        userService.addUser(user1);
	        userService.addUser(user2);
	        
	        for (User retrivedUser : userService.getAllUsers()) {
	            System.out.println(retrivedUser.getFirstName());
	            System.out.println(retrivedUser.getLastName());
	            System.out.println(retrivedUser.getEmail());
	            System.out.println(retrivedUser.getDob());
	        }

	}

}
