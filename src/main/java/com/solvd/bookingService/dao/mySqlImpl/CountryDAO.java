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
import com.solvd.bookingService.dao.IEntityDAO;
import com.solvd.bookingService.models.localization.Country;

public class CountryDAO implements IEntityDAO<Country>{
	
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(CountryDAO.class);

	@Override
	public List<Country> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Country> countries = new ArrayList<Country>();
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Countries");
			rs = ps.executeQuery();
			while(rs.next()) {
				Country co = new Country();
				co.setId(rs.getLong("id"));
				co.setName(rs.getString("name"));
				co.setContinentId(rs.getLong("continent_id"));
				countries.add(co);
			}
		} catch (ClassNotFoundException e) {
			LOGGER.error(e);
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
			connectionPool.releaseConnection(c);
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
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Countries co WHERE co.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			co = new Country();
			co.setId(rs.getLong("id"));
			co.setName(rs.getString("name"));
			co.setContinentId(rs.getLong("continent_id"));
		} catch (ClassNotFoundException e) {
			LOGGER.error(e);
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
			connectionPool.releaseConnection(c);
		}
		return co;
	}

	@Override
	public void save(Country entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("INSERT INTO Countries (name,continent_id) VALUES (?,?)");
			ps.setString(1,entity.getName());
			ps.setLong(2, entity.getContinentId());
			ps.executeQuery();
		} catch (ClassNotFoundException e) {
			LOGGER.error(e);
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
			connectionPool.releaseConnection(c);
		}
	}

	@Override
	public void update(Country entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("UPDATE Countries co SET co.name = ?, co.continent_id = ? WHERE co.id = ?");
			ps.setString(1,entity.getName());
			ps.setLong(2, entity.getContinentId());
			ps.setLong(3, entity.getId());
			ps.executeQuery();
		} catch (ClassNotFoundException e) {
			LOGGER.error(e);
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
			connectionPool.releaseConnection(c);
		}
	}

	@Override
	public void delete(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("DELETE FROM Countries co WHERE co.id = ?");
			ps.setLong(1, id);
			ps.executeQuery();
		} catch (ClassNotFoundException e) {
			LOGGER.error(e);
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
			connectionPool.releaseConnection(c);
		}
	}
}
