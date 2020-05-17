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
import com.solvd.bookingService.models.reservation.ReservationStatus;

public class ReservationStatusDAO implements IEntityDAO<ReservationStatus>{

	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(ReservationStatusDAO.class);

	@Override
	public List<ReservationStatus> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReservationStatus> reservationStatus = new ArrayList<ReservationStatus>();
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Reservation_Status");
			rs = ps.executeQuery();
			while(rs.next()) {
				ReservationStatus rst = new ReservationStatus();
				rst.setId(rs.getLong("id"));
				rst.setStatus(rs.getString("status"));
				reservationStatus.add(rst);
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
		return reservationStatus;
	}

	@Override
	public ReservationStatus getEntityById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReservationStatus rst = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Reservation_Status rst WHERE rst.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			rst = new ReservationStatus();
			rst.setId(rs.getLong("id"));
			rst.setStatus(rs.getString("status"));
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
		return rst;
	}

	@Override
	public void save(ReservationStatus entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("INSERT INTO Reservation_Status (status) VALUES (?)");
			ps.setString(1,entity.getStatus());
			ps.executeUpdate();
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
	public void update(ReservationStatus entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("UPDATE Reservation_Status rst SET rst.status = ? WHERE rst.id = ?");
			ps.setString(1, entity.getStatus());
			ps.setLong(2, entity.getId());
			ps.executeUpdate();
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
			ps = c.prepareStatement("DELETE FROM Reservation_Status rst WHERE rst.id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
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
