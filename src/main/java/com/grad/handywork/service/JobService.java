package com.grad.handywork.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.grad.handywork.dto.AllJobsDto;
import com.grad.handywork.dto.JobDto;
import com.grad.handywork.dto.JobUpdateDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.entity.User;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.mapper.JobMapper;
import com.grad.handywork.repo.JobRepository;
import com.grad.handywork.repo.UserRepository;

@Service
public class JobService {
	
	@Value("${DEFAULT_JOB_URL}")
	private String DEFAULT_JOB_URL;
	
	@Autowired
	JobMapper jobMapper;
		
	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CloudinaryService cloudinaryService;
	
	@Autowired
	JwtService jwtService;
	
	public JobDto saveJob(Job job, String username) {
		User dbUser = userRepository.findByUsername(username).orElseThrow(
				() -> new ResourceNotFoundException(username)
		);
		job.setOwner(dbUser);
		if(job.getImagesFiles() == null || job.getImagesFiles().get(0) == "") {
			List<String> imageUrls = new ArrayList<>();
			imageUrls.add(DEFAULT_JOB_URL);
			job.setImagesUrls(imageUrls);
		} else {
			job.setImagesUrls(cloudinaryService.imageToUrl(job.getImagesFiles()));
		}
		Job dbJob =jobRepository.save(job);
		return jobMapper.jobToJobDto(dbJob);
	}
	
	public JobDto gtJobById(Long id) {
		Job job = jobRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Job With ID: " + id + " NotFond")
		);
		return jobMapper.jobToJobDto(job);
	}
	
	public AllJobsDto getAllByFieldAndCity(String field, String city, Integer page, String bearerToken) {
		String token = bearerToken.substring(7);
		String username = jwtService.extractUsername(token);
		Page<Job> jobs;
		if (!StringUtils.hasText(field) && !StringUtils.hasText(city)) {
			jobs = jobRepository.findAllByDoneAndOwnerUsernameNot(false, username, PageRequest.of(page, 10).withSort(Sort.by(Direction.DESC ,"publishDate")));
		} else if (!StringUtils.hasText(field) && StringUtils.hasText(city)) {
			jobs = jobRepository.findByCityIsLikeIgnoreCaseAndDoneAndOwnerUsernameNot("%"+city+"%", false, username, PageRequest.of(page, 10).withSort(Sort.by(Direction.DESC ,"publishDate")));
		} else if (StringUtils.hasText(field) && !StringUtils.hasText(city)) {
			jobs = jobRepository.findByFieldIsLikeIgnoreCaseAndDoneAndOwnerUsernameNot("%"+field+"%", false, username, PageRequest.of(page, 10).withSort(Sort.by(Direction.DESC ,"publishDate")));
		} else {
			jobs = jobRepository.findByFieldIsLikeIgnoreCaseAndCityIsLikeIgnoreCaseAndDoneAndOwnerUsernameNot("%"+field+"%", "%"+city+"%", username, false, PageRequest.of(page, 10).withSort(Sort.by(Direction.DESC ,"publishDate")));
		}
		List<JobDto> dtos =new ArrayList<>();
		jobs.stream()
			.forEach(
					(job) -> dtos.add(jobMapper.jobToJobDto(job))
			);
		return AllJobsDto.builder().jobs(dtos).numOfPages(jobs.getTotalPages()).build();
	}
	
	public JobDto updateJob(JobUpdateDto job, Long id) {
		Job dbJob = jobRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Job With ID: " + id + " NotFond")
		);
		dbJob.setJobName(job.getJobName());
		dbJob.setDescription(job.getDescription());
		dbJob.setCity(job.getCity());
		dbJob.setField(job.getField());
		dbJob.setUpdateDate(LocalDateTime.now());
		return jobMapper.jobToJobDto(jobRepository.save(dbJob));
	}

}
