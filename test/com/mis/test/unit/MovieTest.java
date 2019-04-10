package com.mis.test.unit;

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
	}

	
	@Test
	public void movieTest()
	{
		// test movies
		for(int i = 0; i < TEST_COUNT; i++)
		{
			testMovie[i] = new Movie();
			
			testMovie[i].setMovieTitle("actionMovie" + i);
			testMovie[i].setMovieArtist("tester" + i);
			testMovie[i].setYear(2000 + i);
			testMovie[i].setDescription("Good movie"+ i);
			
			assertEquals(testMovie[i].getMovieTitle(), "actionMovie" + i);
			assertEquals(testMovie[i].getMovieArtist(), "tester" + i);
			assertEquals(testMovie[i].getYear(), 2000 + i);
			assertEquals(testMovie[i].getDescription(), "Good movie"+ i);
		}	
	}
}
