package com.grad.handywork.controller;

import java.util.List;

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

import com.grad.handywork.dto.AuthDto;
import com.grad.handywork.dto.JobDto;
import com.grad.handywork.dto.JobOfferDto;
import com.grad.handywork.dto.JobReviewDto;
import com.grad.handywork.dto.PasswordDto;
import com.grad.handywork.dto.PfpFileDto;
import com.grad.handywork.dto.RatingsDto;
import com.grad.handywork.dto.UserDto;
import com.grad.handywork.dto.UserUpdateMainDto;
import com.grad.handywork.enumtypes.JobReviewType;
import com.grad.handywork.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	// OK
	@PostMapping("/register")
	public ResponseEntity<AuthDto> register(@RequestBody @Validated UserDto userDto) {
		return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.OK);
	}
	
	// OK
	@PostMapping("/{username}/job/save")
	public ResponseEntity<Void> saveJob(@RequestHeader("Authorization") String BearerToken,
			@PathVariable String username, @Validated @RequestBody JobDto jobDto) {
		userService.saveJob(jobDto, username);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// OK
	@GetMapping("/{username}")
	public ResponseEntity<UserDto> getUser(@RequestHeader("Authorization") String BearerToken,
			@PathVariable String username) {
		return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
	}
	
	// OK
	@GetMapping("/{username}/job/all")
	public ResponseEntity<List<JobDto>> getAllJobsByUsername(@PathVariable String username) {
		return new ResponseEntity<>(userService.getAllJobsByUsername(username), HttpStatus.OK);
	}
	
	// OK
	@PatchMapping("{username}/update/main")
	public ResponseEntity<Void> updateMain(@RequestHeader("Authorization") String BearerToken,
			@PathVariable String username, @Validated @RequestBody UserUpdateMainDto userUpdateMainDto) {
		userService.updateMain(username, userUpdateMainDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// OK
	@PatchMapping("/{username}/update/password")
	public ResponseEntity<Void> updatePassword(@RequestHeader("Authorization") String BearerToken,
			@PathVariable String username, @Validated @RequestBody PasswordDto passwordDto) {
		userService.updatePassword(username, passwordDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// OK
	@PatchMapping("/{username}/update/pfpUrl")
	public ResponseEntity<String> updatePfpUrl(@RequestHeader("Authorization") String BearerToken,
			@PathVariable String username, @Validated @RequestBody PfpFileDto pfpFileDto) {
		return new ResponseEntity<>(userService.updatePfpUrl(username, pfpFileDto), HttpStatus.OK);
	}
	
	// OK
	@GetMapping("/{username}/offers")
	public ResponseEntity<List<JobOfferDto>> getAllOffersByUsername(@PathVariable String username) {
		return new ResponseEntity<>(userService.getAllOffers(username), HttpStatus.OK);
	}
	
	// OK
	@GetMapping("/{username}/ratings")
	public ResponseEntity<RatingsDto> getRatings(@PathVariable String username) {
		return new ResponseEntity<>(userService.getRatings(username), HttpStatus.OK);
	}
	
	// OK
	@GetMapping("/{username}/reviews")
	public ResponseEntity<List<JobReviewDto>> getJobReviewAsLister(@PathVariable String username, @RequestParam JobReviewType type) {
		return new ResponseEntity<>(userService.getJobReviews(username, type), HttpStatus.OK);
	}

}