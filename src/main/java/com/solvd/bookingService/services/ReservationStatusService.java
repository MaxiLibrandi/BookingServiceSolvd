package com.solvd.bookingService.services;

import java.util.List;

import com.solvd.bookingService.dao.mySqlImpl.ReservationDAO;
import com.solvd.bookingService.dao.mySqlImpl.ReservationStatusDAO;
import com.solvd.bookingService.models.reservation.ReservationStatus;

public class ReservationStatusService {
	
	private ReservationStatusDAO reservationStatusDAO;
	private ReservationDAO reservationDAO;
	
	public ReservationStatusService() {
		reservationStatusDAO = new ReservationStatusDAO();
	}
	
	public List<ReservationStatus> getReservationStatus(){
		List<ReservationStatus> reservationStatus = reservationStatusDAO.getEntities();
		reservationDAO = new ReservationDAO();
		reservationStatus.stream().forEach(rs -> rs.setReservations(reservationDAO.getReservationsByReservationStatusId(rs.getId())));
		return reservationStatus;
	}
	
	public ReservationStatus getReservationStatusById(Long id) {
		ReservationStatus rs = reservationStatusDAO.getEntityById(id);
		reservationDAO = new ReservationDAO();
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
