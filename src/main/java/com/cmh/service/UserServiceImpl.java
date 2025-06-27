package com.cmh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmh.dao.UserDao;
import com.cmh.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
	@Override
	@Transactional
	public List<User> findUser() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public User findUser(long id) {
		return dao.findById(id);
	}


	@Override
	@Transactional
	public void createUser(User s) {
		dao.create(s);
	}
	
	@Override
	@Transactional
	public void updateUser(User s) {
		dao.update(s);
	}

	@Override
	@Transactional
	public void deleteUser(User s) {
		dao.delete(s);
	}
}
