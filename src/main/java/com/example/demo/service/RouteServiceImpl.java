package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RouteDao;
import com.example.demo.model.Bus;
import com.example.demo.model.Route;

@Service
public class RouteServiceImpl implements RouteService {
	@Autowired
	RouteDao routeDao;

	@Override
	public List<Route> findAllRoute() {
		List<Route> lst=routeDao.findAllRoute();
		return lst;
	}

//	@Override
//	public List<Route> getbuslist(String source, String destination) {
//		List<Route> lst=routeDao.getbuslist(source,destination);
//		return lst;
//	}

}
