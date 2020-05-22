package com.solvd.bookingService.dao.mySqlImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.bookingService.connectionPool.ConnectionPool;
import com.solvd.bookingService.dao.IDBConfigurationDAO;

public class DBConfigurationDAO implements IDBConfigurationDAO{

	private ConnectionPool connectionPool = ConnectionPool.getInstance();
	
	private static final Logger LOGGER = LogManager.getLogger(DBConfigurationDAO.class);
	
	@Override
	public void initDB() {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = connectionPool.getConnection();
			ps = c.prepareStatement("USE booking_service_db");
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
