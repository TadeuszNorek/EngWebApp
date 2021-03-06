package com.dglowienkowski.engwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		
		return "login";
		
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		
		return "welcome";
		
	}
	
	@GetMapping("/howToPlay")
	public String howToPlay() {
		
		return "how-to-play";
	
	}
	
}
