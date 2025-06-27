package com.cmh.dao;

import java.util.List;

import com.cmh.model.User;

public interface UserDao {
	User findById(long id);
	List<User> findAll();
	void create(User s);
	void update(User s);
	void delete(User s);
}