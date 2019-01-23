package com.dglowienkowski.engwebapp.dao;

import java.util.List;

import com.dglowienkowski.engwebapp.entity.TabooCard;

public interface TabooCardDAO {

	public List<TabooCard> getTabooCards(String username);
	
	public void saveTabooCard(TabooCard theTabooCard);
	
	public TabooCard getTabooCard(int theId);
	
	public void deleteTabooCard(int theId);
	
}
