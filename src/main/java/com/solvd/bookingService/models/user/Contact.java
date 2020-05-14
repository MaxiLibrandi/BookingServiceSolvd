package com.solvd.bookingService.models.user;

public class Contact {
	private Long id;
	private Long userId;
	private Long contactSourceId;
	private String contactData;
	
	public Contact() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public Long getContactSourceId() {
		return contactSourceId;
	}
	
	public String getContactData() {
		return contactData;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public void setContactSourceId(Long contactSourceId) {
		this.contactSourceId = contactSourceId;
	}
	
	public void setContactData(String contactData) {
		this.contactData = contactData;
	}
}
