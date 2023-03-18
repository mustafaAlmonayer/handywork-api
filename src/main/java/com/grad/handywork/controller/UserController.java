package com.grad.handywork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grad.handywork.dto.AuthDto;
import com.grad.handywork.entity.User;
import com.grad.handywork.repo.UserRepository;
import com.grad.handywork.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/register")
	public ResponseEntity<AuthDto> register(@RequestBody @Valid User user) {
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		 User user = userRepository.findByUsername(username).get();
		 user.getJobs();
		return user;
	}

}