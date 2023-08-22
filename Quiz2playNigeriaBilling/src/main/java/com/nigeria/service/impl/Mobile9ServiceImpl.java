package com.nigeria.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nigeria.model.PartnerNoticationRequest;
import com.nigeria.model.helper.ModelHelper;
import com.nigeria.repos.PartnerNotificationRepo;
import com.nigeria.repos.SubscriptionRequestRepos;
import com.nigeria.request.SubscriptionRequest;
import com.nigeria.response.StatusResponse;
import com.nigeria.service.Mobile9Service;
import com.nigeria.utils.HttpUtils;

@Service
public class Mobile9ServiceImpl implements Mobile9Service {

	@Autowired
	private PartnerNotificationRepo notificationRepo;

	@Autowired
	private SubscriptionRequestRepos subRequestRepo;

	@Autowired
	private ModelHelper helper;

	@SuppressWarnings("unchecked")
	@Override
	public StatusResponse saveNotification(String notificationRequest) {
		StatusResponse response = new StatusResponse();
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			JsonNode reqNode = objectMapper.readTree(notificationRequest);
			Map<String, Object> responseMap = objectMapper.readValue(notificationRequest, Map.class);
			if (responseMap.containsKey("error")) {
				String msisdn = reqNode.get("error").get("msisdn").asText();
				helper.saveNotificationRequest(msisdn, notificationRequest, "200-ok", "106");
				System.out.println(notificationRequest);
			}
			if (responseMap.containsKey("success")) {
				String msisdn = reqNode.get("error").get("msisdn").asText();
				helper.saveNotificationRequest(msisdn, notificationRequest, "200-ok", "106");
			}

			response.setStatusCode(200);
			response.setDescripttion("Success");
		} catch (Exception e) {
			response.setStatusCode(500);
			response.setDescripttion("Internal Server Error !");
			e.printStackTrace();

		}
		return response;
	}

	@Override
	public StatusResponse sendSubscription(SubscriptionRequest body) {
		try {
			String url = " https://api.sla-alacrity.com/v2.2/subscription/create?msisdn=" + body.getMsisdn()
					+ "&campaign=campaign:20b1b06bcf116d2388b84870a78ca4beb7fed222&merchant"
					+ "=partner:29905e4f22cc93f337652a554165d60bf637b8ed&trial=0&language=en&trial_once=false";
			String response = HttpUtils.sendRequest(url);
			helper.saveSubscriptionRequest(body, response, url);
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
