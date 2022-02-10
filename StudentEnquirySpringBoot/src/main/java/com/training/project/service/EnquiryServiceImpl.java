package com.training.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.project.dao.EnquiryDao;
import com.training.project.model.Enquiry;

@Service
public class EnquiryServiceImpl implements EnquiryService {


	@Autowired
	EnquiryDao edao;

	@Override
	@Transactional
	public void save(Enquiry enquiry) {

		edao.save(enquiry);

	}

	@Override
	@Transactional
	public Optional<Enquiry> getEnquiryById(int id) {

		return edao.findById(id);

	}

	@Override
	@Transactional
	public Iterable<Enquiry> getTodayEnquiry() {

		return edao.findAll();

	}

	@Override
	@Transactional
	public void deleteById(int id) {

		edao.deleteById(id);

	}

}
