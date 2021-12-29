package com.training.project.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.training.project.model.City;
import com.training.project.model.Country;
import com.training.project.model.Language;
import com.training.project.model.Sport;

//Create language table in db using hibernate
public class CreateLanguage {

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

			//Get country from db
			Country country1 =  session.get(Country.class, 1);
			Country country2 =  session.get(Country.class, 2);
			Country country3 =  session.get(Country.class, 3);
			Country country4 =  session.get(Country.class, 4);
			Country country5 =  session.get(Country.class, 5);

			//Add Langauage to db
			Language lang1 = new Language("English");
			Language lang2 = new Language("Malayalam");
			Language lang3 = new Language("Chinese");
			Language lang4 = new Language("French");

			//Add country to language
			lang1.addCountry(country1);
			lang1.addCountry(country4);
			lang2.addCountry(country3);
			lang3.addCountry(country2);
			lang4.addCountry(country5);

			session.save(lang1);
			session.save(lang2);
			session.save(lang3);
			session.save(lang4);

			session.getTransaction().commit();

		}

		finally {

			session.close();
			sessionFactory.close();

		}

	}

}
