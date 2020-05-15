package com.solvd.bookingService.services;

import java.util.List;

import com.solvd.bookingService.dao.mySqlImpl.RoomDAO;
import com.solvd.bookingService.dao.mySqlImpl.RoomTypeDAO;
import com.solvd.bookingService.models.information.RoomType;

public class RoomTypeService {
	
	private RoomTypeDAO roomTypeDAO;
	private RoomDAO roomDAO;
	
	public RoomTypeService() {
		roomTypeDAO = new RoomTypeDAO();
	}
	
	public List<RoomType> getRoomTypes(){
		List<RoomType> roomTypes = roomTypeDAO.getEntities();
		roomDAO = new RoomDAO();
		roomTypes.stream().forEach(roomType -> roomType.setRooms(roomDAO.getRoomsByRoomTypeId(roomType.getId())));
		return roomTypes;
	}
	
	public RoomType getRoomTypeById(Long id) {
		RoomType rt = roomTypeDAO.getEntityById(id);
		roomDAO = new RoomDAO();
		rt.setRooms(roomDAO.getRoomsByRoomTypeId(id));
		return rt;
	}
	
	public void save(RoomType newRoomType) {
		roomTypeDAO.save(newRoomType);
	}
	
	public void update(RoomType updatedRoomType) {
		roomTypeDAO.update(updatedRoomType);
	}
	
	public void delete(Long roomTypeId) {
		roomTypeDAO.delete(roomTypeId);
	}
}
