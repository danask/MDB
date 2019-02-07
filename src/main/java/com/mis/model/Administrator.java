package com.mis.model;

import java.text.SimpleDateFormat;

public class Administrator extends Users 
										implements UserFunction
{
	public String type;
	public boolean userRoleChecker;
	public String lastUpdate;
	
	public Administrator(String name) {
		super(name);
		this.type = ADMIN;
	}
	
	
	public boolean isUserRoleChecker() {
		return userRoleChecker;
	}

	public void setUserRoleChecker(boolean userRoleChecker) {
		this.userRoleChecker = userRoleChecker;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	// for polymorphism: method from interface
	public void displayUserRole()
	{
		System.out.println("I can do assign a role to user and clean up the entire system data.");
	}
	
	
	// method from super-class
	@Override
	public void showStatus() {
		System.out.println("I am a " + this.type);
		backupSystem();
		rebootSystem();
	}

	
	// methods for Administrator
	private void displayUserRoleStatus() 
	{
		if(userRoleChecker)
			System.out.println("This is a list with status from User table.");
	}
	
	private void backupSystem() 
	{
		System.out.println("All data backed up in " + getLastUpdate());
	}
	
	private void rebootSystem() 
	{
		System.out.println("The system rebooted in " + getLastUpdate());
	}

}
