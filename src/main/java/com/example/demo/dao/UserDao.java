package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Subscription;
import com.example.demo.model.User;

public interface UserDao {

	void registeruser(User user);

	User getuser(String mobile, String pass);

	void deleteUser(int userid);

	User getuserbymobile(String mobile);

	User getuaserbyid(int id);

	Subscription buysub(User u);

	User getuserbysubscribtion(Subscription s);

	List<User> getalluser();

}
