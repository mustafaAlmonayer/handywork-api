package com.grad.handywork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.grad.handywork.dto.AuthDto;
import com.grad.handywork.dto.LoginDto;
import com.grad.handywork.entity.User;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.repo.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtService jwtService;

	public AuthDto authinticate(LoginDto loginDto) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
		);
		User user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow(
				() -> new ResourceNotFoundException("User With Username: " + loginDto.getUsername() + " Not Found")
		);
		String jwtToken = jwtService.generateToken(user);
		return AuthDto
				.builder()
				.token(jwtToken)
				.build();
	}

}
