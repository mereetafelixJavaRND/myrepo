package com.training.project.dao;

import java.util.List;

import com.training.project.model.Country;

public interface CountryDao {

	//Get country object from db
	Country getCountryObj(int id);

	//Get language object from db
	List getLangObj(int id);

}
