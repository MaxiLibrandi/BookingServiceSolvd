package com.solvd.bookingService.models.localization;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.solvd.bookingService.models.accommodation.Accommodation;

@XmlRootElement(name = "city")
@XmlType(propOrder = {"name", "countryId"})
public class City {
	private Long id;
	private String name;
	private Long countryId;
	private List<Accommodation> accommodations;

	public City() {
		
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}

	@XmlElement(name = "country_id")
	public Long getCountryId() {
		return countryId;
	}
	
	@XmlTransient
	public List<Accommodation> getAccommodations() {
		return accommodations;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	
	public void setAccommodations(List<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}
	
	@Override
	public String toString() {
		return "City id: " + this.id + " |name: " + this.name + " |countryId: " + this.countryId;
	}
}
