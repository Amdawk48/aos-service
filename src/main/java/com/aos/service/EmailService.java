package com.aos.service;

import com.aos.dto.Email;

import jakarta.mail.MessagingException;

public interface EmailService {
	void sendSimpleEmail(String from, String[] to, String subject, String body);
	void sendSimpleEmail(Email email);
	void sendEmailWithAttachment(String from, String[] to, String subject, String body, String attachmentPath) throws MessagingException;
}
