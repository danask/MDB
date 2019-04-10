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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mis.model.*;
import com.mis.service.*;

@Controller
@SessionAttributes("User")
public class MovieController {

	private static final Logger logger = Logger.getLogger(MovieController.class);

	public MovieController() {
		System.out.println("MovieController");
	}

	@Autowired
	private MovieService movieService;

	
	@RequestMapping(value = "/searchMovie", method = RequestMethod.GET)
	public ModelAndView searchMovie(ModelAndView model, @ModelAttribute("User") User userSession) {
		Movie movie = new Movie();
		
		ModelAndView mv = new ModelAndView("movieSearch", "sessionInfo", userSession.getRole());
		mv.addObject("movie", movie);
		
		return mv;
	}
	
	
	@RequestMapping(value = "/searchMovieResult", method = RequestMethod.POST)
	public ModelAndView searchMovieResult(@RequestParam("movieTitle")String movieTitle,
									@RequestParam("movieArtist")String movieArtist,
//									@RequestParam("year")int year,
									@ModelAttribute("User") User userSession) throws IOException 
	{
		List<Movie> listMovie = movieService.getMovie(movieTitle, movieArtist);
        ModelAndView model = new ModelAndView("movieSearchResult", "sessionInfo", userSession.getRole());
        model.addObject("listMovie", listMovie);
		
		return model;
	}	
	
	@RequestMapping(value = "/listMovie")
	public ModelAndView listMovie(ModelAndView model, @ModelAttribute("User") User userSession) throws IOException 
	{
		List<Movie> listMovie = movieService.getAllMovies();
		ModelAndView mv = new ModelAndView("movieManagement","sessionInfo", userSession.getRole());
		mv.addObject("listMovie", listMovie);
		
		return mv;
	}
	
	@RequestMapping(value = "/addMovie", method = RequestMethod.GET)
	public ModelAndView addMovie(ModelAndView model, @ModelAttribute("User") User userSession) {
		Movie movie = new Movie();
		
		ModelAndView mv = new ModelAndView("movieRegistration","sessionInfo", userSession.getRole());
		mv.addObject("movie", movie);
		
		return mv;
	}


	@RequestMapping(value = "/saveMovie", method = RequestMethod.POST)
	public ModelAndView saveMovie(@RequestParam("id")String id,
								@RequestParam("movieTitle")String movieTitle,
								@RequestParam("movieArtist")String movieArtist,
								@RequestParam("year")int year,
								@RequestParam("description")String description,
								@ModelAttribute("User") User userSession
								) 
	{
		String msg = "Registered successfully";
		
		if(id.equals("0"))
		{
			Movie movie = new Movie(movieTitle, movieArtist, year, description);
			movieService.addMovie(movie);
			return new ModelAndView("fail", "sessionInfo", userSession.getRole());
		}
		else 
		{ 
			Movie movie = new Movie(Integer.parseInt(id), movieTitle, movieArtist, year, description);
			movieService.updateMovie(movie);  
			return new ModelAndView("redirect:/listMovie", "sessionInfo", userSession.getRole());
		}
	}
	
    @RequestMapping(value = "/deleteMovie", method = RequestMethod.GET)
    public ModelAndView deleteMovie(HttpServletRequest request, @ModelAttribute("User") User userSession) 
    {
        int id = Integer.parseInt(request.getParameter("id"));
        movieService.deleteMovie(id);
        return new ModelAndView("redirect:/listMovie", "sessionInfo", userSession.getRole());
    }
    
    @RequestMapping(value = "/editMovie", method = RequestMethod.GET)
    public ModelAndView editMovie(HttpServletRequest request, @ModelAttribute("User") User userSession) 
    {
        int movieId = Integer.parseInt(request.getParameter("id"));
        Movie movie = movieService.getMovie(movieId);
        ModelAndView model = new ModelAndView("movieRegistration", "sessionInfo", userSession.getRole());
        model.addObject("movie", movie);
 
        return model;
    }
}