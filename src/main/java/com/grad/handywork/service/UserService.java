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
import com.grad.handywork.dto.JobReviewDto;
import com.grad.handywork.dto.PasswordDto;
import com.grad.handywork.dto.PfpFileDto;
import com.grad.handywork.dto.RatingsDto;
import com.grad.handywork.dto.RatingsDto.RatingsDtoBuilder;
import com.grad.handywork.dto.UserDto;
import com.grad.handywork.dto.UserUpdateMainDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.entity.JobReview;
import com.grad.handywork.entity.User;
import com.grad.handywork.enumtypes.JobReviewType;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.mapper.JobMapper;
import com.grad.handywork.mapper.JobOfferMapper;
import com.grad.handywork.mapper.JobReviewMapper;
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
	private JobReviewMapper jobReviewMapper;

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
	
	public RatingsDto getRatings(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
		RatingsDtoBuilder ratingsDtoBuilder = RatingsDto.builder();
		List<JobReview> asListerJobReview = user.getOnJobReviews()
				.stream()
				.filter(review -> review.getType() == JobReviewType.USER_REVIEW)
				.collect(Collectors.toList());
		List<JobReview> asProfessionalJobReviews = user.getOnJobReviews()
				.stream()
				.filter(review -> review.getType() == JobReviewType.JOB_REVIEW)
				.collect(Collectors.toList());
		if (asListerJobReview.isEmpty()) {
			ratingsDtoBuilder.asListerRating(-1f);
		} else {
			float asListerRating = 0f; 
			for (JobReview jobReview : asListerJobReview) {
				asListerRating += (float) jobReview.getRating();
			}
			asListerRating /= (float) asListerJobReview.size();
			ratingsDtoBuilder.asListerRating(asListerRating);
		}
		if(asProfessionalJobReviews.isEmpty()) {
			ratingsDtoBuilder.asProfessionalRating(-1f);
		} else {
			float asProfessionalRating = 0f;
			for (JobReview jobReview : asProfessionalJobReviews) {
				asProfessionalRating += (float) jobReview.getRating();
			}
			asProfessionalRating /= (float) asProfessionalJobReviews.size();
			ratingsDtoBuilder.asProfessionalRating(asProfessionalRating);
		}
		return ratingsDtoBuilder.build();
	}
	
	public List<JobReviewDto> getJobReviews(String username, JobReviewType type) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(username));
		List<JobReviewDto> jobReviewDtos;
		if (JobReviewType.USER_REVIEW.equals(type)) {
			jobReviewDtos = user.getOnJobReviews()
					.stream()
					.filter(review -> review.getType() == JobReviewType.USER_REVIEW)
					.map(review -> jobReviewMapper.jobReviewToJobReviewDto(review))
					.collect(Collectors.toList());
		} else {
			jobReviewDtos = user.getOnJobReviews()
					.stream()
					.filter(review -> review.getType() == JobReviewType.JOB_REVIEW)
					.map(review -> jobReviewMapper.jobReviewToJobReviewDto(review))
					.collect(Collectors.toList());
		}
		return jobReviewDtos;
	}

}
