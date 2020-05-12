package com.solvd.bookingService.models.reservation;

public class ReservationStatus {
	private Long id;
	private String status;
	
	public ReservationStatus() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
