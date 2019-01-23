package com.dglowienkowski.engwebapp.service;

import java.util.List;

import com.dglowienkowski.engwebapp.entity.TabooCard;

public interface TabooCardService {

	public List<TabooCard> getTabooCards(String username);
	
	public void saveTabooCard(TabooCard theTabooCard);
	
	public TabooCard getTabooCard(int theId);
	
	public void deleteTabooCard(int theId);
	
}
