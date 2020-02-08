package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ticket;

@Repository
public class TicketDaoImpl  implements TicketDao{
	
	@Autowired
	TicketRepositorty tickres;

	@Override
	public List<Ticket> getalltickets(int userid) {
		
		List<Ticket> lst=tickres.FindTicketByUser(userid);
		
		if (lst!=null)
		{
			return lst;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Ticket> getallticketsbybusid(int busid) {
		
		List<Ticket> lst=tickres.FindTicketByBus(busid);
		if (lst!=null)
		{
			return lst;
		}
		else {
			return null;
		}
	}

	@Override
	public void addticket(Ticket tc) {
		tickres.save(tc);
	}

}
