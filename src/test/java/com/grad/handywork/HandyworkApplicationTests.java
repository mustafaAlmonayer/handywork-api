package com.grad.handywork;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grad.handywork.repo.UserRepository;

@SpringBootTest
class HandyworkApplicationTests {

	@Autowired
	UserRepository userRepository;
	
	@Test
	void contextLoads() {
		
		System.out.println(userRepository.existsByPhoneNumber("078888888"));
		
	}

}
