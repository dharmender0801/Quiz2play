package com.mobile.service;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface LpService {

	Boolean SaveToTransaction(String userAgent, Model model, String cpId, String kpId, String pubId, String language,
			String productId, long requestId);
	String getRedirectionURl(String kpId, String pubId, String productId, String language, String transId);
	String sendSubscriptionRequest(String status, String token, String kpId, String language, String productId, String msisdn, String transactionId);

}
