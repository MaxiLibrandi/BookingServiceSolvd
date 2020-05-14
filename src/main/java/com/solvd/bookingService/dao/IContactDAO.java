package com.solvd.bookingService.dao;

import java.util.List;

import com.solvd.bookingService.models.user.Contact;

public interface IContactDAO extends IEntityDAO<Contact>{
	
	public List<Contact> getContactsByUserId(Long userId);
	public List<Contact> getContactsByContactSourcesId(Long contactSourceId);
}
