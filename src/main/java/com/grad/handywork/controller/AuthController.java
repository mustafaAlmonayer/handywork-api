package com.grad.handywork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grad.handywork.dto.AuthDto;
import com.grad.handywork.dto.LoginDto;
import com.grad.handywork.service.AuthService;

@RestController
@RequestMapping("/v1")
public class AuthController {
	
	@Autowired
	private AuthService authService;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthDto> login(@RequestBody LoginDto loginDto) {
		return new ResponseEntity<>(authService.authinticate(loginDto), HttpStatus.OK);
	}

}
