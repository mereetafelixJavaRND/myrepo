package com.training.project.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.training.project.model.City;
import com.training.project.model.Country;
import com.training.project.model.Language;
import com.training.project.model.Sport;

//Create country table in db using hibernate
public class CreateCountry {

	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Country.class)
		.addAnnotatedClass(Sport.class)
		.addAnnotatedClass(Language.class)
		.addAnnotatedClass(City.class)
		.configure("com/training/project/resource/hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {

			//Add country to db
			Country country1 = new Country("India");
			Country country2 = new Country("China");
			Country country3 = new Country("UAE");
			Country country4 = new Country("Uk");
			Country country5 = new Country("Switzerland");

			session.save(country1);
			session.save(country2);
			session.save(country3);
			session.save(country4);
			session.save(country5);

			session.getTransaction().commit();

		}

		finally {

			session.close();
			sessionFactory.close();
		}

	}

}
