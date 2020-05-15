package com.solvd.bookingService.dao;

import java.util.List;

import com.solvd.bookingService.models.accommodation.Room;

public interface IRoomDAO extends IEntityDAO<Room>{

	public List<Room> getRoomsByRoomTypeId(Long roomTypeId);
}
