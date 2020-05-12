package com.solvd.bookingService.models.accommodation;

import com.solvd.bookingService.models.information.RoomType;

public class Room {
	private Long id;
	private String description;
	private Accommodation accommodation;
	private RoomType roomType; 
	
	public Room() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Accommodation getAccommodation() {
		return accommodation;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}
	
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
}
