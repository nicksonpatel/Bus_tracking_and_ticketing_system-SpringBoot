package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Destination;

@Repository
public class DestinationDaoImpl implements DestinationDao {
	
	@Autowired
	DestinationRepository desRes;

	@Override
	public void addDestination(Destination destination) {
		desRes.save(destination);
	}

	@Override
	public void deleteDestination(int destid) {
		desRes.deleteById(destid);
	}
	
	@Override
	public List<Destination> getbuslist(String source, String destination) {
		List<Destination> lst=desRes.FindALLBuses(source,destination);
		//System.out.println("last"+lst);
		return lst;
	}
	

}
