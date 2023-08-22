package com.nigeria.model.helper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nigeria.model.PartnerNoticationRequest;
import com.nigeria.model.SubscriptionRequestModel;
import com.nigeria.repos.PartnerNotificationRepo;
import com.nigeria.repos.SubscriptionRequestRepos;
import com.nigeria.request.SubscriptionRequest;

@Component
public class ModelHelper {

	@Autowired
	private PartnerNotificationRepo notificationRepo;

	@Autowired
	private SubscriptionRequestRepos subRequestRepo;

	public void saveSubscriptionRequest(SubscriptionRequest body, String response, String url) {
		// TODO Auto-generated method stub

		SubscriptionRequestModel subscriptionRequestModel = new SubscriptionRequestModel();
		try {
			subscriptionRequestModel.setDateTime(new Date());
			subscriptionRequestModel.setAdvId(body.getAdvId());
			subscriptionRequestModel.setChannel("WAP");
			subscriptionRequestModel.setProductId(body.getProductId());
			subscriptionRequestModel.setPinPushResponse(response);
			subscriptionRequestModel.setPartnerTransactionId(body.getPartnerTransactionId());
			subscriptionRequestModel.setTransactionId("0");
			subscriptionRequestModel.setLanguage(body.getLanguage());
			subscriptionRequestModel.setMsisdn(body.getMsisdn());
			subscriptionRequestModel.setPinPushRequest(url);
			subscriptionRequestModel.setPortalId("106");
			subRequestRepo.save(subscriptionRequestModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void saveNotificationRequest(String msisdn, String notifyRequest, String notifyResponse, String portalId) {
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
