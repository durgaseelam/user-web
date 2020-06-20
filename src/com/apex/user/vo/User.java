package com.apex.user.vo;

public class User {	
	private int userId;
	private String  firstName;
	public int getUserId() {
		return userId;
	}

	public User(int userId, String firstName, String lastName, String middleName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	private String	lastName;
	private String  middleName;
	
	public User() {
		
		// TODO Auto-generated constructor stub
	}
	
}
