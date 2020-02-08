package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DestinationDao;
import com.example.demo.model.Destination;

@Service
public class DestinationServiceImpl implements DestinationService {
	
	@Autowired
	DestinationDao DesDao;

	@Override
	public void add(Destination destination) {
		DesDao.addDestination(destination);		
	}

	@Override
	public void deleteDestination(int destid) {
		DesDao.deleteDestination(destid);
		
	}
	
	@Override
	public List<Destination> getbuslist(String source, String destination) {
		List<Destination> lst=DesDao.getbuslist(source,destination);
		return lst;
	}
		
	
	
}
