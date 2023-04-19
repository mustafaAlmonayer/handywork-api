package com.grad.handywork.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grad.handywork.dto.AllJobsDto;
import com.grad.handywork.dto.JobDto;
import com.grad.handywork.dto.JobOfferDto;
import com.grad.handywork.dto.JobUpdateDto;
import com.grad.handywork.service.JobService;

@RestController
@RequestMapping("/v1/job")
public class JobController {

	@Autowired
	private JobService jobService;

	@GetMapping("/all")
	public ResponseEntity<AllJobsDto> getAllJobs(@RequestParam(required = false) String field,
			@RequestParam(required = false) String city, @RequestParam(required = true) Integer page,
			@RequestHeader("Authorization") String bearerToken) {
		return new ResponseEntity<>(jobService.getAllByFieldAndCity(field, city, page, bearerToken), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<JobDto> getJobById(@PathVariable Long id) {
		return new ResponseEntity<>(jobService.gtJobById(id), HttpStatus.OK);
	}
	
	@GetMapping("/cities")
	public ResponseEntity<Set<String>> getAllCities(){
		return new ResponseEntity<>(jobService.getAllCities(), HttpStatus.OK);
	}
	
	@GetMapping("/fields")
	public ResponseEntity<Set<String>> getAllFields(){
		return new ResponseEntity<>(jobService.getAllFields(), HttpStatus.OK);
	}

	@PatchMapping("/{id}/update")
	public ResponseEntity<JobDto> updateJob(@RequestHeader("Authorization") String BearerToken, @PathVariable Long id,
			@Validated @RequestBody JobUpdateDto jobUpdateDto) {
		return new ResponseEntity<>(jobService.updateJob(id, jobUpdateDto), HttpStatus.OK);

	}
	
	@PostMapping("/{id}/makeOffer")
	public ResponseEntity<Void> makeOffer(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id,
			@Validated @RequestBody JobOfferDto jobOfferDto) {
		jobService.makeOffer(jobOfferDto, bearerToken, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
