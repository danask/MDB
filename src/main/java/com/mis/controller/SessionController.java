package com.mis.controller;

import java.io.IOException;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mis.model.Movie;
import com.mis.model.User;
import com.mis.service.UserService;

@Controller
@SessionAttributes("User")
public class SessionController {


	private static final Logger logger = Logger.getLogger(SessionController.class);

	public SessionController() {
		System.out.println("SessionController");
	}

	@Autowired
	private UserService userService;
	
	
   @ModelAttribute("User")
   public User setUpUserForm() {
      return new User();
   }

	@RequestMapping(value = "/")
	public ModelAndView index(ModelAndView model, @ModelAttribute("User") User userSession) throws IOException 
	{
		userSession.setName("");
		userSession.setRole("");
		System.out.println("Welcome " + userSession.getEmail() + " / " + userSession.getRole()  + "!");	
		
		return new ModelAndView("index","sessionInfo", userSession.getRole());
	}
   
	@RequestMapping(value = "/home")
	public ModelAndView home(ModelAndView model, 
							@ModelAttribute("User") User userSession) 
									throws IOException 
	{
		return new ModelAndView("home", "sessionInfo", userSession.getRole());
	}
   
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@RequestParam("email")String email,
								@RequestParam("password")String password,
								@ModelAttribute("User") User userSession) 
										throws IOException 
	{
		String msg = "";
		
		User user = userService.getUserByEmailPwd(email, password);
		
		if(user == null)
		{
			msg = "Invalid credentials";
			return new ModelAndView("fail", "sessionInfo", userSession.getRole());
		}
		else //if(!user.getEmail().equalsIgnoreCase(null))
		{
			userSession.setName(user.getEmail());
			userSession.setRole(user.getRole());
			System.out.println("Welcome " + userSession.getEmail() + " / " + userSession.getRole()  + "!");	
			
			return new ModelAndView("home", "sessionInfo", userSession.getRole());
		}
	}	
}