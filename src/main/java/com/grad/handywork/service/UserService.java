package com.grad.handywork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.grad.handywork.entity.User;
import com.grad.handywork.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User saveUser(User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return userRepository.save(user);
	}

}
