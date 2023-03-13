package com.grad.handywork.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.grad.handywork.repo.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniquePhoneNumberValidator implements ConstraintValidator<UniquePhoneNumber, String> {
	
	@Autowired
	UserRepository userRepository;
	
    @Override
    public void initialize(UniquePhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		try {
			return !userRepository.existsByPhoneNumber(phoneNumber);
		} catch (NullPointerException e) {
			return true;
		}
	}

}
