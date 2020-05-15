package com.solvd.bookingService.services;

import com.solvd.bookingService.dao.mySqlImpl.CityDAO;
import com.solvd.bookingService.dao.mySqlImpl.CountryDAO;
import com.solvd.bookingService.models.localization.Country;

public class CountryService {

	private CountryDAO countryDAO;
	private CityDAO cityDAO;
	
	public Country getCountryById(Long id) {
		countryDAO = new CountryDAO();
		Country co = countryDAO.getEntityById(id);
		cityDAO = new CityDAO();
		co.setCities(cityDAO.getCitiesByCountryId(id));
		return co;
	}
}
