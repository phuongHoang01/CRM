package com.CRM_Entity;

public class User {
	private int id;
	private String email;
	private String password;
	private String fullName;
	private String avatar;
	private String description;
	private int roleID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User(int id, String email, String password, String fullName, String avatar, int roleID) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.avatar = avatar;
		this.roleID = roleID;
	}
	
	public User(String email, String password, String fullName, String avatar, int roleID) {
	
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.avatar = avatar;
		this.roleID = roleID;
	}

	public User() {
		
	}

	public User(String email2, String fullName2, String avatar2, int roleID2) {
		// TODO Auto-generated constructor stub
		this.email = email2;
		this.fullName = fullName2;
		this.avatar = avatar2;
		this.roleID = roleID2;
	}

	
}
