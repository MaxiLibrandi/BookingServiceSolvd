package com.solvd.bookingService.models.user;

public class ContactSource {
	private Long id;
	private String source; 
	
	public ContactSource() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
}
