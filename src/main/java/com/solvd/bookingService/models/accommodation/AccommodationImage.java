package com.solvd.bookingService.models.accommodation;

public class AccommodationImage {
	private Long id;
	private String path;
	private Long accommodationId; 
	
	public AccommodationImage() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getPath() {
		return path;
	}
	
	public Long getAccommodationId() {
		return accommodationId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void setAccommodationId(Long accommodationId) {
		this.accommodationId = accommodationId;
	}
}
