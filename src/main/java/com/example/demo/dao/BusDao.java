package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Bus;
import com.example.demo.model.Ticket;

public interface BusDao {

	List<Bus> getbuslist(String source, String destination);

	void addbus(Bus bus);

	void deletebus(int busid);

	Bus getbus(Integer busid);

	List<Bus> getallbus();


}
