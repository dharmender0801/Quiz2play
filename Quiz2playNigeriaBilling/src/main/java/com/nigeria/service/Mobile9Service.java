package com.nigeria.service;

import com.nigeria.request.NotificationRequest;
import com.nigeria.request.SubscriptionRequest;
import com.nigeria.response.StatusResponse;

public interface Mobile9Service {

	StatusResponse saveNotification(NotificationRequest notificationRequest);

	StatusResponse sendSubscription(SubscriptionRequest body);

}
