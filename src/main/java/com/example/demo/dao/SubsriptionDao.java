package com.example.demo.dao;

import com.example.demo.model.Subscription;
import com.example.demo.model.User;

public interface SubsriptionDao {

	Subscription getsubscription(int user_id);

	void deletesub(Subscription sb);

	Subscription checksub(String data);

}
