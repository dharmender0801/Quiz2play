package com.nigeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nigeria.request.SubscriptionRequest;
import com.nigeria.response.StatusResponse;
import com.nigeria.service.MtnService;

@RestController
@RequestMapping("/api/mtn-nigeria/")
public class MtnController {

	@Autowired
	private MtnService mtnservice;

	@GetMapping("/test")
	public String test() {
		return "Test Method";
	}

	@GetMapping("v1/notifications")
	public ResponseEntity<StatusResponse> Notificaton(@RequestParam String channel, @RequestParam String action,
			@RequestParam String circle, @RequestParam String endDate, @RequestParam String msisdn,
			@RequestParam String operator, @RequestParam String packName, @RequestParam String amount,
			@RequestParam String startDate, @RequestParam String userStatus, @RequestParam String subscriberType,
			@RequestParam String transactionId, @RequestParam String vendorName, @RequestParam String contestLevel,
			@RequestParam String contestName, @RequestParam String language, @RequestParam String src) {

		return new ResponseEntity<StatusResponse>(mtnservice.SaveNotification(channel, action, circle, endDate, msisdn,
				operator, packName, amount, startDate, userStatus, subscriberType, transactionId, vendorName,
				contestLevel, contestName, language, src), HttpStatus.OK);
	}

	@GetMapping("v1/unsubscription")
	public ResponseEntity<StatusResponse> unsub(@RequestParam String msisdn) {
		return new ResponseEntity<StatusResponse>(mtnservice.sendForUnsub(msisdn), HttpStatus.OK);
	}
//	 in this request token is msisdn
	@PostMapping("v1/subscription")
	public ResponseEntity<StatusResponse> subscribe(@RequestBody SubscriptionRequest request) {
		return new ResponseEntity<StatusResponse>(mtnservice.sendforSub(request), HttpStatus.OK);
	}

}
