package com.nigeria.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nigeria.model.PartnerNoticationRequest;
import com.nigeria.repos.PartnerNotificationRepo;
import com.nigeria.response.StatusResponse;
import com.nigeria.service.Mobile9Service;

@Service
public class Mobile9ServiceImpl implements Mobile9Service {

	@Autowired
	private PartnerNotificationRepo notificationRepo;

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
				saveNotificationRequest(msisdn, notificationRequest, "200-ok", "106");
				System.out.println(notificationRequest);
			}
			if (responseMap.containsKey("success")) {
				String msisdn = reqNode.get("error").get("msisdn").asText();
				saveNotificationRequest(msisdn, notificationRequest, "200-ok", "106");
			}

			response.setStatusCode(200);
			response.setDescripttion("Success");
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(500);
			response.setDescripttion("Internal Server Error !");
		}
		return response;
	}

	private void saveNotificationRequest(String msisdn, String notifyRequest, String notifyResponse, String portalId) {
		PartnerNoticationRequest notifyModel = new PartnerNoticationRequest();
		try {
			notifyModel.setDateTime(new Date());
			notifyModel.setMsisdn(msisdn);
			notifyModel.setNotificationRequest(notifyRequest);
			notifyModel.setNotificationResponse(notifyResponse);
			notifyModel.setPortalId(portalId);
			notificationRepo.save(notifyModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
