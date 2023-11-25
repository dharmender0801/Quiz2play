package com.nigeria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nigeria.model.helper.ModelHelper;
import com.nigeria.request.SubscriptionRequest;
import com.nigeria.response.StatusResponse;
import com.nigeria.service.MtnService;

@Service
public class MtnServiceImpl implements MtnService {

	@Value("${notificationReq}")
	private String notificationReq;
	@Autowired
	private ModelHelper helper;

	@Override
	public StatusResponse SaveNotification(String channel, String action, String circle, String endDate, String msisdn,
			String operator, String packName, String amount, String startDate, String userStatus, String subscriberType,
			String transactionId, String vendorName, String contestLevel, String contestName, String language,
			String src) {
		StatusResponse response = new StatusResponse();
		// TODO Auto-generated method stub
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
		helper.saveNotificationRequest(msisdn, notification, "200-ok", "106");
		
		return null;
	}

	@Override
	public StatusResponse sendForUnsub(String msisdn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusResponse sendforSub(SubscriptionRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
