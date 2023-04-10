package com.grad.handywork.aop;

import java.time.LocalDateTime;

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
	
	@Pointcut("execution(* com.grad.handywork.controller.JobController.saveJob(com.grad.handywork.entity.Job, String, String))")
	public void saveJobPointCut() {}
	
	@Before("saveJobPointCut()")
	public void beforeSaveJob(JoinPoint joinPoint) {
		String username = (String) joinPoint.getArgs()[1];
		String token = (String) joinPoint.getArgs()[2];
		String bearerToken = token.substring(7);
		if(!jwtService.extractUsername(bearerToken).equals(username)) 
			throw new ResourceAccessException(username + ": Is Not The Resource Owner");
		Job job = (Job) joinPoint.getArgs()[0];
		job.setId(null);
		job.setDone(false);
		job.setDoneBy(null);
		job.setPublishDate(LocalDateTime.now());
	}
	
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
	
}
