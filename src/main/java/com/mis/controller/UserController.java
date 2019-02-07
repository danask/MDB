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

import com.mis.model.User;
import com.mis.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = Logger
			.getLogger(UserController.class);

	public UserController() {
		System.out.println("UserController");
	}

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public ModelAndView listUser(ModelAndView model) throws IOException 
	{
		// Temporarily
		List<User> listUser = userService.getAllUsers();
		model.addObject("listUser", listUser);
		model.setViewName("index");
	
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@RequestParam("email")String email,
								@RequestParam("password")String password) 
										throws IOException 
	{
		String msg = "";
		
		User user = userService.getUserByEmailPwd(email, password);
		
		if(!user.getEmail().equalsIgnoreCase(null))
		{
			msg = "Welcome " + user.getEmail() + "!";
		}
		else {
			msg = "Invalid credentials";
		}

		return new ModelAndView("result", "output", msg);
	}	
		
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("userRegistration");
		return model;
	}


	
		
}