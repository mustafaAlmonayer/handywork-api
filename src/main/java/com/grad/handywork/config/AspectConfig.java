package com.grad.handywork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.grad.handywork.aop.UserAspect;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
	
	@Bean
	public UserAspect userAspect() {
		return new UserAspect();
	}

}
