package com.grad.handywork.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.ResourceAccessException;

import com.grad.handywork.dto.JobReviewDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.enumtypes.JobReviewType;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.repo.JobRepository;
import com.grad.handywork.repo.JobReviewRepository;
import com.grad.handywork.service.JwtService;

@Aspect
public class JobReviewPreprocessAspect {
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JobReviewRepository jobReviewRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Pointcut("execution(* com.grad.handywork.controller.JobController.makeReview"
			+ "(String, Long, com.grad.handywork.dto.JobReviewDto))")
	public void makeReviewPointCut() {}
	
	@Order(value = 1)
	@Before("makeReviewPointCut() && args(bearerToken, id, jobReviewDto)")
	public void beforeMakeReview(String bearerToken, Long id, JobReviewDto jobReviewDto) {
		String username = jwtService.extractUsername(bearerToken.substring(7));
		Job job = jobRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Job Wiht ID: " + id + " Not Found"));
		if(username.equals(job.getDoneBy().getUsername()))
			if(jobReviewRepository.existsByJobIdAndType(id, JobReviewType.USER_REVIEW)) {
				throw new ResourceAccessException("This Job Has A User Review");
			} else {
				jobReviewDto.setType(JobReviewType.USER_REVIEW);
				jobReviewDto.setPublishDate(LocalDateTime.now());
			}
		if(username.equals(job.getOwner().getUsername()))
			if(jobReviewRepository.existsByJobIdAndType(id, JobReviewType.JOB_REVIEW)) {
				throw new ResourceAccessException("This Job Has A Job Review");
			} else {
				jobReviewDto.setType(JobReviewType.JOB_REVIEW);
				jobReviewDto.setPublishDate(LocalDateTime.now());
			}
	}
}	
