package com.solvd.bookingService.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.bookingService.models.user.User;

public class UserJAXBParser {
	private String filename;
	
	private static final Logger LOGGER = LogManager.getLogger(UserJAXBParser.class);

	public UserJAXBParser(String filename) {
		this.filename = filename;
	}
	
	public User jaxbXMLToUsers() {
		User u = null;
		try {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Unmarshaller un = context.createUnmarshaller();
            u = (User) un.unmarshal(new File(filename));
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
        return u;
	}
	
	public void jaxbUserToXML(User u) {
		try {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(u, new File(filename));
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
	}
}
