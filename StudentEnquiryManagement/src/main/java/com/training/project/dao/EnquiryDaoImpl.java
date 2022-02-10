package com.training.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.training.project.model.Enquiry;

@Repository
@EnableTransactionManagement
public class EnquiryDaoImpl implements EnquiryDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Enquiry enquiry) {

		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(enquiry);

	}

	@Override
	@Transactional
	public void deleteById(int enquiryId) {

		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from Enquiry where enquiryId=:enquiryId");
		query.setParameter("enquiryId", enquiryId);
		query.executeUpdate();

	}

	@Override
	@Transactional
	public Enquiry getEnquiryById(int id) {

		Session session = entityManager.unwrap(Session.class);
		Enquiry enquiry =session.get(Enquiry.class, id);
		return enquiry;

	}

	@Override
	@Transactional
	public List<Enquiry> getTodayEnquiry(String enquiryDate) {

		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Enquiry where enquiryDate=:enquiryDate");
		query.setParameter("enquiryDate", enquiryDate);
		return query.getResultList();

	}

}
