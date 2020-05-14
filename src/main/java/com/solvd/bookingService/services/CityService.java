package com.solvd.bookingService.services;

import com.solvd.bookingService.dao.mySqlImpl.AccommodationDAO;
import com.solvd.bookingService.dao.mySqlImpl.CityDAO;
import com.solvd.bookingService.models.localization.City;

public class CityService {
	
	private CityDAO cityDAO;
	private AccommodationDAO accommodationDAO;
	
	public City getCityById(Long id) {
		cityDAO = new CityDAO();
		City ci = cityDAO.getEntityById(id);
		accommodationDAO = new AccommodationDAO();
		ci.setAccommodations(accommodationDAO.getAccommodationsByCityId(id));
		return ci;
	}
}
