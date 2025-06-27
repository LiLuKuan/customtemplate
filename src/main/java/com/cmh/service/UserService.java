package com.cmh.service;

import java.util.List;

import com.cmh.model.User;

public interface UserService {
	List<User> findUser();
	User findUser(long id);
	void createUser(User s);
	void updateUser(User s);
	void deleteUser(User s);
}