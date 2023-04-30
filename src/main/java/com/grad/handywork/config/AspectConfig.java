package com.grad.handywork.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.grad.handywork.aop.JobOfferPreprocessAspect;
import com.grad.handywork.aop.JobPreprocessAspect;
import com.grad.handywork.aop.JobReviewPreprocessAspect;
import com.grad.handywork.aop.SecurityAspect;
import com.grad.handywork.aop.UserPreprocessAspect;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
	
	@Value("${DEFAULT_PFP_URL}")
	private String DEFAULT_PFP_URL;
	
	@Value("${DEFAULT_JOB_P_URL}")
	private String DEFAULT_JOB_P_URL;
	
	@Bean
	public SecurityAspect userAspect() {
		return new SecurityAspect();
	}
	
	@Bean
	public UserPreprocessAspect UserPreprocessAspect() {
		return new UserPreprocessAspect(DEFAULT_PFP_URL, DEFAULT_JOB_P_URL);
	}
	
	@Bean
	public JobPreprocessAspect JobAspect() {
		return new JobPreprocessAspect();
	}
	
	@Bean
	public JobOfferPreprocessAspect jobOfferPreprocessAspect() {
		return new JobOfferPreprocessAspect();
	}
	
	@Bean
	public JobReviewPreprocessAspect jobReviewPreprocessAspect() {
		return new JobReviewPreprocessAspect();
	}

}