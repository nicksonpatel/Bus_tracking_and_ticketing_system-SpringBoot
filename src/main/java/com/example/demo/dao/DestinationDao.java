package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Destination;

public interface DestinationDao {

	void addDestination(Destination destination);

	void deleteDestination(int destid);

	List<Destination> getbuslist(String source, String destination);

}
