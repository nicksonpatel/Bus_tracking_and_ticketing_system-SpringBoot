package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Destination;

public interface DestinationRepository  extends JpaRepository<Destination, Integer> {
	
	@Query("SELECT distinct d  FROM Destination d , Destination s  WHERE LOWER(d.standName) = LOWER(:from) and LOWER(s.standName) = LOWER(:dest)  and TIME_FORMAT(d.time, '%H:%i') >= TIME_FORMAT(CURTIME(),'%H:%i') ")
	public List<Destination> FindALLBuses(@Param("from") String from ,@Param("dest") String dest);
	
	
}
