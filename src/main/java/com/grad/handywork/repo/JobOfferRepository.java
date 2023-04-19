package com.grad.handywork.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grad.handywork.entity.Job;
import com.grad.handywork.entity.JobOffer;

import jakarta.transaction.Transactional;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long>{
	
	@Transactional
	void deleteAllByJobAndAcceptedNot(Job job, boolean accepted);

}
