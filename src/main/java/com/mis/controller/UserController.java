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
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	public UserController() {
		System.out.println("UserController");
	}

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home")
	public ModelAndView home(ModelAndView model) throws IOException 
	{
		model.setViewName("home");
	
		return model;
	}
	
	@RequestMapping(value = "/listUser")
	public ModelAndView listUser(ModelAndView model) throws IOException 
	{
		List<User> listUser = userService.getAllUsers();
		model.addObject("listUser", listUser);
		model.setViewName("userManagement");
	
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@RequestParam("email")String email,
								@RequestParam("password")String password) 
										throws IOException 
	{
		String msg = "";
		
		User user = userService.getUserByEmailPwd(email, password);
		
		if(user == null)
		{
			msg = "Invalid credentials";
			return new ModelAndView("result", "output", msg);
		}
		else //if(!user.getEmail().equalsIgnoreCase(null))
		{
			msg = "Welcome " + user.getEmail() + "!";	
			return new ModelAndView("redirect:/home");
		}
	}	
		
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser(ModelAndView model) 
	{
		User user = new User();
		model.addObject("user", user);
		model.setViewName("userRegistration");
		return model;
	}
	//

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@RequestParam("id")String id,
								@RequestParam("email")String email,
								@RequestParam("password")String password,
								@RequestParam("name")String name,
								@RequestParam("phone")String phone
								) 
	{
		String role = "Guest";
		String msg = "Registered successfully";
		 
		if(id.equals("0"))
		{
			User user = new User(name, email, password, phone, role);
			userService.addUser(user);
			return new ModelAndView("result", "output", msg);
		}
		else 
		{ 
			User user = new User(Integer.parseInt(id), name, email, password, phone, role);
			userService.updateUser(user);  
			return new ModelAndView("redirect:/listUser");
		}
	}

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) 
    {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
        return new ModelAndView("redirect:/listUser");
    }
	
    
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) 
    {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUser(userId);
        ModelAndView model = new ModelAndView("userRegistration");
        model.addObject("user", user);
 
        return model;
    }
 
}
