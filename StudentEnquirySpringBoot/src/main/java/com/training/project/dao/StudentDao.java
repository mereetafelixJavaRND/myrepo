package com.training.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.project.model.Students;

@Repository
public interface StudentDao extends CrudRepository<Students, Integer>{

}
