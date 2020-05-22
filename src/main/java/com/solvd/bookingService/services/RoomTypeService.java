package com.solvd.bookingService.services;

import java.util.List;

import com.solvd.bookingService.dao.IEntityDAO;
import com.solvd.bookingService.dao.IRoomDAO;
import com.solvd.bookingService.dao.mySqlImpl.RoomDAO;
import com.solvd.bookingService.dao.mySqlImpl.RoomTypeDAO;
import com.solvd.bookingService.models.information.RoomType;

public class RoomTypeService {
	
	private IEntityDAO<RoomType> roomTypeDAO;
	private IRoomDAO roomDAO;
	
	public RoomTypeService() {
		roomTypeDAO = new RoomTypeDAO();
		roomDAO = new RoomDAO();
	}
	
	public List<RoomType> getRoomTypes(){
		List<RoomType> roomTypes = roomTypeDAO.getEntities();
		roomTypes.stream().forEach(roomType -> roomType.setRooms(roomDAO.getRoomsByRoomTypeId(roomType.getId())));
		return roomTypes;
	}
	
	public RoomType getRoomTypeById(Long id) {
		RoomType rt = roomTypeDAO.getEntityById(id);
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
