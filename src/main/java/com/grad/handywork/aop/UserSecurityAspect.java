package com.grad.handywork.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.ResourceAccessException;

import com.grad.handywork.service.JwtService;

import lombok.RequiredArgsConstructor;

@Aspect
@RequiredArgsConstructor
public class UserSecurityAspect {
	
	@Autowired
	private JwtService jwtService;	
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updateEmail(String, String, com.grad.handywork.dto.EmailDto))")
	public void updateEmailPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updatePhoneNumber(String, String, com.grad.handywork.dto.PhoneNumberDto))")
	public void updatePhoneNumberPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updatePassword(String, String, com.grad.handywork.dto.PasswordDto))")
	public void updatePasswordPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updateCity(String, String, com.grad.handywork.dto.CityDto))")
	public void updateCityPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updateFirstAndLastName(String, String, com.grad.handywork.dto.FirstAndLastNameDto))")
	public void updateFirstAndLastNamePointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updatePfpUrl(String, String, com.grad.handywork.dto.PfpFileDto))")
	public void updatePfpUrlPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.saveJob(String, String, com.grad.handywork.entity.Job))")
	public void saveJobPointCut() {}
	
	@Pointcut(" updateEmailPointCut()"
			+ "||"
			+ "updatePhoneNumberPointCut()"
			+ "||"
			+ "updatePasswordPointCut()"
			+ "||"
			+ "updateCityPointCut()"
			+ "||"
			+ "updateFirstAndLastNamePointCut()"
			+ "||"
			+ "updatePfpUrlPointCut()"
			+ "||"
			+ "saveJobPointCut()")
	public void updateAllPointCut() {}
	
	@Order(value = 0)
	@Before("updateAllPointCut() && args(username, bearerToken, *)") 
	public void security(String username, String bearerToken) {
		System.out.println("from security");
		if(!jwtService.extractUsername(bearerToken.substring(7)).equals(username)) 
			throw new ResourceAccessException(username + ": Is Not The Resource Owner");
	}
		
}
