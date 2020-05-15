package com.solvd.bookingService.services;

import com.solvd.bookingService.models.localization.Continent;

import java.util.List;

import com.solvd.bookingService.dao.mySqlImpl.ContinentDAO;
import com.solvd.bookingService.dao.mySqlImpl.CountryDAO;

public class ContinentService {
	
	private ContinentDAO continentDAO;
	private CountryDAO countryDAO;
	
	public ContinentService() {
		continentDAO = new ContinentDAO();
	}
	
	public List<Continent> getContinents(){
		List<Continent> continents = continentDAO.getEntities();
		countryDAO = new CountryDAO();
		continents.stream().forEach(continent -> continent.setCountries(countryDAO.getCountriesByContinentId(continent.getId())));
		return continents;
	}
	
	public Continent getContinentById(Long id) {
		Continent con = continentDAO.getEntityById(id);
		countryDAO = new CountryDAO();
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
