package com.mis.model;

public class UserManager  extends Users 
									implements UserFunction
{
	private String userId;
	private String type;
	private boolean userChecker;	
	
	
	// constructor
	public UserManager(String name) {
		super(name);
		this.type = USER_MGR;
	}
		
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isUserChecker() {
		return userChecker;
	}

	public void setUserChecker(boolean userChecker) {
		this.userChecker = userChecker;
	}

	
	// for polymorphism: method from interface
	public void displayUserRole()
	{
		System.out.println("I can see user list and delete a user.");
	}
	
	
	// method inherited from super-class
	public void showStatus() {
		System.out.println("I am a " + this.type);
		displayUserList();
	}
	
	// methods for UserManager
	private void displayUserList() 
	{
		if(userChecker)
			System.out.println("This is a list from User table.");
	}
	
	private boolean deleteUser(String id) 
	{
		if(id.length() > 0)
		{
			System.out.println(id + " is deleted in User table.");
			return true;
		}
		return false;
	}

}
