package com.dglowienkowski.engwebapp.service;

import java.util.List;

import com.dglowienkowski.engwebapp.entity.TabooCard;

public interface TabooCardService {

	public List<TabooCard> getTabooCards();
	
	public void saveTabooCard(TabooCard theTabooCard);
	
	public TabooCard getTabooCard(int theId);
	
	public void deleteTabooCard(int theId);
	
}
