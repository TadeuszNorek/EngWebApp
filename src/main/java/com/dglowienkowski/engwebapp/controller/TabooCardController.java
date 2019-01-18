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

import com.dglowienkowski.engwebapp.entity.TabooCard;
import com.dglowienkowski.engwebapp.service.TabooCardService;

@Controller
@RequestMapping("/taboocards")
public class TabooCardController {
	
	@Autowired
	private TabooCardService tabooCardService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
	@GetMapping("/list")
	public String listTabooCards(Model theModel) {
		
		List<TabooCard> tabooCards = tabooCardService.getTabooCards();
		
		theModel.addAttribute("tabooCards", tabooCards);
		
		logger.info("\nTaboo cards from db: " + tabooCards.toString());
		
		return "list-taboocards";	
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    
		String name = user.getUsername(); //get logged in username

		TabooCard theTabooCard = new TabooCard();
		
		//logger.info("\nLogger: user name is " + name);
		
		theTabooCard.setUsername(name);
		
		theModel.addAttribute("tabooCard", theTabooCard);
		
		return "taboo-add-form";
	}
	
	@PostMapping("/saveTabooCard")
	public String saveTabooCard(@ModelAttribute("tabooCard") TabooCard theTabooCard) {
		
		tabooCardService.saveTabooCard(theTabooCard);
		
		return "redirect:/taboocards/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("tabooCardId") int theId,
								 Model theModel	) {
		
		TabooCard theTabooCard = tabooCardService.getTabooCard(theId);
		
		theModel.addAttribute("tabooCard", theTabooCard);
		
		return "taboo-add-form";
	}
	
	@GetMapping("/delete")
	public String deleteTabooCard(@RequestParam("tabooCardId") int theId) {
		
		tabooCardService.deleteTabooCard(theId);
		
		return "redirect:/taboocards/list";
	}
}
