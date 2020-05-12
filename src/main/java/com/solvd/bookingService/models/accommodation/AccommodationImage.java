package com.solvd.bookingService.models.accommodation;

public class AccommodationImage {
	private Long id;
	private String path;
	private Accommodation accommodation; 
	
	public AccommodationImage() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getPath() {
		return path;
	}
	
	public Accommodation getAccommodation() {
		return accommodation;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}
}
