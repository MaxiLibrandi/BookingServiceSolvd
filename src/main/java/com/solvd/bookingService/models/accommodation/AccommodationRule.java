package com.solvd.bookingService.models.accommodation;

import com.solvd.bookingService.models.information.Rule;

public class AccommodationRule {
	private Long id;
	private Rule rule;
	private Accommodation accommodation; 
	
	public AccommodationRule() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public Rule getRule() {
		return rule;
	}
	
	public Accommodation getAccommodation() {
		return accommodation;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setRule(Rule rule) {
		this.rule = rule;
	}
	
	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}
}
