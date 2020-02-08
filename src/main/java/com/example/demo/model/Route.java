package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Route {

	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private int route_id;
	  private String route_name;
	  
	  @JsonManagedReference
	  @ManyToMany(cascade=CascadeType.ALL,mappedBy="routes")
	  private List<Bus> buses=new ArrayList<>();
	  
	  @JsonBackReference
	  @ManyToMany(cascade=CascadeType.ALL)
	  private List<Destination> deslist=new ArrayList<>();

	public Route() {
		super();
	}

	public int getRoute_id() {
		return route_id;
	}

	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}

	public String getRoute_name() {
		return route_name;
	}

	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public List<Destination> getDeslist() {
		return deslist;
	}

	public void setDeslist(List<Destination> deslist) {
		this.deslist = deslist;
	}

	
	  
}
