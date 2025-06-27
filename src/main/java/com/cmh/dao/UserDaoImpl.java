package com.cmh.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cmh.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public User findById(long id) {
		String sql = "select * from User where id = :id";
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(User.class);
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}

	@Override
	@Transactional
	public List<User> findAll() {
		String sql = "select * from user";
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(User.class);
		
		@SuppressWarnings("unchecked")
		List<User> resultList = query.getResultList();
		return resultList;
	}

	@Override
	@Transactional
	public void create(User s) {
		sessionFactory.getCurrentSession().persist(s);
	}
	
	@Override
	@Transactional
	public void update(User s) {
		sessionFactory.getCurrentSession().update(s);
	}
	
	@Override
	@Transactional
	public void delete(User s) {
		s.setStatus(0);
		sessionFactory.getCurrentSession().update(s);
	}
}
