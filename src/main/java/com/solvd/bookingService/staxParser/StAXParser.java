package com.solvd.bookingService.staxParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.bookingService.models.accommodation.Accommodation;
import com.solvd.bookingService.models.reservation.Reservation;
import com.solvd.bookingService.models.user.Contact;
import com.solvd.bookingService.models.user.User;

public class StAXParser {

	private static final Logger LOGGER = LogManager.getLogger(StAXParser.class);
	
	public List<User> getUsersFromXML(String pathToXML) throws NumberFormatException, XMLStreamException{
		
		List<User> userList = null;
		List<Contact> contactList = null;
		List<Reservation> reservationList = null;
		List<Accommodation> accommodationList = null;
		
		User user = null;
		Contact contact = null;
		Reservation reservation = null;
		Accommodation accommodation = null;
		
		File file = new File(pathToXML);
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader streamReader = null;
		try {
			streamReader = factory.createXMLStreamReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		}
		
        while(streamReader.hasNext())
        {
            streamReader.next();
            if(streamReader.getEventType() == XMLStreamReader.START_ELEMENT)
            {
                switch(streamReader.getLocalName().toLowerCase()) {
            	case "users":
            		userList = new ArrayList<User>();
            		break;
                case "contacts":
                	contactList = new ArrayList<Contact>();
                	break;
                case "reservations":
                	reservationList = new ArrayList<Reservation>();
                	break;
                case "accommodations":
                	accommodationList = new ArrayList<Accommodation>();
                	break;
            	case "user":
            		user = new User();  
                    if(streamReader.getAttributeCount() > 0) {
                        String id = streamReader.getAttributeValue(null,"id");
                        user.setId(Long.valueOf(id));
                    }
                    break;
                case "name":
					user.setName(streamReader.getElementText());
                	break;
                case "last_name":
					user.setLastName(streamReader.getElementText());
                	break;
                case "birth_date":
					user.setBirthDate(LocalDate.parse(streamReader.getElementText()));
                	break;
                case "contact":
                	contact = new Contact();
                	if(streamReader.getAttributeCount() > 0) {
                        String id = streamReader.getAttributeValue(null,"id");
                        contact.setId(Long.valueOf(id));
                    }
                	contact.setUserId(user.getId());
                	break;
                case "contact_source_id":
                	contact.setContactSourceId(Long.valueOf(streamReader.getElementText()));
                	break;
                case "contact_data":
                	contact.setContactData(streamReader.getElementText());
                	break;
                case "reservation":
                	reservation = new Reservation();
                	if(streamReader.getAttributeCount() > 0) {
                        String id = streamReader.getAttributeValue(null,"id");
                        reservation.setId(Long.valueOf(id));
                    }
                	reservation.setGuestId(user.getId());
                	break;
                case "accommodation_id":
                	reservation.setAccommodationId(Long.valueOf(streamReader.getElementText()));
                	break;
                case "date_from":
                	reservation.setDateFrom(LocalDate.parse(streamReader.getElementText()));
                	break;
                case "date_to":
                	reservation.setDateTo(LocalDate.parse(streamReader.getElementText()));
                	break;
                case "price":
                	reservation.setPrice(Float.valueOf(streamReader.getElementText()));
                	break;
                case "reservation_status_id":
                	reservation.setReservationStatusId(Long.valueOf(streamReader.getElementText()));
                	break;
                case "rating":
                	reservation.setRating(Integer.valueOf(streamReader.getElementText()));
                	break;
                case "accommodation":
                	accommodation = new Accommodation();
                	if(streamReader.getAttributeCount() > 0) {
                        String id = streamReader.getAttributeValue(null,"id");
                        accommodation.setId(Long.valueOf(id));
                    }
                	accommodation.setHostId(user.getId());
                	break;
                case "direction":
                	accommodation.setDirection(streamReader.getElementText());
                	break;
                case "description":
                	accommodation.setDescription(streamReader.getElementText());
                	break;
                case "max_capacity":
                	accommodation.setMaxCapacity(Integer.valueOf(streamReader.getElementText()));
                	break;
                case "city_id":
                	accommodation.setCityId(Long.valueOf(streamReader.getElementText()));
                	break;                    	
                default:
                	LOGGER.error("No match for start tag: " + streamReader.getLocalName());
                }
            }
             
            if(streamReader.getEventType() == XMLStreamReader.END_ELEMENT)
            {
            	switch(streamReader.getLocalName().toLowerCase()) {
            	case "user":
                    userList.add(user);
                    break;
            	case "contacts":
            		user.setContacts(contactList);
            		break;
            	case "contact":
            		contactList.add(contact);
            		break;
            	case "reservations":
            		user.setReservations(reservationList);
            		break;
            	case "reservation":
            		reservationList.add(reservation);
            		break;
            	case "accommodations":
            		user.setAccommodations(accommodationList);
            		break;
            	case "accommodation":
            		accommodationList.add(accommodation);
            		break;
                default:
                	LOGGER.error("No match for end tag: " + streamReader.getLocalName());
            	}
            }
        }
		return userList; 
	}
}
