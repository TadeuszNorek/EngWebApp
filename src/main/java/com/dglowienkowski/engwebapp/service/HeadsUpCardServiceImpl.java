package com.dglowienkowski.engwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dglowienkowski.engwebapp.dao.HeadsUpCardDAO;
import com.dglowienkowski.engwebapp.entity.HeadsUpCard;

@Service
public class HeadsUpCardServiceImpl implements HeadsUpCardService {

	@Autowired
	private HeadsUpCardDAO headsUpCardDAO;
	
	@Override
	@Transactional
	public List<HeadsUpCard> getHeadsUpCards() {

		return headsUpCardDAO.getHeadsUpCards();
	}

	@Override
	@Transactional
	public void saveHeadsUpCard(HeadsUpCard theHeadsUpCard) {

		headsUpCardDAO.saveHeadsUpCard(theHeadsUpCard);
	}

	@Override
	@Transactional
	public HeadsUpCard getHeadsUpCard(int theId) {

		return headsUpCardDAO.getHeadsUpCard(theId);
	}

	@Override
	@Transactional
	public void deleteHeadsUpCard(int theId) {
		headsUpCardDAO.deleteHeadsUpCard(theId);
	}

	
}
