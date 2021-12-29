package com.training.project.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.training.project.model.City;
import com.training.project.model.Country;
import com.training.project.model.Language;
import com.training.project.model.Sport;

//Create sport table in db using hibernate
public class CreateSports {

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

			//Add sports to db
			Sport sport1 = new Sport("cricket");
			Sport sport2 = new Sport("tennis");
			Sport sport3 = new Sport("hockey");
			Sport sport4 = new Sport("basketball");
			Sport sport5 = new Sport("volleyball");
			Sport sport6 = new Sport("soccer");
			Sport sport7 = new Sport("football");
			Sport sport8 = new Sport("kabadi");

			//get country from db
			Country country1 = session.get(Country.class, 1);
			Country country2 = session.get(Country.class, 2);
			Country country3 = session.get(Country.class, 3);
			Country country4 = session.get(Country.class, 4);
			Country country5 = session.get(Country.class, 5);

			//Add sports to country
			country1.addSport(sport1);
			country1.addSport(sport2);
			country1.addSport(sport3);
			country2.addSport(sport1);
			country2.addSport(sport5);
			country2.addSport(sport4);
			country3.addSport(sport6);
			country3.addSport(sport7);
			country3.addSport(sport8);
			country4.addSport(sport4);
			country4.addSport(sport5);
			country5.addSport(sport3);
			country5.addSport(sport2);

			session.save(sport1);
			session.save(sport2);
			session.save(sport3);
			session.save(sport4);
			session.save(sport5);
			session.save(sport6);
			session.save(sport7);
			session.save(sport8);

			session.getTransaction().commit();

		}

		finally {

			session.close();
			sessionFactory.close();

		}

	}

}
