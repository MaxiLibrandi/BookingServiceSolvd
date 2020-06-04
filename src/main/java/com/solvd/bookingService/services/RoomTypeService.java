package com.solvd.bookingService.services;

import java.util.List;

import com.solvd.bookingService.dao.IRoomDAO;
import com.solvd.bookingService.dao.IRoomTypeDAO;
import com.solvd.bookingService.models.information.RoomType;
import com.solvd.bookingService.myBatis.SqlSession;

public class RoomTypeService {
	
	private IRoomTypeDAO roomTypeDAO;
	private IRoomDAO roomDAO;
	
	public RoomTypeService() {
		roomTypeDAO = SqlSession.getInstance().openSession(true).getMapper(IRoomTypeDAO.class);
		roomDAO = SqlSession.getInstance().openSession(true).getMapper(IRoomDAO.class);
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
