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
import com.solvd.bookingService.dao.ICountryDAO;
import com.solvd.bookingService.models.localization.Country;

public class CountryDAO implements ICountryDAO{
	
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(CountryDAO.class);

	private static final String GET_ALL = "SELECT * FROM Countries";
	private static final String GET_BY_ID = "SELECT * FROM Countries co WHERE co.id = ?";
	private static final String INSERT = "INSERT INTO Countries (name,continent_id) VALUES (?,?)";
	private static final String UPDATE = "UPDATE Countries co SET co.name = ?, co.continent_id = ? WHERE co.id = ?";
	private static final String DELETE = "DELETE FROM Countries co WHERE co.id = ?";
	private static final String GET_BY_CONTINENT_ID = "SELECT * FROM Countries co WHERE co.continent_id = ?";
	
	@Override
	public Country buildModel(ResultSet rs) {
		Country co = new Country();
		try {
			co.setId(rs.getLong("id"));
			co.setName(rs.getString("name"));
			co.setContinentId(rs.getLong("continent_id"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return co;
	}
	
	@Override
	public List<Country> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Country> countries = new ArrayList<Country>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				Country co = buildModel(rs);
				countries.add(co);
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
		return countries;
	}

	@Override
	public Country getEntityById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Country co = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_BY_ID);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			co = buildModel(rs);
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
		return co;
	}

	@Override
	public void save(Country entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(INSERT);
			ps.setString(1,entity.getName());
			ps.setLong(2, entity.getContinentId());
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
	public void update(Country entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(UPDATE);
			ps.setString(1,entity.getName());
			ps.setLong(2, entity.getContinentId());
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
	public List<Country> getCountriesByContinentId(Long continentId) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Country> countries = new ArrayList<Country>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_BY_CONTINENT_ID);
			ps.setLong(1, continentId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Country co = buildModel(rs);
				countries.add(co);
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
		return countries;
	}
}
