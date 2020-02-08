package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Destination {

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private int destId;
	  private String standName;
	  private String standLatitude;
	  private String standLangitude ; 
	  private String time;
	  
	  
	  @JsonManagedReference
	  @ManyToMany(cascade=CascadeType.ALL,mappedBy="deslist")
	  private List<Route> routes=new ArrayList<>();

	  
	  
	  public Destination() {
		  super();
	  }
	  


	
	  //Parameterize Constructor
	  
	  
	  //SeterGeter methods

		public int getDestId() {
			return destId;
		}


		public void setDestId(int destId) {
			this.destId = destId;
		}


	


		public String getStandName() {
			return standName;
		}


		public void setStandName(String standName) {
			this.standName = standName;
		}


		public String getStandLatitude() {
			return standLatitude;
		}


		public void setStandLatitude(String standLatitude) {
			this.standLatitude = standLatitude;
		}


		public String getStandLangitude() {
			return standLangitude;
		}


		public void setStandLangitude(String standLangitude) {
			this.standLangitude = standLangitude;
		}


		public String getTime() {
			return time;
		}


		public void setTime(String time) {
			this.time = time;
		}

		public List<Route> getRoutes() {
			return routes;
		}

		public void setRoutes(List<Route> routes) {
			this.routes = routes;
		}




	
		  
}
