package com.mobile.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "quiz2play_subscription_request")
@Data
public class SubscriptionRequestModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "msisdn")
	private String msisdn;

	@Column(name = "portal_id")
	private String portalId;

	@Column(name = "date_time")
	private Date dateTime;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "channel")
	private String channel;

	@Column(name = "adv_id")
	private String advId;

	@Column(name = "language")
	private String language;

	@Column(name = "partner_transaction_id")
	private String partnerTransactionId;

	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "pin_push_request")
	private String pinPushRequest;

	@Column(name = "pin_push_response")
	private String pinPushResponse;

	@Column(name = "pin_verify_request")
	private String pinVerifyRequest;

	@Column(name = "pin_verify_response")
	private String pinVerifyResponse;

	@Column(name = "pubid")
	private String pubid;

	@Column(name = "meta2")
	private String meta2;
}
