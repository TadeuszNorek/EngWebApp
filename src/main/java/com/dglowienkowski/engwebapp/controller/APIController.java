package com.dglowienkowski.engwebapp.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dglowienkowski.engwebapp.entity.HeadsUpCard;
import com.dglowienkowski.engwebapp.entity.TabooCard;
import com.dglowienkowski.engwebapp.service.HeadsUpCardService;
import com.dglowienkowski.engwebapp.service.TabooCardService;

@RestController
@RequestMapping("/api")
public class APIController {

	@Autowired
	private TabooCardService tabooCardService;
	
	@Autowired
	private HeadsUpCardService headsUpCardService;
	
	// TODO only api testing here
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@GetMapping("/taboocards/{username}")
	public List<TabooCard> listCards(@PathVariable String username) {
		
		List<TabooCard> tabooCards = tabooCardService.getTabooCards(username);
		
		//logger.info("\nTaboo cards from db: " + tabooCards.toString());
		return tabooCards;
	}
	
	@GetMapping("/headsupcards/{username}")
	public List<HeadsUpCard> listHeadsUpCards(@PathVariable String username) {
		
		List<HeadsUpCard> headsUpCards = headsUpCardService.getHeadsUpCards(username);
		
		logger.info("\nHeads Up cards from db: " + headsUpCards.toString());
		return headsUpCards;
	}
	
	@GetMapping("/authentication")
	public boolean authentication() {
		return true;
	}
	
}
