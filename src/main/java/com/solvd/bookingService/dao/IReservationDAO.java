package com.solvd.bookingService.dao;

import java.util.List;

import com.solvd.bookingService.models.reservation.Reservation;

public interface IReservationDAO extends IEntityDAO<Reservation>{
	
	public List<Reservation> getReservationsByReservationStatusId(Long reservationStatusId);
}
