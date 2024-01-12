package com.nigeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nigeria.request.SubscriptionRequest;
import com.nigeria.request.secureDRequest;
import com.nigeria.response.StatusResponse;
import com.nigeria.service.MtnService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/mtn-nigeria/")
public class MtnController {

	@Autowired
	private MtnService mtnservice;

	@GetMapping("/test")
	public String test() {
		return "Test Method";
	}

//	@GetMapping("")
	@RequestMapping(path = "v1/notifications", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<StatusResponse> Notificaton(@RequestParam(defaultValue = "", required = false) String channel,
			@RequestParam(defaultValue = "", required = false) String action,
			@RequestParam(defaultValue = "", required = false) String circle,
			@RequestParam(defaultValue = "", required = false) String endDate,
			@RequestParam(defaultValue = "0", required = false) String msisdn,
			@RequestParam(defaultValue = "", required = false) String operator,
			@RequestParam(defaultValue = "", required = false) String packName,
			@RequestParam(defaultValue = "", required = false) String amount,
			@RequestParam(defaultValue = "", required = false) String startDate,
			@RequestParam(defaultValue = "", required = false) String userStatus,
			@RequestParam(defaultValue = "", required = false) String subscriberType,
			@RequestParam(defaultValue = "", required = false) String transactionId,
			@RequestParam(defaultValue = "", required = false) String vendorName,
			@RequestParam(defaultValue = "", required = false) String contestLevel,
			@RequestParam(defaultValue = "", required = false) String contestName,
			@RequestParam(required = false, defaultValue = "en") String language,
			@RequestParam(defaultValue = "", required = false) String src) {
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

	@PostMapping("v1/notifications/secureD")
	public ResponseEntity<StatusResponse> notifySecure(@RequestBody secureDRequest dRequest) {
		return new ResponseEntity<StatusResponse>(mtnservice.notifcationSecureD(dRequest), HttpStatus.OK);
	}

}
