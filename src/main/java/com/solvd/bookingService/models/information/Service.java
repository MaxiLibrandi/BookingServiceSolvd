package com.solvd.bookingService.models.information;

import java.util.List;

import com.solvd.bookingService.models.accommodation.AccommodationService;

public class Service {
	private Long id;
	private String description; 
	private List<AccommodationService> accommodationServices;
	
	public Service() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public List<AccommodationService> getAccommodationServices() {
		return accommodationServices;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setAccommodationServices(List<AccommodationService> accommodationServices) {
		this.accommodationServices = accommodationServices;
	}
}
