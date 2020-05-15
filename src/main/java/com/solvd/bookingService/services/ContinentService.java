package com.solvd.bookingService.services;

import com.solvd.bookingService.models.localization.Continent;
import com.solvd.bookingService.dao.mySqlImpl.ContinentDAO;
import com.solvd.bookingService.dao.mySqlImpl.CountryDAO;

public class ContinentService {
	
	private ContinentDAO continentDAO;
	private CountryDAO countryDAO;
	
	public Continent getContinentById(Long id) {
		continentDAO = new ContinentDAO();
		Continent con = continentDAO.getEntityById(id);
		countryDAO = new CountryDAO();
		con.setCountries(countryDAO.getCountriesByContinentId(id));
		return con;
	}
}
