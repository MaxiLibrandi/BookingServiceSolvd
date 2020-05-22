package com.solvd.bookingService.dao.mySqlImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.bookingService.connectionPool.ConnectionPool;
import com.solvd.bookingService.dao.ICityDAO;
import com.solvd.bookingService.models.localization.City;

public class CityDAO implements ICityDAO{

	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(CityDAO.class);
	
	private static final String GET_ALL = "SELECT * FROM Cities";
	private static final String GET_BY_ID = "SELECT * FROM Cities ci WHERE ci.id = ?";
	private static final String INSERT = "INSERT INTO Cities (name,country_id) VALUES (?,?)";
	private static final String UPDATE = "UPDATE Cities ci SET ci.name = ?, ci.country_id = ? WHERE ci.id = ?";
	private static final String DELETE = "DELETE FROM Cities ci WHERE ci.id = ?";
	private static final String GET_BY_COUNTRY_ID = "SELECT * FROM Cities ci WHERE ci.country_id = ?";
	
	@Override
	public List<City> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<City> cities = new ArrayList<City>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				City ci = new City();
				ci.setId(rs.getLong("id"));
				ci.setName(rs.getString("name"));
				ci.setCountryId(rs.getLong("country_id"));
				cities.add(ci);
			}
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}finally {
				try {
					ps.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}finally {
					connectionPool.releaseConnection(c);
				}
			}
		}
		return cities;
	}

	@Override
	public City getEntityById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		City ci = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_BY_ID);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			ci = new City();
			ci.setId(rs.getLong("id"));
			ci.setName(rs.getString("name"));
			ci.setCountryId(rs.getLong("country_id"));
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}finally {
				try {
					ps.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}finally {
					connectionPool.releaseConnection(c);
				}
			}
		}
		return ci;
	}

	@Override
	public void save(City entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(INSERT);
			ps.setString(1,entity.getName());
			ps.setLong(2, entity.getCountryId());
			ps.executeUpdate();
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			} finally {
				connectionPool.releaseConnection(c);
			}
		}
	}

	@Override
	public void update(City entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(UPDATE);
			ps.setString(1,entity.getName());
			ps.setLong(2, entity.getCountryId());
			ps.setLong(3, entity.getId());
			ps.executeUpdate();
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			} finally {
				connectionPool.releaseConnection(c);
			}
		}
	}

	@Override
	public void delete(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(DELETE);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			} finally {
				connectionPool.releaseConnection(c);
			}
		}
	}

	@Override
	public List<City> getCitiesByCountryId(Long countryId) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<City> cities = new ArrayList<City>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_BY_COUNTRY_ID);
			ps.setLong(1, countryId);
			rs = ps.executeQuery();
			while(rs.next()) {
				City ci = new City();
				ci.setId(rs.getLong("id"));
				ci.setName(rs.getString("name"));
				ci.setCountryId(rs.getLong("country_id"));
				cities.add(ci);
			}
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}finally {
				try {
					ps.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}finally {
					connectionPool.releaseConnection(c);
				}
			}
		}
		return cities;
	}
}
