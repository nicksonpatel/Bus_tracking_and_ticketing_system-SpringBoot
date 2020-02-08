package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Ticket;

public interface TicketDao {

	List<Ticket> getalltickets(int userid);

	List<Ticket> getallticketsbybusid(int busid);

	void addticket(Ticket tc);

}
