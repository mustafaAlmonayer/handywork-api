package com.grad.handywork.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.grad.handywork.aop.JobAspect;
import com.grad.handywork.aop.UserSecurityAspect;
import com.grad.handywork.aop.UserPreprocessAspect;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
	
	@Value("${DEFAULT_PFP_URL}")
	private String DEFAULT_PFP_URL;
	
	@Bean
	public UserSecurityAspect userAspect() {
		return new UserSecurityAspect();
	}
	
	@Bean
	public UserPreprocessAspect UserPreprocessAspect() {
		return new UserPreprocessAspect(DEFAULT_PFP_URL);
	}
	
	@Bean
	public JobAspect JobAspect() {
		return new JobAspect();
	}

}
