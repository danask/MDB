package com.mis.model;

public class DataAdmin extends Users 
			implements UserFunction
{
	private String type;
	
	private boolean cleanUpDatabase;
	private boolean isEmpty;
	
	// constructor 
	public DataAdmin(String name) {
		super(name);
		this.type = DBA;
	}
	 //methods and setter methods
	 
	public boolean isCleanUpDatabase() {
		return cleanUpDatabase;
	}

	public void setCleanUpDatabase(boolean cleanUpDatabase) {
		this.cleanUpDatabase = cleanUpDatabase;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}


	// for polymorphism: method from interface
	public void displayUserRole()
	{
		System.out.println("I can sign up, log in, search the movie data, and insert/delete a movie data");
	}
	
	// method inherited from super-class
	public void showStatus() {
		System.out.println("I am a " + this.type);
		
		if(!isEmpty())
			displayMovieList();
	}

	
	
	// just work for this assignment 
	// -> these will be refactored and moved to the movie implementation class later.
	
	// method overloading
	public void insertData(String movieTitle)
	{
		System.out.println("Inserted: " + movieTitle);
	}
	
	public void insertData(String movieTitle, String movieArtist)
	{
		System.out.println("Inserted: " + movieTitle + ", " + movieArtist);
	}
	
	public void insertData(String movieTitle, String movieArtist, int year)
	{
		System.out.println("Inserted: " + movieTitle + ", " + movieArtist + ", " + year);
	}
	
	public void insertData(Movie movieInformation)
	{
		System.out.println("Inserted: " + movieInformation.getMovieTitle() + ", " + 
										movieInformation.getMovieArtist()  + ", " + 
										movieInformation.getYear()+ ", " + 
										movieInformation.getDescription());
	}
	
	public void displayMovieList()
	{
		System.out.println("Movie list has been shown");
	}
	
	public void deleteData(String movieId)
	{
		System.out.println("Delete: "+ movieId);
	}
}
