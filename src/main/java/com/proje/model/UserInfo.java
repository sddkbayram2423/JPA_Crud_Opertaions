package com.proje.model;

import java.util.Date;

public class UserInfo {
	
	private String userName;
	
	private String lastName;
	
	private Date birthDate;

	public UserInfo() {	}

	public UserInfo(String userName, String lastName, Date birthDate) {
		super();
		this.userName = userName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
	}

	
	
}
