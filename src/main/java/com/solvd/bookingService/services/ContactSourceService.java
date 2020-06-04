package com.solvd.bookingService.services;

import java.util.List;

import com.solvd.bookingService.dao.IContactDAO;
import com.solvd.bookingService.dao.IContactSourceDAO;
import com.solvd.bookingService.models.user.ContactSource;
import com.solvd.bookingService.myBatis.SqlSession;

public class ContactSourceService {
	
	private IContactSourceDAO contactSourceDAO;
	private IContactDAO contactDAO;
	
	public ContactSourceService() {
		contactSourceDAO = SqlSession.getInstance().openSession(true).getMapper(IContactSourceDAO.class);
		contactDAO = SqlSession.getInstance().openSession(true).getMapper(IContactDAO.class);
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
