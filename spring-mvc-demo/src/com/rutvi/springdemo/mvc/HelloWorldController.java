package com.rutvi.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// method to show initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// method to process the from 
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// modifying the parameters using model
	
	@RequestMapping("/processFormVersionTwo")
	public String shoutoutDude(HttpServletRequest request, Model model) {
		
		// get the name parameter
		String theName = request.getParameter("studentName");
		
		// change the name to caps
		theName = theName.toUpperCase();
		
		// create the msg
		String message = "YO! " + theName;
		
		//add the msg to model
		model.addAttribute("message", message);
		
		return "helloworld";
	}
	
	// verison 3 to use request parameter annotation
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName,
			Model model) {
	
		// change the name to caps
		theName = theName.toUpperCase();
		
		// create the msg
		String message = "Hey my friend from v3! " + theName;
		
		//add the msg to model
		model.addAttribute("message", message);
		
		return "helloworld";
	}
}
