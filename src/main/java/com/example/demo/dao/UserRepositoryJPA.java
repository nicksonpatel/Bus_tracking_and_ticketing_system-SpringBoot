package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Subscription;
import com.example.demo.model.User;

public interface UserRepositoryJPA extends JpaRepository<User, Integer> {
	
	
	@Query("SELECT p FROM User p WHERE LOWER(p.mobile) = LOWER(:mobile) and LOWER(p.psw) = LOWER(:psw) ")
    public User findbyMoPass(@Param("mobile") String mobile,@Param("psw") String psw);

	@Query("SELECT p FROM User p WHERE LOWER(p.mobile) = LOWER(:mobile)")
	public User getuserbymobile(@Param("mobile") String mobile);

//	@Query("SELECT p FROM User P WHERE LOWER(p.subscription) = LOWER(:subscription)")
//	public User getbysubscription(@Param("subscription") int subscription);

}