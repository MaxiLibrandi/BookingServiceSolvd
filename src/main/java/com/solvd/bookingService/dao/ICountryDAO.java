package com.solvd.bookingService.dao;

import java.util.List;

import com.solvd.bookingService.models.localization.Country;

public interface ICountryDAO extends IEntityDAO<Country>{
	
	public List<Country> getCountriesByContinentId(Long continentId);
}
