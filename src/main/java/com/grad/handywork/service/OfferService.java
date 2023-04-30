package com.grad.handywork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grad.handywork.entity.Job;
import com.grad.handywork.entity.JobOffer;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.repo.JobOfferRepository;
import com.grad.handywork.repo.JobRepository;

@Service
public class OfferService {

	@Autowired
	private JobOfferRepository jobOfferRepository;

	@Autowired
	private JobRepository jobRepository;

	public void acceptOffer(Long id) {
		JobOffer jobOffer = jobOfferRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Offer Wiht ID: " + id + " Not Found"));
		jobOffer.setAccepted(true);
		jobOfferRepository.save(jobOffer);
		Job job = jobRepository.findById(jobOffer.getJob().getId()).orElseThrow(
				() -> new ResourceNotFoundException("Job Wiht ID: " + jobOffer.getJob().getId() + " Not Found"));
		job.setDone(true);
		job.setDoneBy(jobOffer.getUser());
		jobRepository.save(job);
		jobOfferRepository.deleteAllByJobAndAcceptedNot(job, true);
	}

	public void rejectOffer(Long id) {
		JobOffer jobOffer = jobOfferRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Offer Wiht ID: " + id + " Not Found"));
		jobOffer.setRejected(true);
		jobOfferRepository.save(jobOffer);
	}

	public void deleteOffer(Long id) {
		JobOffer jobOffer = jobOfferRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Offer Wiht ID: " + id + " Not Found"));
		jobOfferRepository.delete(jobOffer);
	}

}
