package com.example.demo.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "user_id")
	  private int id;
	  private String userName;
	  private String dob;
	  //private Date dob; 
	  private String gender;
	  private String mobile;
	  private String adharNo;
	  private String email;
	  private String psw;
	  
	  @OneToMany(cascade=CascadeType.ALL)
	  @JoinColumn(name="user_id",referencedColumnName="user_id")
	  private List<Ticket> tickets;
	  	  
	  @OneToOne(cascade=CascadeType.ALL)
	  @JoinColumn(name="sub_id",referencedColumnName="subid")
	  Subscription subscription;
	  
		public Subscription getSubscription() {
		return subscription;
	}


	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}


		public List<Ticket> getTickets() {
			return tickets;
		}

	
	public User(String userName, String dob, String gender, String mobile, String adharNo, String email, String psw) {
		super();
		this.userName = userName;
		this.dob = dob;
		this.gender = gender;
		this.mobile = mobile;
		this.adharNo = adharNo;
		this.email = email;
		this.psw = psw;
	}


	public User() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getAdharNo() {
		return adharNo;
	}


	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPsw() {
		return psw;
	}


	public void setPsw(String psw) {
		this.psw = psw;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", dob=" + dob + ", gender=" + gender + ", mobile="
				+ mobile + ", adharNo=" + adharNo + ", email=" + email + ", psw=" + psw + ", tickets=" + tickets
				+ ", subscription=" + subscription + "]";
	}


	

}
