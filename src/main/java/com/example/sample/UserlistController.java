package com.example.sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.DeleteMapping;
*/
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.example.sample.User;
import com.example.sample.UserService;
import com.example.sample.UserRepository;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("userlist")
public class UserlistController {

	@Autowired
    UserService userService;
	
	@Autowired
	UserRepository repository;
	
	@GetMapping
	public String list(Model model) {
		ArrayList<User> users = repository.findAll();
		model.addAttribute("users",users);
		return "userlist";
	}
	
	
}
