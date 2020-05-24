package com.solvd.bookingService.models.localization;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "country")
@XmlType(propOrder = {"name", "continentId"})
public class Country {
	private Long id;
	private String name; 
	private Long continentId;
	private List<City> cities;
	
	public Country() {
		
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	@XmlElement(name = "continent_id")
	public Long getContinentId() {
		return continentId;
	}

	@XmlTransient
	public List<City> getCities() {
		return cities;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setContinentId(Long continentId) {
		this.continentId = continentId;
	}
	
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	@Override
	public String toString() {
		return "Country id: " + this.id + " |name: " + this.name + " |continentId: " + this.continentId;
	}
}
