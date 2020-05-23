package com.solvd.bookingService.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.bookingService.models.user.User;

public class UserJAXBParser {
	private String filename;
	
	private static final Logger LOGGER = LogManager.getLogger(UserJAXBParser.class);

	public UserJAXBParser(String filename) {
		this.filename = filename;
	}
	
	public List<User> jaxbXMLToUser() {
		List<User> users = null;
		try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class,User.class);
            Unmarshaller un = context.createUnmarshaller();
			Wrapper<User> wrapper = (Wrapper<User>) un.unmarshal(new StreamSource(filename),Wrapper.class).getValue();
            users = wrapper.getItems();
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
        return users;
	}
	
	//DO THE MARSHAL FOR LIST OF USERS
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
