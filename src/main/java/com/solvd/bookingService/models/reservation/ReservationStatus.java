package com.solvd.bookingService.models.reservation;

import java.util.List;

public class ReservationStatus {
	private Long id;
	private String status;
	private List<Reservation> reservations;
	
	public ReservationStatus() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	@Override
	public String toString() {
		return "ReservationStatus id: " + this.id + " |status: " + this.status;
	}
}
