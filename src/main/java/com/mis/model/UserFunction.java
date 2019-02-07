package com.mis.model;

// for interface which should implement in the children class
public interface UserFunction 
{
	public static final String ADMIN = "Administrator";
	public static final String DBA = "Database Administrator";
	public static final String USER_MGR = "User Manager";
	public static final String GUEST = "Guest";
	
	public void displayUserRole();

}
