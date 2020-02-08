package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Route;

@Repository
public class RouteDaoImpl implements RouteDao {
	@Autowired
	RouteRepository routeRepository;
	@Override
	public List<Route> findAllRoute() {
		List<Route> lst=routeRepository.findAll();
		return lst;
	}
//	@Override
//	public List<Route> getbuslist(String source, String destination) {
//		List<Route> lst=routeRepository.FindALLBuses(source,destination);
//		System.out.println("last"+lst);
//		return lst;
//	}
	

}
