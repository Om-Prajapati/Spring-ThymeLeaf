package com.springthymeleaf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springthymeleaf.model.User;
import com.springthymeleaf.service.UserService;

@Controller
@RequestMapping("/user")
public class HelloController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {
		model.addAttribute("name", name);
		return "hello";
	}

	
	@RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView save(@Valid User user) {
		ModelAndView modelAndView = new ModelAndView();

		userService.saveUser(user);
		
		modelAndView.addObject("successMessage", "User has been registered successfully");
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
}