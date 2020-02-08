package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubsriptionDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Subscription;
import com.example.demo.model.User;

@Service
public class SubsriptionServiceImpl implements SubscriptionService{

	@Autowired
	SubsriptionDao subdao;
	
	@Autowired
	UserDao userdao;
	
	@Override
	public Subscription getsubscription(int user_id) {
		User u=userdao.getuaserbyid(user_id);
		Subscription s=u.getSubscription();
		System.out.println(u);		
		Date dt=s.getExpair();
		Date currentdate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String curdate=sdf.format(currentdate);
		try {
			Date dt2=sdf.parse(curdate);
			System.out.println("-----"+dt+"----"+currentdate);
			if(dt.before(currentdate))
			{
				subdao.deletesub(s);
				s=null;
			}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return s;
	}

	protected String getsubString() {
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
	public Subscription buyService(int id, int pack) {
		System.out.println("----------------"+id+pack);
		String sub=getsubString();
		User u=userdao.getuaserbyid(id);
		String subid=u.getMobile()+sub;
		Date expdate=getsubdate(pack);
		Subscription sb=new Subscription();
		sb.setExpair(expdate);
		sb.setSubsribation(subid);
		u.setSubscription(sb);
		System.out.println("*****+++++"+sb);
		return userdao.buysub(u);
	//	return null;
	}
	
	protected Date getsubdate(int pack) {
		Date current=new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(current);
		//System.out.println(current);
		if (pack==200) {
			cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+1));
			current = cal.getTime();
			
		}else if(pack==350){
			cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+2));
			current = cal.getTime();
			
		}else if(pack==500) {
			cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
			current = cal.getTime();
		}else {
			return null;
		}
		return current;
	}

	@Override
	public User checksub(String data) {
		Subscription S=new Subscription();
		User u=new User();
		S=subdao.checksub(data);
		if(S!=null) {
			u=userdao.getuserbysubscribtion(S);
		}else {
			u=null;
		}
		return u;
	}
	
}
