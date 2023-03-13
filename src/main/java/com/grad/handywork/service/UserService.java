package com.grad.handywork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grad.handywork.entity.User;
import com.grad.handywork.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public User saveUser(User user) {	
		return userRepository.save(user);
	}

}
