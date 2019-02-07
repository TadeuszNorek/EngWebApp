package com.dglowienkowski.engwebapp.controller;

import java.util.List;
import java.util.Random;
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
	
	@GetMapping("/taboocard/{username}")
	public TabooCard pickTabooCard(@PathVariable String username) {
		
		List<TabooCard> tabooCards = tabooCardService.getTabooCards(username);
		
		Random generator = new Random();
		int i = generator.nextInt(tabooCards.size());
		
		TabooCard card = tabooCards.get(i);
		//logger.info("\nTaboo cards from db: " + tabooCards.toString());
		return card;
	}
	
	@GetMapping("/headsupcard/{username}")
	public HeadsUpCard pickHeadsUpCard(@PathVariable String username) {
		
		List<HeadsUpCard> headsUpCards = headsUpCardService.getHeadsUpCards(username);
		logger.info("\nHeads Up cards from db: " + headsUpCards.toString());
		
		Random generator = new Random();
		int i = generator.nextInt(headsUpCards.size());
		
		HeadsUpCard card = headsUpCards.get(i);
		
		return card;
	}
	
	@GetMapping("/authentication")
	public boolean authentication() {
		return true;
	}
	
}
