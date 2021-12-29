package com.training.project.service;

import java.util.List;

import com.training.project.model.Country;

public interface CountryService {

	//Get country object from db
	Country getCountryObj(int id);

	//Get language object from db
	List getLangObj(int langId);

}
