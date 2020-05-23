package com.solvd.bookingService.models.user;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.solvd.bookingService.jaxb.adapters.LocalDateAdapter;
import com.solvd.bookingService.models.accommodation.Accommodation;
import com.solvd.bookingService.models.reservation.Reservation;

@XmlRootElement(name = "user")
@XmlType(propOrder = {"name", "lastName", "birthDate"})
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

	@XmlAttribute
	public Long getId() {
		return id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	@XmlElement(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	@XmlElement(name = "birth_date")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	@XmlTransient
	public List<Contact> getContacts() {
		return contacts;
	}

	@XmlTransient
	public List<Reservation> getReservations() {
		return reservations;
	}

	@XmlTransient
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
	
	@Override
	public String toString() {
		return "User id: " + this.id + " |name: " + this.name + " |lastName: " + this.lastName + " |birthDate: " + this.birthDate;
	}
}
