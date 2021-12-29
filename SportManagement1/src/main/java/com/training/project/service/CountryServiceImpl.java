package com.training.project.service;

import java.util.List;

import com.training.project.dao.CountryDao;
import com.training.project.dao.CountryDaoImpl;
import com.training.project.model.Country;

public class CountryServiceImpl implements CountryService {

	CountryDao countryDao = new CountryDaoImpl();

	//Get country object from db
	@Override
	public Country getCountryObj(int id) {

		return countryDao.getCountryObj(id);

	}

	//Get language object from db
	@Override
	public List getLangObj(int langId) {

		return countryDao.getLangObj(langId);

	}



}
