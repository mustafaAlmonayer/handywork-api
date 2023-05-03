package com.grad.handywork.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.ResourceAccessException;

import com.grad.handywork.dto.JobReviewDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.entity.JobOffer;
import com.grad.handywork.entity.JobReview;
import com.grad.handywork.entity.User;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.repo.JobOfferRepository;
import com.grad.handywork.repo.JobRepository;
import com.grad.handywork.repo.JobReviewRepository;
import com.grad.handywork.service.JwtService;

@Aspect
public class SecurityAspect {
	
	@Autowired
	private JwtService jwtService;	
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JobOfferRepository jobOfferRepository;
	
	@Autowired
	private JobReviewRepository jobReviewRepository;
	
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
	
	@Pointcut("updatePfpUrlPointCut()"
			+ "||"
			+ "updatePasswordPointCut()"
			+ "||"
			+ "updateMainPointCut()"
			+ "||"
			+ "saveJobPointCut()")
	public void secureUserUpdateAndJobSavePointCut() {}
	
	@Order(value = 0)
	@Before("secureUserUpdateAndJobSavePointCut() && args(bearerToken, username, *)") 
	public void secureUserUpdateAndJobSave(String bearerToken, String username) {
		if(!jwtService.extractUsername(bearerToken.substring(7)).equals(username)) 
			throw new ResourceAccessException(username + ": Is Not The Resource Owner");
	}
	
	@Pointcut("execution(* com.grad.handywork.controller.JobController.updateJob"
			+ "(String, Long, com.grad.handywork.dto.JobUpdateDto))")
	public void updateJobPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.JobController.deleteJob"
			+ "(String, Long))")
	public void deleteJobPointCut() {}
	
	@Pointcut("updateJobPointCut()"
			+ "||"
			+ "deleteJobPointCut()")
	public void deleteAndUpdateJobPointCut() {}
	
	@Order(value = 0)
	@Before("deleteAndUpdateJobPointCut()  && ( args(bearerToken, id, *) ||  args(bearerToken, id) )")
	public void secureUpdateJob(String bearerToken, Long id) {
		Job dbJob = jobRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Job With ID: " + id + " Not Found")
		);
		if(!jwtService.extractUsername(bearerToken.substring(7)).equals(dbJob.getOwner().getUsername()))
			throw new ResourceAccessException(jwtService.extractUsername(bearerToken.substring(7)) + ": Is Not The Resource Owner");
	}
	
	@Pointcut("execution(* com.grad.handywork.controller.OfferController.acceptOffer"
			+ "(String, Long))")
	public void acceptOfferPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.OfferController.rejectOffer"
			+ "(String, Long))")
	public void rejectOfferPointCut() {}
	
	@Pointcut("acceptOfferPointCut()"
			+ "||"
			+ "rejectOfferPointCut()")
	public void secureOfferOppPointCut() {}
	
	@Order(value = 0)
	@Before("secureOfferOppPointCut() && args(bearerToken, id)")
	public void secureAcceptOffer(String bearerToken, Long id) {
		String username = jwtService.extractUsername(bearerToken.substring(7));
		JobOffer jobOffer = jobOfferRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Offer Wiht ID: " + id + " Not Found"));
		User user = jobOffer.getJob().getOwner();
		if(!username.equals(user.getUsername())) {
			throw new ResourceAccessException(username + ": Is Not The Resource Owner");
		}
	}
	
	@Pointcut("execution(* com.grad.handywork.controller.OfferController.deleteOffer"
			+ "(String, Long))")
	public void deleteOfferPointCut() {}
	
	@Order(value = 0)
	@Before("deleteOfferPointCut() && args(bearerToken, id)")
	public void secureDeleteOffer(String bearerToken, Long id) {
		String username = jwtService.extractUsername(bearerToken.substring(7));
		JobOffer jobOffer = jobOfferRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Offer Wiht ID: " + id + " Not Found"));
		User user = jobOffer.getUser();
		if(!username.equals(user.getUsername())) {
			throw new ResourceAccessException(username + ": Is Not The Resource Owner");
		}
	}
	
	@Pointcut("execution(* com.grad.handywork.controller.JobController.makeReview"
			+ "(String, Long, com.grad.handywork.dto.JobReviewDto))")
	public void makeReviewPointCut() {}
	
	@Order(value = 0)
	@Before("makeReviewPointCut() && args(bearerToken, id, jobReviewDto)")
	public void secureMakeReview(String bearerToken, Long id, JobReviewDto jobReviewDto) {
		String username = jwtService.extractUsername(bearerToken.substring(7));
		Job job = jobRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Job With ID: " + id + " Not Found"));
		if (!job.isDone())
			throw new ResourceAccessException("Job With ID: " + id + " Is Not Finished");
		if (!username.equals(job.getOwner().getUsername()) && !username.equals(job.getDoneBy().getUsername()))
			throw new ResourceAccessException(
					"User Wiht Username: " + username + " Is Not The Job Owner Nor The One Who Finished The Job");
	}
	
	@Pointcut("execution(* com.grad.handywork.controller.ReviewController.updateJobReview"
			+ "(String, Long, com.grad.handywork.dto.JobReviewDto))")
	public void updateReviewPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.ReviewController.deleteJobReview"
			+ "(String, Long))")
	public void deleteReviewPointCut() {}
	
	@Pointcut("updateReviewPointCut()"
			+ "||"
			+ "deleteReviewPointCut()")
	public void seureDeleteAndUpdateReviewPointCut() {}
	
	@Order(value = 0)
	@Before("seureDeleteAndUpdateReviewPointCut() && ( args(bearerToken, id) || args(bearerToken, id) )")
	public void secureUpdateReview(String bearerToken, Long id) {
		String username = jwtService.extractUsername(bearerToken.substring(7));
		JobReview jobReview = jobReviewRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Job Review With ID: " + id + " Not Found"));
		if (!username.equals(jobReview.getByUser().getUsername())) {
			throw new ResourceAccessException("User " + username + " Is Not Resource Owner");
		}
	}
		
}
