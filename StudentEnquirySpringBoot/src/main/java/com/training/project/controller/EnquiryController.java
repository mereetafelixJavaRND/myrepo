package com.training.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.exception.EnquiryNotFound;
import com.training.project.model.Enquiry;
import com.training.project.model.Students;
import com.training.project.service.EnquiryService;
import com.training.project.service.StudentService;


@RestController
@RequestMapping("/api/v2/ems")
public class EnquiryController {

	@Autowired
	EnquiryService service;

	@Autowired
	StudentService sservice;

	@PostMapping("/enquiry/{id}")
	public Enquiry saveEnquiry(@PathVariable int id, @RequestBody Enquiry enquiry){

		Optional<Students> studentOpt = sservice.getStudentById(id);
		Students student = studentOpt.get();
		if(student !=  null) {

			enquiry.setStudent(student);
			enquiry.setEnquiryId(0);
			enquiry.getCourse().setCourseId(0);
			service.save(enquiry);

		}

		return enquiry;

	}

	@PutMapping("/enquiry/{id}")
	public Enquiry updateEnquiry(@PathVariable int id, @RequestBody Enquiry enquiry) {

		Optional<Students> studentOpt = sservice.getStudentById(id);
		Students student = studentOpt.get();
		if(student !=  null) {

			enquiry.setStudent(student);
			service.save(enquiry);

		}else {

			throw new EnquiryNotFound("Enquiry id not found exception"+id);

		}

		return enquiry;

	}

	@DeleteMapping("/enquiry/{id}")
	public String deleteEnquiry(@PathVariable int id){

		Optional<Enquiry> enquiryOpt = service.getEnquiryById(id);
		Enquiry enquiry = enquiryOpt.get();
		if(enquiry==null)
		{

			throw new EnquiryNotFound("Enquiry id not found exception"+id);

		}

		service.deleteById(id);
		return "Deleted Enquiry Successfully";

	}

	@GetMapping("/todayEnquiryList")
	public List<Enquiry> getTodayEnquiry() {

		String todayDate = java.time.LocalDate.now().toString();
		Iterable<Enquiry>itrEnquiry = service.getTodayEnquiry();
		List<Enquiry>enqList = new ArrayList<Enquiry>();
		itrEnquiry.forEach(e -> {

			if(e.getEnquiryDate().equals(todayDate)) {

				enqList.add(e);

			}
		});

		return enqList;

	}

}
