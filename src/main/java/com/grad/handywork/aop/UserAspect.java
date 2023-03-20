package com.grad.handywork.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.ResourceAccessException;

import com.grad.handywork.entity.User;
import com.grad.handywork.service.CloudinaryService;
import com.grad.handywork.service.JwtService;

@Aspect
public class UserAspect {
	
	private final String DEFAULT_PFP_URL = "";
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private CloudinaryService cloudinaryService;
	
	@Autowired
	private PasswordEncoder  passwordEncoder;
	
	@Pointcut("execution(* com.grad.handywork.service.UserService.saveUser(User))")
	public void saveUserPointCut() {}
	
	@Before("saveUserPointCut()")
	public void beforeSaveUser(JoinPoint joinPoint) {
		User user = (User)joinPoint.getArgs()[0];
		String base64File = user.getPfpFile();
		if(base64File == null || base64File.isEmpty()) {
			 user.setPfpFile(DEFAULT_PFP_URL);
			 return;
		}
		user.setPfpUrl(cloudinaryService.imageToUrl(user.getPfpFile()));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	}
	
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
