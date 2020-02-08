package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

	void registeruser(User user);

	User checkuser(String mobile, String pass);

	void deleteUser(int userid);

	List<User> getalluser();

}
