package com.grad.handywork.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.ResourceAccessException;

import com.grad.handywork.entity.JobOffer;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.repo.JobOfferRepository;

@Aspect
public class JobOfferPreprocessAspect {
	
	@Autowired
	private JobOfferRepository jobOfferRepository;
	
	@Pointcut("execution(* com.grad.handywork.controller.OfferController.acceptOffer"
			+ "(String, Long))")
	public void acceptOfferPointCut() {}
	
	@Pointcut("execution(* com.grad.handywork.controller.OfferController.rejectOffer"
			+ "(String, Long))")
	public void rejectOfferPointCut() {}
	
	@Pointcut("acceptOfferPointCut()"
			+ "||"
			+ "rejectOfferPointCut()")
	public void beforeOfferOppPointCut() {}
	
	@Order(value = 1)
	@Before("beforeOfferOppPointCut() && args(bearerToken, id)")
	public void beforeOfferOpp(String bearerToken, Long id) {
		JobOffer jobOffer = jobOfferRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Offer Wiht ID: " + id + " Not Found"));
		if (jobOffer.getJob().isDone()) {
			throw new ResourceAccessException("This Job Is Already Have An Accepted Offer");
		}
		if (jobOffer.getAccepted() || jobOffer.getRejected()) {
			throw new ResourceAccessException("You Cannot Make Any New Action On This Offer");
		}
	}
	
	@Pointcut("execution(* com.grad.handywork.controller.OfferController.deleteOffer"
			+ "(String, Long))")
	public void deleteOfferPointCut() {}
	
	@Order(value = 1)
	@Before("deleteOfferPointCut() && args(bearerToken, id)")
	public void beforeDeleteOffer(String bearerToken, Long id) {
		JobOffer jobOffer = jobOfferRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Offer Wiht ID: " + id + " Not Found"));
		if (jobOffer.getAccepted()) {
			throw new ResourceAccessException("You Cannot Delete This Offer");
		}
	}

}
