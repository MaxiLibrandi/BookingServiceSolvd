package com.solvd.bookingService.services;

import com.solvd.bookingService.dao.IDBConfigurationDAO;
import com.solvd.bookingService.dao.mySqlImpl.DBConfigurationDAO;

public class DBConfigurationService {
	
	private IDBConfigurationDAO dbConfigurationDAO;
	
	public DBConfigurationService() {
		dbConfigurationDAO = new DBConfigurationDAO();
	}
	
	public void initDB() {
		dbConfigurationDAO.initDB();
	}
}
