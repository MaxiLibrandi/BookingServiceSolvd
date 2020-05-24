package com.solvd.bookingService.jaxb;

import java.util.List;
import javax.xml.bind.annotation.XmlAnyElement;

public class Wrapper<T> {
	
	private List<T> items;
	
	@XmlAnyElement(lax = true)
	public List<T> getItems() {
		return items;
	}
	
	public void setItems(List<T> items) {
		this.items = items;
	}
}
