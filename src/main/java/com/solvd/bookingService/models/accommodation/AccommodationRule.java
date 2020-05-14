package com.solvd.bookingService.models.accommodation;

public class AccommodationRule {
	private Long id;
	private Long ruleId;
	private Long accommodationId; 
	
	public AccommodationRule() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getRuleId() {
		return ruleId;
	}
	
	public Long getAccommodationId() {
		return accommodationId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
	
	public void setAccommodationId(Long accommodationId) {
		this.accommodationId = accommodationId;
	}
}
