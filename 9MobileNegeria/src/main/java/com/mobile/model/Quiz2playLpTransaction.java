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
@Data
@Table(name = "quiz2play_lp_transaction")
public class Quiz2playLpTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "msisdn")
	private String msisdn;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "pin")
	private String pin;

	@Column(name = "adv_id")
	private String advId;

	@Column(name = "pub_id")
	private String pubId;

	@Column(name = "ip_address")
	private String ipAdress;

	@Column(name = "request_date")
	private Date requestDate;

	@Column(name = "pingen_date")
	private Date PingenDate;

	@Column(name = "pinverify_date")
	private Date PinverifyDate;

	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "partner_tran_id")
	private String partnerTransactionId;

	@Column(name = "pin_send_req")
	private String pinSendRequest;

	@Column(name = "pin_verify_req")
	private String pinverifyRequest;

	@Column(name = "pin_send_resp")
	private String pinSendResponse;

	@Column(name = "pin_verify_resp")
	private String pinverifyResponse;

	@Column(name = "user_agent")
	private String userAgent;

	@Column(name = "meta2")
	private String meta2;
}
