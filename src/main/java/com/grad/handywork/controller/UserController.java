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
import org.springframework.web.bind.annotation.RestController;

import com.grad.handywork.dto.AuthDto;
import com.grad.handywork.dto.CityDto;
import com.grad.handywork.dto.EmailDto;
import com.grad.handywork.dto.FirstAndLastNameDto;
import com.grad.handywork.dto.JobDto;
import com.grad.handywork.dto.PasswordDto;
import com.grad.handywork.dto.PfpFileDto;
import com.grad.handywork.dto.PhoneNumberDto;
import com.grad.handywork.dto.UserDto;
import com.grad.handywork.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<AuthDto> register(@RequestBody @Validated UserDto userDto) {
		return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public ResponseEntity<UserDto> getUser(@PathVariable String username,
			@RequestHeader("Authorization") String bearerToken) {
		return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
	}

	@GetMapping("/{username}/job/all")
	public ResponseEntity<List<JobDto>> getAllJobsByUsername(@PathVariable String username) {
		return new ResponseEntity<>(userService.getAllJobsByUsername(username), HttpStatus.OK);
	}
	
	@PatchMapping("/{username}/update/email")
	public ResponseEntity<Void> updateEmail(@PathVariable String username,
			@RequestHeader("Authorization") String bearerToken, @Validated @RequestBody EmailDto emailDto) {
		userService.updateEmail(username, emailDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/{username}/update/phoneNumber")
	public ResponseEntity<Void> updatePhoneNumber(@PathVariable String username,
			@RequestHeader("Authorization") String bearerToken, @Validated @RequestBody PhoneNumberDto phoneNumberDto) {
		userService.updatePhoneNumber(username, phoneNumberDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/{username}/update/password")
	public ResponseEntity<Void> updatePassword(@PathVariable String username,
			@RequestHeader("Authorization") String bearerToken, @Validated @RequestBody PasswordDto passwordDto) {
		userService.updatePassword(username, passwordDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/{username}/update/city")
	public ResponseEntity<Void> updateCity(@PathVariable String username,
			@RequestHeader("Authorization") String bearerToken, @Validated @RequestBody CityDto cityDto) {
		userService.updateCity(username, cityDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/{username}/update/firstAndLastName")
	public ResponseEntity<Void> updateFirstAndLastName(@PathVariable String username,
			@RequestHeader("Authorization") String bearerToken, @Validated @RequestBody FirstAndLastNameDto firstAndLastNameDto) {
		userService.updateFirstAndLastName(username, firstAndLastNameDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/{username}/update/pfpUrl")
	public ResponseEntity<Void> updatePfpUrl(@PathVariable String username,
			@RequestHeader("Authorization") String bearerToken, @Validated @RequestBody PfpFileDto pfpFileDto) {
		userService.updatePfpUrl(username, pfpFileDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}