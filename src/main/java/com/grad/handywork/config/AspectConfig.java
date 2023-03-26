package com.grad.handywork.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.grad.handywork.aop.UserAspect;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
	
	@Value("${DEFAULT_PFP_URL}")
	private String DEFAULT_PFP_URL;
	
	@Bean
	public UserAspect userAspect() {
		return new UserAspect(DEFAULT_PFP_URL);
	}

}
