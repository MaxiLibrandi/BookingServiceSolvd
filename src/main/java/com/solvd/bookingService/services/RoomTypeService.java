package com.solvd.bookingService.services;

import com.solvd.bookingService.dao.mySqlImpl.RoomDAO;
import com.solvd.bookingService.dao.mySqlImpl.RoomTypeDAO;
import com.solvd.bookingService.models.information.RoomType;

public class RoomTypeService {
	
	private RoomTypeDAO roomTypeDAO;
	private RoomDAO roomDAO;
	
	public RoomType getRoomTypeById(Long id) {
		roomTypeDAO = new RoomTypeDAO();
		RoomType rt = roomTypeDAO.getEntityById(id);
		roomDAO = new RoomDAO();
		rt.setRooms(roomDAO.getRoomsByRoomTypeId(id));
		return rt;
	}
}
