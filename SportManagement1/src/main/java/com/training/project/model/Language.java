package com.training.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private int languageId;
	private String langugeName;

	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
			mappedBy = "language")
	List<Country> countries;

	public List<Country> getCountries() {
		return countries;
	}


	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}


	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getLanguageId() {
		return languageId;
	}


	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}


	public String getLangugeName() {
		return langugeName;
	}


	public void setLangugeName(String langugeName) {
		this.langugeName = langugeName;
	}


	public Language(String langugeName) {
		super();
		this.langugeName = langugeName;
	}

	public void addCountry(Country country) {
		if(countries == null) {
			countries = new ArrayList<Country>();
		}
		countries.add(country);
		country.setLanguage(this);
	}
}


