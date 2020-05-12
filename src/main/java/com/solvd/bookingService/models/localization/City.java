package com.solvd.bookingService.models.localization;

public class City {
	private Long id;
	private String name;
	private Country country;

	public City() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
}
