package com.solvd.bookingService.models.information;

public class RoomType {
	private Long id;
	private String type;
	
	public RoomType() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
