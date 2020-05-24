package com.solvd.bookingService.models.accommodation;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.solvd.bookingService.models.reservation.Reservation;

@XmlRootElement(name = "accommodation")
@XmlType(propOrder = {"hostId", "direction", "description", "maxCapacity", "cityId"})
public class Accommodation {
	private Long id; 
	private Long hostId;
	private String direction; 
	private String description; 
	private Integer maxCapacity;
	private Long cityId; 
	private List<AccommodationRule> accommodationRules;
	private List<AccommodationService> accommodationServices;
	private List<AccommodationImage> accommodationImages;
	private List<Room> rooms;
	private List<Reservation> reservations; 
	
	public Accommodation() {
		
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
	@XmlElement(name = "host_id")
	public Long getHostId() {
		return hostId;
	}

	@XmlElement
	public String getDirection() {
		return direction;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	@XmlElement(name = "max_capacity")
	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	@XmlElement(name = "city_id")
	public Long getCityId() {
		return cityId;
	}
	
	@XmlTransient
	public List<AccommodationImage> getAccommodationImages() {
		return accommodationImages;
	}

	@XmlTransient
	public List<AccommodationRule> getAccommodationRules() {
		return accommodationRules;
	}

	@XmlTransient
	public List<AccommodationService> getAccommodationServices() {
		return accommodationServices;
	}

	@XmlTransient
	public List<Reservation> getReservations() {
		return reservations;
	}

	@XmlTransient
	public List<Room> getRooms() {
		return rooms;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setHostId(Long hostId) {
		this.hostId = hostId;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	
	public void setAccommodationImages(List<AccommodationImage> accommodationImages) {
		this.accommodationImages = accommodationImages;
	}
	
	public void setAccommodationRules(List<AccommodationRule> accommodationRules) {
		this.accommodationRules = accommodationRules;
	}
	
	public void setAccommodationServices(List<AccommodationService> accommodationServices) {
		this.accommodationServices = accommodationServices;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	@Override
	public String toString() {
		return "Accommodation id: " + this.id + " |hostId: " + this.hostId + " |direction: " + this.direction + " |description: " + this.description + " |maxCapacity: " + this.maxCapacity + " |cityId: " + this.cityId;
	}
}
