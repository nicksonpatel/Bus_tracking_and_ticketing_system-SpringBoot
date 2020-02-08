package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.demo.model.Bus;
import com.example.demo.model.Ticket;

public interface BusService {

	void sendotp(Integer busid, HttpSession ht);

	List<Bus> getbuslist(String source, String destination);

	void addbus(Bus bus);

	void deletebus(int busid);

	Bus verifyotp(String otp, int busid);

	Ticket generateticket(int busid, String source, String destination, String mobile);

	List<Bus> getallbus();


}
