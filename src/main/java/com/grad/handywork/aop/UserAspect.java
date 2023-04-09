package com.grad.handywork.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.ResourceAccessException;

import com.grad.handywork.dto.PasswordDto;
import com.grad.handywork.dto.PfpFileDto;
import com.grad.handywork.dto.UserDto;
import com.grad.handywork.service.CloudinaryService;
import com.grad.handywork.service.JwtService;

import lombok.RequiredArgsConstructor;

@Aspect
@RequiredArgsConstructor
public class UserAspect {
	
	private final String DEFAULT_PFP_URL;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private CloudinaryService cloudinaryService;
	
	@Autowired
	private PasswordEncoder  passwordEncoder;
	
	@Pointcut("execution(* com.grad.handywork.service.UserService.saveUser(com.grad.handywork.dto.UserDto))")
	public void saveUserPointCut() {}
	
	@Before("saveUserPointCut()")
	public void beforeSaveUser(JoinPoint joinPoint) {
		UserDto userDto = (UserDto)joinPoint.getArgs()[0];
		String base64File = userDto.getPfpFile();
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		if(base64File == null || base64File.isEmpty()) {
			 userDto.setPfpUrl(DEFAULT_PFP_URL);
			 return;
		}
		userDto.setPfpUrl(cloudinaryService.imageToUrl(userDto.getPfpFile()));
	}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updateUsername(String, String, com.grad.handywork.dto.UsernameDto))")
	public void updateUsernamePointCut() {}
	
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
	
	@Pointcut("updateUsernamePointCut()"
			+ "||"
			+ " updateEmailPointCut()"
			+ "||"
			+ "updatePhoneNumberPointCut()"
			+ "||"
			+ "updatePasswordPointCut()"
			+ "||"
			+ "updateCityPointCut()"
			+ "||"
			+ "updateFirstAndLastNamePointCut()"
			+ "||"
			+ "updatePfpUrlPointCut()")
	public void updateAllPointCut() {}
	
	@Before("updateAllPointCut()")
	public void beforeUpdate(JoinPoint joinPoint) {
		security(joinPoint);
	}
	
	@Before("updatePasswordPointCut()")
	public void beforeUpdatePassword(JoinPoint joinPoint) {
		PasswordDto passwordDto = (PasswordDto) joinPoint.getArgs()[2];
		passwordDto.setEncodedPassword(passwordEncoder.encode(passwordDto.getPassword()));
	}
	
	@Before("updatePfpUrlPointCut()")
	public void beforeUpdatePfpUrl(JoinPoint joinPoint) {
		PfpFileDto pfpFileDto = (PfpFileDto) joinPoint.getArgs()[2];
		pfpFileDto.setPfpUrl(cloudinaryService.imageToUrl(pfpFileDto.getPfpFile()));
	}
	
	private void security(JoinPoint joinPoint) {
		String username = (String)joinPoint.getArgs()[0];
		String token = (String)joinPoint.getArgs()[1];
		String bearerToken = token.substring(7);
		if(!jwtService.extractUsername(bearerToken).equals(username)) 
			throw new ResourceAccessException(username + ": Is Not The Resource Owner");
	}
	
}
