package com.example.demo.service;

import com.example.demo.model.Subscription;
import com.example.demo.model.User;

public interface SubscriptionService {

	Subscription getsubscription(int user_id);

	Subscription buyService(int id, int pack);

	User checksub(String data);

}
