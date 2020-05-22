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
import com.solvd.bookingService.models.user.ContactSource;

public class ContactSourceDAO implements IEntityDAO<ContactSource>{

	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(ContactSourceDAO.class);

	@Override
	public List<ContactSource> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ContactSource> contactSources = new ArrayList<ContactSource>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Contact_Sources");
			rs = ps.executeQuery();
			while(rs.next()) {
				ContactSource cs = new ContactSource();
				cs.setId(rs.getLong("id"));
				cs.setSource(rs.getString("source"));
				contactSources.add(cs);
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
		return contactSources;
	}

	@Override
	public ContactSource getEntityById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ContactSource cs = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Contact_Sources cs WHERE cs.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			cs = new ContactSource();
			cs.setId(rs.getLong("id"));
			cs.setSource(rs.getString("source"));
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
		return cs;
	}

	@Override
	public void save(ContactSource entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("INSERT INTO Contact_Sources (source) VALUES (?)");
			ps.setString(1, entity.getSource());
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
	public void update(ContactSource entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("UPDATE Contact_Sources cs SET cs.source = ? WHERE cs.id = ?");
			ps.setString(1, entity.getSource());
			ps.setLong(2, entity.getId());
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
			ps = c.prepareStatement("DELETE FROM Contact_Sources cs WHERE cs.id = ?");
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
}
