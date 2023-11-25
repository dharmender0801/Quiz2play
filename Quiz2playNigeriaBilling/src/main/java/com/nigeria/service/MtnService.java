package com.nigeria.service;

import com.nigeria.request.SubscriptionRequest;
import com.nigeria.response.StatusResponse;

public interface MtnService {

	StatusResponse SaveNotification(String channel, String action, String circle, String endDate, String msisdn,
			String operator, String packName, String amount, String startDate, String userStatus, String subscriberType,
			String transactionId, String vendorName, String contestLevel, String contestName, String language,
			String src);

	StatusResponse sendForUnsub(String msisdn);

	StatusResponse sendforSub(SubscriptionRequest request);

}
