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

import com.solvd.bookingService.models.localization.Country;

public class CountryJAXBParser {

	private String fileName;
	
	private static final Logger LOGGER = LogManager.getLogger(CountryJAXBParser.class);
	
	public CountryJAXBParser(String fileName) {
		this.fileName = fileName;
	}
	
	public List<Country> XMLToCountries(){
		List<Country> countries = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Wrapper.class, Country.class);
            Unmarshaller un = context.createUnmarshaller();
            Wrapper<Country> wrapper = (Wrapper<Country>) un.unmarshal(new StreamSource(fileName),Wrapper.class).getValue();
            countries = wrapper.getItems();
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
        return countries;
	}
	
	public void CountriesToXML(List<Country> countries) {
		try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class, Country.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Wrapper<Country> wrapper = new Wrapper<Country>();
            wrapper.setItems(countries);
            QName qName = new QName("countries");
            JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName, Wrapper.class ,wrapper);
            m.marshal(jaxbElement,new File(fileName));
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
	}
}
