package com.aos.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Value("${mail.smtp.host}")
	String host;
	
	@Value("${mail.smtp.port}")
	String port;
	
	@Value("${mail.smtp.user.email}")
	public String userEmail;
	
	@Value("${mail.smtp.password}")
	String password;
	
	@Value("${mail.smtp.auth}")
	String auth;
	
	@Value("${mail.smtp.starttls.enable}")
	String startTlsEnabled;
	
	@Value("${mail.smtp.ssl.trust}")
	String sslTrust;
	
    @Bean
    public JavaMailSender javaMailSender() {
    	
    	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    	mailSender.setHost(host); 
        mailSender.setPort(Integer.parseInt(port)); 
        mailSender.setUsername(userEmail);
        mailSender.setPassword(password); 
        mailSender.setJavaMailProperties(getGmailProperties());
        return mailSender;
        
    }	
    
    private Properties getGmailProperties() {
    	Properties props = new Properties();
    	props.put("mail.smtp.auth", auth);
    	props.put("mail.smtp.starttls.enable", startTlsEnabled);
    	props.put("mail.smtp.ssl.trust", sslTrust);
    	return props;
    }
	
}
