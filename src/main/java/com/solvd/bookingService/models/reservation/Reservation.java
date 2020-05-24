package com.solvd.bookingService.models.reservation;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.solvd.bookingService.jaxb.adapters.LocalDateAdapter;

@XmlRootElement(name = "reservation")
@XmlType(propOrder = {"guestId", "accommodationId", "dateFrom", "dateTo", "price", "reservationStatusId", "rating"})
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

	@XmlAttribute
	public Long getId() {
		return id;
	}

	@XmlElement(name = "guest_id")
	public Long getGuestId() {
		return guestId;
	}

	@XmlElement(name = "accommodation_id")
	public Long getAccommodationId() {
		return accommodationId;
	}
	
	@XmlElement(name = "date_from")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDateFrom() {
		return dateFrom;
	}
	
	@XmlElement(name = "date_to")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDateTo() {
		return dateTo;
	}

	@XmlElement
	public Float getPrice() {
		return price;
	}

	@XmlElement(name = "reservation_status_id")
	public Long getReservationStatusId() {
		return reservationStatusId;
	}

	@XmlElement
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
	
	@Override
	public String toString() {
		return "Reservation id: " + this.id + " |guestId: " + this.guestId + " |accommodationId: " + this.accommodationId + " |dateFrom: " + this.dateFrom + " |dateTo: " + this.dateTo + " |price:" + this.price + " |reservationStatusId: " + this.reservationStatusId + " |rating: " + this.rating;
	}
}
