package com.dglowienkowski.engwebapp.dao;

import java.util.List;

import com.dglowienkowski.engwebapp.entity.HeadsUpCard;

public interface HeadsUpCardDAO {

	public List<HeadsUpCard> getHeadsUpCards(String username);
	
	public void saveHeadsUpCard(HeadsUpCard theHeadsUpCard);
	
	public HeadsUpCard getHeadsUpCard(int theId);
	
	public void deleteHeadsUpCard(int theId);
}
