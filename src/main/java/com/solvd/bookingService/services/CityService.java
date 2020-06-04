package com.solvd.bookingService.services;

import java.util.List;

import com.solvd.bookingService.dao.IAccommodationDAO;
import com.solvd.bookingService.dao.ICityDAO;
import com.solvd.bookingService.models.localization.City;
import com.solvd.bookingService.myBatis.SqlSession;

public class CityService {
	
	private ICityDAO cityDAO;
	private IAccommodationDAO accommodationDAO;
	
	public CityService() {
		cityDAO = SqlSession.getInstance().openSession(true).getMapper(ICityDAO.class);
		accommodationDAO = SqlSession.getInstance().openSession(true).getMapper(IAccommodationDAO.class);
	}
	
	public List<City> getCities(){
		List<City> cities = cityDAO.getEntities();
		cities.stream().forEach(city -> city.setAccommodations(accommodationDAO.getAccommodationsByCityId(city.getId())));
		return cities;
	}
	
	public City getCityById(Long id) {
		City ci = cityDAO.getEntityById(id);
		ci.setAccommodations(accommodationDAO.getAccommodationsByCityId(id));
		return ci;
	}
	
	public void save(City newCity) {
		cityDAO.save(newCity);
	}
	
	public void update(City updatedCity) {
		cityDAO.update(updatedCity);
	}
	
	public void delete(Long cityId) {
		cityDAO.delete(cityId);
	}
}
