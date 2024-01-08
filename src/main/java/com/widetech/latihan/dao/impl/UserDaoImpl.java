package com.widetech.latihan.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.widetech.latihan.dao.UserDao;
import com.widetech.latihan.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	// Create of CRUD
	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	// Read of CRUD
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
	}

	// Read of CRUD
	@Override
	public User getUserById(int userid) {
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		String hqlQuery = "from User where id = :id";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hqlQuery);
		query.setParameter("id", userid);
		user = (User) query.getSingleResult();
		return user;
	}

	// Update of CRUD
	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	// Delete of CRUD
	@Override
	public void deleteUser(int userid) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, userid);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}

	}

}