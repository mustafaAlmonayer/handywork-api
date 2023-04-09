package com.grad.handywork.controller;

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
import com.grad.handywork.dto.JobUpdateDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.service.JobService;

@RestController
@RequestMapping("/v1")
public class JobController {

	@Autowired
	private JobService jobService;

	@GetMapping("/job/all")
	public ResponseEntity<AllJobsDto> getAllJobs(@RequestParam(required = false) String field,
			@RequestParam(required = false) String city, @RequestParam(required = true) Integer page,
			@RequestHeader("Authorization") String bearerToken) {
		return new ResponseEntity<>(jobService.getAllByFieldAndCity(field, city, page, bearerToken), HttpStatus.OK);
	}

	@GetMapping("/job/{id}")
	public ResponseEntity<JobDto> getJobById(@PathVariable Long id) {
		return new ResponseEntity<>(jobService.gtJobById(id), HttpStatus.OK);
	}

	@PostMapping("/user/{username}/job/save")
	public ResponseEntity<JobDto> saveJob(@Validated @RequestBody Job job, @PathVariable String username,
			@RequestHeader("Authorization") String BearerToken) {
		return new ResponseEntity<>(jobService.saveJob(job, username), HttpStatus.OK);
	}

	@PatchMapping("/job/{id}/update")
	public ResponseEntity<JobDto> updateJob(@Validated @RequestBody JobUpdateDto job,
			@RequestHeader("Authorization") String BearerToken, @PathVariable Long id) {
		return new ResponseEntity<>(jobService.updateJob(job, id), HttpStatus.OK);

	}

}
