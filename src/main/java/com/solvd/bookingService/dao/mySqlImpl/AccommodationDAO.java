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
import com.solvd.bookingService.dao.IAccommodationDAO;
import com.solvd.bookingService.models.accommodation.Accommodation;

public class AccommodationDAO implements IAccommodationDAO{
	
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(AccommodationDAO.class);

	@Override
	public List<Accommodation> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Accommodation> accommodations = new ArrayList<Accommodation>();
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Accommodations");
			rs = ps.executeQuery();
			while(rs.next()) {
				Accommodation a = new Accommodation();
				a.setId(rs.getLong("id"));
				a.setHostId(rs.getLong("host_id"));
				a.setDirection(rs.getString("direction"));
				a.setDescription(rs.getString("description"));
				a.setMaxCapacity(rs.getInt("max_capacity"));
				a.setCityId(rs.getLong("city_id"));
				accommodations.add(a);
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
		return accommodations;
	}

	@Override
	public Accommodation getEntityById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Accommodation a = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Accommodations a WHERE a.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			a = new Accommodation();
			a.setId(rs.getLong("id"));
			a.setHostId(rs.getLong("host_id"));
			a.setDirection(rs.getString("direction"));
			a.setDescription(rs.getString("description"));
			a.setMaxCapacity(rs.getInt("max_capacity"));
			a.setCityId(rs.getLong("city_id"));
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
		return a;
	}

	@Override
	public void save(Accommodation entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("INSERT INTO Accomodations (host_id,direction,description,max_capacity,city_id) VALUES (?,?,?,?,?)");
			ps.setLong(1, entity.getHostId());
			ps.setString(2, entity.getDirection());
			ps.setString(3, entity.getDescription());
			ps.setInt(4, entity.getMaxCapacity());
			ps.setLong(5, entity.getCityId());
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
	public void update(Accommodation entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("UPDATE Accommodations a SET a.host_id = ?, a.direction = ?, a.description = ?, a.max_capacity = ?, a.city_id = ? WHERE a.id = ?");
			ps.setLong(1, entity.getHostId());
			ps.setString(2, entity.getDirection());
			ps.setString(3, entity.getDescription());
			ps.setInt(4, entity.getMaxCapacity());
			ps.setLong(5, entity.getCityId());
			ps.setLong(6, entity.getId());
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
			ps = c.prepareStatement("DELETE FROM Accommodations a WHERE a.id = ?");
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
	
@Override
	public List<Accommodation> getAccommodationsByCityId(Long cityId) {
	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<Accommodation> accommodations = new ArrayList<Accommodation>();
	try {
		Class.forName(ConnectionPool.DB_DRIVER);
		c = connectionPool.getConnection();
		ps = c.prepareStatement("SELECT * FROM Accommodations a WHERE a.city_id = ?");
		ps.setLong(1, cityId);
		rs = ps.executeQuery();
		while(rs.next()) {
			Accommodation a = new Accommodation();
			a.setId(rs.getLong("id"));
			a.setHostId(rs.getLong("host_id"));
			a.setDirection(rs.getString("direction"));
			a.setDescription(rs.getString("description"));
			a.setMaxCapacity(rs.getInt("max_capacity"));
			a.setCityId(rs.getLong("city_id"));
			accommodations.add(a);
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
	return accommodations;
	}
}
