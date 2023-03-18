package com.grad.handywork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.grad.handywork.dto.AuthDto;
import com.grad.handywork.entity.User;
import com.grad.handywork.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CloudinaryService cloudinaryService;
	
	@Autowired
	private JwtService jwtService;

	public AuthDto saveUser(User user) {
		user.setPfpUrl(cloudinaryService.imageToUrl(user.getPfpFile()));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User savedUser = userRepository.save(user);
		String jwtToken =jwtService.generateToken(savedUser);
		return AuthDto
				.builder()
				.token(jwtToken)
				.build();
	}

}
