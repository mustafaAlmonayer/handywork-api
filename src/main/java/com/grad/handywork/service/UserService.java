package com.grad.handywork.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.grad.handywork.dto.AuthDto;
import com.grad.handywork.dto.CityDto;
import com.grad.handywork.dto.EmailDto;
import com.grad.handywork.dto.FirstAndLastNameDto;
import com.grad.handywork.dto.JobDto;
import com.grad.handywork.dto.PasswordDto;
import com.grad.handywork.dto.PfpFileDto;
import com.grad.handywork.dto.PhoneNumberDto;
import com.grad.handywork.dto.UserDto;
import com.grad.handywork.dto.UsernameDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.entity.User;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.mapper.JobMapper;
import com.grad.handywork.mapper.UserMapper;
import com.grad.handywork.repo.JobRepository;
import com.grad.handywork.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JobMapper jobMapper;

	public AuthDto saveUser(UserDto user) {
		User savedUser = userRepository.save(userMapper.userDtoToUserWithoutId(user));
		String jwtToken = jwtService.generateToken(savedUser);
		return AuthDto.builder().token(jwtToken).build();
	}

	public UserDto getUser(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
		return userMapper.userToUserDtoWithoutIdandPassword(user);
	}
	
	public List<JobDto> getAllJobsByUsername(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
		List<Job> jobs = jobRepository.findAllByOwnerId(user.getId(), Sort.by(Direction.DESC, "publishDate"));
		List<JobDto> dtos = new ArrayList<>();
		jobs.stream()
			.forEach(
					(job) -> dtos.add(jobMapper.jobToJobDto(job))
			);
		return dtos;
				
	}

	public void updateUsername(String username, UsernameDto usernameDto) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
		user.setUsername(usernameDto.getUsername());
		userRepository.save(user);
	}
	
	public void updateEmail(String username, EmailDto emailDto) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
		user.setEmail(emailDto.getEmail());
		userRepository.save(user);
	}
	
	public void updatePhoneNumber(String username, PhoneNumberDto phoneNumberDto) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
		user.setPhoneNumber(phoneNumberDto.getPhoneNumber());
		userRepository.save(user);
	}
	
	public void updatePassword(String username, PasswordDto passwordDto) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
		user.setPassword(passwordDto.getEncodedPassword());
		userRepository.save(user);
	}
	
	public void updateCity(String username, CityDto cityDto) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
		user.setCity(cityDto.getCity());
		userRepository.save(user);
	}
	
	public void updateFirstAndLastName(String username, FirstAndLastNameDto firstAndLastNameDto) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
		user.setFirstName(firstAndLastNameDto.getFirstName());
		user.setLastName(firstAndLastNameDto.getLastName());
		userRepository.save(user);
	}
	
	public void updatePfpUrl(String username, PfpFileDto pfpFileDto) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
		user.setPfpUrl(pfpFileDto.getPfpUrl());
		userRepository.save(user);
	}

}
