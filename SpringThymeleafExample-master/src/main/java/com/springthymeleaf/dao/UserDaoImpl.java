package com.springthymeleaf.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.springthymeleaf.model.User;


public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction.commit();
			session.close();
		}
	}

}
