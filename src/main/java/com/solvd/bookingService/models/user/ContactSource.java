package com.solvd.bookingService.models.user;

import java.util.List;

public class ContactSource {
	private Long id;
	private String source;
	private List<Contact> contacts;
	
	public ContactSource() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getSource() {
		return source;
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}
