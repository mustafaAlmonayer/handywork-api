package com.grad.handywork.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.grad.handywork.repo.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		try {
			return !userRepository.existsByEmail(email);
		} catch (NullPointerException e) {
			return true;
		}

	}

}
