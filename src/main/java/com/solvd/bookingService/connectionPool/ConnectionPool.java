package com.solvd.bookingService.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {
	private static ConnectionPool cp;
	private BlockingQueue<Connection> connections;
	private Integer connectionsCount;
	public static final Integer POOL_SIZE = 5;
	private static final String DB_URL = "jdbc:mysql://192.168.99.100:33060/booking_service_db";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "secret";
	
	private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
	
	private ConnectionPool(){
		connections = new LinkedBlockingQueue<Connection>(POOL_SIZE);
		connectionsCount = 0;
	};
	
	public static ConnectionPool getInstance(){
		if(cp == null){
			synchronized (ConnectionPool.class){ 
				if(cp == null)
				{
					cp = new ConnectionPool();
				}
			}
		}
		return cp;
	}
	
	private void initConnection() {
		try {
			connections.add(DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	public Connection getConnection() throws InterruptedException {
		if(connections.size() == 0 && connectionsCount < POOL_SIZE ) {
			synchronized (ConnectionPool.class){
				if(connections.size() == 0 && connectionsCount < POOL_SIZE ) {
					initConnection();
					connectionsCount++;
				}
			}
		}
		return connections.take();
	}
	
	public void releaseConnection(Connection connectionReleased) {
		connections.offer(connectionReleased);
	}
}

