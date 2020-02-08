package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Bus {

	
		  @Id
		  @GeneratedValue(strategy=GenerationType.AUTO)
		  private int bus_id;
		  private String bus_num;
		  private String bus_numberPalte;
		  private int bus_capacity ;
		  private String bus_password;
		  private String bus_mobile;
		  
		
		  @JsonBackReference
		  @ManyToMany(cascade=CascadeType.ALL)
		  private List<Route> routes=new ArrayList<>();
		  
		  public String getBus_mobile() {
				return bus_mobile;
			}
		  public void setBus_mobile(String bus_mobile) {
				this.bus_mobile = bus_mobile;
			}  
		
		 
		
		public void setBus_password(String bus_password) {
			this.bus_password = bus_password;
		}
		//Default Constructor
		  public Bus() {
			super();
		}
		//Parameterize Constructor
		
		//SeterGeter methods
		public int getBus_id() {
			return bus_id;
		}
		public void setBus_id(int bus_id) {
			this.bus_id = bus_id;
		}
		public String getBus_num() {
			return bus_num;
		}
		public void setBus_num(String bus_num) {
			this.bus_num = bus_num;
		}
		public String getBus_numberPalte() {
			return bus_numberPalte;
		}
		public void setBus_numberPalte(String bus_numberPalte) {
			this.bus_numberPalte = bus_numberPalte;
		}
		public int getBus_capacity() {
			return bus_capacity;
		}
		public void setBus_capacity(int bus_capacity) {
			this.bus_capacity = bus_capacity;
		}
	
		public String getBus_password() {
			return bus_password;
		}
		public List<Route> getRoutes() {
			return routes;
		}
		public void setRoutes(List<Route> routes) {
			this.routes = routes;
		}
		@Override
		public String toString() {
			return "Bus [bus_id=" + bus_id + ", bus_num=" + bus_num + ", bus_numberPalte=" + bus_numberPalte
					+ ", bus_capacity=" + bus_capacity + ", bus_password=" + bus_password + ", bus_mobile=" + bus_mobile
					+ ", routes=" + routes + "]";
		}
}
