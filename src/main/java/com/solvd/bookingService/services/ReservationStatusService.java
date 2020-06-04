package com.solvd.bookingService.services;

import java.util.List;

import com.solvd.bookingService.dao.IReservationStatusDAO;
import com.solvd.bookingService.dao.IReservationDAO;
import com.solvd.bookingService.models.reservation.ReservationStatus;
import com.solvd.bookingService.myBatis.SqlSession;

public class ReservationStatusService {
	
	private IReservationStatusDAO reservationStatusDAO;
	private IReservationDAO reservationDAO;
	
	public ReservationStatusService() {
		reservationStatusDAO = SqlSession.getInstance().openSession(true).getMapper(IReservationStatusDAO.class);
		reservationDAO = SqlSession.getInstance().openSession(true).getMapper(IReservationDAO.class);
	}
	
	public List<ReservationStatus> getReservationStatus(){
		List<ReservationStatus> reservationStatus = reservationStatusDAO.getEntities();
		reservationStatus.stream().forEach(rs -> rs.setReservations(reservationDAO.getReservationsByReservationStatusId(rs.getId())));
		return reservationStatus;
	}
	
	public ReservationStatus getReservationStatusById(Long id) {
		ReservationStatus rs = reservationStatusDAO.getEntityById(id);
		rs.setReservations(reservationDAO.getReservationsByReservationStatusId(id));
		return rs;
	}
	
	public void save(ReservationStatus newReservationStatus) {
		reservationStatusDAO.save(newReservationStatus);
	}
	
	public void update(ReservationStatus updatedReservationStatus) {
		reservationStatusDAO.update(updatedReservationStatus);
	}
	
	public void delete(Long reservationStatusId) {
		reservationStatusDAO.delete(reservationStatusId);
	}
}
