package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Subscription;

public interface SubsribtionRepository extends JpaRepository<Subscription, Integer>{

	@Query("SELECT p FROM Subscription p WHERE LOWER(p.subsribation) = LOWER(:subscription)")
	Subscription checksub(@Param("subscription")String subscription);

	
	//@Query("SELECT p FROM Subscription p WHERE LOWER(p.user_id) = LOWER(:user_id)")
	//Subscription getsubbyuserid(@Param("user_id") int user_id);

}
