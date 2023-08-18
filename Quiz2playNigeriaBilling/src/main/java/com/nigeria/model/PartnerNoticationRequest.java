package com.nigeria.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "partner_notification_logs")
public class PartnerNoticationRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "msisdn")
	private String msisdn;

	@Column(name = "notification_request")
	private String notificationRequest;

	@Column(name = "notification_response")
	private String notificationResponse;

	@Column(name = "date_time")
	private Date dateTime;

	@Column(name = "portal_id")
	private String portalId;

	@Column(name = "meta2")
	private String meta2;

}
