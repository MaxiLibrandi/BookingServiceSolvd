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
import com.solvd.bookingService.dao.IContactDAO;
import com.solvd.bookingService.models.user.Contact;

public class ContactDAO implements IContactDAO{
	
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(ContactDAO.class);
	
	private static final String GET_ALL = "SELECT * FROM Contacts";
	private static final String GET_BY_ID = "SELECT * FROM Contacts co WHERE co.id = ?";
	private static final String INSERT = "INSERT INTO Contacts (user_id,contact_source_id,contact_data) VALUES (?,?,?)";
	private static final String UPDATE = "UPDATE Contacts co SET co.user_id = ?, co.contact_source_id = ?, co.contact_data = ? WHERE co.id = ?";
	private static final String DELETE = "DELETE FROM Contacts co WHERE co.id = ?";
	private static final String GET_BY_USER_ID = "SELECT * FROM Contacts co WHERE co.user_id = ?";
	private static final String GET_BY_CONTACT_SOURCE_ID = "SELECT * FROM Contacts co WHERE co.contact_source_id = ?";

	@Override
	public List<Contact> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Contact> contacts = new ArrayList<Contact>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				Contact co = new Contact();
				co.setId(rs.getLong("id"));
				co.setUserId(rs.getLong("user_id"));
				co.setContactSourceId(rs.getLong("contact_source_id"));
				co.setContactData(rs.getString("contact_data"));
				contacts.add(co);
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
		return contacts;
	}

	@Override
	public Contact getEntityById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Contact co = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_BY_ID);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			co = new Contact();
			co.setId(rs.getLong("id"));
			co.setUserId(rs.getLong("user_id"));
			co.setContactSourceId(rs.getLong("contact_source_id"));
			co.setContactData(rs.getString("contact_data"));
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
	public void save(Contact entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(INSERT);
			ps.setLong(1, entity.getUserId());
			ps.setLong(2, entity.getContactSourceId());
			ps.setString(3, entity.getContactData());
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
	public void update(Contact entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(UPDATE);
			ps.setLong(1, entity.getUserId());
			ps.setLong(2, entity.getContactSourceId());
			ps.setString(3, entity.getContactData());
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
	public List<Contact> getContactsByUserId(Long userId) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Contact> contacts = new ArrayList<Contact>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_BY_USER_ID);
			ps.setLong(1, userId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Contact co = new Contact();
				co.setId(rs.getLong("id"));
				co.setUserId(rs.getLong("user_id"));
				co.setContactSourceId(rs.getLong("contact_source_id"));
				co.setContactData(rs.getString("contact_data"));
				contacts.add(co);
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
		return contacts;
	}

	@Override
	public List<Contact> getContactsByContactSourcesId(Long contactSourceId){
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Contact> contacts = new ArrayList<Contact>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_BY_CONTACT_SOURCE_ID);
			ps.setLong(1, contactSourceId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Contact co = new Contact();
				co.setId(rs.getLong("id"));
				co.setUserId(rs.getLong("user_id"));
				co.setContactSourceId(rs.getLong("contact_source_id"));
				co.setContactData(rs.getString("contact_data"));
				contacts.add(co);
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
		return contacts;
	}
}
