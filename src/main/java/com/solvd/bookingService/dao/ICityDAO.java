package com.solvd.bookingService.dao;

import java.util.List;

import com.solvd.bookingService.models.localization.City;

public interface ICityDAO extends IEntityDAO<City>{

	public List<City> getCitiesByCountryId(Long countryId);
}
