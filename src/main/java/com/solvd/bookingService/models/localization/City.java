package com.solvd.bookingService.models.localization;

import java.util.List;
import com.solvd.bookingService.models.accommodation.Accommodation;

public class City {
	private Long id;
	private String name;
	private Long countryId;
	private List<Accommodation> accommodations;

	public City() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Long getCountryId() {
		return countryId;
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
	
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	
	public void setAccommodations(List<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}
}
