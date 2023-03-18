package com.grad.handywork.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.grad.handywork.repo.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {

		try {
			return !userRepository.existsByUsername(username);
		} catch (NullPointerException e) {
			return true;
		}
	}

}
