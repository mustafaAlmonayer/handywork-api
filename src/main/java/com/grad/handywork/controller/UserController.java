package com.grad.handywork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grad.handywork.dto.AuthDto;
import com.grad.handywork.dto.JobDto;
import com.grad.handywork.dto.UserDto;
import com.grad.handywork.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<AuthDto> register(@RequestBody @Validated UserDto userDto) {
		return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public ResponseEntity<UserDto> getUser(@PathVariable String username, @RequestHeader("Authorization") String BearerToken) {
		return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
	}
	
	@GetMapping("/{username}/job/all")
	public ResponseEntity<List<JobDto>> getAllJobsByUsername(@PathVariable String username) {
		return new ResponseEntity<>(userService.getAllJobsByUsername(username), HttpStatus.OK);
	}

}