package com.mobile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "appstore_promotion_type")
public class PromotionTypeModel {

	@Id
	@Column
	private int id;
	@Column
	private String portalid;
	@Column
	private String productId;
	@Column
	private String pricePoint;
	@Column
	private String status;
	@Column
	private String packType;
	@Column
	private String pageMsg1;
	@Column
	private String pageMsg2;
	@Column
	private String currency;
	@Column
	private String unsubcode;
	@Column
	private String country;
	@Column
	private String user;
	@Column(name = "Operator_id")
	private String operatorid;
	@Column
	private String language;
}