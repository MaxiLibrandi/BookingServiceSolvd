package com.solvd.bookingService.models.accommodation;

import com.solvd.bookingService.models.information.Service;

public class AccommodationService {
	private Long id;
	private Service service;
	private Accommodation accommodation;
	
	public AccommodationService() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public Service getService() {
		return service;
	}
	
	public Accommodation getAccommodation() {
		return accommodation;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setService(Service service) {
		this.service = service;
	}
	
	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}
}
