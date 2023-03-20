package com.grad.handywork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grad.handywork.dto.AuthDto;
import com.grad.handywork.entity.User;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtService jwtService;

	public AuthDto saveUser(User user) {
		User savedUser = userRepository.save(user);
		String jwtToken = jwtService.generateToken(savedUser);
		return AuthDto.builder().token(jwtToken).build();
	}

	public User getUser(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
	}

}
