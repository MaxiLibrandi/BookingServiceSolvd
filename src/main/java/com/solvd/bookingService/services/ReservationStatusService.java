package com.solvd.bookingService.services;

import com.solvd.bookingService.dao.mySqlImpl.ReservationDAO;
import com.solvd.bookingService.dao.mySqlImpl.ReservationStatusDAO;
import com.solvd.bookingService.models.reservation.ReservationStatus;

public class ReservationStatusService {
	
	private ReservationStatusDAO reservationStatusDAO;
	private ReservationDAO reservationDAO;
	
	public ReservationStatus getReservationStatusById(Long id) {
		reservationStatusDAO = new ReservationStatusDAO();
		ReservationStatus rs = reservationStatusDAO.getEntityById(id);
		reservationDAO = new ReservationDAO();
		rs.setReservations(reservationDAO.getReservationsByReservationStatusId(id));
		return rs;
	}
}
