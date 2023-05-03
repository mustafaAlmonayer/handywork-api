package com.grad.handywork.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grad.handywork.dto.JobReviewDto;
import com.grad.handywork.entity.JobReview;
import com.grad.handywork.exception.ResourceNotFoundException;
import com.grad.handywork.mapper.JobReviewMapper;
import com.grad.handywork.repo.JobReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private JobReviewMapper jobReviewMapper;
	
	@Autowired
	private JobReviewRepository jobReviewRepository;
	
	public JobReviewDto getJobReview(Long id) {
		JobReview jobReview = jobReviewRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Job Review With ID: " + id  + " Not Found"));
		return jobReviewMapper.jobReviewToJobReviewDto(jobReview);
	}
	
	public void updateJobReview(Long id, JobReviewDto jobReviewDto) {
		JobReview jobReview = jobReviewRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Job Review With ID: " + id  + " Not Found"));
		jobReview.setRating(jobReviewDto.getRating());
		jobReview.setReviewText(jobReviewDto.getReviewText());
		jobReview.setUpdateDate(LocalDateTime.now());
		jobReviewRepository.save(jobReview);
	}
	
	public void deleteJobReview(Long id) {
		JobReview jobReview = jobReviewRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Job Review With ID: " + id  + " Not Found"));
		jobReview.setByUser(null);
		jobReview.setOnUser(null);
		jobReview.setJob(null);
		jobReviewRepository.delete(jobReview);
	}

}
