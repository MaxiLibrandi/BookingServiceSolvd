package com.solvd.bookingService.services;

import java.util.List;

import com.solvd.bookingService.dao.IContactDAO;
import com.solvd.bookingService.dao.IEntityDAO;
import com.solvd.bookingService.dao.mySqlImpl.ContactDAO;
import com.solvd.bookingService.dao.mySqlImpl.ContactSourceDAO;
import com.solvd.bookingService.models.user.ContactSource;

public class ContactSourceService {
	
	private IEntityDAO<ContactSource> contactSourceDAO;
	private IContactDAO contactDAO;
	
	public ContactSourceService() {
		contactSourceDAO = new ContactSourceDAO();
		contactDAO = new ContactDAO();
	}
	
	public List<ContactSource> getContactSources(){
		List<ContactSource> contactSources = contactSourceDAO.getEntities();
		contactSources.stream().forEach(contactSource -> contactSource.setContacts(contactDAO.getContactsByContactSourcesId(contactSource.getId())));
		return contactSources;
	}
	
	public ContactSource getContactSourceById(Long id) {
		ContactSource cs = contactSourceDAO.getEntityById(id);
		cs.setContacts(contactDAO.getContactsByContactSourcesId(id));
		return cs;
	}

	public void save(ContactSource newContactSource) {
		contactSourceDAO.save(newContactSource);
	}
	
	public void update(ContactSource updatedContactSource) {
		contactSourceDAO.update(updatedContactSource);
	}
	
	public void delete(Long contactSourceId) {
		contactSourceDAO.delete(contactSourceId);
	}
}
