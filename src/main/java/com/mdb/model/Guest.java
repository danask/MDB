package com.mdb.model;

public class Guest extends Users implements UserFunction
{
	private String type;
	private String searchMovieKeyword;
	private String preferenceType;
	
	public Guest(String name) {
		super(name);
		this.type = GUEST;
	}

	public String getSearchMovieKeyword() {
		return searchMovieKeyword;
	}

	public void setSearchMovieKeyword(String searchMovieKeyword) {
		this.searchMovieKeyword = searchMovieKeyword;
	}

	public String getPreferenceType() {
		return preferenceType;
	}

	public void setPreferenceType(String preferenceType) {
		this.preferenceType = preferenceType;
	}


	// for polymorphism: method from interface
	public void displayUserRole()
	{
		System.out.println("I can sign up, log in and search the movie data.");
	}
	
	// method inherited from super-class
	public void showStatus() 
	{
		System.out.println("I am a " + this.type);
		searchMovies();
	}

	
	// only work for this class
	// method overloading for polymophism
	private void searchMovies()
	{
		System.out.println("Here are movie list which we can searche in the movie database.");
	}
	
	private void searchMovies(String searchMovieKeyword)
	{
		if(this.searchMovieKeyword.length() > 0)
			System.out.println(searchMovieKeyword + "was searched in the movie database.");
	}
	
	private void searchMovies(String searchMovieKeyword, String preferenceType)
	{
		if(this.searchMovieKeyword.length() > 0 && this.preferenceType.length() > 0)
			System.out.println("Movies of " + preferenceType + "was searched the movie data in "+ searchMovieKeyword);
	}

}
