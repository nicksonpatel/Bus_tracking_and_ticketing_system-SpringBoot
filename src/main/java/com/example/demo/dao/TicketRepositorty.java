package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.model.Ticket;

public interface TicketRepositorty extends JpaRepository<Ticket, Integer>{

	@Query("SELECT t FROM Ticket t WHERE t.busid = :busid AND DATE_FORMAT(t.dateandtime,'%d-%m-%Y') >= DATE_FORMAT(current_date(),'%d-%m-%Y') ")
	public List<Ticket> FindTicketByBus(@Param("busid") int busid);


	@Query("SELECT t FROM Ticket t WHERE t.userid = :userid ")
	public List<Ticket> FindTicketByUser(@Param("userid") int userid);

}
