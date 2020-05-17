package com.solvd.bookingService.services;

import com.solvd.bookingService.dao.mySqlImpl.DBConfigurationDAO;

public class DBConfigurationService {
	
	private DBConfigurationDAO dbConfigurationDAO;
	
	public void initDB() {
		dbConfigurationDAO = new DBConfigurationDAO();
		dbConfigurationDAO.initDB();
	}
}
