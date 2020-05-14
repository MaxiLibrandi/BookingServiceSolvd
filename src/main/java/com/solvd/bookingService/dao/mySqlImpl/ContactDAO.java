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
import com.solvd.bookingService.models.user.Contact;

public class ContactDAO implements IEntityDAO<Contact>{
	
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(ContactDAO.class);

	@Override
	public List<Contact> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Contact> contacts = new ArrayList<Contact>();
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Contacts");
			rs = ps.executeQuery();
			while(rs.next()) {
				Contact co = new Contact();
				co.setId(rs.getLong("id"));
				co.setUserId(rs.getLong("user_id"));
				co.setContactSourceId(rs.getLong("contact_source_id"));
				co.setContactData(rs.getString("contact_data"));
				contacts.add(co);
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
		return contacts;
	}

	@Override
	public Contact getEntityById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Contact co = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Contacts co WHERE co.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			co = new Contact();
			co.setId(rs.getLong("id"));
			co.setUserId(rs.getLong("user_id"));
			co.setContactSourceId(rs.getLong("contact_source_id"));
			co.setContactData(rs.getString("contact_data"));
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
	public void save(Contact entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("INSERT INTO Contacts (user_id,contact_source_id,contact_data) VALUES (?,?,?)");
			ps.setLong(1, entity.getUserId());
			ps.setLong(2, entity.getContactSourceId());
			ps.setString(3, entity.getContactData());
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
	public void update(Contact entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = connectionPool.getConnection();
			ps = c.prepareStatement("UPDATE Contacts co SET co.user_id = ?, co.contact_source_id = ?, co.contact_data = ? WHERE co.id = ?");
			ps.setLong(1, entity.getUserId());
			ps.setLong(2, entity.getContactSourceId());
			ps.setString(3, entity.getContactData());
			ps.setLong(4, entity.getId());
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
			ps = c.prepareStatement("DELETE FROM Contacts co WHERE co.id = ?");
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
