package com.mobile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "quiz2play_vendor_detail")
@Data
public class Quiz2playLpAdvertizer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "cp_id")
	private String cpId;

	@Column(name = "kp_id")
	private String kpId;

	@Column(name = "publisher_id")
	private String pubId;

	@Column(name = "callback_url")
	private String callbackUrl;

	@Column(name = "cut")
	private int cut;

	@Column(name = "counter")
	private int counter;

	@Column(name = "callback_limit")
	private int callbackLimit;

	@Column(name = "vendor_name")
	private String vendorName;

	@Column(name = "operator_name")
	private String operatorName;

	@Column(name = "service_name")
	private String serviceName;

	@Column(name = "lp_url")
	private String lpUrl;

	@Column(name = "status")
	private Boolean status;
}
