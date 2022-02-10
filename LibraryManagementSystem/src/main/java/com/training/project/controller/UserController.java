package com.training.project.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.project.model.User;
import com.training.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("getUser")
	public String getBook(Model model) {

		model.addAttribute("user", new User());
		return "add-user";

	}

	@PostMapping("addUser")
	public String addBook(@Valid @ModelAttribute("user") User user, BindingResult result) {

		Date eDate = null;
		try {
			eDate = new SimpleDateFormat("yyyy-MM-dd").parse(user.getDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setExpiryDate(eDate);
		userService.saveOrUpdate(user);
		if(result.hasErrors()) {

			return "add-user";

		} else {

			return "redirect:/getUserList";

		}
	}

	@GetMapping("getUserList")
	public String getBookList(Model model) {

		List<User> user = userService.getAllUsers();
		model.addAttribute("users", user);
		return "update-delete-user";

	}

	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(Model model, @RequestParam("id") int id) {

		User user = userService.getUserById(id);
		model.addAttribute("users", user);
		return "display-add-user";

	}

	@GetMapping("delete")
	public String deleteBook(@RequestParam("id") int id) {

		userService.deleteUser(id);
		return "redirect:/getUserList";

	}
}
