package com.solvd.bookingService;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.bookingService.models.information.*;
import com.solvd.bookingService.models.reservation.*;
import com.solvd.bookingService.models.user.*;
import com.solvd.bookingService.services.*;

public class Runner {

	private static final Logger LOGGER = LogManager.getLogger(Runner.class);

	
	public static void main(String[] args) {	
		
		DBConfigurationService dbConfigurationService = new DBConfigurationService();
		dbConfigurationService.initDB();
		
		ReservationStatusService reservationStatusService = new ReservationStatusService();
		ReservationStatus reservationStatus;
		
		reservationStatus = new ReservationStatus();
		reservationStatus.setStatus("pending");
		reservationStatusService.save(reservationStatus);
		
		reservationStatus = new ReservationStatus();
		reservationStatus.setStatus("cancelled");
		reservationStatusService.save(reservationStatus);
		
		reservationStatus = new ReservationStatus();
		reservationStatus.setStatus("accepted");
		reservationStatusService.save(reservationStatus);
		
		LOGGER.debug(reservationStatusService.getReservationStatus().toString());
		
		RoomTypeService roomTypeService = new RoomTypeService();
		RoomType roomType;
		
		roomType = new RoomType();
		roomType.setType("Bedroom");
		roomTypeService.save(roomType);
		
		roomType = new RoomType();
		roomType.setType("Bathroom");
		roomTypeService.save(roomType);
		
		roomType = new RoomType();
		roomType.setType("Living Room");
		roomTypeService.save(roomType);
		

		LOGGER.debug(roomTypeService.getRoomTypes().toString());
		
		UserService userService = new UserService();
		User user;
		
		user = new User();
		user.setName("Maximo");
		user.setLastName("Librandi");
		user.setBirthDate(LocalDate.of(1997, 7, 3));
		userService.save(user);
		
		user = new User();
		user.setName("Johny");
		user.setLastName("Wilson");
		user.setBirthDate(LocalDate.of(1987, 9, 17));
		userService.save(user);
		
		LOGGER.debug(userService.getUsers().toString());
	}
}
