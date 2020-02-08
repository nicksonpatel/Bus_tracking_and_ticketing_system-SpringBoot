package com.example.demo.service;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BusDao;
import com.example.demo.dao.TicketDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Bus;
import com.example.demo.model.Ticket;
import com.example.demo.model.User;

@Service
public class BusServiceImpl implements BusService{
	
	@Autowired
	UserDao userdao;

	@Autowired
	BusDao busdao;
	
	@Autowired
	TicketDao ticketdao;
	
	@Autowired 
	SendOTPService otpservice;
	
	String otp;
	
	@Override
	public void sendotp(Integer busid,HttpSession ht) {
		Bus bus=busdao.getbus(busid);
		String mobile=bus.getBus_mobile();
		System.out.println("from database:"+mobile);
		Random rand = new Random();
		//otp= String.format("%04d%n", rand.nextInt(10000));
		otp=String.format("%04d", rand.nextInt(10000));
		System.out.println(otp);
		String otp2="Your OTP is :"+otp;
		otpservice.sendSms(mobile, otp2);
		//ht.setAttribute("otp", otp);
		//ht.setMaxInactiveInterval(20000);
		
	}
	
	@Override
	public Bus verifyotp(String otp1, int busid) {
		System.out.println("genrated saved otp:"+otp+"...");
		//String op=otp1.toString();
		System.out.println("for veryfiy:"+otp1+"...");
		//Integer ot=Integer.parseInt(otp);
		
		if(otp.equalsIgnoreCase(otp1)) 
		{
			System.out.println("correct otp");
			Bus b=busdao.getbus(busid);
			System.out.println(b);
			otp=null;
			return b;
		}
		else {
			System.out.println("otp wrong");
			otp=null;
			return null;
		}	
	}
		


	@Override
	public List<Bus> getbuslist(String source, String destination) {
		return busdao.getbuslist(source,destination);		
	}

	@Override
	public void addbus(Bus bus) {
		busdao.addbus(bus);
		
	}

	@Override
	public void deletebus(int busid) {
		busdao.deletebus(busid);
		
	}

	@Override
	public Ticket generateticket(int busid, String source, String destination, String mobile) {
		Date dt=new Date();
		SimpleDateFormat sdt=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dt1=sdt.format(dt);
		Ticket tc=new Ticket();
		try {
			Date dt2=sdt.parse(dt1);
			String tc2=getticketString();
			String ticket="Your Ticket ID :"+tc2+"\n DATE-TIME"+dt1;
			System.out.println(ticket);
			otpservice.sendSms(mobile, ticket);
			
			tc.setBusid(busid);
			tc.setDestination(destination);
			tc.setSource(source);
			tc.setTicketid(tc2);
			tc.setDateandtime(dt2);
			User u=userdao.getuserbymobile(mobile);
			System.out.println(u);
			if(u!=null) {
				tc.setUserid(u.getId());
			}
			ticketdao.addticket(tc);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tc;
	}
	
	protected String getticketString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";   //ticket string 
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

	@Override
	public List<Bus> getallbus() {
		return busdao.getallbus();
	}

	

	
	
}
