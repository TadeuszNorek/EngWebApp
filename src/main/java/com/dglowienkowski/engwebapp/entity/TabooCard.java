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

	public TabooCard() {
		
	}

	public TabooCard(String keyword, String tabooWord1, String tabooWord2, String tabooWord3, String tabooWord4,
			String tabooWord5) {
		this.keyword = keyword;
		this.tabooWord1 = tabooWord1;
		this.tabooWord2 = tabooWord2;
		this.tabooWord3 = tabooWord3;
		this.tabooWord4 = tabooWord4;
		this.tabooWord5 = tabooWord5;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getTabooWord1() {
		return tabooWord1;
	}

	public void setTabooWord1(String tabooWord1) {
		this.tabooWord1 = tabooWord1;
	}

	public String getTabooWord2() {
		return tabooWord2;
	}

	public void setTabooWord2(String tabooWord2) {
		this.tabooWord2 = tabooWord2;
	}

	public String getTabooWord3() {
		return tabooWord3;
	}

	public void setTabooWord3(String tabooWord3) {
		this.tabooWord3 = tabooWord3;
	}

	public String getTabooWord4() {
		return tabooWord4;
	}

	public void setTabooWord4(String tabooWord4) {
		this.tabooWord4 = tabooWord4;
	}

	public String getTabooWord5() {
		return tabooWord5;
	}

	public void setTabooWord5(String tabooWord5) {
		this.tabooWord5 = tabooWord5;
	}

	@Override
	public String toString() {
		return "TabooCard [id=" + id + ", username=" + username + ", keyword=" + keyword + ", tabooWord1=" + tabooWord1
				+ ", tabooWord2=" + tabooWord2 + ", tabooWord3=" + tabooWord3 + ", tabooWord4=" + tabooWord4
				+ ", tabooWord5=" + tabooWord5 + "]";
	}


	
}
