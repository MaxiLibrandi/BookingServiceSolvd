package com.solvd.bookingService.services;

import java.util.List;

import com.solvd.bookingService.dao.IEntityDAO;
import com.solvd.bookingService.dao.IReservationDAO;
import com.solvd.bookingService.dao.mySqlImpl.ReservationDAO;
import com.solvd.bookingService.dao.mySqlImpl.ReservationStatusDAO;
import com.solvd.bookingService.models.reservation.ReservationStatus;

public class ReservationStatusService {
	
	private IEntityDAO<ReservationStatus> reservationStatusDAO;
	private IReservationDAO reservationDAO;
	
	public ReservationStatusService() {
		reservationStatusDAO = new ReservationStatusDAO();
		reservationDAO = new ReservationDAO();
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
