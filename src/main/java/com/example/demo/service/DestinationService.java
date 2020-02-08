package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Destination;

public interface DestinationService {

	void add(Destination destination);

	void deleteDestination(int destid);

	List<Destination> getbuslist(String source, String destination);

}
