package com.solvd.bookingService.models.localization;

import java.util.List;

public class Country {
	private Long id;
	private String name; 
	private Long continentId;
	private List<City> cities;
	
	public Country() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Long getContinentId() {
		return continentId;
	}
	
	public List<City> getCities() {
		return cities;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setContinentId(Long continentId) {
		this.continentId = continentId;
	}
	
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	@Override
	public String toString() {
		return "Country id: " + this.id + " |name: " + this.name + " |continentId: " + this.continentId;
	}
}
