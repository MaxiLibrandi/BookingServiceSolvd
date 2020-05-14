package com.solvd.bookingService.models.reservation;

import java.time.LocalDate;

public class Reservation {
	private Long id;
	private Long guestId; 
	private Long accommodationId; 
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private Float price;
	private Long reservationStatusId;
	private Integer rating;
	
	public Reservation() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getGuestId() {
		return guestId;
	}
	
	public Long getAccommodationId() {
		return accommodationId;
	}
	
	public LocalDate getDateFrom() {
		return dateFrom;
	}
	
	public LocalDate getDateTo() {
		return dateTo;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public Long getReservationStatusId() {
		return reservationStatusId;
	}
	
	public Integer getRating() {
		return rating;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}
	
	public void setAccommodationId(Long accommodationId) {
		this.accommodationId = accommodationId;
	}
	
	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public void setReservationStatusId(Long reservationStatusId) {
		this.reservationStatusId = reservationStatusId;
	}
	
	public void setRating(Integer rating) {
		this.rating = rating;
	}
}
