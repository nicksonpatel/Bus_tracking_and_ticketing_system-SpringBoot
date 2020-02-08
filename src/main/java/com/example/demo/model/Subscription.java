package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Subscription {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="subid")
	int id;
	String subsribation;
	
	Date expair;
	

	public Subscription() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubsribation() {
		return subsribation;
	}

	public void setSubsribation(String subsribation) {
		this.subsribation = subsribation;
	}

	public Date getExpair() {
		return expair;
	}

	public void setExpair(Date expair) {
		this.expair = expair;
	}


	

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", subsribation=" + subsribation + ", expair=" + expair + "]";
	}
	
	
}
