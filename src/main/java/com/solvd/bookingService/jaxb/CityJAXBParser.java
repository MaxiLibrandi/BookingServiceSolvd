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

import com.solvd.bookingService.models.localization.City;

public class CityJAXBParser {

	private String fileName;
	
	private static final Logger LOGGER = LogManager.getLogger(CityJAXBParser.class);
	
	public CityJAXBParser(String fileName) {
		this.fileName = fileName;
	}
	
	public List<City> XMLToCities(){
		List<City> cities = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Wrapper.class, City.class);
            Unmarshaller un = context.createUnmarshaller();
            Wrapper<City> wrapper = (Wrapper<City>) un.unmarshal(new StreamSource(fileName),Wrapper.class).getValue();
            cities = wrapper.getItems();
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
        return cities;
	}
	
	public void CitiesToXML(List<City> cities) {
		try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class, City.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Wrapper<City> wrapper = new Wrapper<City>();
            wrapper.setItems(cities);
            QName qName = new QName("cities");
            JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName, Wrapper.class ,wrapper);
            m.marshal(jaxbElement,new File(fileName));
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
	}
}
