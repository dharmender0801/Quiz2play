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
@Table(name = "user_unsub_logs")
@Data
public class UnsubLogsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String msisdn;
	@Column
	private String meta2;
	@Column
	private String response;
	@Column
	private String request;
	@Column
	private String status;
	@Column
	private Date datetime;
	@Column
	private String portalid;
}