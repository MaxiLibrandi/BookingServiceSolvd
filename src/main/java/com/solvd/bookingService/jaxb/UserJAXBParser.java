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

import com.solvd.bookingService.models.user.User;

public class UserJAXBParser {
	
	private String fileName;
	
	private static final Logger LOGGER = LogManager.getLogger(UserJAXBParser.class);

	public UserJAXBParser(String fileName) {
		this.fileName = fileName;
	}
	
	public List<User> XMLToUsers() {
		List<User> users = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Wrapper.class, User.class);
            Unmarshaller un = context.createUnmarshaller();
            Wrapper<User> wrapper = (Wrapper<User>) un.unmarshal(new StreamSource(fileName),Wrapper.class).getValue();
            users = wrapper.getItems();
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
        return users;
	}
	  
	public void UsersToXML(List<User> users) {
		try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class, User.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Wrapper<User> wrapper = new Wrapper<User>();
            wrapper.setItems(users);
            QName qName = new QName("users");
            JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName, Wrapper.class ,wrapper);
            m.marshal(jaxbElement,new File(fileName));
        } catch (JAXBException e) {
        	LOGGER.error(e);
        }
	}
}
