package com.solvd.bookingService;

import java.time.LocalDate;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.bookingService.models.accommodation.Accommodation;
import com.solvd.bookingService.models.information.*;
import com.solvd.bookingService.models.reservation.*;
import com.solvd.bookingService.models.user.*;
import com.solvd.bookingService.services.*;
import com.solvd.bookingService.staxParser.StAXParser;

public class Runner {

	private static final Logger LOGGER = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {	
		/*
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
		
		reservationStatus.setStatus("waiting");
		reservationStatusService.update(reservationStatus);
		
		reservationStatusService.delete(Integer.toUnsignedLong(1));
		
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
		

		roomType.setType("Kitchen");
		roomTypeService.update(roomType);
		
		roomTypeService.delete(Integer.toUnsignedLong(1));

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
		
		user.setName("John");
		userService.update(user);
		
		userService.delete(Integer.toUnsignedLong(1));
		
		LOGGER.debug(userService.getUsers().toString());
		*/
		
		StAXParser pars = new StAXParser();
		List<User> users = null;
		try {
			users = pars.getUsersFromXML("src/main/resources/users.xml");
		} catch (NumberFormatException e) {
			LOGGER.error(e);
		} catch (XMLStreamException e) {
			LOGGER.error(e);
		}
		
		for(User u : users) {
			LOGGER.debug("USER: " + u.getId() + " | " + u.getName() + " | " + u.getLastName() + " | " + u.getBirthDate().toString());
			for (Contact c : u.getContacts()) {
				LOGGER.debug("CONTACT: " + c.getId() + " | "+ c.getUserId() + " | " + c.getContactSourceId() + " | " + c.getContactData());
			}
			for (Reservation r : u.getReservations()) {
				LOGGER.debug("RESERVATION: " + r.getId() + " | "+ r.getGuestId() + " | " + r.getAccommodationId() + " | " + r.getDateFrom() + " | " + r.getDateTo() + " | " + r.getPrice() + " | " + r.getReservationStatusId() + " | " + r.getRating());
			}
			for (Accommodation a : u.getAccommodations()) {
				LOGGER.debug("ACCOMMODATION: " + a.getId() + " | " + a.getHostId() + " | " + a.getDirection() + " | " + a.getDescription() + " | " + a.getMaxCapacity() + " | " + a.getCityId());
			}
		}
	}
}
