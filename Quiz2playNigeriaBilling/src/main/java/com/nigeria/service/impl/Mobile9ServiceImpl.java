package com.nigeria.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nigeria.model.PartnerNoticationRequest;
import com.nigeria.model.ProductConfigModel;
import com.nigeria.model.SubscriptionModel;
import com.nigeria.model.SubscriptionRequestModel;
import com.nigeria.model.helper.ModelHelper;
import com.nigeria.repos.PartnerNotificationRepo;
import com.nigeria.repos.ProductConfigRepos;
import com.nigeria.repos.SubscriptionRepos;
import com.nigeria.repos.SubscriptionRequestRepos;
import com.nigeria.request.NotificationRequest;
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
	private ProductConfigRepos configRepos;
	@Autowired
	private SubscriptionRepos subscriptionRepo;

	@Autowired
	private ModelHelper helper;

	@Override
	public StatusResponse saveNotification(NotificationRequest req) {
		StatusResponse response = new StatusResponse();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonBody;
		try {
			jsonBody = objectMapper.writeValueAsString(req);
			helper.saveNotificationRequest(req.getSuccess().getMsisdn(), jsonBody, "200-ok", "106");
			if (req.getSuccess() != null) {
				if (req.getSuccess().getTransaction().getStatus().equalsIgnoreCase("DELETED")
						|| req.getSuccess().getTransaction().getStatus().equalsIgnoreCase("REMOVED")
						|| req.getSuccess().getTransaction().getStatus().equalsIgnoreCase("CANCELLED")) {
					helper.Unsubscription(req.getSuccess().getMsisdn());
				}
				if (req.getSuccess().getMode().equalsIgnoreCase("RENEWAL")) {
					if (req.getSuccess().getTransaction().getStatus().equalsIgnoreCase("CHARGED")) {
						SubscriptionModel subModel = helper.updateSubscription(req.getSuccess());
					} else {
						helper.saveBillingLogsEntry(req.getSuccess());
					}
				}

			} else {
				if (req.getError().getMode().equalsIgnoreCase("RENEWAL")) {
					helper.saveBillingLogsEntry(req.getError());
				}
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
		StatusResponse status = new StatusResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {

			ProductConfigModel configModel = configRepos.findByProductId(body.getProductId());
			if (configModel != null) {
				String url = "https://api.sla-alacrity.com/v2.2/subscription/create?msisdn=" + body.getToken()
						+ "&campaign=" + configModel.getCredit() + "&merchant" + "=" + configModel.getGraceDuration()
						+ "&language=en&trial=1&trial_once=true";
				String response = HttpUtils.sendRequest(url);
				JsonNode reqNode = mapper.readTree(response);
				JsonNode msisdnNode = reqNode.path("msisdn");
				@SuppressWarnings("unchecked")
				Map<String, Object> responseMap = mapper.readValue(response, Map.class);
				if (responseMap.containsKey("error")) {
					String msisdn = "";
					if (!msisdnNode.isMissingNode()) {
						msisdn = msisdnNode.asText();
					} else {
						JsonNode error = reqNode.path("error");
						if (!error.isMissingNode()) {
							msisdn = error.path("msisdn").asText();
							status.setDescripttion(reqNode.get("transaction").get("status").asText());
						}
					}
					SubscriptionRequestModel requestModel = helper.saveSubscriptionRequest(body, response, url, msisdn);
					status.setDescripttion("Failed");
					status.setStatusCode(404);
				}
				if (responseMap.containsKey("success")) {
					String msisdn = "";
					int flag = 0;
					if (!msisdnNode.isMissingNode()) {
						msisdn = msisdnNode.asText();
					} else {
						JsonNode successNode = reqNode.path("success");
						if (!successNode.isMissingNode()) {
							msisdn = successNode.path("msisdn").asText();
							flag = 1;
						}
					}
					SubscriptionRequestModel requestModel = helper.saveSubscriptionRequest(body, response, url, msisdn);
					SubscriptionModel subModel = helper.saveintosubscription(msisdn, requestModel, configModel, flag);
					if (flag == 1) {
						helper.saveBillingSuccessEntry(msisdn, configModel, subModel, "sub");
						helper.saveBillingLogsEntry(msisdn, configModel, subModel, "sub", "success",
								reqNode.get("success").get("transaction").get("status").asText());
					}
					status.setDescripttion("Success");
					status.setStatusCode(200);
				}

			}
		} catch (Exception e) {
			status.setDescripttion("Internal Server Error !");
			status.setStatusCode(500);
			e.printStackTrace();

		}

		return status;
	}

	@Override
	public StatusResponse sendUnsubRequest(String msisdn) {
		// TODO Auto-generated method stub
		StatusResponse status = new StatusResponse();
		try {
			SubscriptionModel subModel = subscriptionRepo.findByMsisdn(msisdn).get();
			if (subModel != null) {
				ProductConfigModel configModel = configRepos.findByProductId(subModel.getProductId());
				if (configModel != null) {
					String url = "https://api.sla-alacrity.com/v2.2/subscription/delete?msisdn=" + subModel.getMeta2()
							+ "&campaign=" + configModel.getCredit() + "&merchant=" + configModel.getGraceDuration()
							+ "";
					String response = HttpUtils.sendRequest(url);
					System.out.println(response);
					helper.savetounsublog(url, response, msisdn, subModel.getPortalId());
					status.setStatusCode(200);
					status.setDescripttion("Success");
				}
			} else {
				status.setStatusCode(404);
				status.setDescripttion("Subscription Not Found");
			}
		} catch (Exception e) {
			status.setStatusCode(500);
			status.setDescripttion("Internal Server Error !");
		}
		return status;
	}

}
