package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Subscription;
import com.example.demo.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	
	
	@Autowired
	UserRepositoryJPA JpaRes;
	
	@Autowired
	EntityManagerFactory emf;

	@Override
	public void registeruser(User user) {
//		userres.save(user);
		JpaRes.save(user);
	}
	
	
	@Override
	public User getuser(String mobile, String pass) {		
		User u=JpaRes.findbyMoPass(mobile, pass);		
		System.out.println(u);
		if(u==null) {return null;}else {return u;}
	}


	@Override
	public void deleteUser(int userid) {
		JpaRes.deleteById(userid);
	}


	@Override
	public User getuserbymobile(String mobile) {
		return JpaRes.getuserbymobile(mobile);
	}


	@Override
	public User getuaserbyid(int id) {
		return JpaRes.getOne(id);
	}


	@Override
	public Subscription buysub(User u) {
		JpaRes.save(u);
		return null;
	}


	@Override
	public User getuserbysubscribtion(Subscription s) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		javax.persistence.Query q=em.createNativeQuery("SELECT * FROM User p WHERE p.sub_id="+s.getId(),User.class);
		User u=(User) q.getSingleResult();
		em.close();
		System.out.println(u);
		//User u=JpaRes.getbysubscription(s.getId());
		return u;
	}


	@Override
	public List<User> getalluser() {
		return JpaRes.findAll();
	}
	
	


}
