package com.nigeria.request;

import lombok.Data;

@Data

public class notifyReq {

	private String type;
	private String uuid;
	private String bill_id;
	private String operator;
	private String merchant;
	private String campaign;
	private String environment;
	private String msisdn;
	private String currency;
	private String amount;
	private String mode;
	private String frequency;
	private String next_payment_timestamp;
	private transactionReq transaction;

}
