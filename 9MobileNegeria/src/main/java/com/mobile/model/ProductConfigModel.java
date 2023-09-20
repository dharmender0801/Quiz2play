package com.mobile.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appstore_product_config")
public class ProductConfigModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "auto_renewal")
	private String autoRenewal;

	@Column(name = "billing_type")
	private String billingType;

	@Column(name = "creation_date_time")
	private Date creationDateTime;

	@Column(name = "credit")
	private String credit;

	@Column(name = "description")
	private String description;

	@Column(name = "display_order")
	private Integer displayOrder;

	@Column(name = "grace_duration")
	private String graceDuration;

	@Column(name = "is_approved")
	private Boolean isApproved;

	@Column(name = "is_fallback")
	private Boolean isFallback;

	@Column(name = "mapped_itemtype_id")
	private Long mappedItemtypeId;

	@Column(name = "pack_type")
	private String packType;

	@Column(name = "portal_id")
	private Integer portalId;

	@Column(name = "price_point")
	private String pricePoint;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "service_id")
	private Long serviceId;

	@Column(name = "service_name")
	private String serviceName;

	@Column(name = "sms_type")
	private String smsType;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "validity")
	private String validity;

	@Column(name = "language")
	private String language;

	@Column(name = "sub_msg_en")
	private String subMsgEn;

	@Column(name = "sub_msg_ar")
	private String subMsgAr;

	@Column(name = "currency")
	private String currency;

	@Column(name = "country")
	private String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutoRenewal() {
		return autoRenewal;
	}

	public void setAutoRenewal(String autoRenewal) {
		this.autoRenewal = autoRenewal;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public Date getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getGraceDuration() {
		return graceDuration;
	}

	public void setGraceDuration(String graceDuration) {
		this.graceDuration = graceDuration;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Boolean getIsFallback() {
		return isFallback;
	}

	public void setIsFallback(Boolean isFallback) {
		this.isFallback = isFallback;
	}

	public Long getMappedItemtypeId() {
		return mappedItemtypeId;
	}

	public void setMappedItemtypeId(Long mappedItemtypeId) {
		this.mappedItemtypeId = mappedItemtypeId;
	}

	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	public Integer getPortalId() {
		return portalId;
	}

	public void setPortalId(Integer portalId) {
		this.portalId = portalId;
	}

	public String getPricePoint() {
		return pricePoint;
	}

	public void setPricePoint(String pricePoint) {
		this.pricePoint = pricePoint;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSubMsgEn() {
		return subMsgEn;
	}

	public void setSubMsgEn(String subMsgEn) {
		this.subMsgEn = subMsgEn;
	}

	public String getSubMsgAr() {
		return subMsgAr;
	}

	public void setSubMsgAr(String subMsgAr) {
		this.subMsgAr = subMsgAr;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "ProductConfigModel [id=" + id + ", autoRenewal=" + autoRenewal + ", billingType=" + billingType
				+ ", creationDateTime=" + creationDateTime + ", credit=" + credit + ", description=" + description
				+ ", displayOrder=" + displayOrder + ", graceDuration=" + graceDuration + ", isApproved=" + isApproved
				+ ", isFallback=" + isFallback + ", mappedItemtypeId=" + mappedItemtypeId + ", packType=" + packType
				+ ", portalId=" + portalId + ", pricePoint=" + pricePoint + ", productId=" + productId
				+ ", productName=" + productName + ", serviceId=" + serviceId + ", serviceName=" + serviceName
				+ ", smsType=" + smsType + ", status=" + status + ", validity=" + validity + ", language=" + language
				+ ", subMsgEn=" + subMsgEn + ", subMsgAr=" + subMsgAr + ", currency=" + currency + "]";
	}

}
