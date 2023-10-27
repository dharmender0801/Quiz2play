package com.nigeria.request;

import lombok.Data;

@Data
public class transactionReq {
	private String status;
	private String bill_id;
	private String message;
	private String timestamp;
	private String transactionId;

}
