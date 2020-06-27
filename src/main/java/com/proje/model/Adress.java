package com.proje.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {
	private String street;
	private String road;
	private String city;
	
	public Adress() {	}

	public Adress(String street, String road, String city) {
		this.street = street;
		this.road = road;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Adress [" + street + "-" + road + "-" + city + "]";
	}
	

}
