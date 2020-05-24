package com.solvd.bookingService.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.bookingService.models.reservation.Reservation;

public class ReservationJAXBParser {

	private String fileName;
	
	private static final Logger LOGGER = LogManager.getLogger(ReservationJAXBParser.class);
	
	public ReservationJAXBParser(String fileName) {
		this.fileName = fileName;
	}
	
	public List<Reservation> XMLToReservations(){
		List<Reservation> reservations = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Wrapper.class, Reservation.class);
            Unmarshaller un = context.createUnmarshaller();
            Wrapper<Reservation> wrapper = (Wrapper<Reservation>) un.unmarshal(new StreamSource(fileName),Wrapper.class).getValue();
            reservations = wrapper.getItems();
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
        return reservations;
	}
	
	public void ReservationsToXML(List<Reservation> reservations) {
		try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class, Reservation.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Wrapper<Reservation> wrapper = new Wrapper<Reservation>();
            wrapper.setItems(reservations);
            QName qName = new QName("reservations");
            JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName, Wrapper.class ,wrapper);
            m.marshal(jaxbElement,new File(fileName));
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
	}
}
