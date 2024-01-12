package com.nigeria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nigeria.model.ProductConfigModel;
import com.nigeria.model.SubscriptionModel;
import com.nigeria.model.helper.ModelHelper;
import com.nigeria.repos.ProductConfigRepos;
import com.nigeria.repos.SubscriptionRepos;
import com.nigeria.request.SubscriptionRequest;
import com.nigeria.request.secureDRequest;
import com.nigeria.response.StatusResponse;
import com.nigeria.service.MtnService;
import com.nigeria.utils.HttpUtils;

@Service
public class MtnServiceImpl implements MtnService {

	@Value("${notificationReq}")
	private String notificationReq;
	@Autowired
	private ModelHelper helper;

	@Autowired
	private ProductConfigRepos configRepos;

	@Autowired
	private SubscriptionRepos subscriptionRepo;

	@Override
	public StatusResponse SaveNotification(String channel, String action, String circle, String endDate, String msisdn,
			String operator, String packName, String amount, String startDate, String userStatus, String subscriberType,
			String transactionId, String vendorName, String contestLevel, String contestName, String language,
			String src) {
		StatusResponse response = new StatusResponse();
		// TODO Auto-generated method stub
		try {
			String notification = notificationReq;
			notification = notification.replace("channel_value", channel);
			notification = notification.replace("action_value", action);
			notification = notification.replace("circle_value", circle);
			notification = notification.replace("endDate_value", endDate);
			notification = notification.replace("msisdn_value", msisdn);
			notification = notification.replace("operator_value", operator);
			notification = notification.replace("packName_value", packName);
			notification = notification.replace("amount_value", amount);
			notification = notification.replace("startDate_value", startDate);
			notification = notification.replace("userStatus_value", userStatus);
			notification = notification.replace("subscriberType_value", subscriberType);
			notification = notification.replace("transactionId_value", transactionId);
			notification = notification.replace("vendorName_value", vendorName);
			notification = notification.replace("contestLevel_value", contestLevel);
			notification = notification.replace("contestName_value", contestName);
			notification = notification.replace("language_value", language);
			notification = notification.replace("src_value", src);
			System.out.println(notification);
			helper.saveNotificationRequest(msisdn, notification, "200-ok", "106");
			ProductConfigModel configModel = configRepos.findByCredit(packName);

			if (action.equalsIgnoreCase("Subscription")) {
				SubscriptionModel Submodel = helper.SubscribeUser(msisdn, packName, channel, transactionId, userStatus);
				if (userStatus.equalsIgnoreCase("0")) {
					helper.saveBillingSuccessEntry(msisdn, configModel, Submodel, "sub");
				}
			} else if (action.equalsIgnoreCase("Deactivation")) {
				helper.Unsubscription(msisdn);
			} else if (action.equalsIgnoreCase("Renewal")) {
				SubscriptionModel subModel = subscriptionRepo.findByMsisdn(msisdn).get();
				if (!subModel.equals(null)) {
					helper.updateSubscriptionModel(subModel, configModel);
					helper.saveBillingSuccessEntry(msisdn, configModel, subModel, "ren");
				}

				System.out.println("user in Renewal");
			} else if (action.equalsIgnoreCase("churn")) {

			} else if (action.equalsIgnoreCase("UnSubscription")) {
				helper.Unsubscription(msisdn);
				System.out.println("This is Deactivation");
			}
			response.setStatusCode(200);
			response.setDescripttion("Success");

		} catch (Exception e) {
			response.setStatusCode(500);
			response.setDescripttion("Some internal server Error !");
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public StatusResponse sendForUnsub(String msisdn) {
		StatusResponse statusResponse = new StatusResponse();
		try {
			SubscriptionModel subscriptionModel = subscriptionRepo.findByMsisdn(msisdn).get();
			if (subscriptionModel != null) {
				ProductConfigModel configModel = configRepos.findByProductId(subscriptionModel.getProductId());
				if (configModel != null) {
					String url = "http://172.16.203.25:8080/SMInterfaceMad/onlineRequest.htm?msisdn=" + msisdn
							+ "&channel=WAP&shortCode=70707&userText=unsub+" + configModel.getCredit()
							+ "&operator=mamtnnigeria&sendMessage=1&circle=nz";
					System.out.println(url);
					String response = HttpUtils.sendRequestPost(url);
					System.out.println(response);
					helper.savetounsublog(url, response, msisdn, "106");
					String[] data = response.split("\\|");
					int statusCode = Integer.parseInt(data[1]);
					if (statusCode == 306) {
						statusResponse.setStatusCode(200);
						statusResponse.setDescripttion(data[2]);
					} else {
						statusResponse.setStatusCode(403);
						statusResponse.setDescripttion(data[2]);
					}
				} else {
					statusResponse.setStatusCode(404);
					statusResponse.setDescripttion("Product details Not Found");
				}
			} else {
				statusResponse.setStatusCode(404);
				statusResponse.setDescripttion("Subscription Not Found !");
			}
		} catch (Exception e) {
			statusResponse.setStatusCode(500);
			statusResponse.setDescripttion("Internal server Error !");
		}
		return statusResponse;
	}

	@Override
	public StatusResponse sendforSub(SubscriptionRequest request) {
		// TODO Auto-generated method stub
		StatusResponse statusResponse = new StatusResponse();
		try {
			ProductConfigModel configModel = configRepos.findByProductId(request.getProductId());
			if (configModel != null) {
				String url = "http://172.16.203.25:8080/SMInterfaceMad/onlineRequest.htm?msisdn=" + request.getToken()
						+ "&channel=WAP&shortCode=70707&userText=sub+" + configModel.getCredit()
						+ "&operator=mamtnnigeria&sendMessage=1&circle=nz";
				System.out.println(url);
				String response = HttpUtils.sendRequestPost(url);
				System.out.println(response);
				String[] data = response.split("\\|");
				helper.saveSubscriptionRequest(request, response, url, request.getToken());
				int statusCode = Integer.parseInt(data[1]);
				if (statusCode == 306) {
					statusResponse.setStatusCode(200);
					statusResponse.setDescripttion(data[2]);
				} else {
					statusResponse.setStatusCode(403);
					statusResponse.setDescripttion(data[2]);
				}
			} else {
				statusResponse.setStatusCode(404);
				statusResponse.setDescripttion("Product details Not Found");
			}
		} catch (Exception e) {
			statusResponse.setStatusCode(500);
			statusResponse.setDescripttion("Internal server Error !");
		}

		return statusResponse;
	}

	@Override
	public StatusResponse notifcationSecureD(secureDRequest dRequest) {
		// TODO Auto-generated method stub
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonBody;
		try {
			jsonBody = objectMapper.writeValueAsString(dRequest);

		} catch (Exception e) {

		}
		return null;
	}

}
