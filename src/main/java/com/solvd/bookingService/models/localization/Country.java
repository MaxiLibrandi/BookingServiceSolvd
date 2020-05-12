package com.solvd.bookingService.models.localization;

public class Country {
	private Long id;
	private String name; 
	private Continent continent;
	
	public Country() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Continent getContinent() {
		return continent;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setContinent(Continent continent) {
		this.continent = continent;
	}
}
