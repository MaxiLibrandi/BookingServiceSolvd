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
import com.solvd.bookingService.models.accommodation.AccommodationService;

public class AccommodationServiceDAO implements IEntityDAO<AccommodationService>{
	
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	private static final Logger LOGGER = LogManager.getLogger(AccommodationServiceDAO.class);
	
	private static final String GET_ALL = "SELECT * FROM Accommodation_Services";
	private static final String GET_BY_ID = "SELECT * FROM Accommodation_Services asv WHERE asv.id = ?";
	private static final String INSERT = "INSERT INTO Accomodation_Services (service_id,accommodation_id) VALUES (?,?)";
	private static final String UPDATE = "UPDATE Accommodation_Services asv SET asv.service_id = ?, asv.accommodation_id = ? WHERE asv.id = ?";
	private static final String DELETE = "DELETE FROM Accommodation_Services asv WHERE asv.id = ?";
	
	@Override
	public AccommodationService buildModel(ResultSet rs) {
		AccommodationService asv = new AccommodationService();
		try {
			asv.setId(rs.getLong("id"));
			asv.setServiceId(rs.getLong("service_id"));
			asv.setAccommodationId(rs.getLong("accommodation_id"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return asv;
	}
	
	@Override
	public List<AccommodationService> getEntities() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AccommodationService> accommodationServices = new ArrayList<AccommodationService>();
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				AccommodationService asv = buildModel(rs);
				accommodationServices.add(asv);
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
		return accommodationServices;
	}

	@Override
	public AccommodationService getEntityById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AccommodationService asv = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(GET_BY_ID);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			asv = buildModel(rs);
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
		return asv;
	}

	@Override
	public void save(AccommodationService entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(INSERT);
			ps.setLong(1,entity.getServiceId());
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
	public void update(AccommodationService entity) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement(UPDATE);
			ps.setLong(1,entity.getServiceId());
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

}
