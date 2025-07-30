package com.aos.dto;

public class Email {

	private String[] to;
	private String from;
	private String subject;
	private String body;
	
	Email(){}
	
	Email(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.subject = builder.subject;
        this.body = builder.body;
    }
	
	public String[] getTo() {
		return to;
	}
	
	public void setTo(String[] to) {
		this.to = to;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	 
	public static class Builder {
		
		private String from;
		private String[] to;
		private String subject;
		private String body;
		
		public Builder to(String[] to) {
			this.to = to;
			return this;
		}
		
		public Builder from(String from) {
			this.from = from;
			return this;
		}
		
		public Builder subject(String subject) {
			this.subject = subject;
			return this;
		}
		
		public Builder body(String body) {
			this.body = body;
			return this;
		}
		
		public Email build(String body) {
			return new Email(this);
		}
		
		
	}
}
