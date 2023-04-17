package com.grad.handywork.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.ResourceAccessException;

import com.grad.handywork.entity.Job;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.repo.JobRepository;
import com.grad.handywork.service.JwtService;

@Aspect
public class SecurityAspect {
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JwtService jwtService;	
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updatePfpUrl"
			+ "(String, String, com.grad.handywork.dto.PfpFileDto))")
	public void updatePfpUrlPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updatePassword"
			+ "(String, String, com.grad.handywork.dto.PasswordDto))")
	public void updatePasswordPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updateMain"
			+ "(String, String, com.grad.handywork.dto.UserUpdateMainDto))")
	public void updateMainPointCut() {};
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.saveJob"
			+ "(String, String, com.grad.handywork.dto.JobDto))")
	public void saveJobPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.JobController.updateJob"
			+ "(String, Long, com.grad.handywork.dto.JobUpdateDto))")
	public void updateJobPointCut() {}
	

	@Pointcut("updatePfpUrlPointCut()"
			+ "||"
			+ "updatePasswordPointCut()"
			+ "||"
			+ "updateMainPointCut()"
			+ "||"
			+ "saveJobPointCut()")
	public void secureUserUpdateAndJobSavePointCut() {}
	
	@Order(value = 0)
	@Before("secureUserUpdateAndJobSavePointCut() && args(username, bearerToken, *)") 
	public void secureUserUpdateAndJobSave(String username, String bearerToken) {
		if(!jwtService.extractUsername(bearerToken.substring(7)).equals(username)) 
			throw new ResourceAccessException(username + ": Is Not The Resource Owner");
	}
	
	@Order(value = 0)
	@Before("updateJobPointCut()  && args(bearerToken, id, *)")
	public void secureUpdateJobPointCut(String bearerToken, Long id) {
		Job dbJob = jobRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Job With ID: " + id + " Not Found")
		);
		if(!jwtService.extractUsername(bearerToken.substring(7)).equals(dbJob.getOwner().getUsername()))
			throw new ResourceAccessException(dbJob.getOwner().getUsername() + ": Is Not The Resource Owner");
	}
		
}