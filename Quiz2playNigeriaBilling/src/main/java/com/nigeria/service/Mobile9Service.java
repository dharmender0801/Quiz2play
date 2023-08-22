package com.nigeria.service;

import com.nigeria.request.SubscriptionRequest;
import com.nigeria.response.StatusResponse;

public interface Mobile9Service {

	StatusResponse saveNotification(String notificationRequest);

	StatusResponse sendSubscription(SubscriptionRequest body);

}
