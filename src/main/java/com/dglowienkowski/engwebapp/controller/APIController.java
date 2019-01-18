package com.dglowienkowski.engwebapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dglowienkowski.engwebapp.entity.TabooCard;
import com.dglowienkowski.engwebapp.service.TabooCardService;

@RestController
@RequestMapping("/api")
public class APIController {

	private TabooCardService tabooCardService;
	// TODO only api testing here
	@GetMapping("/cards")
	public List<TabooCard> listCards() {
		
		List<TabooCard> tabooCards = tabooCardService.getTabooCards();
		//TODO nie dzia³a, leci null :(
		return tabooCards;
	}
}
