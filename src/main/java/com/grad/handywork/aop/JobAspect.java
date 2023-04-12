package com.grad.handywork.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

import com.grad.handywork.entity.Job;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.repo.JobRepository;
import com.grad.handywork.service.JwtService;

@Aspect
public class JobAspect {	
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Pointcut("execution(* com.grad.handywork.controller.JobController.updateJob(com.grad.handywork.dto.JobUpdateDto, String, Long))")
	public void updateJobPointCut() {}
	
	@Before("updateJobPointCut()")
	public void beforeUpdateJob(JoinPoint joinPoint) {
		String token = (String) joinPoint.getArgs()[1];
		String bearerToken = token.substring(7);
		Long id = (Long) joinPoint.getArgs()[2];
		Job dbJob = jobRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Job Not Found")
		);
		if(!jwtService.extractUsername(bearerToken).equals(dbJob.getOwner().getUsername()))
			throw new ResourceAccessException(dbJob.getOwner().getUsername() + ": Is Not The Resource Owner");
	}
	
	@Pointcut("execution(* com.grad.handywork.controller.JobController.makeOffer(com.grad.handywork.dto.JobOfferDto, String, Long))")
	public void makeOfferPointCut() {}
	
	@Before("makeOfferPointCut()")
	public void beforeMakeOffer(JoinPoint joinPoint) {
		String bearerToken = (String) joinPoint.getArgs()[1];
		String username = jwtService.extractUsername(bearerToken.substring(7));
		Long id = (Long) joinPoint.getArgs()[2];
		Job job = jobRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Job Not Found"));
		if (job.isDone()) {
			throw new ResourceAccessException("this job is fenished");
		}
		if (job.getOwner().getUsername().equals(username)) {
			throw new ResourceAccessException("You Cannot Make An Offer On your On Job");
		}
	}
}
