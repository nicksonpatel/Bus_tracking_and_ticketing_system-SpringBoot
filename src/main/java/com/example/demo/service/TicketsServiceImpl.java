package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TicketDao;
import com.example.demo.model.Ticket;

@Service
public class TicketsServiceImpl implements TicketService {

	@Autowired
	TicketDao ticketdao;

	@Override
	public List<Ticket> getallticket(int userid) {
		return ticketdao.getalltickets(userid);
	}

	@Override
	public List<Ticket> getallticketsbyBusid(int busid) {
		
		return ticketdao.getallticketsbybusid(busid);
	}
	
	
	
	
}
