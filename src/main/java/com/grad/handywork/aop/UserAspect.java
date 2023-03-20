package com.grad.handywork.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

import com.grad.handywork.service.JwtService;

@Aspect
public class UserAspect {
	
	@Autowired
	JwtService jwtService;
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.getUser(String, String))")
	public void getUserPointCut() {}
	
	@Before("getUserPointCut()")
	public void beforeGetUser(JoinPoint joinPoint) {
		String username = (String)joinPoint.getArgs()[0];
		String token = (String)joinPoint.getArgs()[1];
		String bearerToken = token.substring(7);
		if(!jwtService.extractUsername(bearerToken).equals(username)) 
			throw new ResourceAccessException(username + ": Is Not The Resource Owner");
	}

}
