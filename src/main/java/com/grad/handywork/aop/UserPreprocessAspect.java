package com.grad.handywork.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.grad.handywork.dto.PasswordDto;
import com.grad.handywork.dto.PfpFileDto;
import com.grad.handywork.dto.UserDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.service.CloudinaryService;

import lombok.RequiredArgsConstructor;

@Aspect
@RequiredArgsConstructor
public class UserPreprocessAspect {
	
	private final String DEFAULT_PFP_URL;
	
	@Autowired
	private CloudinaryService cloudinaryService;
	
	@Autowired
	private PasswordEncoder  passwordEncoder;
	
	@Pointcut("execution(* com.grad.handywork.service.UserService.saveUser(com.grad.handywork.dto.UserDto))")
	public void saveUserPointCut() {}
	
	@Before("saveUserPointCut() && args(userDto)")
	public void beforeSaveUser(UserDto userDto) {
		String base64File = userDto.getPfpFile();
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		if(base64File == null || base64File.isEmpty()) {
			 userDto.setPfpUrl(DEFAULT_PFP_URL);
			 return;
		}
		userDto.setPfpFile(null);
		userDto.setPfpUrl(cloudinaryService.imageToUrl(userDto.getPfpFile()));
	}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updatePassword(String, String, com.grad.handywork.dto.PasswordDto))")
	public void updatePasswordPointCut() {}
	
	@Order(value = 1)
	@Before("updatePasswordPointCut() && args(*, *, passwordDto)")
	public void beforeUpdatePassword(PasswordDto passwordDto) {
		passwordDto.setEncodedPassword(passwordEncoder.encode(passwordDto.getPassword()));
	}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.updatePfpUrl(String, String, com.grad.handywork.dto.PfpFileDto))")
	public void updatePfpUrlPointCut() {}
	
	@Order(value = 1)
	@Before("updatePfpUrlPointCut() && args(*, *, pfpFileDto)")
	public void beforeUpdatePfpUrl(PfpFileDto pfpFileDto) {
		pfpFileDto.setPfpUrl(cloudinaryService.imageToUrl(pfpFileDto.getPfpFile()));
	}
	
	@Pointcut("execution(* com.grad.handywork.controller.UserController.saveJob(String, String, com.grad.handywork.entity.Job))")
	public void saveJobPointCut() {}

	@Order(value = 1)
	@Before("saveJobPointCut() && args(*, *, job)")
	public void beforeSaveJob(Job job) {
		job.setId(null);
		job.setDone(false);
		job.setDoneBy(null);
		job.setPublishDate(LocalDateTime.now());
	}
}
