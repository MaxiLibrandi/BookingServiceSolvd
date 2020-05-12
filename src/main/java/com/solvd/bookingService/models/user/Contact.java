package com.solvd.bookingService.models.user;

public class Contact {
	private Long id;
	private User user;
	private ContactSource contactSource;
	private String contactData;
	
	public Contact() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
	
	public ContactSource getContactSource() {
		return contactSource;
	}
	
	public String getContactData() {
		return contactData;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setContactSource(ContactSource contactSource) {
		this.contactSource = contactSource;
	}
	
	public void setContactData(String contactData) {
		this.contactData = contactData;
	}
}
