package com.nigeria.request;

import lombok.Data;

@Data
public class secureDRequest {
	private String msisdn;
	private String activation;
	private String productID;
	private String description;
	private String timestamp;
	private String trxId;

}
