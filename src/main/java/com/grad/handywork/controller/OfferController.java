package com.grad.handywork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grad.handywork.service.OfferService;

@RestController
@RequestMapping("/v1/offer")
public class OfferController {
	
	@Autowired
	private OfferService offerService;
	
	// OK
	@PatchMapping("/{id}/accept")
	public ResponseEntity<Void> acceptOffer(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id) {
		offerService.acceptOffer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// OK
	@PatchMapping("/{id}/reject")
	public ResponseEntity<Void> rejectOffer(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id) {
		offerService.rejectOffer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// OK
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Void> deleteOffer(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id) {
		offerService.deleteOffer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
