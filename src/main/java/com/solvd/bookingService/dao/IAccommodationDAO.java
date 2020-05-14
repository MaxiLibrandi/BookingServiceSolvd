package com.solvd.bookingService.dao;

import java.util.List;

import com.solvd.bookingService.models.accommodation.Accommodation;

public interface IAccommodationDAO extends IEntityDAO<Accommodation>{
	
	public List<Accommodation> getAccommodationsByCityId(Long cityId);
}
