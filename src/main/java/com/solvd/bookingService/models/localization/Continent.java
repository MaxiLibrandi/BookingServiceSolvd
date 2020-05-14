package com.solvd.bookingService.models.localization;

import java.util.List;

public class Continent {
	private Long id;
	private String name;
	private List<Country> countries;
	
	public Continent() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Country> getCountries() {
		return countries;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
}
