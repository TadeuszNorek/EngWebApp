package com.dglowienkowski.engwebapp.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dglowienkowski.engwebapp.entity.HeadsUpCard;
import com.dglowienkowski.engwebapp.service.HeadsUpCardService;

@Controller
@RequestMapping("/headsupcards")
public class HeadsUpCardController {

	@Autowired
	private HeadsUpCardService headsUpCardService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	Authentication autentication = SecurityContextHolder.getContext().getAuthentication();
	
	@GetMapping("/list")
	public String listHeadsUpCards(Model theModel) {
		
		List<HeadsUpCard> headsUpCards = headsUpCardService.getHeadsUpCards();
		
		theModel.addAttribute("headsUpCards", headsUpCards);
		
		return "list-headsupcards";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    
		String name = user.getUsername(); //get logged in username
		
		HeadsUpCard theHeadsUpCard = new HeadsUpCard();
		
		theHeadsUpCard.setUsername(name);
		
		theModel.addAttribute("headsUpCard", theHeadsUpCard);
		
		return "headsup-add-form";
	}
	
	@PostMapping("/saveHeadsUpCard")
	public String saveHeadsUpCard(@ModelAttribute("headsUpCard") HeadsUpCard theHeadsUpCard) {

		headsUpCardService.saveHeadsUpCard(theHeadsUpCard);
		
		return "redirect:/headsupcards/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("headsUpCardId") int theId, 
								 Model theModel ) {
		
		HeadsUpCard theHeadsUpCard = headsUpCardService.getHeadsUpCard(theId);
		
		theModel.addAttribute("headsUpCard", theHeadsUpCard);
		
		return "headsup-add-form";
	}
	
	@GetMapping("/delete")
	public String deleteHeadsUpCard(@RequestParam("headsUpCardId") int theId) {
		
		headsUpCardService.deleteHeadsUpCard(theId);
		
		return "redirect:/headsupcards/list";
	}
}
