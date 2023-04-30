package com.grad.handywork.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.grad.handywork.dto.AllJobsDto;
import com.grad.handywork.dto.JobDto;
import com.grad.handywork.dto.JobOfferDto;
import com.grad.handywork.dto.JobReviewDto;
import com.grad.handywork.dto.JobUpdateDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.entity.JobOffer;
import com.grad.handywork.entity.JobReview;
import com.grad.handywork.entity.User;
import com.grad.handywork.enumtypes.JobReviewType;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.mapper.JobMapper;
import com.grad.handywork.mapper.JobOfferMapper;
import com.grad.handywork.mapper.JobReviewMapper;
import com.grad.handywork.repo.JobOfferRepository;
import com.grad.handywork.repo.JobRepository;
import com.grad.handywork.repo.JobReviewRepository;
import com.grad.handywork.repo.UserRepository;

@Service
public class JobService {

	@Autowired
	private JobMapper jobMapper;

	@Autowired
	private JobOfferMapper jobOfferMapper;
	
	@Autowired
	private JobReviewMapper jobReviewMapper;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JobOfferRepository jobOfferRepository;
	
	@Autowired
	private JobReviewRepository jobReviewRepository;

	@Autowired
	private JwtService jwtService;

	public JobDto gtJobById(Long id) {
		Job job = jobRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Job With ID: " + id + " NotFond"));
		return jobMapper.jobToJobDto(job);
	}

	public AllJobsDto getAllByFieldAndCity(String field, String city, Integer page, String bearerToken) {
		String token = bearerToken.substring(7);
		String username = jwtService.extractUsername(token);
		Page<Job> jobs;
		if (!StringUtils.hasText(field) && !StringUtils.hasText(city)) {
			jobs = jobRepository.findAllByDoneAndOwnerUsernameNot(false, username,
					PageRequest.of(page, 10).withSort(Sort.by(Direction.DESC, "publishDate")));
		} else if (!StringUtils.hasText(field) && StringUtils.hasText(city)) {
			jobs = jobRepository.findByCityIsLikeIgnoreCaseAndDoneAndOwnerUsernameNot("%" + city + "%", false, username,
					PageRequest.of(page, 10).withSort(Sort.by(Direction.DESC, "publishDate")));
		} else if (StringUtils.hasText(field) && !StringUtils.hasText(city)) {
			jobs = jobRepository.findByFieldIsLikeIgnoreCaseAndDoneAndOwnerUsernameNot("%" + field + "%", false,
					username, PageRequest.of(page, 10).withSort(Sort.by(Direction.DESC, "publishDate")));
		} else {
			jobs = jobRepository.findByFieldIsLikeIgnoreCaseAndCityIsLikeIgnoreCaseAndDoneAndOwnerUsernameNot(
					"%" + field + "%", "%" + city + "%", false, username,
					PageRequest.of(page, 10).withSort(Sort.by(Direction.DESC, "publishDate")));
		}
		List<JobDto> dtos = new ArrayList<>();
		jobs.stream().forEach((job) -> dtos.add(jobMapper.jobToJobDtoForBrowse(job)));
		return AllJobsDto.builder().jobs(dtos).numOfPages(jobs.getTotalPages()).build();
	}

	public Set<String> getAllCities() {
		Set<String> cities = jobRepository.findAllCities();
		return cities.stream().map(city -> city.toLowerCase()).collect(Collectors.toSet());
	}

	public Set<String> getAllFields() {
		Set<String> fields = jobRepository.findAllFields();
		return fields.stream().map(field -> field.toLowerCase()).collect(Collectors.toSet());
	}

	public JobDto updateJob(Long id, JobUpdateDto jobUpdateDto) {
		Job job = jobRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Job With ID: " + id + " NotFond"));
		job.setJobName(jobUpdateDto.getJobName());
		job.setDescription(jobUpdateDto.getDescription());
		job.setCity(jobUpdateDto.getCity());
		job.setField(jobUpdateDto.getField());
		job.setUpdateDate(LocalDateTime.now());
		return jobMapper.jobToJobDto(jobRepository.save(job));
	}

	public void makeOffer(JobOfferDto jobOfferDto, String bearerToken, Long id) {
		String token = bearerToken.substring(7);
		String username = jwtService.extractUsername(token);
		Job job = jobRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Job With ID: " + id + " NotFond"));
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User With Username: " + username + " NotFond"));
		JobOffer jobOffer = jobOfferMapper.jobOfferDtoToJobOffer(jobOfferDto);
		jobOffer.setJob(job);
		jobOffer.setUser(user);
		jobOffer.setAccepted(false);
		jobOffer.setRejected(false);
		jobOfferRepository.save(jobOffer);
	}

	public List<JobOfferDto> getOffers(Long id) {
		Job job = jobRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Job Wiht ID: " + id + " Not Found"));
		return job.getJobOffers().stream().map(jobOffer -> jobOfferMapper.jobOfferToJobOfferDto(jobOffer))
				.collect(Collectors.toList());
	}
	
	public void makeReview(String bearerToken, Long id, JobReviewDto jobReviewDto) {
		JobReview jobReview = jobReviewMapper.jobReviewDtoTojobReview(jobReviewDto);
		Job job = jobRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Job With ID: " + id + " Not Found"));
		jobReview.setJob(job);
		boolean isOwner;
		if (jobReview.getType().equals(JobReviewType.JOB_REVIEW)) {
			isOwner = true;
		} else {
			isOwner = false;
		}
		User byUser;
		User onUser;
		if (isOwner) {
			byUser = userRepository.findByUsername(job.getOwner().getUsername())
				.orElseThrow( () -> new ResourceNotFoundException("User Not Found"));
			onUser = userRepository.findByUsername(job.getDoneBy().getUsername())
				.orElseThrow( () -> new ResourceNotFoundException("User Not Found"));
		} else {
			onUser = userRepository.findByUsername(job.getOwner().getUsername())
				.orElseThrow( () -> new ResourceNotFoundException("User Not Found"));
			byUser = userRepository.findByUsername(job.getDoneBy().getUsername())
				.orElseThrow( () -> new ResourceNotFoundException("User Not Found"));
		}
		jobReview.setByUser(byUser);
		jobReview.setOnUser(onUser);
		jobReviewRepository.save(jobReview);
	}
	
	public List<JobReviewDto> getJobReviews(Long id) {
		Job job = jobRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Job Wit ID: " + id + " Not Found"));
		return job.getJobReviews().stream().map(jobReviewDto -> jobReviewMapper.jobReviewToJobReviewDto(jobReviewDto))
				.collect(Collectors.toList());
	}

}
