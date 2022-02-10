package com.training.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.project.model.Enquiry;

@Repository
public interface EnquiryDao extends CrudRepository<Enquiry, Integer>{



}
