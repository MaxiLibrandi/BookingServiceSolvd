package com.solvd.bookingService.models.user;

public class ContactSource {
	private Long id;
	private String name; 
	
	public ContactSource() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
