package com.grad.handywork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grad.handywork.dto.JobReviewDto;
import com.grad.handywork.service.ReviewService;

@RestController
@RequestMapping("/v1/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/{id}")
	public ResponseEntity<JobReviewDto> getJobReview(@PathVariable Long id) {
		return new ResponseEntity<>(reviewService.getJobReview(id), HttpStatus.OK);
	}

	@PatchMapping("/{id}/update")
	public ResponseEntity<Void> updateJobReview(@RequestHeader("Authorization") String bearerToke,
			@PathVariable Long id, @RequestBody JobReviewDto jobReviewDto) {
		reviewService.updateJobReview(id, jobReviewDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Void> deleteJobReview(@RequestHeader("Authorization") String bearerToke, @PathVariable Long id){
		reviewService.deleteJobReview(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
