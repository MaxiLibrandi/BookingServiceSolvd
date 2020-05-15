package com.solvd.bookingService.services;

import com.solvd.bookingService.dao.mySqlImpl.ContactDAO;
import com.solvd.bookingService.dao.mySqlImpl.UserDAO;

import java.util.List;

import com.solvd.bookingService.dao.mySqlImpl.AccommodationDAO;
import com.solvd.bookingService.dao.mySqlImpl.ReservationDAO;
import com.solvd.bookingService.models.user.User;

public class UserService {

	private UserDAO userDAO;
	private ContactDAO contactDAO;
	private AccommodationDAO accommodationDAO;
	private ReservationDAO reservationDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	public List<User> getUsers(){
		List<User> users = userDAO.getEntities();
		contactDAO = new ContactDAO();
		accommodationDAO = new AccommodationDAO();
		reservationDAO = new ReservationDAO();
		users.stream().forEach(user -> {
			Long userId = user.getId();
			user.setContacts(contactDAO.getContactsByUserId(userId));
			user.setAccommodations(accommodationDAO.getAccommodationsByHostId(userId));
			user.setReservations(reservationDAO.getReservationsByGuestId(userId));
		});
		return users;
	}
	
	public User getUserById(Long id) {
		User u = userDAO.getEntityById(id);
		contactDAO = new ContactDAO();
		u.setContacts(contactDAO.getContactsByUserId(id));
		accommodationDAO = new AccommodationDAO();
		u.setAccommodations(accommodationDAO.getAccommodationsByHostId(id));
		reservationDAO = new ReservationDAO();
		u.setReservations(reservationDAO.getReservationsByGuestId(id));
		return u;
	}
	
	public void save(User newUser) {
		userDAO.save(newUser);
	}
	
	public void update(User updatedUser) {
		userDAO.update(updatedUser);
	}
	
	public void delete(Long userId) {
		userDAO.delete(userId);
	}
}
