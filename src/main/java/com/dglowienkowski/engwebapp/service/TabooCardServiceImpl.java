package com.dglowienkowski.engwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dglowienkowski.engwebapp.dao.TabooCardDAO;
import com.dglowienkowski.engwebapp.entity.TabooCard;

@Service
public class TabooCardServiceImpl implements TabooCardService {

	@Autowired
	private TabooCardDAO tabooCardDAO;
	
	@Override
	@Transactional
	public List<TabooCard> getTabooCards() {

		return tabooCardDAO.getTabooCards();
	}

	@Override
	@Transactional
	public void saveTabooCard(TabooCard theTabooCard) {

		tabooCardDAO.saveTabooCard(theTabooCard);
	}

	@Override
	@Transactional
	public TabooCard getTabooCard(int theId) {

		return tabooCardDAO.getTabooCard(theId);
	}

	@Override
	@Transactional
	public void deleteTabooCard(int theId) {

		tabooCardDAO.deleteTabooCard(theId);
	}

}
