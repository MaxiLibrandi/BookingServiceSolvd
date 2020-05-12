package com.solvd.bookingService.models.accommodation;

import com.solvd.bookingService.models.localization.City;
import com.solvd.bookingService.models.user.User;

public class Accommodation {
	private Long id; 
	private User host;
	private String direction; 
	private String description; 
	private Integer maxCapacity;
	private City city; 
	
	public Accommodation() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public User getHost() {
		return host;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public String getDescription() {
		return description;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	
	public City getCity() {
		return city;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setHost(User host) {
		this.host = host;
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
	
	public void setCity(City city) {
		this.city = city;
	}
}
