package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BusRepository;
import com.example.demo.dao.DestinationRepository;
import com.example.demo.dao.SubsribtionRepository;
import com.example.demo.dao.UserRepositoryJPA;
import com.example.demo.model.Bus;
import com.example.demo.model.Destination;
import com.example.demo.model.Subscription;
import com.example.demo.model.Ticket;
import com.example.demo.model.User;
import com.example.demo.service.BusService;
import com.example.demo.service.DestinationService;
import com.example.demo.service.SubscriptionService;
import com.example.demo.service.TicketService;
import com.example.demo.service.UserService;

@RestController 
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class MyController {
	
	@Autowired
	UserService user_service;
	
	@Autowired
	TicketService ticket_service;
	
	@Autowired
	DestinationService destination_sevice;
	
	@Autowired
	BusService bus_service;
	
	@Autowired
	SubscriptionService Sub_service;
	
	@Autowired
	BusRepository busres;
	
	@Autowired
	DestinationRepository des;
	
	@PostMapping("/api/register")
	public ResponseEntity<?> RegisterUser(@RequestBody User user) {
		System.out.println("here in register controller"+user );
		user_service.registeruser(user);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/api/login")
	public ResponseEntity<User> Login(@RequestBody Map<String, Object> user){
		String mobile=(String) user.get("mob");
		String pass=(String) user.get("pass");
		User u=user_service.checkuser(mobile,pass);
		 return ResponseEntity.ok().body(u);	
	}
	
	

	@PostMapping("/api/otprequest")
	public Bus sendotp(@RequestBody Integer busid,HttpSession ht){
		bus_service.sendotp(busid,ht);
		System.out.println(busid);
		return null;
	}
	
	@PostMapping("/api/verifyotp")
	public ResponseEntity<Bus> verifyotp(@RequestBody Map<String,Object> bus){
		String otp=bus.get("otp").toString();
		int busid=Integer.parseInt(bus.get("busid").toString());
		System.out.println(otp+"ef"+busid);
		Bus b=bus_service.verifyotp(otp,busid);
		return ResponseEntity.ok().body(b);
		//return null;
	}
	
	@PostMapping("/api/addbus")
	public ResponseEntity<?> addbus(@RequestBody Bus bus){
		System.out.println("----------"+bus);
		bus_service.addbus(bus);
		return ResponseEntity.ok().body("added");
	}
	
	
	@PostMapping("/api/adddestination")
	public ResponseEntity<?> addrout(@RequestBody Destination destination){
		destination_sevice.add(destination);
		return ResponseEntity.ok().body("added");
	}
	
	@PostMapping("/api/deleteuser")
	public ResponseEntity<?> deleteuser(@RequestBody Map<String,Object> user){
		int userid=(int) user.get("userid");
		user_service.deleteUser(userid);
		return ResponseEntity.ok().body("deleted");
	}
		
	@PostMapping("/api/deleteBus")
	public ResponseEntity<?> deleteBus(@RequestBody Map<String,Object> bus){
		int busid=(int) bus.get("busid");
		bus_service.deletebus(busid);
		return ResponseEntity.ok().body("deletd");
	}
	
	
	@PostMapping("/api/deleteDestination")
	public ResponseEntity<?> deleteDestination(@RequestBody Map<String,Object> destination){
		int destid=(int) destination.get("destid");
		destination_sevice.deleteDestination(destid);
		return ResponseEntity.ok().body("deleted");
	}
	
	@PostMapping("api/bus/ticketgenrate")
	public ResponseEntity<?> ticketgenrate(@RequestBody Map<String,Object> ticket){
		int busid=(int)ticket.get("busid");
		String source=(String)ticket.get("source");
		String destination= (String) ticket.get("destination");
		String mobile=(String)ticket.get("mobile");
		System.out.println(busid+source+destination+mobile);
		Ticket ts=bus_service.generateticket(busid,source,destination,mobile);
		return ResponseEntity.ok().body(ts);
	}
	
	
	@GetMapping("api/user/getsubsription/{user_id}")
	public ResponseEntity<?> getsubscription(@PathVariable int user_id){
		System.out.println("user id :--"+user_id);
		Subscription sb=Sub_service.getsubscription(user_id);
		System.err.println(sb);
		return ResponseEntity.ok().body(sb);
		
	}
	
	@PostMapping("api/user/buysub")
	public ResponseEntity<?> buysubscription(@RequestBody Map<String,Object> obj){
		int id=Integer.parseInt(obj.get("id").toString());
		int pack=Integer.parseInt(obj.get("pack").toString());
		System.out.println("-----------"+id+pack);
		Subscription s=Sub_service.buyService(id,pack);	
		return ResponseEntity.ok().body(s);
	}
	
	@GetMapping("api/subscription/checksubsription/{data}")
	public ResponseEntity<?> cheaksub(@PathVariable("data") String data){
		User u=Sub_service.checksub(data);
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping("/api/getlist/{source}/{destination}")
	public ResponseEntity<?> getbuss(@PathVariable("source") String source,@PathVariable("destination") String destination){
		/*String source=(String) bus.get("source");
		String destination=(String) bus.get("desination");*/
		List<Destination> blist=destination_sevice.getbuslist(source,destination);
		System.out.println(source+" + "+destination);
		System.out.println("hii"+blist);
		return ResponseEntity.ok().body(blist);
		//return null;
	}
	
	@GetMapping("/api/getalltickets/{userid}")
	public List<Ticket> gettickets(@PathVariable("userid") Integer userid){
		System.out.println(userid);
		List<Ticket> tList= ticket_service.getallticket(userid);
		return tList;
	}

	
	@GetMapping("/api/getallticketsbyBusid/{busid}")
	public List<Ticket> getallticketbybusid(@PathVariable("busid") Integer busid){
		//System.out.println(busid);
		List<Ticket> tlist= ticket_service.getallticketsbyBusid(busid);
		//System.out.println(tlist);
		return tlist;
	}
	
	
	
	
	@GetMapping("/api/getallbus")
	public ResponseEntity<?> getallbus(){
		List<Bus> lb=bus_service.getallbus();
		System.out.println(lb);
		return ResponseEntity.ok().body(lb);
	}
	
	@GetMapping("/api/getalluser")
	public ResponseEntity<?> getalluser(){
		List<User> user=user_service.getalluser();
		return ResponseEntity.ok().body(user);
	}
	
		

	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/api/test")
	public ResponseEntity<?> testdata(){
		
		return ResponseEntity.ok().body(null);
		
	}

}
