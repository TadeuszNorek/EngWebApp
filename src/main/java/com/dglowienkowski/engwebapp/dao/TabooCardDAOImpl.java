package com.dglowienkowski.engwebapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dglowienkowski.engwebapp.entity.TabooCard;

@Repository
public class TabooCardDAOImpl implements TabooCardDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TabooCard> getTabooCards(String username) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<TabooCard> theQuery = 
				currentSession.createQuery("from TabooCard where username = :username OR username = 'default' order by id", 
											TabooCard.class);
		
		List<TabooCard> tabooCards = theQuery.setParameter("username", username).getResultList();
		
		return tabooCards;
	}

	@Override
	public void saveTabooCard(TabooCard theTabooCard) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theTabooCard);
		
	}

	@Override
	public TabooCard getTabooCard(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		TabooCard theTabooCard = currentSession.get(TabooCard.class, theId);
		
		return theTabooCard;
	}

	@Override
	public void deleteTabooCard(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("delete from TabooCard where id=:tabooCardId");
		theQuery.setParameter("tabooCardId", theId);
		theQuery.executeUpdate();

	}

}



