package com.cmh.controller;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmh.common.RspBody;
import com.cmh.model.User;
import com.cmh.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService service;
	
    // 查詢所有使用者
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public RspBody getAllUser() {
		List<User> list = service.findUser();
		return new RspBody(true, list);
    }
	
    // 新增使用者
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces= {"application/json;charset=utf-8;"})
    public RspBody createUser(@RequestBody User user) {
    	try {
    		service.createUser(user);
    		return new RspBody(true, "成功新增使用者");
    	} catch (NoResultException e) {
    		return new RspBody(false, e.toString());
    	}
    }

    // 查詢單一使用者
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RspBody getSingleUser(@PathVariable("id") int id) {
    	try {
    		User singleuser = service.findUser(id);
    		return new RspBody(true, singleuser);
    	} catch (NoResultException e) {
    		return new RspBody(false, e.toString());
    	}
    }

    // 更新使用者
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces= {"application/json;charset=utf-8;"})
    public RspBody updateUser(@RequestBody User user,@PathVariable("id") int id) {
    	try {
    		user.setId(id);
    		service.updateUser(user);
    		return new RspBody(true, "成功更新使用者資料");
    	} catch (NoResultException e) {
    		return new RspBody(false, e.toString());
    	}
    }

    // 刪除使用者
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces= {"application/json;charset=utf-8;"})
    public RspBody deleteUser(@RequestBody User user,@PathVariable("id") int id) {
    	try {
    		user.setId(id);
    		service.deleteUser(user);
    		return new RspBody(true, "成功刪除使用者資料");
    	} catch (NoResultException e) {
    		return new RspBody(false, e.toString());
    	}
    }
}