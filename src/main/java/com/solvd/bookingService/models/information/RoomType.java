package com.solvd.bookingService.models.information;

import java.util.List;

import com.solvd.bookingService.models.accommodation.Room;

public class RoomType {
	private Long id;
	private String type;
	private List<Room> rooms;
	
	public RoomType() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	@Override
	public String toString() {
		return "RoomType id: " + this.id + " |type: " + this.type;
	}
}
