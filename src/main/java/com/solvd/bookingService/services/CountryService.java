package com.solvd.bookingService.services;

import java.util.List;

import com.solvd.bookingService.dao.ICityDAO;
import com.solvd.bookingService.dao.ICountryDAO;
import com.solvd.bookingService.models.localization.Country;
import com.solvd.bookingService.myBatis.SqlSession;

public class CountryService {

	private ICountryDAO countryDAO;
	private ICityDAO cityDAO;
	
	public CountryService() {
		countryDAO = SqlSession.getInstance().openSession(true).getMapper(ICountryDAO.class);
		cityDAO = SqlSession.getInstance().openSession(true).getMapper(ICityDAO.class);
	}
	
	public List<Country> getCountries(){
		List<Country> countries = countryDAO.getEntities();
		countries.stream().forEach(country -> country.setCities(cityDAO.getCitiesByCountryId(country.getId())));
		return countries;
	}
	
	public Country getCountryById(Long id) {
		Country co = countryDAO.getEntityById(id);
		co.setCities(cityDAO.getCitiesByCountryId(id));
		return co;
	}
	
	public void save(Country newCountry) {
		countryDAO.save(newCountry);
	}
	
	public void update(Country updatedCountry) {
		countryDAO.update(updatedCountry);
	}
	
	public void delete(Long countryId) {
		countryDAO.delete(countryId);
	}
}
