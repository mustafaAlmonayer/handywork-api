package com.grad.handywork.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

import com.grad.handywork.dto.JobOfferDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.repo.JobRepository;
import com.grad.handywork.service.JwtService;

@Aspect
public class JobPreprocessAspect {	
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Pointcut("execution(* com.grad.handywork.controller.JobController.makeOffer"
			+ "(String, Long, com.grad.handywork.dto.JobOfferDto))")
	public void makeOfferPointCut() {}
	
	@Before("makeOfferPointCut() && args(bearerToken, id, jobOfferDto)")
	public void beforeMakeOffer(String bearerToken, Long id, JobOfferDto jobOfferDto) {
		System.out.println("from before make offer");
		String username = jwtService.extractUsername(bearerToken.substring(7));
		Job job = jobRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Job With ID: " + id + " Not Found"));
		if (job.isDone())
			throw new ResourceAccessException("This Job Is Fenished");
		if (job.getOwner().getUsername().equals(username))
			throw new ResourceAccessException("You Cannot Make An Offer On your On Job");
	}
	
}
