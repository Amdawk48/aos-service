package com.aos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aos.dto.Email;
import com.aos.service.EmailService;

@RestController
@RequestMapping
public class EmailController {
	
	@Autowired
	EmailService emailService;

	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody Email email){
		emailService.sendSimpleEmail(email);
		return new ResponseEntity<>("Email Sent Successfully", HttpStatus.OK);
	}
}
