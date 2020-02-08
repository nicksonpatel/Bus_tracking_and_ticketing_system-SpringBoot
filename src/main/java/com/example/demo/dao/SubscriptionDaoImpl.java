package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Subscription;
import com.example.demo.model.User;


@Service
public class SubscriptionDaoImpl implements SubsriptionDao {

	@Autowired
	SubsribtionRepository SubRes;
	
	@Autowired
	EntityManagerFactory emf;
	
	@Transactional
	@Override
	public Subscription getsubscription(int sub_id) {
		Subscription s=SubRes.getOne(sub_id);
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		System.out.println("user id--" +user_id);
//		javax.persistence.Query q=em.createNativeQuery("SELECT * FROM Subscription p WHERE p.user_id="+user_id,Subscription.class);
//		Subscription s=(Subscription) q.getSingleResult();
//		em.close();
//		System.out.println(s);
		return s;	
		//return null;//SubRes.getsubbyuserid(user_id);
	}

	@Override
	public void deletesub(Subscription sb) {
		System.out.println("in sub delete dao-------------------");
		SubRes.delete(sb);	
	}

	@Override
	public Subscription checksub(String data) {
	 Subscription s=SubRes.checksub(data);
	 return s;
	}
	
}
