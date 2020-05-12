package com.solvd.bookingService.models.reservation;

import java.time.LocalDate;

import com.solvd.bookingService.models.accommodation.Accommodation;
import com.solvd.bookingService.models.user.User;

public class Reservation {
	private Long id;
	private User guest; 
	private Accommodation accommodation; 
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private Float price;
	private ReservationStatus reservationStatus;
	private Integer rating;
	
	public Reservation() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public User getGuest() {
		return guest;
	}
	
	public Accommodation getAccommodation() {
		return accommodation;
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
	
	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}
	
	public Integer getRating() {
		return rating;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setGuest(User guest) {
		this.guest = guest;
	}
	
	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
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
	
	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	
	public void setRating(Integer rating) {
		this.rating = rating;
	}
}
