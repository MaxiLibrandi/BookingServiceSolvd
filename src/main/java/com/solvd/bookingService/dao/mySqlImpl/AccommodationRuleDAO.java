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
import com.solvd.bookingService.models.accommodation.AccommodationRule;


public class AccommodationRuleDAO implements IEntityDAO<AccommodationRule>{
	
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(AccommodationRuleDAO.class);

	@Override
	public List<AccommodationRule> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AccommodationRule> accommodationRules = new ArrayList<AccommodationRule>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Accommodation_Rules");
			rs = ps.executeQuery();
			while(rs.next()) {
				AccommodationRule ar = new AccommodationRule();
				ar.setId(rs.getLong("id"));
				ar.setRuleId(rs.getLong("rule_id"));
				ar.setAccommodationId(rs.getLong("accommodation_id"));
				accommodationRules.add(ar);
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
		return accommodationRules;
	}

	@Override
	public AccommodationRule getEntityById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AccommodationRule ar = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("SELECT * FROM Accommodation_Rules ar WHERE ar.id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			ar = new AccommodationRule();
			ar.setId(rs.getLong("id"));
			ar.setRuleId(rs.getLong("rule_id"));
			ar.setAccommodationId(rs.getLong("accommodation_id"));
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
		return ar;
	}

	@Override
	public void save(AccommodationRule entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("INSERT INTO Accomodation_Rules (rule_id,accommodation_id) VALUES (?,?)");
			ps.setLong(1,entity.getRuleId());
			ps.setLong(2,entity.getAccommodationId());
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
	public void update(AccommodationRule entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("UPDATE Accommodation_Rules ar SET ar.rule_id = ?, ar.accommodation_id = ? WHERE ar.id = ?");
			ps.setLong(1,entity.getRuleId());
			ps.setLong(2,entity.getAccommodationId());
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
			ps = c.prepareStatement("DELETE FROM Accommodation_Rules ar WHERE ar.id = ?");
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
