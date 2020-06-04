package com.solvd.bookingService.services;

import com.solvd.bookingService.models.localization.Continent;
import com.solvd.bookingService.myBatis.SqlSession;

import java.util.List;

import com.solvd.bookingService.dao.ICountryDAO;
import com.solvd.bookingService.dao.IContinentDAO;

public class ContinentService {
	
	private IContinentDAO continentDAO;
	private ICountryDAO countryDAO;
	
	public ContinentService() {
		continentDAO = SqlSession.getInstance().openSession(true).getMapper(IContinentDAO.class);
		countryDAO = SqlSession.getInstance().openSession(true).getMapper(ICountryDAO.class);
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
