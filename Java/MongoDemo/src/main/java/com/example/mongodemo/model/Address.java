package com.example.mongodemo.model;

public class Address {
	

	public int houseNumber;
	public int streetNumber;
	public long zipCode;
	
	public Address() {

	}
	
	public Address(int houseNumber, int streetNumber, long zipCode) {
		super();
		this.houseNumber = houseNumber;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
	}
	
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", streetNumber=" + streetNumber + ", zipCode=" + zipCode + "]";
	}

}
