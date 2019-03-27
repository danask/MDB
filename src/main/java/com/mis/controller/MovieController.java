package com.mis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mis.model.*;
import com.mis.service.*;

@Controller
public class MovieController {

	private static final Logger logger = Logger.getLogger(MovieController.class);

	public MovieController() {
		System.out.println("MovieController");
	}
	//comment

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/")
	public ModelAndView searchMovie(ModelAndView model) throws IOException 
	{
		// Temporarily
		List<Movie> listMovie = movieService.getAllMovies();
		model.addObject("listMovie", listMovie);
		model.setViewName("index");
	
		return model;
	}	
	
	@RequestMapping(value = "/listMovie")
	public ModelAndView listMovie(ModelAndView model) throws IOException 
	{
		// Temporarily
		List<Movie> listMovie = movieService.getAllMovies();
		model.addObject("listMovie", listMovie);
		model.setViewName("movieManagement");
	
		return model;
	}
	
	@RequestMapping(value = "/addMovie", method = RequestMethod.GET)
	public ModelAndView addMovie(ModelAndView model) {
		Movie movie = new Movie();
		model.addObject("movie", movie);
		model.setViewName("movieRegistration");
		return model;
	}


	@RequestMapping(value = "/saveMovie", method = RequestMethod.POST)
	public ModelAndView saveMovie(@RequestParam("id")String id,
								@RequestParam("movieTitle")String movieTitle,
								@RequestParam("movieArtist")String movieArtist,
								@RequestParam("year")int year,
								@RequestParam("description")String description
								) 
	{
		String msg = "Registered successfully";
		
		if(id.equals("0"))
		{
			Movie movie = new Movie(movieTitle, movieArtist, year, description);
			movieService.addMovie(movie);
			return new ModelAndView("result", "output", msg);
		}
		else 
		{ 
			Movie movie = new Movie(Integer.parseInt(id), movieTitle, movieArtist, year, description);
			movieService.updateMovie(movie);  
			return new ModelAndView("redirect:/listMovie");
		}
	}
	
    @RequestMapping(value = "/deleteMovie", method = RequestMethod.GET)
    public ModelAndView deleteMovie(HttpServletRequest request) 
    {
        int id = Integer.parseInt(request.getParameter("id"));
        movieService.deleteMovie(id);
        return new ModelAndView("redirect:/listMovie");
    }
    
    @RequestMapping(value = "/editMovie", method = RequestMethod.GET)
    public ModelAndView editMovie(HttpServletRequest request) 
    {
        int movieId = Integer.parseInt(request.getParameter("id"));
        Movie movie = movieService.getMovie(movieId);
        ModelAndView model = new ModelAndView("movieRegistration");
        model.addObject("movie", movie);
 
        return model;
    }
		
    @RequestMapping(value = "/updateMovie", method = RequestMethod.GET)
    public ModelAndView editMovie(HttpServletRequest request) 
    {
        int movieId = Integer.parseInt(request.getParameter("id"));
        Movie movie = movieService.getMovie(movieId);
        ModelAndView model = new ModelAndView("movieManagement");
        model.addObject("movie", movie);
 
        return model;
    }
}
