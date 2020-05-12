package com.solvd.bookingService.models.information;

public class Service {
	private Long id;
	private String description; 
	
	public Service() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
