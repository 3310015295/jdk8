package com.luo.review.jdbc;

import java.util.Date;

public class Student {

	private int uuid;
	
	private String username;
	
	private Date birthDay;

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Student [uuid=" + uuid + ", username=" + username + ", birthDay=" + birthDay + "]";
	}
	
	
}
