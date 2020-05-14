package com.solvd.bookingService.services;

import com.solvd.bookingService.dao.mySqlImpl.ContactDAO;
import com.solvd.bookingService.dao.mySqlImpl.UserDAO;
import com.solvd.bookingService.models.user.User;

public class UserService {

	private UserDAO userDAO;
	private ContactDAO contactDAO;
	
	public User getUserById(Long id) {
		userDAO = new UserDAO();
		User u = userDAO.getEntityById(id);
		contactDAO = new ContactDAO();
		u.setContacts(contactDAO.getContactsByUserId(id));
		return u;
	}
}
