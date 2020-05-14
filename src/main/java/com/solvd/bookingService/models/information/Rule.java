package com.solvd.bookingService.models.information;

import java.util.List;

import com.solvd.bookingService.models.accommodation.AccommodationRule;

public class Rule {
	private Long id;
	private String description;
	private List<AccommodationRule> accommodationRules;
	
	public Rule() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public List<AccommodationRule> getAccommodationRules() {
		return accommodationRules;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setAccommodationRules(List<AccommodationRule> accommodationRules) {
		this.accommodationRules = accommodationRules;
	}
}
