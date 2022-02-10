package com.training.project.service;

import java.util.Optional;

import com.training.project.model.Enquiry;

public interface EnquiryService {

	void save(Enquiry enquiry);

	void deleteById(int id);

	Optional<Enquiry> getEnquiryById(int id);

	Iterable<Enquiry> getTodayEnquiry();

}
