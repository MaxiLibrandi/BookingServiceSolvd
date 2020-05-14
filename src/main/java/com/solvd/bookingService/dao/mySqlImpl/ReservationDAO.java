package com.solvd.bookingService.dao.mySqlImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.bookingService.connectionPool.ConnectionPool;
import com.solvd.bookingService.dao.IEntityDAO;
import com.solvd.bookingService.models.reservation.Reservation;

public class ReservationDAO implements IEntityDAO<Reservation>{
	
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(ReservationDAO.class);

	@Override
	public List<Reservation> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Reservation> reservations = new ArrayList<Reservation>();
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Reservations");
			rs = ps.executeQuery();
			while(rs.next()) {
				Reservation r = new Reservation();
				r.setId(rs.getLong("id"));
				r.setDateFrom(rs.getDate("date_from").toLocalDate());
				r.setDateTo(rs.getDate("date_to").toLocalDate());
				r.setPrice(rs.getFloat("price"));
				r.setRating(rs.getInt("rating"));
				reservations.add(r);
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
		return reservations;
	}

	@Override
	public Reservation getEntityById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reservation r = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Reservations r WHERE r.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			r = new Reservation();
			r.setId(rs.getLong("id"));
			r.setDateFrom(rs.getDate("date_from").toLocalDate());
			r.setDateTo(rs.getDate("date_to").toLocalDate());
			r.setPrice(rs.getFloat("price"));
			r.setRating(rs.getInt("rating"));
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
		return r;
	}

	@Override
	public void save(Reservation entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("INSERT INTO Reservations (guest_id,accommodation_id,date_from,date_to,price,reservation_status,rating) VALUES (?,?,?,?,?,?,?)");
			ps.setLong(1, entity.getGuest().getId());
			ps.setLong(2, entity.getAccommodation().getId());
			ps.setDate(3, Date.valueOf(entity.getDateFrom()));
			ps.setDate(4, Date.valueOf(entity.getDateTo()));
			ps.setFloat(5, entity.getPrice());
			ps.setLong(6, entity.getReservationStatus().getId());
			ps.setInt(7, entity.getRating());
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
	public void update(Reservation entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("UPDATE Reservations r SET r.guest_id = ?, r.accommodation_id = ?, r.date_from = ?, r.date_to = ?, r.price = ?, r.reservation_status_id = ?, r.rating = ? WHERE r.id = ?");
			ps.setLong(1, entity.getGuest().getId());
			ps.setLong(2, entity.getAccommodation().getId());
			ps.setDate(3, Date.valueOf(entity.getDateFrom()));
			ps.setDate(4, Date.valueOf(entity.getDateTo()));
			ps.setFloat(5, entity.getPrice());
			ps.setLong(6, entity.getReservationStatus().getId());
			ps.setInt(7, entity.getRating());
			ps.setLong(8, entity.getId());
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
			ps = c.prepareStatement("DELETE FROM Reservations r WHERE r.id = ?");
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
