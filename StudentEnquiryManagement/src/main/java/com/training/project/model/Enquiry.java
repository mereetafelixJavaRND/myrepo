package com.training.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Enquiry {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enquiryId;
	private String enquiryDate;
	private String enquiryTitle;
	private String enquiryDesc;

	@ManyToOne(cascade=CascadeType.ALL)
	private Course course;

	@ManyToOne
	private Students student;


	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}
	public String getEnquiryDate() {
		return enquiryDate;
	}
	public void setEnquiryDate(String enquiryDate) {
		this.enquiryDate = enquiryDate;
	}
	public String getEnquiryTitle() {
		return enquiryTitle;
	}
	public void setEnquiryTitle(String enquiryTitle) {
		this.enquiryTitle = enquiryTitle;
	}
	public String getEnquiryDesc() {
		return enquiryDesc;
	}
	public void setEnquiryDesc(String enquiryDesc) {
		this.enquiryDesc = enquiryDesc;
	}

}
