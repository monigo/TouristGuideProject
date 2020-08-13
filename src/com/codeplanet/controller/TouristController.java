package com.codeplanet.controller;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeplanet.dao.TouristDao;
import com.codeplanet.model.Booking;
import com.codeplanet.service.TouristService;

@Controller
public class TouristController {
@Autowired
TouristService touristService;
	@RequestMapping(value="/check_free_slots")
	public String test(HttpServletRequest req ) {
		String day = req.getParameter("day");
		String email = req.getParameter("email");
		
		Date date = new Date(System.currentTimeMillis());
		LocalDate localDate = date.toLocalDate();
		LocalDate localDate1 = localDate;
		
		if(day.equalsIgnoreCase("Today")) {
			
		}
		else if(day.equalsIgnoreCase("tmrw")) {
			localDate1  = localDate.plusDays(1);
		}
		else if(day.equalsIgnoreCase("tmrww")) {
			localDate1  = localDate.plusDays(2);
		}
		day = localDate1.toString() ;
		
		
		//session to store
		HttpSession sess1=req.getSession(false);  
	    sess1.setAttribute("date",day);  
	    
		System.out.println(day+email);
		
		List<String> slots = new ArrayList<>();
		slots = touristService.getGuideFreeslots(day,email);
//		StringBuilder sb = new StringBuilder();
//		for(int i=0;i<slots.size();i++) {
//			sb.append(slots.get(i));
//			sb.append(System.getProperty("line.separator"));
//		}
//		System.out.println(sb.toString());
//      req.setAttribute("slts", sb.toString());
		req.setAttribute("slts", slots);
		return "ShowGuideSlots";
	}
	@RequestMapping("handle_booking_and_mail")
	public String handlebooking(HttpServletRequest req) throws AddressException, MessagingException {
		
		// session to store
		HttpSession sess1=req.getSession(false);  
		
	    String slot = (String)req.getParameter("choosenslot"); 
	    String msg_from_tourist = req.getParameter("msg_to_guide"); 
	    
	    String guideEmail = (String) sess1.getAttribute("guideEmail");
	    String touristEmail = (String)sess1.getAttribute("userEmail");
	    String date = (String)sess1.getAttribute("date");

	    //System.out.println(guideEmail+touristEmail+date+slot+msg_from_tourist);
	    
	    if(touristService.mapTouristToGudie(guideEmail , touristEmail , date , slot)) {
	    	//send Email
	    	 SendEmail se = new SendEmail();
	 	     se.sendEmail(guideEmail , touristEmail , msg_from_tourist , date , slot);
	 	     req.setAttribute("date", date);
	 	     req.setAttribute("slot", slot); 
	 		 return  "Confirm";
	    }
	    else {
	    	return "ShowGuideSlots";
	    }
	    
	    //return  "Confirm";
	
	   
	   
	}
	@RequestMapping("req_accepted")
	public String handleReqAc(HttpServletRequest req ,Booking booking) throws AddressException, MessagingException  {
		
		if(touristService.deleteFromToBeMapped(booking)) {
			if(touristService.insertIntoMapped(booking)) {
				System.out.println("Mapped final successfully");
				SendEmail em = new SendEmail();
				em.sendEmail(booking.getTouristEmail(), booking.getGuideEmail(), "Your request is accepted", booking.getDate(), booking.getSlot());
			
			}
		}
		else {
			
		}
		return "GuideDisplay";
	   
	}
	@RequestMapping("req_declined")
	public String handleReqDec(HttpServletRequest req ,Booking booking) throws AddressException, MessagingException  {
		
		if(touristService.deleteFromToBeMapped(booking)) {
			System.out.println("declined");
			SendEmail em = new SendEmail();
			em.sendEmail(booking.getTouristEmail(), booking.getGuideEmail(), "Your request is accepted", booking.getDate(), booking.getSlot());
		
		}
		else {
			
		}
		return "GuideDisplay";
	   
	}
	
	
}
