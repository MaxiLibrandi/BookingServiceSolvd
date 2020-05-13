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
import com.solvd.bookingService.models.user.User;

public class UserDAO implements IEntityDAO<User>{

	private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

	@Override
	public List<User> getEntities() {
		Connection c = null;
		List<User> users = new ArrayList<User>();
		try {
			Class.forName(ConnectionPool.DB_DRIVER);
			c = ConnectionPool.getInstance().getConnection();
			PreparedStatement ps = c.prepareStatement("select * from Users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getLong("id"));
				u.setName(rs.getString("name"));
				u.setLastName(rs.getString("last_name"));
				u.setBirthDate(rs.getDate("birth_date").toLocalDate());
				users.add(u);
			}
			ps.close();
			rs.close();
		} catch (ClassNotFoundException e) {
			LOGGER.error(e);
		} catch (InterruptedException e) {
			LOGGER.error(e);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			ConnectionPool.getInstance().releaseConnection(c);
		}
		return users;
	}

	@Override
	public User getEntityById(Long id) {
		return null;
	}

	@Override
	public void save(User entity) {
		
	}

	@Override
	public void update(User entity) {
		
	}

	@Override
	public void delete(Long id) {
		
	}

}
