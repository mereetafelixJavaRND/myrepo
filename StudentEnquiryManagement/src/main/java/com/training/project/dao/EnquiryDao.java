package com.training.project.dao;

import java.util.List;

import com.training.project.model.Enquiry;

public interface EnquiryDao {

	void save(Enquiry enquiry);

	void deleteById(int id);

	Enquiry getEnquiryById(int id);

	List<Enquiry> getTodayEnquiry(String todayDate);

}
