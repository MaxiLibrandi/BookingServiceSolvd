package com.solvd.bookingService.services;

import com.solvd.bookingService.models.localization.Continent;

import java.util.List;

import com.solvd.bookingService.dao.ICountryDAO;
import com.solvd.bookingService.dao.IEntityDAO;
import com.solvd.bookingService.dao.mySqlImpl.ContinentDAO;
import com.solvd.bookingService.dao.mySqlImpl.CountryDAO;

public class ContinentService {
	
	private IEntityDAO<Continent> continentDAO;
	private ICountryDAO countryDAO;
	
	public ContinentService() {
		continentDAO = new ContinentDAO();
		countryDAO = new CountryDAO();
	}
	
	public List<Continent> getContinents(){
		List<Continent> continents = continentDAO.getEntities();
		continents.stream().forEach(continent -> continent.setCountries(countryDAO.getCountriesByContinentId(continent.getId())));
		return continents;
	}
	
	public Continent getContinentById(Long id) {
		Continent con = continentDAO.getEntityById(id);
		con.setCountries(countryDAO.getCountriesByContinentId(id));
		return con;
	}
	
	public void save(Continent newContinent) {
		continentDAO.save(newContinent);
	}
	
	public void update(Continent updatedContinent) {
		continentDAO.update(updatedContinent);
	}
	
	public void delete(Long continentId) {
		continentDAO.delete(continentId);
	}
}
