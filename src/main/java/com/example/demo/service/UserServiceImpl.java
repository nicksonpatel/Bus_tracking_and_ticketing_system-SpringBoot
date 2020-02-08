package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Subscription;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao user_dao;

	@Override
	public void registeruser(User user) {
		Subscription sb=new Subscription();
		user.setSubscription(sb);
		user_dao.registeruser(user);
		
	}

	@Override
	public User checkuser(String mobile, String pass) {
		return user_dao.getuser(mobile,pass);
	}

	@Override
	public void deleteUser(int userid) {
		user_dao.deleteUser(userid);
		
	}

	@Override
	public List<User> getalluser() {
		return user_dao.getalluser();
	}

}
