package com.mis.model;

//for inheritance and polymorphism

public abstract class Users 
{
	private int id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String role;
	
	// constructor
	public Users(String name)
	{
		this.name = name;
		System.out.println(this.name + " instance was created...");
	}
		
	// methods for encapsulation

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", password=" + password + ", role=" + role + "]";
	}


	// common methods
	public void registerUser(String name, String role) 
	{
		System.out.println(this.name + " is successfully registered in User table.");
	}


	public boolean loginUser(String id, String password) 
	{
		if(id.length() > 0 && password.length() > 0)
		{
			System.out.println("-------------------------------");
			System.out.println(this.name + " has logged in");
			System.out.println("-------------------------------");
			
			return true;
		}
		return false;
	}

	public boolean logoutUser(String id) 
	{
		if(id.length() > 0)
		{
			System.out.println(this.name + " has logged out");
			return true;
		}
		return false;
	}	
	
	// This method should be overridden
//	public abstract void create();  
//	public abstract void read();
//	public abstract void update();
//	public abstract void delete();
	public abstract void showStatus();

}
