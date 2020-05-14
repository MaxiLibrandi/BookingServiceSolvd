package com.solvd.bookingService.services;

import com.solvd.bookingService.dao.mySqlImpl.ContactDAO;
import com.solvd.bookingService.dao.mySqlImpl.ContactSourceDAO;
import com.solvd.bookingService.models.user.ContactSource;

public class ContactSourceService {
	
	private ContactSourceDAO contactSourceDAO;
	private ContactDAO contactDAO;
	
	public ContactSource getContactSourceById(Long id) {
		contactSourceDAO = new ContactSourceDAO();
		ContactSource cs = contactSourceDAO.getEntityById(id);
		contactDAO = new ContactDAO();
		cs.setContacts(contactDAO.getContactsByContactSourcesId(id));
		return cs;
	}

}
