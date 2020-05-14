package com.solvd.bookingService.models.accommodation;

public class AccommodationService {
	private Long id;
	private Long serviceId;
	private Long accommodationId;
	
	public AccommodationService() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getServiceId() {
		return serviceId;
	}
	
	public Long getAccommodationId() {
		return accommodationId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
	public void setAccommodationId(Long accommodationId) {
		this.accommodationId = accommodationId;
	}
}
