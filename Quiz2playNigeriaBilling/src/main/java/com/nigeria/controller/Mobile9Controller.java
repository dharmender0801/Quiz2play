package com.nigeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nigeria.request.NotificationRequest;
import com.nigeria.request.SubscriptionRequest;
import com.nigeria.response.StatusResponse;
import com.nigeria.service.Mobile9Service;

@RestController
@RequestMapping("/api/9mobile-nigeria/")
public class Mobile9Controller {

	@Autowired
	private Mobile9Service mobile9Service;

	@GetMapping("check")
	public String checkMeyhos() {
		return "Testing Method";
	}

	@PostMapping("v1/notifications")
	public ResponseEntity<StatusResponse> notifications(@RequestBody String notificationRequest) {
		return new ResponseEntity<StatusResponse>(mobile9Service.saveNotification(notificationRequest), HttpStatus.OK);
	}

	@PostMapping("v1/subscription")
	public ResponseEntity<StatusResponse> sendSubscriptionRequest(@RequestBody SubscriptionRequest body) {
		return new ResponseEntity<StatusResponse>(mobile9Service.sendSubscription(body), HttpStatus.OK);
	}

}
