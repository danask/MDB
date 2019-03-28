package com.mis.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mis.controller.MovieController;
import com.mis.model.Movie;
import com.mis.service.MovieService;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestBeanConfig.class})
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@ContextConfiguration (locations = {"file:src/main/webapp/WEB-INF/spring-servlet.xml"})

public class MovieTest {
	
	@Autowired
	private MovieController movieController;
	
	@Autowired
	private MovieService movieService;

	private static int TEST_COUNT= 3;
	private String id;
	private String password;
	private int originalCount = 0;
	private boolean isAdded = false;
	
	Movie currentMovie;
	Movie[] testMovie = new Movie[TEST_COUNT];
	
	
	@Before
	public void setUp() throws Exception 
	{
		// movie for login
		List<Movie> resultMovieList = movieService.getAllMovies();

		
		// check current status
		for(Movie u : resultMovieList)
		{
			System.out.println("Movie: " + u.toString());
			originalCount++;
		}

		// test movies
		for(int i = 0; i < TEST_COUNT; i++)
		{
			testMovie[i] = new Movie();
			
			testMovie[i].setMovieTitle("actionMovie" + i);
			testMovie[i].setMovieArtist("tester" + i);
			testMovie[i].setYear(2000 + i);
			testMovie[i].setDescription("Good movie"+ i);
		}	
		
		testMultipleFunctions();
	}

	
	@Test
	public void testMultipleFunctions()
	{
		addMovies();
		updateMovie();
		deleteMovie();
	}
	
	public void addMovies()
	{
		for(int i = 0; i < TEST_COUNT; i++)
		{

			assertThat(testMovie[i], instanceOf(Movie.class));
			System.out.println("Added Movie: " + testMovie[i].toString());
			
			try {
				movieService.addMovie(testMovie[i]);
				
				// check the result
				List<Movie> movie = (List<Movie>) movieService.getMovie(testMovie[i].getMovieTitle(), testMovie[i].getMovieArtist());
				assertThat(movie.get(0).getMovieTitle(), equalTo(testMovie[i].getMovieTitle()));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}	
	}
	
	
	public void updateMovie()
	{
		for(int i = 0; i < TEST_COUNT; i++)
		{
			try {
				List<Movie> movie = (List<Movie>) movieService.getMovie(testMovie[i].getMovieTitle(), testMovie[i].getMovieArtist());
				assertThat(movie.get(0).getMovieTitle(), equalTo(testMovie[i].getMovieTitle()));
				movie.get(0).setYear(2999);
				
				movieService.updateMovie(movie.get(0));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	
	public void deleteMovie()
	{		
		for(int i = 0; i < TEST_COUNT; i++)
		{
			try {
				List<Movie> movie = (List<Movie>)movieService.getMovie(testMovie[i].getMovieTitle(), testMovie[i].getMovieArtist());
				assertThat(movie.get(0).getMovieTitle(), equalTo(testMovie[i].getMovieTitle()));

				// check id to delete
				assertThat(movie.get(0).getId(), notNullValue());
				movieService.deleteMovie(movie.get(0).getId());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}		
		}
	}
	
	
	@Test
	public void getMovieList()
	{	
		int count = 0;
		
		List<Movie> resultMovieList = movieService.getAllMovies();

		for(Movie u : resultMovieList)
		{
			System.out.println("Movie: " + u.toString());
			count++;
		}
		
		// Check total count between AS-IS and TO-BE 
		assertThat(count, is(originalCount)); 
	}
}
