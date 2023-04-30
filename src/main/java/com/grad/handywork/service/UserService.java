package com.grad.handywork.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.grad.handywork.dto.AuthDto;
import com.grad.handywork.dto.JobDto;
import com.grad.handywork.dto.JobOfferDto;
import com.grad.handywork.dto.PasswordDto;
import com.grad.handywork.dto.PfpFileDto;
import com.grad.handywork.dto.UserDto;
import com.grad.handywork.dto.UserUpdateMainDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.entity.User;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.mapper.JobMapper;
import com.grad.handywork.mapper.JobOfferMapper;
import com.grad.handywork.mapper.UserMapper;
import com.grad.handywork.repo.JobRepository;
import com.grad.handywork.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private JobMapper jobMapper;

	@Autowired
	private JobOfferMapper jobOfferMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private JwtService jwtService;

	public AuthDto saveUser(UserDto user) {
		User savedUser = userRepository.save(userMapper.userDtoToUserForSave(user));
		String jwtToken = jwtService.generateToken(savedUser);
		return AuthDto.builder().token(jwtToken).build();
	}

	public void saveJob(JobDto jobDto, String username) {
		Job job = jobMapper.JobDtoToJobForSave(jobDto);
		User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException(username));
		if (job.getCity() == null) {
			job.setCity(user.getCity());
		}
		job.setCity(job.getCity().toLowerCase());
		job.setField(job.getField().toLowerCase());
		job.setOwner(user);
		jobRepository.save(job);
	}

	public UserDto getUser(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException(username));
		return userMapper.userToUserDtoForGet(user);
	}

	public List<JobDto> getAllJobsByUsername(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException(username));
		List<Job> jobs = jobRepository.findAllByOwnerId(user.getId(), Sort.by(Direction.DESC, "publishDate"));
		List<JobDto> dtos = new ArrayList<>();
		jobs.stream().forEach((job) -> dtos.add(jobMapper.jobToJobDto(job)));
		dtos.sort(Comparator.comparing(JobDto::getPublishDate).reversed());
		return dtos;
	}

	public void updateMain(String username, UserUpdateMainDto userUpdateMainDto) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User With Username: " + username + " NotFound"));
		user.setFirstName(userUpdateMainDto.getFirstName());
		user.setLastName(userUpdateMainDto.getLastName());
		user.setEmail(userUpdateMainDto.getEmail());
		user.setPhoneNumber(userUpdateMainDto.getPhoneNumber());
		user.setCity(userUpdateMainDto.getCity());
		userRepository.save(user);
	}

	public void updatePassword(String username, PasswordDto passwordDto) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException(username));
		user.setPassword(passwordDto.getEncodedPassword());
		userRepository.save(user);
	}

	public String updatePfpUrl(String username, PfpFileDto pfpFileDto) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException(username));
		user.setPfpUrl(pfpFileDto.getPfpUrl());
		userRepository.save(user);
		return user.getPfpUrl();
	}

	public List<JobOfferDto> getAllOffers(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException(username));
		List<JobOfferDto> dtos = user.getJobOffers().stream()
				.map(jobOffer -> jobOfferMapper.jobOfferToJobOfferDto(jobOffer)).collect(Collectors.toList());
		dtos.sort(Comparator.comparing(JobOfferDto::getId).reversed());
		return dtos;
	}

}
