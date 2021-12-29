package com.training.project.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.training.project.model.City;
import com.training.project.model.Country;
import com.training.project.model.Language;
import com.training.project.model.Sport;


//Create table city on db using hibernate
public class CreateCity {

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

			//Add city to db
			City city1 = new City("Delhi");
			City city2 = new City("Beijing");
			City city3 = new City("Dubai");
			City city4 = new City("London");
			City city5 = new City("Bern");

			//Set city to country
			country1.setCity(city1);
			country2.setCity(city2);
			country3.setCity(city3);
			country4.setCity(city4);
			country5.setCity(city5);

			//Set country to city
			city1.setCountry(country1);
			city2.setCountry(country2);
			city3.setCountry(country3);
			city4.setCountry(country4);
			city5.setCountry(country5);

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
