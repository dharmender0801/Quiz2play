package com.nigeria.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sdp_notification_logs")
@Data
public class SdpNoticationLogsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String msisdn;
	@Column
	private String portalId;
	@Column
	private String notificationRequest;
	@Column
	private String operatorId;
	@Column
	private Date datTime;

}
