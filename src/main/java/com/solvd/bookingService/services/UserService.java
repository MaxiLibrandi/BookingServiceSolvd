package com.solvd.bookingService.services;

import com.solvd.bookingService.dao.mySqlImpl.ContactDAO;
import com.solvd.bookingService.dao.mySqlImpl.UserDAO;
import com.solvd.bookingService.dao.mySqlImpl.AccommodationDAO;
import com.solvd.bookingService.dao.mySqlImpl.ReservationDAO;
import com.solvd.bookingService.models.user.User;

public class UserService {

	private UserDAO userDAO;
	private ContactDAO contactDAO;
	private AccommodationDAO accommodationDAO;
	private ReservationDAO reservationDAO;
	
	public User getUserById(Long id) {
		userDAO = new UserDAO();
		User u = userDAO.getEntityById(id);
		contactDAO = new ContactDAO();
		u.setContacts(contactDAO.getContactsByUserId(id));
		accommodationDAO = new AccommodationDAO();
		u.setAccommodations(accommodationDAO.getAccommodationsByHostId(id));
		reservationDAO = new ReservationDAO();
		u.setReservations(reservationDAO.getReservationsByGuestId(id));
		return u;
	}
}
