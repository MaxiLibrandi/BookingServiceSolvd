package com.solvd.bookingService.models.accommodation;

public class Room {
	private Long id;
	private String description;
	private Long accommodationId;
	private Long roomTypeId; 
	
	public Room() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Long getAccommodationId() {
		return accommodationId;
	}
	
	public Long getRoomTypeId() {
		return roomTypeId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setAccommodationId(Long accommodationId) {
		this.accommodationId = accommodationId;
	}
	
	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	
	@Override
	public String toString() {
		return "Room id: " + this.id + " |accommodationId: " + this.accommodationId + " |roomTypeId: " + this.roomTypeId;
	}
}
