package com.solvd.bookingService.models.user;

import java.time.LocalDate;
import java.util.List;

import com.solvd.bookingService.models.accommodation.Accommodation;
import com.solvd.bookingService.models.reservation.Reservation;

public class User {
	private Long id;
	private String name;
	private String lastName;
	private LocalDate birthDate;
	private List<Contact> contacts;
	private List<Reservation> reservations;
	private List<Accommodation> accommodations;
	
	
	public User() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public List<Accommodation> getAccommodations() {
		return accommodations;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void setAccommodations(List<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}
}
