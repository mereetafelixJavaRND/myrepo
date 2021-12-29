package com.training.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.training.project.model.City;
import com.training.project.model.Country;
import com.training.project.model.Language;
import com.training.project.model.Sport;

public class CountryDaoImpl implements CountryDao{

	//Get the configuration
	public Configuration getConfig() {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Country.class)
		.addAnnotatedClass(Sport.class)
		.addAnnotatedClass(Language.class)
		.addAnnotatedClass(City.class)
		.configure("com/training/project/resource/hibernate.cfg.xml");
		return cfg;
	}

	//Get country object from db
	@Override
	public Country getCountryObj(int id) {

		Configuration cfg = getConfig() ;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {

			Country tempCountry = session.get(Country.class, id);
			System.out.println(tempCountry.getSports());
			return tempCountry;

		}

		finally {

			session.close();
			sessionFactory.close();
		}

	}

	//Get language object from db
	@Override
	public List getLangObj(int id) {

		Configuration cfg = getConfig() ;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {

			Criteria criteria = session.createCriteria(Language.class, "language");
			criteria.createCriteria("language.countries", "country");
			Criterion langId = Restrictions.eq("language.languageId", id);
			Projection projection = Projections.property("country.countryName");
			criteria.setProjection(projection);
			criteria.add(langId);
			List list = criteria.list();
			return list;

		}

		finally {

			session.close();
			sessionFactory.close();

		}

	}

}
