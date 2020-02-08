package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Ticket;

public interface TicketService {

	List<Ticket> getallticket(int userid);

	List<Ticket> getallticketsbyBusid(int busid);

}
