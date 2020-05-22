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
import com.solvd.bookingService.dao.IRoomDAO;
import com.solvd.bookingService.models.accommodation.Room;

public class RoomDAO implements IRoomDAO{
	
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(RoomDAO.class);

	@Override
	public List<Room> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Room> rooms = new ArrayList<Room>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Rooms");
			rs = ps.executeQuery();
			while(rs.next()) {
				Room ro = new Room();
				ro.setId(rs.getLong("id"));
				ro.setDescription(rs.getString("description"));
				ro.setAccommodationId(rs.getLong("accommodation_id"));
				ro.setRoomTypeId(rs.getLong("room_type_id"));
				rooms.add(ro);
			}
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
		return rooms;
	}

	@Override
	public Room getEntityById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room ro = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Rooms ro WHERE ro.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			ro = new Room();
			ro.setId(rs.getLong("id"));
			ro.setDescription(rs.getString("description"));
			ro.setAccommodationId(rs.getLong("accommodation_id"));
			ro.setRoomTypeId(rs.getLong("room_type_id"));
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
		return ro;
	}

	@Override
	public void save(Room entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("INSERT INTO Rooms (description,accommodation_id,room_type_id) VALUES (?,?,?)");
			ps.setString(1,entity.getDescription());
			ps.setLong(2,entity.getAccommodationId());
			ps.setLong(3,entity.getRoomTypeId());
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
			}
			connectionPool.releaseConnection(c);
		}
	}

	@Override
	public void update(Room entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("UPDATE Rooms ro SET ro.description = ?, ro.accommodation_id = ?, ro.room_type_id = ? WHERE ro.id = ?");
			ps.setString(1,entity.getDescription());
			ps.setLong(2,entity.getAccommodationId());
			ps.setLong(3,entity.getRoomTypeId());
			ps.setLong(4, entity.getId());
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
			}
			connectionPool.releaseConnection(c);
		}
	}

	@Override
	public void delete(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("DELETE FROM Rooms ro WHERE ro.id = ?");
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
			}
			connectionPool.releaseConnection(c);
		}
	}

	@Override
	public List<Room> getRoomsByRoomTypeId(Long roomTypeId) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Room> rooms = new ArrayList<Room>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Rooms ro WHERE ro.room_type_id = ?");
			ps.setLong(1,roomTypeId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Room ro = new Room();
				ro.setId(rs.getLong("id"));
				ro.setDescription(rs.getString("description"));
				ro.setAccommodationId(rs.getLong("accommodation_id"));
				ro.setRoomTypeId(rs.getLong("room_type_id"));
				rooms.add(ro);
			}
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
		return rooms;
	}
}
