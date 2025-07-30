package com.aos.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.aos.dto.Email;
import com.aos.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImplementation implements EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	// TODO: 
	//	Create basic email and send to myself
	//  Refactor implementation to build email from request and send through this service
	public void sendSimpleEmail(String from, String[] to, String subject, String body) {
		// Setup Email
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		
		mailSender.send(message);
		
	}
	
	public void sendSimpleEmail(Email email) {
		// Setup Email
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(email.getFrom());
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getBody());
		
		// Send Email
		System.out.println("Sending email");
		mailSender.send(message);
		
	}
	
	public void sendEmailWithAttachment(String from, String[] to, String subject, String body, String attachmentPath) throws MessagingException {
	    try {
	    	MimeMessage message = mailSender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(message, true); // true for multipart
	
		    helper.setFrom(from);
		    helper.setTo(to);
		    helper.setSubject(subject);
		    helper.setText(body, true); // true for HTML content
	
		    FileSystemResource file = new FileSystemResource(new File(attachmentPath));
		    helper.addAttachment(file.getFilename(), file);
	
		    mailSender.send(message);
	    } catch (MessagingException msgEx) {
	    	
	    }
		
	}
	
}
