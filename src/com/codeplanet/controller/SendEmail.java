package com.codeplanet.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/*
 * 
 * important to note that email will only be send if 1. antivirus shield is off
 * 2. sender email and password is correct 
 * 3. here sender and receiver are fixed neerajkumar25499@gmail.com and 2017ucp1605@mnit.ac.in respectively
 * because here tourist and guide email are dummy
 * 
 * 
 * */
public class SendEmail {
	public void sendEmail(String toEmail , String fromEmail , String msgbody , String Date , String Slot)throws AddressException, MessagingException {
		Properties p= new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.EnableSSL.enable", "true");
		p.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.socketFactory.port", "465");
		
		Session session=Session.getInstance(p, new SimpleAuthenticator("neerajkumar25499@gmail.com","Gmail1password"));
		Message msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress("neerajkumar25499@gmail.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("2017ucp1605@mnit.ac.in"));//toEmail
		msg.setSubject("Tour Request");
		msg.setContent(msgbody+"\nTourist Email is :"+fromEmail+"\nOn Date"+Date+"\nFor Slot "+Slot, "text/html");	
		Transport.send(msg);
	}
}
