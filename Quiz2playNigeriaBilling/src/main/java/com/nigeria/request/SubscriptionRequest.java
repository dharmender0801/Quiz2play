package com.nigeria.request;

import lombok.Data;

@Data
public class SubscriptionRequest {

	private String msisdn;
	private String productId;
	private String advId;
	private String channel;
	private String partnerTransactionId;
	private String pubid;
	private String language;

}
