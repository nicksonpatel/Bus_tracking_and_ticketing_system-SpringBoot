package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Bus;
import com.example.demo.model.Ticket;

@Repository
public class BusDaoImpl implements BusDao {

	@Autowired
	BusRepository busres;

	@Override
	public List<Bus> getbuslist(String source, String destination) {
	//	List<Bus> lst=busres.FindALLBuses(source ,destination);
		return null;
	}

	@Override
	public void addbus(Bus bus) {
		busres.save(bus);
	}

	@Override
	public void deletebus(int busid){
		busres.deleteById(busid);	
		}

	@Override
	public Bus getbus(Integer busid) {
		return busres.getOne(busid);
	}

	@Override
	public List<Bus> getallbus() {
		return busres.findAll();
	}

	

}
