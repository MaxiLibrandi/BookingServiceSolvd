package com.solvd.bookingService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.bookingService.jaxb.AccommodationJAXBParser;
import com.solvd.bookingService.jaxb.CityJAXBParser;
import com.solvd.bookingService.jaxb.CountryJAXBParser;
import com.solvd.bookingService.jaxb.ReservationJAXBParser;
import com.solvd.bookingService.jaxb.UserJAXBParser;
import com.solvd.bookingService.jaxb.Wrapper;
import com.solvd.bookingService.models.accommodation.Accommodation;
import com.solvd.bookingService.models.information.*;
import com.solvd.bookingService.models.localization.City;
import com.solvd.bookingService.models.localization.Country;
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
		
		reservationStatusService.getReservationStatus().stream().forEach(rs -> LOGGER.debug(rs.toString()));
		
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

		roomTypeService.getRoomTypes().stream().forEach(rt -> LOGGER.debug(rt.toString()));
		
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
		
		userService.getUsers().stream().forEach(u -> LOGGER.debug(u.toString()));
		*/
		
		
		//STAX PARSER
		/*
		StAXParser parser = new StAXParser();
		List<User> users = null;
		try {
			users = parser.getUsersFromXML("src/main/resources/users.xml");
		} catch (NumberFormatException e) {
			LOGGER.error(e);
		} catch (XMLStreamException e) {
			LOGGER.error(e);
		}
		
		for(User u : users) {
			LOGGER.debug(u.toString());
			for (Contact c : u.getContacts()) {
				LOGGER.debug(c.toString());
			}
			for (Reservation r : u.getReservations()) {
				LOGGER.debug(r.toString());
			}
			for (Accommodation a : u.getAccommodations()) {
				LOGGER.debug(a.toString());
			}
		}
		*/
		
		//JAXB Parser
		
		AccommodationJAXBParser jaxbAccommodation = new AccommodationJAXBParser("src/main/resources/accommodations.xml");
		List<Accommodation> accommodations = jaxbAccommodation.XMLToAccommodations();
		accommodations.stream().forEach(a -> LOGGER.info(a.toString()));
		jaxbAccommodation.AccommodationsToXML(accommodations);
		
		CityJAXBParser jaxbCity = new CityJAXBParser("src/main/resources/cities.xml");
		List<City> cities = jaxbCity.XMLToCities();
		cities.stream().forEach(c -> LOGGER.info(c.toString()));
		jaxbCity.CitiesToXML(cities);
		
		CountryJAXBParser jaxbCountry = new CountryJAXBParser("src/main/resources/countries.xml");
		List<Country> countries = jaxbCountry.XMLToCountries();
		countries.stream().forEach(co -> LOGGER.info(co.toString()));
		jaxbCountry.CountriesToXML(countries);
		
		ReservationJAXBParser jaxbReservation = new ReservationJAXBParser("src/main/resources/reservations.xml");
		List<Reservation> reservations = jaxbReservation.XMLToReservations();
		reservations.stream().forEach(r -> LOGGER.info(r.toString()));
		jaxbReservation.ReservationsToXML(reservations);
		
		UserJAXBParser jaxbUser = new UserJAXBParser("src/main/resources/users.xml");
		List<User> users = jaxbUser.XMLToUsers();
		users.stream().forEach(u -> LOGGER.info(u.toString()));
		jaxbUser.UsersToXML(users);
		
		//JACKSON PARSER
		
		ObjectMapper objMapper = new ObjectMapper();
		
		List<Accommodation> jsonAccommodations = null;
		try {
			jsonAccommodations = objMapper.readValue(new File("src/main/resources/accommodation.json"), new TypeReference<List<Accommodation>>(){});
		} catch (JsonParseException e) {
			LOGGER.error(e);
		} catch (JsonMappingException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		jsonAccommodations.stream().forEach(a -> LOGGER.info(a.toString()));
		
		objMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		try {
			objMapper.writeValue(new File("src/main/resources/newAccommodation.json"), jsonAccommodations);
		} catch (JsonGenerationException e) {
			LOGGER.error(e);
		} catch (JsonMappingException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}		
	}
}
