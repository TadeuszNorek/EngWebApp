package com.dglowienkowski.engwebapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dglowienkowski.engwebapp.entity.HeadsUpCard;

@Repository
public class HeadsUpCardDAOImpl implements HeadsUpCardDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<HeadsUpCard> getHeadsUpCards() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<HeadsUpCard> theQuery = 
				currentSession.createQuery("from HeadsUpCard order by id",
											HeadsUpCard.class);
		
		List<HeadsUpCard> headsUpCards = theQuery.getResultList();
		
		return headsUpCards;
	}

	@Override
	public void saveHeadsUpCard(HeadsUpCard theHeadsUpCard) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theHeadsUpCard);
	}

	@Override
	public HeadsUpCard getHeadsUpCard(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		HeadsUpCard theHeadsUpCard = currentSession.get(HeadsUpCard.class, theId);
		
		return theHeadsUpCard;
	}

	@Override
	public void deleteHeadsUpCard(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("delete from HeadsUpCard where id=:headsUpCardId");
		theQuery.setParameter("headsUpCardId", theId);
		theQuery.executeUpdate();
	}

}












