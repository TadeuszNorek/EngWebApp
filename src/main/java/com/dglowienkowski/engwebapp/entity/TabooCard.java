package com.dglowienkowski.engwebapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taboo_cards")
public class TabooCard {

	
	// TODO dokonczyc to
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="keyword")
	private String keyword;
	
	@Column(name="taboo_word_1")
	private String tabooWord1;
	
	@Column(name="taboo_word_2")
	private String tabooWord2;
	
	@Column(name="taboo_word_3")
	private String tabooWord3;
	
	@Column(name="taboo_word_4")
	private String tabooWord4;
	
	@Column(name="taboo_word_5")
	private String tabooWord5;
}
