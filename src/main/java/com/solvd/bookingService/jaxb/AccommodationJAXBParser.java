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

import com.solvd.bookingService.models.accommodation.Accommodation;

public class AccommodationJAXBParser {

	private String fileName;
	
	private static final Logger LOGGER = LogManager.getLogger(AccommodationJAXBParser.class);
	
	public AccommodationJAXBParser(String fileName) {
		this.fileName = fileName;
	}
	
	public List<Accommodation> XMLToAccommodations(){
		List<Accommodation> accommodations = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Wrapper.class, Accommodation.class);
            Unmarshaller un = context.createUnmarshaller();
            Wrapper<Accommodation> wrapper = (Wrapper<Accommodation>) un.unmarshal(new StreamSource(fileName),Wrapper.class).getValue();
            accommodations = wrapper.getItems();
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
        return accommodations;
	}
	
	public void AccommodationsToXML(List<Accommodation> accommodations) {
		try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class, Accommodation.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Wrapper<Accommodation> wrapper = new Wrapper<Accommodation>();
            wrapper.setItems(accommodations);
            QName qName = new QName("accommodations");
            JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName, Wrapper.class ,wrapper);
            m.marshal(jaxbElement,new File(fileName));
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
	}
}
