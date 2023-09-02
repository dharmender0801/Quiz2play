package com.nigeria.request;

import lombok.Data;

@Data
public class SubscriptionRequest {

	private String token;
	private String productId;
	private String advId;
	private String channel;
	private String partnerTransactionId;
	private String pubId;
	private String language;

}
