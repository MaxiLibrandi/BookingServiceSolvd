package com.solvd.bookingService.dao;

import java.sql.ResultSet;
import java.util.List;

public interface IEntityDAO <T>{

	public T buildModel(ResultSet rs);
	public List<T> getEntities();
	public T getEntityById(Long id);
	public void save(T entity);
	public void update(T entity);
	public void delete(Long id);
}
