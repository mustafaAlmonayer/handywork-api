package com.grad.handywork.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.grad.handywork.dto.AuthDto;
import com.grad.handywork.dto.JobDto;
import com.grad.handywork.dto.UserDto;
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
		List<Job> jobs = jobRepository.findAllByOwnerId(user.getId(), Sort.by("publishDate").descending());
		List<JobDto> dtos = new ArrayList<>();
		jobs.stream()
			.forEach(
					(job) -> dtos.add(jobMapper.jobToJobDto(job))
			);
		return dtos;
				
	}

}
